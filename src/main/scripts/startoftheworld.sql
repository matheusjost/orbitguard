CREATE DATABASE orbitguard;
USE orbitguard;

-- OBJETO TABLE
CREATE TABLE objeto (
    id int auto_increment,
    nome varchar(255),
    distancia double,
    velocidade double,
    tamanho double,
    potencial_risco boolean,
    data_aprox date,
    primary key (id)
);