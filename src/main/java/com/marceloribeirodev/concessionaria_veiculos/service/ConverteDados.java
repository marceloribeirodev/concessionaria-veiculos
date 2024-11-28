package com.marceloribeirodev.concessionaria_veiculos.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados {

    private ObjectMapper objectMapper = new ObjectMapper();

    public <T> T obterDados(String json, Class<T> classe){
        try {
            return objectMapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
