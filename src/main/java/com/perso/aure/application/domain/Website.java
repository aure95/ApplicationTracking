package com.perso.aure.application.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Website {
	
	@Id
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Website [name=" + name + "]";
	}
}
