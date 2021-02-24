package com.perso.aure.application.services;

import java.sql.Date;
import java.time.Instant;

import org.springframework.stereotype.Service;

import com.perso.aure.application.domain.Annonce;
import com.perso.aure.application.repositories.AnnonceRepository;

@Service
public class AnnonceService {
	
	private final AnnonceRepository annonceRepository;
	
	public AnnonceService(AnnonceRepository annonceRepository) {
		this.annonceRepository = annonceRepository;
	}
	
	public void test() {
		Annonce annonce = new Annonce();
		annonce.setName("test");
		annonce.setUrl("https://myUrlTest");
		annonce.setDate(Date.from(Instant.now()));
		annonceRepository.save(annonce);
	}
	
}
