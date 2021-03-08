package com.perso.aure.application.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="entreprises")
public class Entreprise {
	
	@Id
	private String name;
	private String adress;
	
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
	
	 

}
