package com.orbitguard.orbitguard.model.objeto;

import com.orbitguard.orbitguard.EnvConfig;
import com.orbitguard.orbitguard.model.http.HttpRequests;
import com.orbitguard.orbitguard.model.http.HttpUtils;
import jakarta.transaction.Transactional;
import java.util.List;
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

    public String apiCallTest() {
        Map<String, String> params;
        String url;
        EnvConfig config = getEnvConfig();

        params = HttpUtils.createParams("start_date", "2015-09-07");
        params = HttpUtils.createParams("end_date", "2015-09-08");
        params = HttpUtils.createParams("api_key", config.getApiKey());
        url = HttpUtils.setUrlParams(NASA_NEO_API_BASE_URL, params);

        // TODO: tratar retorno, transformar em JSONObject e verificar infos
        String res = HttpRequests.get(url);

        return res;
    }

    private EnvConfig getEnvConfig() {
        return EnvConfig.getInstance();
    }
}
