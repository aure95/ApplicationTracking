package com.perso.aure.application.services;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.perso.aure.application.domain.Annonce;
import com.perso.aure.application.domain.Domain;
import com.perso.aure.application.repositories.AnnonceRepository;
import com.perso.aure.application.repositories.DomainsRepository;

@Service
public class AnnonceService {
	
	private final AnnonceRepository annonceRepository;
	
	private final DomainsRepository domainRepository;
	
	public AnnonceService(AnnonceRepository annonceRepository, DomainsRepository domainRepository) {
		this.annonceRepository = annonceRepository;
		this.domainRepository = domainRepository;
	}
	
	public void test() {
		Domain domain = new Domain();
		domain.setName("JAVA");
		domainRepository.save(domain);
		Annonce annonce = new Annonce();
		annonce.setName("test");
		annonce.setUrl("https://myUrlTest2");
		annonce.setDate(Date.from(Instant.now()));
		List<Domain> domainsFound = (List<Domain>) domainRepository.findAll();
		if (domainsFound.size() != 0) {
			annonce.setDomains(domainsFound.stream().collect(Collectors.toSet()));
		}
		annonceRepository.save(annonce);
	}
	
}
