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

import com.projetweb.projetweb.entities.Projet;
import com.projetweb.projetweb.entities.Technologie;
import com.projetweb.projetweb.service.IserviceProjet;
import com.projetweb.projetweb.service.IserviceTechnologie;

@Controller
@RequestMapping("/technologie")
public class TechnologieController {
	
	
	 @Autowired
		IserviceTechnologie st;
	 
	 @Autowired
		IserviceProjet sp;
	 
	 
	 
	 
	 @GetMapping("/all")
	  public String getAllTechnologies(Model m)
	  {
		  List<Technologie>liste_technologie=st.GetAllTechnologie();
		  List<Projet>liste_projet=sp.GetAllProjet();
		  m.addAttribute("liste_technologie", liste_technologie);
		  m.addAttribute("liste_projet", liste_projet);
		  
		  
		  
		  return "vuetechnologie";
	  }
	 
	 
	 
	 
	 @GetMapping("/ajoutertechnologie")
	  public String ajouterTechnologie(Model m)
	  {
		  
		  return "ajoutertechnologie";
	  }
	 
	 
	 @GetMapping("/supprimertechnologie/{id}")
	  public String supprimertechnologie(@PathVariable int id) throws IOException
	  {
		  
		  st.SupprimerTechnologie(id);
		  return "redirect:/technologie/all";
	  }
	
	 
	 
	 
	  @PostMapping("/sauvgardertechnologie")
	  public String sauvgarderTechnologie(@ModelAttribute Technologie t,Model m) throws IOException
	  {
		  Integer id=t.getId();
		  st.SaveTechnologie(t);
		 
		  if(id!=null) // modification
		  {
			  return"redirect:/technologie/all";
		  }
		  else // ajouter
		  {
			  m.addAttribute("message", "ajouter avec suceés");
			  return "ajoutertechnologie";
		  }
			  
	  }
	  
	  @GetMapping("/modifiertechnologie/{idp}")
	  public String modifierTechnologie(Model m,@PathVariable("idp")int id)
	  {
		  m.addAttribute("technologie", st.GetTechnologie(id));
		  return "ajoutertechnologie";
	  }

}
