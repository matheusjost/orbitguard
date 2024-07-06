package com.orbitguard.orbitguard.model.http;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HttpUtils {
    public static Map<String, String> createParams(String name, String val, Map<String, String> params) {
        if (params == null) {
            params = new HashMap<>();
        }

        params.put(name, val);
        return params;
    }


    public static String setUrlParams(String url, Map<String, String> params) {
        if (params == null || params.isEmpty()) {
            return url;
        }

        StringBuilder urlWithParams = new StringBuilder(url);
        boolean firstParam = !url.contains("?");

        for (Map.Entry<String, String> param : params.entrySet()) {
            if (firstParam) {
                urlWithParams.append('?');
                firstParam = false;
            } else {
                urlWithParams.append('&');
            }
            urlWithParams.append(URLEncoder.encode(param.getKey(), StandardCharsets.UTF_8));
            urlWithParams.append('=');
            urlWithParams.append(URLEncoder.encode(param.getValue(), StandardCharsets.UTF_8));
        }

        return urlWithParams.toString();
    }
}
