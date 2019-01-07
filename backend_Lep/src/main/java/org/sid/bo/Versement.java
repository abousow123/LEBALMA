package org.sid.bo;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Versement implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idverser;

	private double montantverser;

	private java.util.Date dateversement;
	
	private int identiteClient ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cni", nullable = true)
	@JsonBackReference
	Client client ;

	public Versement() {
		super();
	}

	public Versement(double montantverser, Date dateversement) {
		super();
		this.montantverser = montantverser;
		this.dateversement = dateversement;
	}

	public Versement(int idverser, double montantverser, Date dateversement) {
		super();
		this.idverser = idverser;
		this.montantverser = montantverser;
		this.dateversement = dateversement;
	}
	
	

	public Versement(int idverser, double montantverser, Date dateversement, Client client) {
		super();
		this.idverser = idverser;
		this.montantverser = montantverser;
		this.dateversement = dateversement;
		this.client = client;
	}

	public int getIdverser() {
		return idverser;
	}

	public void setIdverser(int idverser) {
		this.idverser = idverser;
	}

	public double getMontantverser() {
		return montantverser;
	}

	public void setMontantverser(double montantverser) {
		this.montantverser = montantverser;
	}

	public java.util.Date getDateversement() {
		return dateversement;
	}

	public void setDateversement(java.util.Date dateversement) {
		this.dateversement = dateversement;
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