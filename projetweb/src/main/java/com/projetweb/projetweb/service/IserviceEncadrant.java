package com.projetweb.projetweb.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.projetweb.projetweb.entities.Encadrant;
import com.projetweb.projetweb.entities.Projet;



public interface IserviceEncadrant {
	
	void SaveEncadrant( @RequestBody Encadrant e);
	List<Encadrant>GetAllEncadrant();
	Encadrant GetEncadrant(int id);
	List<Encadrant>GetEncadrantByMc(String key);
	void SupprimerEncadrant(int id);
	public List<Projet> getProductsByCategorie(int idc);

}
