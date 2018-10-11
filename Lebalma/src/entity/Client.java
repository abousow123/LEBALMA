/***********************************************************************
 * Module:  Client.java

 * Author:  sow
 * Purpose: Defines the Class Client
 ***********************************************************************/

package entity;

import java.util.*;

public class Client {

	private int cni;

	private String prenom;

	private String nom;

	private String adresse;

	private int telephone;

	public Pret pret;

	public java.util.Collection<Versement> versement;

	public Client(int cni, String prenom, String nom, String adresse, int telephone, Pret pret,
			Collection<Versement> versement) {
		super();
		this.cni = cni;
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.pret = pret;
		this.versement = versement;
	}

	public Client(int cni, String prenom, String nom, String adresse, int telephone) {
		super();
		this.cni = cni;
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
	}

	public Client(int cni, String prenom, String nom, String adresse, int telephone, Pret pret) {
		super();
		this.cni = cni;
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.pret = pret;
	}

	

	
	// Getters and Setters
	
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

	public Pret getPret() {
		return pret;
	}

	public void setPret(Pret pret) {
		this.pret = pret;
	}

	public java.util.Collection<Versement> getVersement() {
		return versement;
	}

	public void setVersement(java.util.Collection<Versement> versement) {
		this.versement = versement;
	}

}