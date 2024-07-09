package com.orbitguard.orbitguard.model.config;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ConfigService {

    @Autowired
    private ConfigRepository repository;

    public Config save(Config config) {
        return repository.save(config);
    }

    public Config getConfig() {
        return repository.getMyConfig();
    }
}
