package com.orbitguard.orbitguard.model.objeto;

import com.orbitguard.orbitguard.EnvConfig;
import com.orbitguard.orbitguard.model.http.HttpRequests;
import com.orbitguard.orbitguard.model.utils.HttpUtils;
import com.orbitguard.orbitguard.model.utils.JSONObjectUtils;
import jakarta.transaction.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Transactional
public class ObjetoService {
    @Autowired
    private ObjetoRepository repository;

    private final String NASA_NEO_API_BASE_URL = "https://api.nasa.gov/neo/rest/v1/feed";

    public Objeto save(Objeto obj) {
        return repository.save(obj);
    }
    
    public List<Objeto> findAll() {
        return repository.findAll();
    }
    
    public List<Objeto> findByDistanciaGreaterThan(double distancia) {
        return repository.findByDistanciaGreaterThan(distancia);
    }
    
    public List<Object[]> countByDate() {
        return repository.countByDate();
    }

    private String callNasaApi(Date start, Date end) {
        Map<String, String> params;
        String url;
        EnvConfig config = getEnvConfig();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = sdf.format(start);
        String endDate = sdf.format(end);

        params = HttpUtils.createParams("start_date", startDate, null);
        params = HttpUtils.createParams("end_date", endDate, params);
        params = HttpUtils.createParams("api_key", config.getApiKey(), params);
        url = HttpUtils.setUrlParams(NASA_NEO_API_BASE_URL, params);

        return HttpRequests.get(url);
    }

    private boolean validateObjetoData(String name, String date) {
        if (name == null || date == null) return false;

        LocalDate dataAprox = LocalDate.parse(date);
        Objeto check = repository.findByNomeAndDataAprox(name, java.sql.Date.valueOf(dataAprox));

        return check == null;
    }

    private Objeto setObjetoData(JSONObject obj, String date) {
        JSONArray closeApproachData = obj.getJSONArray("close_approach_data");
        JSONObject estimatedDiameter = obj.getJSONObject("estimated_diameter");

        int lastApp = closeApproachData.length() - 1;
        JSONObject missDistance = closeApproachData.getJSONObject(lastApp).getJSONObject("miss_distance");
        JSONObject relativeVelocity = closeApproachData.getJSONObject(lastApp).getJSONObject("relative_velocity");
        JSONObject estimatedDiameterKm = estimatedDiameter.getJSONObject("kilometers");

        Objeto o = new Objeto();
        o.setNome(JSONObjectUtils.getStringOrNull(obj, "name"));
        o.setDistancia(JSONObjectUtils.getDoubleOrNull(missDistance,"kilometers"));
        o.setVelocidade(JSONObjectUtils.getDoubleOrNull(relativeVelocity, "kilometers_per_hour"));
        o.setTamanhoMinEstimado(JSONObjectUtils.getDoubleOrNull(estimatedDiameterKm, "estimated_diameter_min"));
        o.setTamanhoMaxEstimado(JSONObjectUtils.getDoubleOrNull(estimatedDiameterKm, "estimated_diameter_max"));
        o.setPotencialRisco(JSONObjectUtils.getBooleanOrNull(obj, "is_potentially_hazardous_asteroid"));

        LocalDate dataAprox = LocalDate.parse(date);
        o.setDataAprox(java.sql.Date.valueOf(dataAprox));

        return o;
    }

    public void updateLocalObjeto(Date start, Date end) {
        String res = callNasaApi(start, end);
        JSONObject jsonRes;

        try {
            jsonRes = new JSONObject(res);
        } catch (Exception e) {
            return;
        }

        if (!jsonRes.has("element_count") || !jsonRes.has("near_earth_objects")) return;
        if (jsonRes.getInt("element_count") == 0) return;

        if (jsonRes.has("near_earth_objects") &&
                jsonRes.has("element_count") &&
                jsonRes.getInt("element_count") > 0) {
            JSONObject nearEarthObjects = jsonRes.getJSONObject("near_earth_objects");

            for (String date : nearEarthObjects.keySet()) {
                JSONArray dateObjects = nearEarthObjects.getJSONArray(date);

                for (int i = 0; i < dateObjects.length(); i++) {
                    JSONObject obj = dateObjects.getJSONObject(i);
                    if (!validateObjetoData(obj.getString("name"), date)) continue;

                    Objeto o = setObjetoData(obj, date);
                    repository.save(o);
                }
            }
        }
    }

    private EnvConfig getEnvConfig() {
        return EnvConfig.getInstance();
    }
}
