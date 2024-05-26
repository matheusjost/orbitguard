package com.orbitguard.orbitguard;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvConfig {
    private static EnvConfig instance;
    private Dotenv dotenv;
    private String apiKey;

    private EnvConfig() {
        dotenv = Dotenv.load();
        apiKey = dotenv.get("API_KEY");
    }

    public static synchronized EnvConfig getInstance() {
        if (instance == null) {
            instance = new EnvConfig();
        }
        return instance;
    }

    public String getApiKey() {
        return apiKey;
    }
}
