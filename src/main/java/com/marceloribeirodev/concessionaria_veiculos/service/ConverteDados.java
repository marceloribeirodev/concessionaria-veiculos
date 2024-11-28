package com.marceloribeirodev.concessionaria_veiculos.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class ConverteDados {

    private ObjectMapper objectMapper = new ObjectMapper();

    public <T> List<T> obterLista(String json, Class<T> classe){
        try {
             CollectionType lista = objectMapper.getTypeFactory()
                    .constructCollectionType(List.class, classe);

            return objectMapper.readValue(json, lista);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T obterDados(String json, Class<T> classe){
        try {
            return objectMapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
