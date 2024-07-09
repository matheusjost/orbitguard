package com.orbitguard.orbitguard.model.http;

public enum HttpRequestEnum {
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE"),
    GET("GET");

    private final String method;

    private HttpRequestEnum(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}
