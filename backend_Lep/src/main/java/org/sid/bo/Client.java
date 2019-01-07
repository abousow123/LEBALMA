package org.sid.bo;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
//@Table(name = "Client")
public class Client implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int cni;

	private String prenom;

	private String nom;

	private String adresse;

	private int telephone;

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	@JsonManagedReference
	public Set<Pret> pret;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	@JsonManagedReference
	public java.util.Set<Versement> versement;

	public Client() {
		super();
	}
	
	

	public Client(int cni, String prenom, String nom, String adresse, int telephone) {
		super();
		this.cni = cni;
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
	}


	

	public Client(int cni, String prenom, String nom, String adresse, int telephone, Set<Pret> pret,
			Set<Versement> versement) {
		super();
		this.cni = cni;
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.pret = pret;
		this.versement = versement;
	}



	public int getCni() {
		return cni;
	}

	public void setCni(int cni) {
		this.cni = cni;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	
	public Set<Pret> getPret() {
		return pret;
	}

	public void setPret(Set<Pret> pret) {
		this.pret = pret;
	}

	
	public java.util.Set<Versement> getVersement() {
		return versement;
	}

	
	public void setVersement(java.util.Set<Versement> versement) {
		this.versement = versement;
	}

}