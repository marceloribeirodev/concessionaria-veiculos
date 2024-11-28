package com.marceloribeirodev.concessionaria_veiculos.principal;

import com.marceloribeirodev.concessionaria_veiculos.model.Dados;
import com.marceloribeirodev.concessionaria_veiculos.model.ModeloVeiculo;
import com.marceloribeirodev.concessionaria_veiculos.service.ConsumoApi;
import com.marceloribeirodev.concessionaria_veiculos.service.ConverteDados;
import org.springframework.boot.Banner;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);

    // CONSTANTES
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

    private ConsumoApi consumirApi = new ConsumoApi();

    private ConverteDados converteDados = new ConverteDados();

    public void inicializandoSistema(){
        System.out.println("Digite o tipo do veículo: \n 1 - Carro\n 2 - Moto\n 3 - Caminhão\nSe nenhum for digitado o default será Carro");
        var nomeVeiculo = leitura.nextLine();
        String tipoVeiculo;

        switch (nomeVeiculo){
            case "1":
                tipoVeiculo = "carros";
                break;
            case "2":
                tipoVeiculo = "motos";
                break;
            case "3":
                tipoVeiculo = "caminhoes";
                break;
            default:
                tipoVeiculo = "carro";
        }

        String apiMarcaVeiculo = URL_BASE + tipoVeiculo + "/marcas";
        String jsonMarcaVeiculo = consumirApi.obterDados(apiMarcaVeiculo);

        List<Dados> marcasDados = converteDados.obterLista(jsonMarcaVeiculo, Dados.class);

        // Imprimir as marcas e seus determinados códigos
        marcasDados.stream().sorted(Comparator.comparing(Dados::getCodigo))
                .forEach(e -> System.out.println("Código: " + e.getCodigo()
                + " | Nome do Veículo: " + e.getNomeVeiculo()));

        System.out.println("Digite o código da marca do veículo: ");
        String codigoVeiculo = leitura.nextLine();

        String apiModeloVeiculo = URL_BASE + tipoVeiculo + "/marcas/"+ codigoVeiculo + "/modelos";
        String jsonModeloVeiculo = consumirApi.obterDados(apiModeloVeiculo);

        System.out.println(jsonModeloVeiculo);
        var modeloVeiculos = converteDados.obterDados(jsonModeloVeiculo, ModeloVeiculo.class);

        modeloVeiculos.getModelos().stream()
                .sorted(Comparator.comparing(Dados::getCodigo))
                .forEach(e -> System.out.println("Código: " + e.getCodigo()
                        + " | Modelo do Veículo: " + e.getNomeVeiculo()));
    }
}
