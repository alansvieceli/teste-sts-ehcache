package com.alanvieceli.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.alanvieceli.api.services.ExemploCacheService;

@SpringBootApplication
@EnableCaching
public class TesteEhCacheApplication {

	@Autowired
	private ExemploCacheService exemploCacheService;

	public static void main(String[] args) {
		SpringApplication.run(TesteEhCacheApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("Executando serviço pela primeira vez: ");
			System.out.println(this.exemploCacheService.exemploCache());
			
			System.out.println("Executando serviço pela segunda vez, deve obter dados do cache: ");
			System.out.println(this.exemploCacheService.exemploCache());
		};
	}
}
