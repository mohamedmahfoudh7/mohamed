package com.projetweb.projetweb.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Encadrant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "encadrant",cascade = { CascadeType.DETACH,  CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Projet> liste_projet=new ArrayList<Projet>();
}
