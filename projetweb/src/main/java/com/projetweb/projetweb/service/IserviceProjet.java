package com.projetweb.projetweb.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.projetweb.projetweb.entities.Projet;
import com.projetweb.projetweb.entities.Technologie;


public interface IserviceProjet {
	void SaveProjet(@RequestBody Projet p,MultipartFile mf)throws IOException;
	List<Projet>GetAllProjet();
	Projet GetProjet(int id);
	List<Projet>GetProjetByMc(String key);
	void SupprimerProjet(int id);
	public void AffectationProjetTechnologie(Projet idc, Technologie idp) ;
	String saveImage(MultipartFile mf)throws IOException ;
	public byte[] getImage(int id) throws IOException;
	void supprimerImage(Integer idProduit) throws IOException;
	public List<Technologie> getTechnologieByProjet(int idc);


}
