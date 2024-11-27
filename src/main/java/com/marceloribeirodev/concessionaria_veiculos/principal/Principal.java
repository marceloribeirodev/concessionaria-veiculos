package com.marceloribeirodev.concessionaria_veiculos.principal;

import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);

    // CONSTANTES
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";


    public void inicializandoSistema(){
        System.out.println("Digite o tipo do veículo: \n 1 - Carro\n 2 - Moto\n 3 - Caminhão\nSe nenhum for digitado o default será Carro");
        var nomeVeiculo = leitura.nextInt();
        String tipoVeiculo;

        switch (nomeVeiculo){
            case 1:
                tipoVeiculo = "carro";
            case 2:
                tipoVeiculo = "moto";
            case 3:
                tipoVeiculo = "caminhoes";
            default:
                tipoVeiculo = "carro";
        }

        System.out.println(tipoVeiculo);


    }
}
