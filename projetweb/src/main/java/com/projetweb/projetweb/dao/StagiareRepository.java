package com.projetweb.projetweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetweb.projetweb.entities.Stagiare;

@Repository
public interface StagiareRepository extends JpaRepository<Stagiare, Integer> {

}
