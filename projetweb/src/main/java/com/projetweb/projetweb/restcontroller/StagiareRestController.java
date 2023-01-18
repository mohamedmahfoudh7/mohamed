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
import org.springframework.web.bind.annotation.RestController;

import com.projetweb.projetweb.entities.Stagiare;
import com.projetweb.projetweb.service.IserviceStagiare;

@RestController
@RequestMapping("/restapistagiare")
@CrossOrigin(origins = "http://localhost:4200")
public class StagiareRestController {
	
	
	
	@Autowired
	IserviceStagiare ss;
	
	/*
	@GetMapping("/all")
	public List<Stagiare>GetAllStagiare()
	{
		return ss.GetAllStagiare();
	}
	
*/

	@PostMapping("/add")
	public void SaveStagiare (@RequestBody Stagiare s) throws IOException{
		//Projet pro = new ObjectMapper().readValue(p, Projet.class);
		ss.SaveStagiare(s);
		
	}
/*
	@DeleteMapping("/delete/{id}")
	public void DeleteStagiare(@PathVariable int id) throws IOException{
		ss.SupprimerStagiare(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Stagiare s) throws IOException {
		ss.SaveStagiare(s);
	}

*/
}
