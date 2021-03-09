package com.perso.aure.application.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Entreprise {
	
	@Id
	private String name;
	private String adress;
	
	@OneToOne
	private Application application;
	
	@ManyToMany
	@JoinTable(name = "entreprise_domain",
	joinColumns = @JoinColumn(name = "domain_name"),
	inverseJoinColumns = @JoinColumn(name = "entreprise_name"))
	private Set<Domain> domains;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAdress() {
		return adress;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public Application getApplication() {
		return application;
	}
	
	public void setApplication(Application application) {
		this.application = application;
	}
	
	public Set<Domain> getDomains() {
		return domains;
	}

	public void setDomains(Set<Domain> domains) {
		this.domains = domains;
	}
	
	public String toString() {
		return "Entreprise [name=" + name + ", adress=" + adress + ", application=" + application + ", domains="
				+ domains + "]";
	}
	
}
