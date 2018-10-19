/***********************************************************************
 * Module:  Versement.java
 * Author:  sow
 * Purpose: Defines the Class Versement
 ***********************************************************************/
package entity;

import java.util.*;

public class Versement {

	private int idverser;

	private double montantverser;

	private java.util.Date dateversement;

	private int cni;

	public Versement(int idverser, double montantverser, Date dateversement, int cni) {
		super();
		this.idverser = idverser;
		this.montantverser = montantverser;
		this.dateversement = dateversement;
		this.cni = cni;
	}

	public Versement(double montantverser, Date dateversement, int cni) {
		super();
		this.montantverser = montantverser;
		this.dateversement = dateversement;
		this.cni = cni;
	}
	
	
	
	
	
	
	
	// getters and setters

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

	public int getCni() {
		return cni;
	}

	public void setCni(int cni) {
		this.cni = cni;
	}
	
	
	

}