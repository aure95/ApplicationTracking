package com.perso.aure.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.perso.aure.application.domain.Domain;
import com.perso.aure.application.repositories.DomainsRepository;

@Service
public class DomainService {

	private final DomainsRepository domainsRepository;
	
	public DomainService(DomainsRepository domainsRepository) {
		this.domainsRepository = domainsRepository;
	}
	
	public List<Domain> getAll() {
		return (List<Domain>) domainsRepository.findAll();
	}
}
