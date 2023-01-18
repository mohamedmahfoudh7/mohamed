package com.projetweb.projetweb.restcontroller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projetweb.projetweb.entities.Projet;
import com.projetweb.projetweb.service.IserviceProjet;


@RestController
@RequestMapping("/restapiprojet")
@CrossOrigin(origins="http://localhost:4200")
public class ProjetRestController {

	
	@Autowired
	IserviceProjet sp;
	
	@GetMapping("/all")
	public List<Projet>GetAllProjet()
	{
		return sp.GetAllProjet();
	}
	

/*
	@PostMapping("/add")
	public void SaveProjet (@RequestBody Projet p,@RequestParam("file") MultipartFile mf) throws IOException{
		//Projet pro = new ObjectMapper().readValue(p, Projet.class);
		sp.SaveProjet(p,mf);
		
	}

	@DeleteMapping("/delete/{id}")
	public void DeleteProjet(@PathVariable int id) throws IOException{
		sp.SupprimerProjet(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody Projet p,@RequestParam("file") MultipartFile mf) throws IOException {
		sp.SaveProjet(p,mf);
	}
	
	*/
}
