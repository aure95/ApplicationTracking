package com.perso.aure.application.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class MotivationLetter {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String content;
	
	@OneToOne
	private Application application;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	
	public String toString() {
		return "MotivationLetter [id=" + id + ", content=" + content + ", application=" + application + "]";
	}
	
}
