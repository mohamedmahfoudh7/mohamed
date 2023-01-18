package com.projetweb.projetweb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetweb.projetweb.entities.Projet;
import com.projetweb.projetweb.entities.Technologie;

public interface TechnologieRepository extends JpaRepository<Technologie, Integer> {
	
}
