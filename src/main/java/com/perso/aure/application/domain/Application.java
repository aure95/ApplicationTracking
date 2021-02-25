package com.perso.aure.application.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Application {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Date date;
	private String label_status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLabel_status() {
		return label_status;
	}
	public void setLabel_status(String label_status) {
		this.label_status = label_status;
	}
	public String toString() {
		return "Application [id=" + id + ", date=" + date + ", label_status=" + label_status + "]";
	}
	
}
