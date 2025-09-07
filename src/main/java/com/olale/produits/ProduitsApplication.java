package com.olale.produits;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;


import com.olale.produits.entities.Produit;

@SpringBootApplication
public class ProduitsApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(ProduitsApplication.class, args);
	}
	
	// Définition d'un Bean qui s'exécute au démarrage
    @Bean
    CommandLineRunner start(RepositoryRestConfiguration restConfig) {
        return args -> {
            // Exposer les IDs de Produit dans les réponses JSON
            restConfig.exposeIdsFor(Produit.class);
        };
    }
	
	

}
