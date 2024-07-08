package com.orbitguard.orbitguard.model.objeto;

import jakarta.persistence.*;

import java.util.Date;

import java.util.Objects;

@Entity
@Table(name = "objeto")
public class Objeto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "distancia")
    private double distancia;

    @Column(name = "velocidade")
    private double velocidade;

    @Column(name = "tamanho_max_estimado")
    private double tamanhoMaxEstimado;

    @Column(name = "tamanho_min_estimado")
    private double tamanhoMinEstimado;

    @Column(name = "potencial_risco")
    private boolean potencialRisco;

    @Column(name = "data_aprox")
    private Date dataAprox;

    public Date getDataAprox() {
        return dataAprox;
    }

    public boolean isPotencialRisco() {
        return potencialRisco;
    }

    public void setPotencialRisco(boolean potencialRisco) {
        this.potencialRisco = potencialRisco;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public double getTamanhoMinEstimado() {
        return tamanhoMinEstimado;
    }

    public void setTamanhoMinEstimado(double tamanhoMinEstimado) {
        this.tamanhoMinEstimado = tamanhoMinEstimado;
    }

    public double getTamanhoMaxEstimado() {
        return tamanhoMaxEstimado;
    }

    public void setTamanhoMaxEstimado(double tamanhoMaxEstimado) {
        this.tamanhoMaxEstimado = tamanhoMaxEstimado;
    }

    public void setDataAprox(Date dataAprox) {
        this.dataAprox = dataAprox;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome());
    }

    @Override
    public String toString() {
        return nome;
    }
}
