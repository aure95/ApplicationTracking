package com.perso.aure.application.domain;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name="domains")
public class Domain {

	@Id
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
