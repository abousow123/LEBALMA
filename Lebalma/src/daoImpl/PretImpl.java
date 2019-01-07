package daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import dao.DBconnexion;
import dao.IPret;
import entity.Pret;

public class PretImpl implements IPret {
	
	Connection dbConnection = null;
	PreparedStatement preparedStatement = null;
	Statement st=null;
	ResultSet rs=null;
	
	@Override
	public void addPret(Pret p)  {
		// TODO Auto-generated method stub
		dbConnection = DBconnexion.getConnection() ;
		
		
		try {
			preparedStatement = dbConnection.prepareStatement("INSERT INTO Pret(idpret,cni,montant,datepret)"
					+ " values(?,?,?,?);") ;
			preparedStatement.setInt(1, p.getIdpret());
			preparedStatement.setInt(2, p.getCni());
			preparedStatement.setDouble(3, p.getMontant());
			preparedStatement.setDate(4,  (Date) p.getDatepret());
			
			
			preparedStatement.executeUpdate();
			preparedStatement.close();

			System.out.println("Record is inserted into DBUSER table!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	@SuppressWarnings("unused")
	@Override
	public Pret getPret(int idPret) {
		// TODO Auto-generated method stub
		dbConnection = DBconnexion.getConnection() ;
	
		
		try {
			st = dbConnection.createStatement();
			rs = st.executeQuery("SELECT idpret,montant,datepret FROM Pret WHERE idpret="+idPret) ;
			
			if (rs.next()){
				int id = rs.getInt("idpret") ;
				double montant = rs.getDouble("montant") ;
				Date d = rs.getDate("datepret") ;
				
				return new Pret(id, montant, d);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public List<Pret> getAllPrets() {
		dbConnection = DBconnexion.getConnection() ;
		List<Pret> plist = new ArrayList<>() ;
		
		try {
			st = dbConnection.createStatement();
			rs = st.executeQuery("SELECT idpret,montant,datepret FROM Pret;") ;
			
			while (rs.next()){
				int id = rs.getInt("idpret") ;
				double montant = rs.getDouble("montant") ;
				Date d = rs.getDate("datepret") ;
				Pret p = new Pret() ;
				p.setIdpret(id);
				p.setMontant(montant);
				p.setDatepret(d);
				plist.add(p) ;
			}
			
			return plist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public boolean updatePret(int idPred, Pret p) {
		
		dbConnection = DBconnexion.getConnection() ;
		try {
			preparedStatement = dbConnection.prepareStatement("UPDATE Pret SET montant=?,datepret=? WHERE idpret="+idPred);
			
			
			preparedStatement.setDouble(1, p.getMontant());
			preparedStatement.setDate(2, (Date) p.getDatepret());
			
				preparedStatement.executeUpdate();
				preparedStatement.close();
				
			    return true ;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public void deletePret(int idPret) {
		// TODO Auto-generated method stub
		dbConnection = DBconnexion.getConnection() ;
		try {
			preparedStatement = dbConnection.prepareStatement("DELETE FROM Pret WHERE idpret="+idPret) ;
			preparedStatement.executeUpdate() ;
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
