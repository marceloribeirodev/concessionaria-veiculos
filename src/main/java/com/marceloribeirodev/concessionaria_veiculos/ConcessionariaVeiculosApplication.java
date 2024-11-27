package com.marceloribeirodev.concessionaria_veiculos;

import com.marceloribeirodev.concessionaria_veiculos.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConcessionariaVeiculosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConcessionariaVeiculosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.inicializandoSistema();
	}
}
