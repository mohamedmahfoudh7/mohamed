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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projetweb.projetweb.entities.Encadrant;
import com.projetweb.projetweb.service.IserviceEncadrant;


@RestController
@RequestMapping("/restapiencadrant")
@CrossOrigin(origins = "http://localhost:4200")
public class EncadantRestController {

	
	@Autowired
	IserviceEncadrant se;
	/*
	@GetMapping("/all")
	public List<Encadrant>GetAllEncadrant()
	{
		return se.GetAllEncadrant();
	}
	


	@PostMapping("/add")
	public void SaveEncadrant (@RequestParam("encadrant") String e) throws IOException{
		Encadrant encd = new ObjectMapper().readValue(e, Encadrant.class);
		se.SaveEncadrant(encd);
		
	}

	@DeleteMapping("/delete/{id}")
	public void DeleteEncadrant(@PathVariable int id) throws IOException{
		se.SupprimerEncadrant(id);
	}

	@PutMapping("/update")
	public void update(@RequestParam("encadrant") String e) throws IOException {
		SaveEncadrant(e);
	}
	*/
}
