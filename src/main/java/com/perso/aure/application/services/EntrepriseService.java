package com.perso.aure.application.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.perso.aure.application.domain.Entreprise;
import com.perso.aure.application.repositories.EntreprisesRepository;

@Service
public class EntrepriseService {
	
	private final EntreprisesRepository entrepriseRepository;
	
	public EntrepriseService(EntreprisesRepository entrepriseRepository) {
		this.entrepriseRepository = entrepriseRepository;
	}
	
	public Entreprise create(Entreprise entreprise) throws Exception{
		if (entreprise != null) {
			boolean exist = entrepriseRepository.existsById(entreprise.getName());
			if (exist) {
				throw new Exception(String.format("entreprise name : %s already exist", entreprise.getName()));
			}
			entreprise = entrepriseRepository.save(entreprise); 
		}
		return entreprise;
	}
	
	public Entreprise getEntreprise(String name) {
		Entreprise entrepriseResult = null;
		Optional<Entreprise> entreprise = entrepriseRepository.findById(name);
		if (entreprise.isPresent()) {
			entrepriseResult = entreprise.get();
		}
		return entrepriseResult;
	}

}
