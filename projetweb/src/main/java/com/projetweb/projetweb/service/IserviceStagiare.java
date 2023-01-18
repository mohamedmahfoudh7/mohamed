package com.projetweb.projetweb.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.projetweb.projetweb.entities.Stagiare;

public interface IserviceStagiare {

	void SaveStagiare( @RequestBody Stagiare e);
	List<Stagiare>GetAllStagiare();
	Stagiare GetStagiare(int id);
	List<Stagiare>GetStagiareByMc(String key);
	void SupprimerStagiare(int id);
	
}
