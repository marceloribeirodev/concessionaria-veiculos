package com.marceloribeirodev.concessionaria_veiculos.principal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marceloribeirodev.concessionaria_veiculos.model.Veiculo;
import com.marceloribeirodev.concessionaria_veiculos.service.ConsumoApi;
import com.marceloribeirodev.concessionaria_veiculos.service.ConverteDados;

import java.util.*;

public class Principal {

    private Scanner leitura = new Scanner(System.in);

    // CONSTANTES
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

    private ConsumoApi consumirApi = new ConsumoApi();

    private ConverteDados converteDados = new ConverteDados();

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

        String apiVeiculo = URL_BASE + tipoVeiculo + "/marcas";
        String api = consumirApi.obterDados(apiVeiculo);

        List<Veiculo> marcasVeiculos = converteDados.obterLista(api, Veiculo.class);

        // Imprimir as marcas e seus determinados códigos
        marcasVeiculos.stream().sorted(Comparator.comparing(Veiculo::getCodigo))
                .forEach(e -> System.out.println("Código: " + e.getCodigo()
                + " | Nome do Veículo: " + e.getNomeVeiculo()));



    }
}
