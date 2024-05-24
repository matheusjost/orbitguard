package com.orbitguard.orbitguard.model.example;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExampleService {
    @Autowired
    private ExampleRepository repository;

    public Example save(Example example) {
        return repository.save(example);
    }
}
