package com.projetweb.projetweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetweb.projetweb.dao.TechnologieRepository;
import com.projetweb.projetweb.entities.Technologie;

@Service
public class ServiceTechnologie implements IserviceTechnologie {

	
	@Autowired
	TechnologieRepository tr;
	
	@Override
	public void SaveTechnologie(Technologie t) {
		tr.save(t);		
	}

	@Override
	public List<Technologie> GetAllTechnologie() {
		// TODO Auto-generated method stub
		return tr.findAll();
	}

	@Override
	public Technologie GetTechnologie(int id) {
		// TODO Auto-generated method stub
		return tr.findById(id).get();
	}

	@Override
	public void SupprimerTechnologie(int id) {
		// TODO Auto-generated method stub
		tr.deleteById(id);
		
	}

}
