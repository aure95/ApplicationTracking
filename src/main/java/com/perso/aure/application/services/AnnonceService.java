package com.perso.aure.application.services;

import org.springframework.stereotype.Service;

import com.perso.aure.application.domain.Annonce;
import com.perso.aure.application.repositories.AnnonceRepository;

@Service
public class AnnonceService {
	
	private final AnnonceRepository annonceRepository;
	
	private final EntrepriseService entrepriseService;
	
	public AnnonceService(AnnonceRepository annonceRepository,
			EntrepriseService entrepriseService) {
		this.annonceRepository = annonceRepository;
		this.entrepriseService = entrepriseService;
	}
	
	public Annonce create(Annonce annonce) throws Exception {
		if (annonce != null) {
			boolean exist = annonceRepository.existsById(annonce.getUrl());
			if (exist) {
				throw new Exception(String.format("Annonce url %s already exist", annonce.getUrl()));
			}
			annonce = annonceRepository.save(annonce);
		}
		return annonce;
	}
	
	
	
}
