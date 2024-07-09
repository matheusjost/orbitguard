package com.orbitguard.orbitguard.model.config;


import jakarta.persistence.*;

@Entity
@Table(name = "config")
public class Config {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "nasa_api_key")
    private String nasaApiKey;

    public Config() {
    }

    public Config(String nasaApiKey) {
        this.nasaApiKey = nasaApiKey;
    }

    public Config(int id, String nasaApiKey) {
        this.id = id;
        this.nasaApiKey = nasaApiKey;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNasaApiKey() {
        return nasaApiKey;
    }

    public void setNasaApiKey(String nasaApiKey) {
        this.nasaApiKey = nasaApiKey;
    }
}
