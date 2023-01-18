package com.projetweb.projetweb.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projetweb.projetweb.dao.ProjetRepository;
import com.projetweb.projetweb.entities.Projet;
import com.projetweb.projetweb.entities.Technologie;
import com.projetweb.projetweb.service.IserviceProjet;
import com.projetweb.projetweb.service.IserviceTechnologie;
@Controller
@RequestMapping("/affectation")
public class AffectationController {

	@Autowired
	IserviceProjet sp;
	
	@Autowired
	IserviceTechnologie st;
	
	@Autowired
	ProjetRepository pr;
	
	
	@GetMapping("/affectation_projet_technologie")
	public String affecterProjetTechnologie(Model m) {
		List<Projet>liste_projet=sp.GetAllProjet();
		m.addAttribute("liste_projet",liste_projet);
		List<Technologie>liste_technologie=st.GetAllTechnologie();
		m.addAttribute("liste_technologie",liste_technologie);
		
		return "affectation_projet_technologie";
}
	
	@PostMapping("/saveaffecter")
	public String affecterFormation ( Projet p,Technologie t,Model m )throws IOException  {
	sp.AffectationProjetTechnologie(p, t);
	List<Projet>liste_projet=sp.GetAllProjet();
	m.addAttribute("liste_projet",liste_projet);
	List<Technologie>liste_technologie=st.GetAllTechnologie();
	m.addAttribute("liste_technologie",liste_technologie);
	return "affectation_projet_technologie";
	}
	
	@GetMapping("/allaffecter")
	public String listeAffecter(Model m)
	{
	List<Projet>liste_projet=sp.GetAllProjet();
	m.addAttribute("liste_projet",liste_projet);
	List<Technologie>liste_technologie=st.GetAllTechnologie();
	m.addAttribute("liste_technologie",liste_technologie);
	return "vueaffectation";
	}
	
	
	@GetMapping("/technologieParprojet")
	public String getProductsByMc(@RequestParam("projet") int idc,Model m)
	{
		m.addAttribute("liste_projet",sp.GetAllProjet());
		if (idc==0) {System.out.println("ok");
			m.addAttribute("liste_technologie",st.GetAllTechnologie());
			return"redirect:/affectation/allaffecter";}
			else {
				m.addAttribute("technologie",sp.getTechnologieByProjet(idc));
				m.addAttribute("projet",pr.findById(idc).get().getCode());
				return "vueaffectation";
			}
		}
	
	
}
