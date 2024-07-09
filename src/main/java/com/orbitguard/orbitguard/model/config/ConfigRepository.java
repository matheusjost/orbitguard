package com.orbitguard.orbitguard.model.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigRepository extends JpaRepository<Config, Long> {

    @Query("SELECT c FROM Config c")
    Config getMyConfig();
}
