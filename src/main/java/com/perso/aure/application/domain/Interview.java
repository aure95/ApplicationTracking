package com.perso.aure.application.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Interview {
	
	@Id
	private String adress;
	private String contactName;
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "fk_application_id", referencedColumnName = "id")
	private Application application;
	
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	
	public String toString() {
		return "Interview [adress=" + adress + ", contactName=" + contactName + ", date=" + date + "]";
	}
	
}
