package com.marceloribeirodev.concessionaria_veiculos.principal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marceloribeirodev.concessionaria_veiculos.model.Veiculo;
import com.marceloribeirodev.concessionaria_veiculos.service.ConsumoApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);

    // CONSTANTES
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    private ConsumoApi consumirApi = new ConsumoApi();

    public void inicializandoSistema(){
        System.out.println("Digite o tipo do veículo: \n 1 - Carro\n 2 - Moto\n 3 - Caminhão\nSe nenhum for digitado o default será Carro");
        var nomeVeiculo = leitura.nextInt();
        String tipoVeiculo;

        switch (nomeVeiculo){
            case 1:
                tipoVeiculo = "carros";
                break;
            case 2:
                tipoVeiculo = "motos";
                break;
            case 3:
                tipoVeiculo = "caminhoes";
                break;
            default:
                tipoVeiculo = "carro";
        }

        String apiVeiculo = ENDERECO + tipoVeiculo + "/marcas";

        String api = consumirApi.obterDados(apiVeiculo);

        System.out.println(api);

        List<DadosVeiculo> veiculoList = new ArrayList<>();
        List<Veiculo> veiculos = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            veiculos = objectMapper.readValue(api, objectMapper.getTypeFactory().constructCollectionType(List.class, Veiculo.class));
        }catch (JsonProcessingException exception) {
            throw new RuntimeException("Error parsing JSON body: " + exception.getMessage(), exception);
        }

        veiculos.forEach(System.out::println);
    }
}
