package com.orbitguard.orbitguard.model.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class HttpRequests {

    private static Map<String, String> setHeaderContentTypeJson(Map<String, String> header) {
        header.put("Content-Type", "application/json");
        return header;
    }

    private static HttpClient createClient() {
        try {
            return HttpClient.newHttpClient();
        } catch (Exception e) {
            throw e;
        }
    }

    private static HttpRequest.Builder setHttpMethod(HttpRequest.Builder builder, HttpRequestEnum method, String data) {
        switch (method) {
            case GET -> {
                return builder.GET();
            }
            case POST -> {
                return builder.POST(HttpRequest.BodyPublishers.ofString(data));
            }
            case PUT -> {
                return builder.PUT(HttpRequest.BodyPublishers.ofString(data));
            }
            case DELETE -> {
                return builder.DELETE();
            }
            default -> {
                return null;
            }
        }
    }

    private static void setHeader(HttpRequest.Builder builder, Map<String, String> header) {
        try {
            header.forEach(builder::header);
        } catch (Exception e) {
            throw e;
        }
    }

    private static HttpRequest createRequest(String url, HttpRequestEnum method, String data, Map<String, String> header) {
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder()
                    .uri(URI.create(url));

            builder = setHttpMethod(builder, method, data);
            if (header != null) {
                setHeader(builder, header);
            }

            assert builder != null;
            return builder.build();
        } catch (Exception e) {
            throw e;
        }
    }

    private static String fetchResponse(HttpResponse response) {
        int statusCode = response.statusCode();

        if (statusCode != 200) {
            return "ERRO " + statusCode;
        }

        return (String) response.body();
    }


    private static String executeHttpRequest(String url, HttpRequestEnum method, String data, Map<String, String> header) {
        try {
            HttpClient client = createClient();
            HttpRequest req = createRequest(url, method, data, header);

            HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());

            return fetchResponse(res);

        } catch (Exception e) {
            return null;
        }
    }

    public static String get(String caminho) {
        return executeHttpRequest(caminho, HttpRequestEnum.GET, null, null);
    }

    public static String post(String caminho, String dados) {
        Map<String, String> header = new HashMap<>();
        header = setHeaderContentTypeJson(header);
        return executeHttpRequest(caminho, HttpRequestEnum.POST, dados, header);
    }

    public static String put(String caminho, String dados) {
        Map<String, String> header = new HashMap<>();
        header = setHeaderContentTypeJson(header);
        return executeHttpRequest(caminho, HttpRequestEnum.PUT, dados, header);
    }

    public static String delete(String caminho) {
        return executeHttpRequest(caminho, HttpRequestEnum.DELETE, null, null);
    }
}
