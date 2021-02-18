package com.perso.aure.application.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Annonce {
	
	@Id
	private String url;
	private String name;
	private Date date;
	
	public Annonce(String url, String name, Date date) {
		this.url= url;
		this.name = name;
		this.date = date;
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
		return "Annonce [url=" + url + ", name=" + name + ", date=" + date + "]";
	}

}
