/***********************************************************************
 * Module:  Pret.java
 * Author:  sow
 * Purpose: Defines the Class Pret
 ***********************************************************************/
package entity;

import java.util.*;

public class Pret {

	private int idpret;

	private double montant;

	private java.util.Date datepret;

	public Pret(int idpret, double montant, Date datepret) {
		super();
		this.idpret = idpret;
		this.montant = montant;
		this.datepret = datepret;
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
	
	
	

}