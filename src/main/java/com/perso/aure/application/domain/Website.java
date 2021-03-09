package com.perso.aure.application.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Website {
	
	@Id
	private String name;
	
	@ManyToMany
	@JoinTable(name = "website_annonce",
	joinColumns = @JoinColumn(name = "website_name"),
	inverseJoinColumns = @JoinColumn(name = "annonce_url"))
	private Set<Annonce> annonces;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Annonce> getAnnonces() {
		return annonces;
	}

	public void setAnnonces(Set<Annonce> annonces) {
		this.annonces = annonces;
	}
	
	public String toString() {
		return "Website [name=" + name + ", annonces=" + annonces + "]";
	}
}
