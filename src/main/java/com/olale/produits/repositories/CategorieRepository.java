package com.olale.produits.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olale.produits.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long>  {
	
}
