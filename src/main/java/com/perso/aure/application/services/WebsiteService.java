package com.perso.aure.application.services;

import java.util.List;

import com.perso.aure.application.domain.Website;
import com.perso.aure.application.repositories.WebsiteRepository;

public class WebsiteService {
	
	private final WebsiteRepository websiteRepository;
	
	public WebsiteService(WebsiteRepository websiteRepository) {
		this.websiteRepository = websiteRepository;
	}
	
	public Website create(Website website) {
		return websiteRepository.save(website);
	}
	
	public List<Website> getAll() {
		return (List<Website>) websiteRepository.findAll();
	}

}
