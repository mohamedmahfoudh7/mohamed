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

import com.projetweb.projetweb.entities.Stagiare;
import com.projetweb.projetweb.service.IserviceProjet;
import com.projetweb.projetweb.service.IserviceStagiare;

@Controller
@RequestMapping("/stagiare")
public class StagiareController {

	 @Autowired
		IserviceStagiare sr;
	 @Autowired
		IserviceProjet sp;
	 
	 
	 @GetMapping("/all")
	  public String getAllStagiare(Model m)
	  {
		  List<Stagiare>liste=sr.GetAllStagiare();
		  m.addAttribute("liste", liste);
		  return "vuestagiare";
	  }
	 
	 
	 
	 
	 @GetMapping("/ajouterstagiare")
	  public String ajouterStagiare(Model m)
	  {
		 m.addAttribute("projets",sp.GetAllProjet());	
		  return "ajouterstagiare";
	  }
	 
	 
	 @GetMapping("/supprimerstagiare/{id}")
	  public String supprimerStagiare(@PathVariable int id) throws IOException
	  {
		  
		  sr.SupprimerStagiare(id);
		  return "redirect:/stagiare/all";
	  }
	
	 
	 
	 
	  @PostMapping("/sauvgarderstagiare")
	  public String sauvgarderStagiare(@ModelAttribute Stagiare e,Model m) throws IOException
	  {
		  Integer id=e.getId();
		  sr.SaveStagiare(e);
		 
		  if(id!=null) // modification
		  {
			  return"redirect:/stagiare/all";
		  }
		  else // ajouter
		  {
			  m.addAttribute("message", "ajouter avec suceés");
			  return "redirect:/stagiare/ajouterstagiare";
		  }
			  
	  }
	  
	  @GetMapping("/modifierstagiare/{idp}")
	  public String modifierStagiare(Model m,@PathVariable("idp")int id)
	  {
		  m.addAttribute("projets", sp.GetAllProjet());
		  m.addAttribute("stagiare", sr.GetStagiare(id));
		  return "ajouterstagiare";
	  }
	
}
