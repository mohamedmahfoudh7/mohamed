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
import org.springframework.web.multipart.MultipartFile;

import com.projetweb.projetweb.entities.Projet;
import com.projetweb.projetweb.service.IserviceEncadrant;
import com.projetweb.projetweb.service.IserviceProjet;

@Controller
@RequestMapping("/projet")
public class ProjetController {

	
	@Autowired
	IserviceEncadrant se;
	
	 @Autowired
		IserviceProjet sp;
		
		
		 @GetMapping("/all")
		  public String getAllProjet(Model m)
		  {
			  List<Projet>liste=sp.GetAllProjet();
			  m.addAttribute("liste", liste);
			  //m.addAttribute("encadrants",se.GetAllEncadrant());
			 // m.addAttribute("categorie","Toutes les catégories");
			  return "vueprojet";
		  }
		 
		 
		 
		 
		 @GetMapping("/ajouterprojet")
		  public String ajouterProjet(Model m)
		  {
			  //List<Produit>liste=sp.getAllProducts();
			 m.addAttribute("encadrants",se.GetAllEncadrant());			  
			 return "ajouterprojet";
		  }
		 
		 
		 @GetMapping("/supprimerprojet/{id}")
		  public String supprimerProjet(@PathVariable int id) throws IOException
		  {
			  
			  sp.SupprimerProjet(id);
			  return "redirect:/projet/all";
		  }
		
		 
		 
		 
		  @PostMapping("/sauvgarderprojet")
		  public String sauvgarderProjet(@ModelAttribute Projet p,@RequestParam("file") MultipartFile mf,Model m) throws IOException
		  {
			  Integer id=p.getId();
			  sp.SaveProjet(p, mf);
			 
			  if(id!=null) // modification
			  {
				  return"redirect:/projet/all";
			  }
			  else // ajouter
			  {
				  m.addAttribute("message", "ajouter avec suceés");
				 // m.addAttribute("categories", se.GetAllEncadrant());
				  return "ajouterprojet";
			  }
				  
		  }
		  
		  @GetMapping("/modifierprojet/{idp}")
		  public String modifierProjet(Model m,@PathVariable("idp")int id)
		  {
			  m.addAttribute("encadrants", se.GetAllEncadrant());
			  m.addAttribute("projet", sp.GetProjet(id));
			  return "ajouterprojet";
		  }
}
