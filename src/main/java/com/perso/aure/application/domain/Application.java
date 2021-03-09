package com.perso.aure.application.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Application {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Date date;
	private String label_status;
	
	@ManyToOne(optional = false)
	@JoinColumn(name= "fk_status_label", referencedColumnName= "label")
	private Status status;
	
	@OneToMany(mappedBy = "application")
	private List<Interview> interview;
	
	@OneToOne(mappedBy = "application")
	private MotivationLetter motivationLetter;
	
	@OneToOne(mappedBy = "application")
	private Entreprise entreprise;
	
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
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public List<Interview> getInterview() {
		return interview;
	}
	
	public void setInterview(List<Interview> interview) {
		this.interview = interview;
	}
	
	public MotivationLetter getMotivationLetter() {
		return motivationLetter;
	}

	public void setMotivationLetter(MotivationLetter motivationLetter) {
		this.motivationLetter = motivationLetter;
	}
	
	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	
	public String toString() {
		return "Application [id=" + id + ", date=" + date + ", label_status=" + label_status + ", status=" + status
				+ ", interview=" + interview + ", motivationLetter=" + motivationLetter + ", entreprise=" + entreprise
				+ "]";
	}
	
}
