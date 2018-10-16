package test;



import java.util.List;

import daoImpl.PretImpl;
import entity.Pret;

public class Test {

	public static void main(String[] args) {
		
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		//Pret p = new Pret(2, 5000, sqlDate) ;
		
		PretImpl pr = new PretImpl() ;
		Pret p = pr.getPret(2) ;
		//p.setMontant(600);
		pr.deletePret(1);
		//pr.addPret(p);
		List<Pret> pl = pr.getAllPrets() ;
		//if(a==null) System.out.println("wrong");
		
		for (int i = 0; i < pl.size(); i++) {
			System.out.println(pl.get(i).getIdpret()+" "+pl.get(i).getMontant());
		}
		
		//System.out.println(a.getIdpret()+" "+ a.getMontant()+" "+a.getDatepret());
	}
}
