package com.perso.aure.application.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perso.aure.application.services.AnnonceService;

@RestController
@RequestMapping("/annonces")
public class AnnonceResource {
	
	private final AnnonceService annonceService;
	
	public AnnonceResource(AnnonceService annonceService) {
		this.annonceService = annonceService;
	}
	
	@GetMapping("/hello")
	public String hello(){
		return "hello";
	}
	
	@GetMapping("/test")
	public String testBddAnnonce(){
//		annonceService.test();
		return "OK";
	}
}
