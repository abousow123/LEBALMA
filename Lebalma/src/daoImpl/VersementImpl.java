package daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DBconnexion;
import dao.IVersement;
import entity.Versement;

public class VersementImpl implements IVersement {

	@Override
	public void addVersement(Versement v) {
		// TODO Auto-generated method stub
		
		Connection dbConnection = DBconnexion.getConnection() ;
		try {
			PreparedStatement ps = dbConnection.prepareStatement("INSERT INTO Versement(idverser,cni,montantverser,"
					+ "dateversement) values(?,?,?,?)") ;
			ps.setInt(1, v.getIdverser());
			ps.setInt(2, v.getCni());
			ps.setDouble(3,v.getMontantverser());
			ps.setDate(4, (Date) v.getDateversement());
			
			ps.executeQuery();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public Versement getVersement(int idV) {
		// TODO Auto-generated method stub
		Connection dbConnection = DBconnexion.getConnection() ;
		try {
			PreparedStatement ps = dbConnection.prepareStatement("SELECT * FROM Versement WHERE idverser=?");
			ps.setInt(1, idV);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				int idv = rs.getInt("idverser") ;
				int cni = rs.getInt("cni") ;
				double montant = rs.getDouble("montantverser");
				Date date = rs.getDate("dateversement") ;
				
				return new Versement(idv, montant, date, cni) ;
			}
 			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Versement> getAllVersement() {
		List<Versement> versements = new ArrayList<>();
		Connection dbConnection = DBconnexion.getConnection() ;
		try {
			PreparedStatement ps = dbConnection.prepareStatement("SELECT * FROM Versement;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int idverser = rs.getInt("idverser");
				int cni = rs.getInt("cni");
				double montantverser = rs.getDouble("montantverser");
				Date date = rs.getDate("dateversement") ;
				
				versements.add(new Versement(idverser, montantverser, date, cni));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return versements;
	}

	@Override
	public boolean updateVersement(int idV, Versement v) {
		
		return false;
	}

	@Override
	public void deleteVersement(int idV) {
		// TODO Auto-generated method stub

	}

}
