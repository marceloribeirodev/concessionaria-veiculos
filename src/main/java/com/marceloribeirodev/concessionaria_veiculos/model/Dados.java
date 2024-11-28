package com.marceloribeirodev.concessionaria_veiculos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Dados {
    private String codigo;

    private String nomeVeiculo;

   public Dados(@JsonProperty("codigo") String codigo,
                @JsonProperty("nome") String nome) {
        this.codigo = codigo;
        this.nomeVeiculo = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNomeVeiculo() {
        return nomeVeiculo;
    }

}
