package com.projetweb.projetweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetweb.projetweb.dao.StagiareRepository;
import com.projetweb.projetweb.entities.Stagiare;

@Service
public class ServiceStagiare implements IserviceStagiare {

	
	
	@Autowired
	StagiareRepository sr;

	@Override
	public void SaveStagiare(Stagiare e) {
		// TODO Auto-generated method stub
		sr.save(e);
	}

	@Override
	public List<Stagiare> GetAllStagiare() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

	@Override
	public Stagiare GetStagiare(int id) {
		// TODO Auto-generated method stub
		return sr.findById(id).get();
	}

	

	@Override
	public void SupprimerStagiare(int id) {
		// TODO Auto-generated method stub
		sr.deleteById(id);
	}

	@Override
	public List<Stagiare> GetStagiareByMc(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
