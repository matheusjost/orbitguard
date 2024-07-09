CREATE DATABASE orbitguard;
USE orbitguard;

-- OBJETO TABLE
CREATE TABLE objeto (
    id int auto_increment,
    nome varchar(255),
    distancia double,
    velocidade double,
    tamanho_min_estimado double,
    tamanho_max_estimado double,
    potencial_risco boolean,
    data_aprox date,
    primary key (id)
);

-- CONFIG TABLE
CREATE TABLE config (
    id int auto_increment,
    nasa_api_key varchar(255),
    qtd_dias_sync int,
    primary key (id)
);

INSERT INTO config (nasa_api_key, qtd_dias_sync) VALUES ('DEMO_KEY', 7);