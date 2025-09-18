package com.olale.produits.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.olale.produits.repositories.CategorieRepository;
import com.olale.produits.entities.Categorie;
import com.olale.produits.entities.Produit;

@RestController
@RequestMapping("/api/cat")
@CrossOrigin("*")
public class CategorieRESTController {
	@Autowired
	CategorieRepository categorieRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Categorie> getAllCategories() {
		return categorieRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Categorie getCategorieById(@PathVariable("id") Long id) {
		return categorieRepository.findById(id).get();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Categorie createCategory(@RequestBody Categorie categorie) {
		// S’assurer que l’ID est nul → Hibernate fait un INSERT
		categorie.setIdCat(null);
		return categorieRepository.save(categorie);
	}

	@PutMapping
	public Categorie updateCategorie(@RequestBody Categorie categorie) {
		if (!categorieRepository.existsById(categorie.getIdCat())) {

			throw new RuntimeException("Catégorie avec ID " + categorie.getIdCat() + " non trouvée");
		}
		return categorieRepository.save(categorie);
	}

}
