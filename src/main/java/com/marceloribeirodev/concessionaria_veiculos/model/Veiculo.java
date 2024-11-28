package com.marceloribeirodev.concessionaria_veiculos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Veiculo {

    private String modelo;
    private String valor;
    private String combustivel;

    private Integer ano;

    public Veiculo(@JsonProperty("Modelo") String modelo,
                   @JsonProperty("Valor") String valor,
                   @JsonProperty("Combustivel") String combustivel,
                   @JsonProperty("AnoModelo") Integer ano) {
        this.modelo = modelo;
        this.valor = valor;
        this.combustivel = combustivel;
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public String getValor() {
        return valor;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public Integer getAno() {
        return ano;
    }
}
