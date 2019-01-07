/***********************************************************************
 * Module:  Pret.java
 * Author:  sow
 * Purpose: Defines the Class Pret
 ***********************************************************************/
package entity;


import java.util.Date;

public class Pret {

	private int idpret;

	private double montant;

	private java.util.Date datepret;
	
	private int cni ;

	public Pret(double montant, Date datepret) {
		super();
		
		this.montant = montant;
		this.datepret = datepret;
	}
	
	
	
	

	public Pret(int idpret, double montant, Date datepret) {
		super();
		this.idpret = idpret;
		this.montant = montant;
		this.datepret = datepret;
	}
	
	





	public Pret(double montant, Date datepret, int cni) {
		super();
		this.montant = montant;
		this.datepret = datepret;
		this.cni = cni;
	}





	public Pret() {
		super();
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





	public int getCni() {
		return cni;
	}





	public void setCni(int cni) {
		this.cni = cni;
	}
	
	
	
	
	

}