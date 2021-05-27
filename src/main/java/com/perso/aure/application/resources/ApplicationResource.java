package com.perso.aure.application.resources;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.perso.aure.application.domain.Annonce;
import com.perso.aure.application.domain.Application;
import com.perso.aure.application.domain.Domain;
import com.perso.aure.application.domain.Entreprise;
import com.perso.aure.application.domain.Interview;
import com.perso.aure.application.repositories.EntreprisesRepository;
import com.perso.aure.application.services.ApplicationService;

@Controller
public class ApplicationResource {

	private final ApplicationService applicationService;
	
	public ApplicationResource(ApplicationService applicationService, EntreprisesRepository entreprisesRepository) {
		this.applicationService = applicationService;
	}
	
	@PostMapping("applications/create")
	public ModelAndView createApplication(Application applicationData) {
//		applicationService.createApplication(application);
		return new ModelAndView("/applications");
	}
	
//	@PostMapping("/{applicationId}/motivationLetter")
//	public Application addApplicationMotivationLetter() {
//		
//	}
	
	@PostMapping("/applicationsCreate")
	public ModelAndView applicationCreation(ModelAndView modelAndView, @ModelAttribute Application data) {
		applicationService.createApplication(data);
//		modelAndView.setViewName("applicationsCreate");
		
		modelAndView.setViewName("redirect:/applications");
		return modelAndView;
	}
	
	@GetMapping("/applications/{applicationId}/annonces")
	public ModelAndView annonceCreate(@PathVariable Long applicationId, ModelAndView modelAndView) {
		System.out.println(applicationId.toString());
		modelAndView.setViewName("annoncesCreate");
		modelAndView.addObject("annonce", new Annonce());
		return modelAndView;
	}
	
	@PostMapping("/applications/{applicationId}/annonces")
	public ModelAndView annonceCreate(@PathVariable Long applicationId, ModelAndView modelAndView, @ModelAttribute Annonce annonce) {
		System.out.println(annonce.toString());
		modelAndView.addObject("applicationId", applicationId);
		applicationService.createAnnonce(annonce, applicationId);
		modelAndView.setViewName("redirect:/applications");
		return modelAndView;
	}
	
//	@GetMapping("/applications")
//	public ModelAndView applicationCreation(Model model)  {
//		List<Domain> domains = applicationService.getAllDomains();
//		model.addAttribute("domains", domains);
//		return new ModelAndView("applicationsCreate");
//	}
	
	@PostMapping("/applications/{applicationId}/interviews")
	public ModelAndView createInterview(@ModelAttribute Interview interview, @PathVariable Long applicationId, ModelAndView modelAndView) {
		modelAndView.addObject("applicationId", applicationId);
		System.out.println(interview.toString());
		modelAndView.setViewName("redirect:/applications");
		return modelAndView;
	}
	
	@GetMapping("/applications/{applicationId}/interviews")
	public ModelAndView createInterview(@PathVariable Long applicationId, ModelAndView modelAndView) {
		modelAndView.setViewName("interviewsCreate");
		modelAndView.addObject("interview", new Interview());
		return modelAndView;
	}
	
	@GetMapping("/applicationsCreate")
	public ModelAndView createApplication(ModelAndView modelAndView) {
		modelAndView.setViewName("applicationsCreate");
		List<Domain> domains = applicationService.getAllDomains();
		modelAndView.addObject("domains", domains);
		modelAndView.addObject("application", new Application());
		return modelAndView;
	}
	
	@PostMapping("/applicationsDelete/{applicationId}")
	public ModelAndView deleteApplication(@PathVariable Long applicationId, ModelAndView modelAndView) {
		System.out.println(applicationId);
//		applicationService.delete(applicationId);
		modelAndView.setViewName("redirect:/applications");
		return modelAndView;
	}
	//FIXME trouver une solution pour le deleteApplication
	@GetMapping("/applicationsDelete/{applicationId}")
	public ModelAndView deleteApplicationTemplate(@PathVariable Long applicationId, ModelAndView modelAndView) {
		applicationService.delete(applicationId);
		modelAndView.setViewName("redirect:/applications");
//		modelAndView.setViewName("redirect:/applicationsDelete/" + applicationId);
		return modelAndView;
	}
	
	@GetMapping("/applications")
	public ModelAndView getApplications(Model model) {
		ArrayList applications = new ArrayList<Application>();
		applications = (ArrayList) applicationService.getAllApplications();
		//Test
//		Application applicationData = new Application();
//		applicationData.setDate(Date.from(Instant.now()));
//		Entreprise entreprise = new Entreprise();
//		entreprise.setAdress("3 allée du test");
//		entreprise.setName("ENTREPRISE TEST");
//		Domain domain = new Domain();
//		domain.setName("JAVA");
//		Set<Domain> domains = new HashSet<Domain>();
//		domains.add(domain);
//		entreprise.setDomains(domains);
//		applicationData.setEntreprise(entreprise);
//		applications.add(applicationData);
//		applications.add(applicationData);
//		applications.add(applicationData);
//		applications.add(applicationData);
//		applications.add(applicationData);
//		applications.add(applicationData);
//		applications.add(applicationData);
		model.addAttribute("test", applications);
//		model.addAttribute("applicationId", new Long("-1"));
		return new ModelAndView("/applications");
	}
	
//	@GetMapping("/{applicationId}")
//	public Application getApplication(@PathVariable("applicationId") Long applicationId) {
//		
//	}
//	
//	@PutMapping("/{applicationId}/interviews/{interviewId}")
//	public Application modifyApplicationInterview(@PathVariable("applicationId") Long applicationId) {
//		
//	}
//	
//	@PutMapping("/{applicationId}/status")
//	public Application modifyApplicationStatus(@PathVariable("applicationId") Long applicationId) {
//		
//	}

}
