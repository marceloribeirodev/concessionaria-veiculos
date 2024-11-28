package com.marceloribeirodev.concessionaria_veiculos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModeloVeiculo {

    private List<Dados> modelos;

    public ModeloVeiculo(@JsonProperty("modelos") List<Dados> modelos) {
        this.modelos = modelos;
    }

    public List<Dados> getModelos() {
        return modelos;
    }
}
