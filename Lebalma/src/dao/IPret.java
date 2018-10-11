package dao;

import java.util.List;

import entity.Pret;

public interface IPret {
	
	public void addPret(Pret p);
	public Pret getPret(int idPret);
	public List<Pret> getAllPrets();
	public boolean updatePret(int idPred,Pret p);
	public void deletePret(int idPret);

}
