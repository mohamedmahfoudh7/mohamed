package com.projetweb.projetweb.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.projetweb.projetweb.dao.ProjetRepository;
import com.projetweb.projetweb.dao.TechnologieRepository;
import com.projetweb.projetweb.entities.Projet;
import com.projetweb.projetweb.entities.Technologie;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ServiceProjet implements IserviceProjet {
	
	@Autowired
	ProjetRepository pr;
	
	@Autowired
	TechnologieRepository tr;

/*
	@Override
	public void SaveProjet(Projet p) {
		pr.save(p);
		
	}
	*/

	@Override
	public List<Projet> GetAllProjet() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public Projet GetProjet(int id) {
		// TODO Auto-generated method stub
		return pr.findById(id).get();
	}

	@Override
	public List<Projet> GetProjetByMc(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void SupprimerProjet(int id) {
		pr.deleteById(id);
		
	}

	@Override
	public void AffectationProjetTechnologie(Projet idc, Technologie idp) {
		// TODO Auto-generated method stub
		idc.getListe_technologies().add(idp);
		tr.save(idp);
		
	}

	@Override
	public String saveImage(MultipartFile mf) throws IOException {
		String nameFile = mf.getOriginalFilename();
		String tab[] = nameFile.split("\\.");
		String fileModif = tab[0] +"_"+ System.currentTimeMillis()+"."+tab[1];
		String chemin = System.getProperty("user.dir")+"/src/main/webapp/imagesdata/";
		Path p = Paths.get(chemin, fileModif);
		Files.write(p,mf.getBytes());
		return fileModif;
	}

	@Override
	public byte[] getImage(int id) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerImage(Integer idprojet) throws IOException {
Projet p =pr.getById(idprojet);
		
		String chemin =System.getProperty("user.dir")+"/src/main/webapp/imagesdata/";
		Path path=Paths.get(chemin,p.getPhoto());
		Files.delete(path);
		
	}

	@Override
	public void SaveProjet(Projet p, MultipartFile mf) throws IOException {

		String photo;
		if(!mf.getOriginalFilename().equals(""))
		{
			photo=saveImage(mf);
			p.setPhoto(photo);
		
		}
		pr.save(p);			
	}

	@Override
	public List<Technologie> getTechnologieByProjet(int idc) {
		return pr.getById(idc).getListe_technologies();
	}

	
}
