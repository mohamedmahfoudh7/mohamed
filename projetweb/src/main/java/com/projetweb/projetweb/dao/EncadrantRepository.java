package com.projetweb.projetweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetweb.projetweb.entities.Encadrant;
@Repository
public interface EncadrantRepository extends JpaRepository<Encadrant, Integer> {

}
