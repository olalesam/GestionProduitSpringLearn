package com.olale.produits.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olale.produits.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	
}
