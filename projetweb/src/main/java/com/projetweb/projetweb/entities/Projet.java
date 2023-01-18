package com.projetweb.projetweb.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
public class Projet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String code;
	private String description;
	private String photo ;
	
	
	
	@ManyToOne(cascade = { CascadeType.DETACH,  CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Encadrant encadrant;
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY,cascade =  CascadeType.ALL,mappedBy = "projet")
	private Stagiare stagiare;
	
	@ManyToMany
	private List<Technologie> liste_technologies ;
}
