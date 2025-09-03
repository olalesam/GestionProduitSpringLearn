package com.olale.produits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.olale.produits.entities.Produit;
import com.olale.produits.repositories.ProduitRepository;

@SpringBootTest
class ProduitsApplicationTests {

	@Autowired 
	private ProduitRepository produitRepository; 
	
	@Test 
	public void testCreateProduit() { 
		Produit prod = new Produit("PC HP",4000.500,new Date()); 
		produitRepository.save(prod); 
	} 
	
	@Test 
	public void testFindProduit() 
	{ 
		Produit p = produitRepository.findById(1L).get();     
		System.out.println(p); 
	} 
	@Test 
	public void testUpdateProduit() 
	{ 
		Produit p = produitRepository.findById(1L).get(); 
		p.setPrixProduit(1000.0); 
		produitRepository.save(p); 
	} 
	
	@Test 
	public void testListerTousProduits() 
	 { 
		   List<Produit>  prods = produitRepository.findAll();   
		   
		   for (Produit p : prods) 
		   { 
			   System.out.println(p); 
		   }   
	  } 
	
	@Test 
	 public void testDeleteProduit() 
	  { 
	   produitRepository.deleteById(1L);;  
	  } 

}
