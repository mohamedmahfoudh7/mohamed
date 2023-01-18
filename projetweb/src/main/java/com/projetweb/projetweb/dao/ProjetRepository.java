package com.projetweb.projetweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetweb.projetweb.entities.Projet;
@Repository

public interface ProjetRepository extends JpaRepository<Projet, Integer>  {

}
