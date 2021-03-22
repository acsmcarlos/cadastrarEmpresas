package com.emissaoguias.fgf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan({"com.emissaoguias.fgf.controllers"})
//@EntityScan(basePackages = {"com.emissaoguias.fgf.models"})
public class EmissaoDeGuiasFgfApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmissaoDeGuiasFgfApplication.class, args);
	}

}
