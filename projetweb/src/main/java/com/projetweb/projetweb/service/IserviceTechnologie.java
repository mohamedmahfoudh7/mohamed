package com.projetweb.projetweb.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.projetweb.projetweb.entities.Technologie;

public interface IserviceTechnologie {

	void SaveTechnologie( @RequestBody Technologie t);
	List<Technologie>GetAllTechnologie();
	Technologie GetTechnologie(int id);
	void SupprimerTechnologie(int id);
	
	
}
