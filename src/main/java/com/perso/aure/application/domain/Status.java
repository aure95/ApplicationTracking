package com.perso.aure.application.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Status {
	
	@Id
	private String label;
	
	@OneToMany(mappedBy = "status")
	private List<Application> applications;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public String toString() {
		return "Status [label=" + label +"]";
	}
	
}
