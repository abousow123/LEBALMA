package org.sid.bo;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
//@Table(name = "Pret")
public class Pret implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idpret;

	private double montant;

	private java.util.Date datepret;
	
	private int identiteClient ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cni", nullable = true)
	@JsonBackReference
	private Client client ;

	public Pret() {
		super();
	}

	public Pret(int idpret, double montant, Date datepret) {
		super();
		this.idpret = idpret;
		this.montant = montant;
		this.datepret = datepret;
	}

	public Pret(double montant, Date datepret) {
		super();
		this.montant = montant;
		this.datepret = datepret;
	}

	
	
	public Pret(double montant, Date datepret, Client client) {
		super();
		this.montant = montant;
		this.datepret = datepret;
		this.client = client;
	}

	public int getIdpret() {
		return idpret;
	}

	public void setIdpret(int idpret) {
		this.idpret = idpret;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public java.util.Date getDatepret() {
		return datepret;
	}

	public void setDatepret(java.util.Date datepret) {
		this.datepret = datepret;
	}

	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getIdentiteClient() {
		return identiteClient;
	}

	public void setIdentiteClient(int identiteClient) {
		this.identiteClient = identiteClient;
	}
	
	

	
}