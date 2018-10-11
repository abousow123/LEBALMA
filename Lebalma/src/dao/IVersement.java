package dao;

import java.util.List;

import entity.Versement;

public interface IVersement {
	public void addVersement(Versement v);
	public Versement getVersement(int idV);
	public List<Versement> getAllVersement();
	public boolean updateVersement(int idV,Versement v) ;
	public void deleteVersement(int idV) ;
		

}
