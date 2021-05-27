package com.perso.aure.application.services;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.perso.aure.application.domain.Annonce;
import com.perso.aure.application.domain.Application;
import com.perso.aure.application.domain.Domain;
import com.perso.aure.application.domain.Entreprise;
import com.perso.aure.application.domain.Status;
import com.perso.aure.application.enums.StatusEnum;
import com.perso.aure.application.repositories.AnnonceRepository;
import com.perso.aure.application.repositories.ApplicationRepository;
import com.perso.aure.application.repositories.DomainsRepository;
import com.perso.aure.application.repositories.EntreprisesRepository;

@Service
public class ApplicationService {

	private final ApplicationRepository applicationRepository;
	
	private final DomainService domainService;
	
	private final StatusService statusService;
	
	private final EntrepriseService entrepriseService;
	
	private final AnnonceService annonceService;
	
	public ApplicationService(ApplicationRepository applicationRepository, DomainService domainService
			, StatusService statusService,
			EntrepriseService entrepriseService,
			AnnonceService annonceService) {
		this.applicationRepository = applicationRepository;
		this.domainService = domainService;
		this.statusService = statusService;
		this.entrepriseService = entrepriseService;
		this.annonceService = annonceService;
	}
	
	public Application createApplication(Application application) {
		if (application != null) {
			try {
				Entreprise entreprise = entrepriseService.create(application.getEntreprise());
				if (entreprise != null) {
					Status status = statusService.getStatus(StatusEnum.INCOMPLETE);
					//test
					
		//			application = new Application();
		//			application.setId(2);
		//			Entreprise entreprise = new Entreprise();
		//			entreprise.setAdress("3 allée du test");
		//			entreprise.setName("entreprise");
		//			entrepriseRepository.save(entreprise);
					
		//			Domain domain = new Domain();
		//			domain.setName("JAVA");
		//			Set<Domain> domains = new HashSet<Domain>();
		//			domains.add(domain);
		//			entreprise.setDomains(domains);
					application.setEntreprise(entreprise);
					application.setStatus(status);
					application.setDate(Date.from(Instant.now()));
					application = applicationRepository.save(application);
				}
			} catch (Exception e) {
				application = null;
			}
		}
		return application;
	}
	
	public List<Application> getAllApplications() {
		return (List<Application>) applicationRepository.findAll();
	}
	
	public Application getApplication(Long applicationId) throws IllegalArgumentException {
		Application applicationResult = null;
		Optional<Application> application = applicationRepository.findById(applicationId.intValue());
		if (application.isPresent()) {
			applicationResult = application.get();
		}
		return applicationResult;
	}
	
	public Application delete(Long applicationId) throws IllegalArgumentException {
		Application application = getApplication(applicationId);
		if (application != null) {
			applicationRepository.deleteById(applicationId.intValue());
		}
		return application;
	}
	
	public List<Domain> getAllDomains() {
		return domainService.getAll();
	}
	
	public Annonce createAnnonce(Annonce annonce, Long applicationId) {
		if (annonce != null) {
			Application application = getApplication(applicationId);
			if (application != null ) {
				Entreprise entreprise = application.getEntreprise();
				annonce.setEntreprise(entreprise);
				annonce.setDate(Date.from(Instant.now()));
				annonce = annonceService.create(annonce);
				
			}
		}
		return annonce;
	}
	
}
