package com.projetweb.projetweb.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projetweb.projetweb.dao.EncadrantRepository;
import com.projetweb.projetweb.entities.Encadrant;
import com.projetweb.projetweb.entities.Projet;
import com.projetweb.projetweb.service.IserviceEncadrant;
import com.projetweb.projetweb.service.IserviceProjet;

@Controller
@RequestMapping("/encadrant")
public class EncadrantController {
	 @Autowired
	IserviceEncadrant se;
	 @Autowired
		IserviceProjet sp;
	 
	 EncadrantRepository er;
	
	
	 @GetMapping("/all")
	  public String getAllEncadrant(Model m)
	  {
		  List<Encadrant>liste_encadrant=se.GetAllEncadrant();
		  List<Projet>liste_projet=sp.GetAllProjet();
		  m.addAttribute("liste_encadrant", liste_encadrant);
		  m.addAttribute("liste_projet", liste_projet);
		  
		  
		  
		  return "vueencadrant";
	  }
	 
	 
	 
	 
	 @GetMapping("/ajouterencadrant")
	  public String ajouterEncadrant(Model m)
	  {
		  
		  return "ajouterencadrant";
	  }
	 
	 
	 @GetMapping("/supprimerencadrant/{id}")
	  public String supprimerEncadrant(@PathVariable int id) throws IOException
	  {
		  
		  se.SupprimerEncadrant(id);
		  return "redirect:/encadrant/all";
	  }
	
	 
	 
	 
	  @PostMapping("/sauvgarderencadrant")
	  public String sauvgarderEncadrant(@ModelAttribute Encadrant e,Model m) throws IOException
	  {
		  Integer id=e.getId();
		  se.SaveEncadrant(e);
		 
		  if(id!=null) // modification
		  {
			  return"redirect:/encadrant/all";
		  }
		  else // ajouter
		  {
			  m.addAttribute("message", "ajouter avec suceés");
			  return "ajouterencadrant";
		  }
			  
	  }
	  
	  @GetMapping("/modifierencadrant/{idp}")
	  public String modifierEncadrant(Model m,@PathVariable("idp")int id)
	  {
		  m.addAttribute("encadrant", se.GetEncadrant(id));
		  return "ajouterencadrant";
	  }
	  
	  /*
	  @GetMapping("/ProduitParCategorie")
		public String getProductsByMc(@RequestParam("categorie") int idc,Model m)
		{
			m.addAttribute("categories",se.GetAllEncadrant());
			if (idc==0) {System.out.println("ok");
				m.addAttribute("produits",sp.GetAllProjet());
				return"redirect:/produit/all";}
				else {
					m.addAttribute("produits",se.getProductsByCategorie(idc));
					m.addAttribute("categorie",er.findById(idc).get().getNom());
					return "listeProduits";
				}
			}
	  
	  */
}
