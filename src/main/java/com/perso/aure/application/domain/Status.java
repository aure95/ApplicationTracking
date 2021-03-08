package com.perso.aure.application.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Status {
	
	@Id
	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String toString() {
		return "Status [label=" + label + "]";
	}

}
