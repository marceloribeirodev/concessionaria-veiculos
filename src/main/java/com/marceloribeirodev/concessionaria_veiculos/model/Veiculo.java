package com.marceloribeirodev.concessionaria_veiculos.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Veiculo {
    private String codigo;

    private String nomeVeiculo;

   public Veiculo(@JsonProperty("codigo") String codigo,
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(codigo, veiculo.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "codigo=" + codigo +
                ", nomeVeiculo='" + nomeVeiculo + '\'' +
                '}';
    }
}
