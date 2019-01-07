package test;




import daoImpl.ClientImpl;
import daoImpl.PretImpl;
import daoImpl.VersementImpl;
import entity.Client;
import entity.Pret;
import entity.Versement;

public class Test {

	public static void main(String[] args) {
		
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		
		Client c = new Client(17, "Abou", "SOW", "thiaroye", 254689) ;
		Pret p = new Pret(250000,  sqlDate,c.getCni()) ;
		
		Versement v = new Versement(2000, sqlDate, c.getCni()) ;
		
		PretImpl pr = new PretImpl() ;
		ClientImpl cl = new ClientImpl() ;
		VersementImpl vr = new VersementImpl() ;
		
		//cl.addClient(c);
		//pr.addPret(p);
		vr.addVersement(v);
		
	}
}
