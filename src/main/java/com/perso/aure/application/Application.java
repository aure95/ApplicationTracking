package com.perso.aure.application;

import java.net.http.HttpResponse;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perso.aure.application.repositories.AnnonceRepository;
import com.perso.aure.application.services.AnnonceService;

@SpringBootApplication
@ComponentScan(basePackages = "com.perso.aure.application")
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
    
}
