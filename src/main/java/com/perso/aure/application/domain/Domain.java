package com.perso.aure.application.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Domain {

	@Id
	private String name;
	
	@ManyToMany(mappedBy = "domains")
	private Set<Entreprise> entreprises;
	
	@ManyToMany(mappedBy = "domains")
	private Set<Annonce> annonces;

	public Set<Entreprise> getEntreprises() {
		return entreprises;
	}

	public void setEntreprises(Set<Entreprise> entreprises) {
		this.entreprises = entreprises;
	}

	public Set<Annonce> getAnnonces() {
		return annonces;
	}

	public void setAnnonces(Set<Annonce> annonces) {
		this.annonces = annonces;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "Domain [name=" + name + ", entreprises=" + entreprises + ", annonces=" + annonces + "]";
	}
	
}
