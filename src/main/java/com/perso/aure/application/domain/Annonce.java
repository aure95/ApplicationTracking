package com.perso.aure.application.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Annonce {
	
	@Id
	private String url;
	private String name;
	private Date date;
	
	@ManyToMany
	@JoinTable(name = "annonce_domain",
	joinColumns = @JoinColumn(name = "annonce_url"),
	inverseJoinColumns = @JoinColumn(name = "domain_name"))
	private Set<Domain> domains;
	
	@ManyToMany(mappedBy = "annonces")
	private Set<Website> websites;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "entreprise_name", referencedColumnName = "name")
	private Entreprise entreprise;
	
	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public Set<Domain> getDomains() {
		return domains;
	}

	public void setDomains(Set<Domain> domains) {
		this.domains = domains;
	}

	public Set<Website> getWebsites() {
		return websites;
	}

	public void setWebsites(Set<Website> websites) {
		this.websites = websites;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String toString() {
		return "Annonce [url=" + url + ", name=" + name + ", date=" + date + ", domains=" + domains + ", websites="
				+ websites + ", entreprise=" + entreprise + "]";
	}

}
