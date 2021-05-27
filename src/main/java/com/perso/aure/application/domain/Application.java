package com.perso.aure.application.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Application {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Date date;
//	private String statusLabel;
	
	@ManyToOne(optional = false)
	@JoinColumn(name= "status_label", referencedColumnName= "label")
	private Status status;
	
	@OneToMany(mappedBy = "application")
	private List<Interview> interview;
	
	@OneToOne
	@JoinColumn(name = "motivation_letter_id", referencedColumnName = "id")
	private MotivationLetter motivationLetter;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "entreprise_name", referencedColumnName = "name")
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
	
//	public String getStatusLabel() {
//		return statusLabel;
//	}
	
//	public void setStatusLabel(String statusLabel) {
//		this.statusLabel = statusLabel;
//	}
	
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
		return "Application [id=" + id + ", date=" + date + ", status=" + status + ", interview=" + interview
				+ ", motivationLetter=" + motivationLetter + ", entreprise=" + entreprise + "]";
	}
	
}
