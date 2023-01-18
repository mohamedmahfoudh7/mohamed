package com.projetweb.projetweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetweb.projetweb.dao.EncadrantRepository;
import com.projetweb.projetweb.entities.Encadrant;
import com.projetweb.projetweb.entities.Projet;


@Service
public class ServiceEncadrant implements IserviceEncadrant {

	@Autowired
	EncadrantRepository er;
	
	@Override
	public void SaveEncadrant(Encadrant e) {
		er.save(e);
		
	}

	@Override
	public List<Encadrant> GetAllEncadrant() {
		// TODO Auto-generated method stub
		return er.findAll();
	}

	@Override
	public Encadrant GetEncadrant(int id) {
		// TODO Auto-generated method stub
		return er.findById(id).get();
	}

	@Override
	public List<Encadrant> GetEncadrantByMc(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void SupprimerEncadrant(int id) {
		er.deleteById(id);
		
	}

	@Override
	public List<Projet> getProductsByCategorie(int idc) {
		// TODO Auto-generated method stub
		return er.getById(idc).getListe_projet();
	}

	
	
}
