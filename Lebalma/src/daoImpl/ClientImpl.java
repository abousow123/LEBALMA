package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DBconnexion;
import dao.IClient;
import entity.Client;

public class ClientImpl implements IClient {

	@Override
	public void addClient(Client c) {
		// TODO Auto-generated method stub
		Connection dbConnection = DBconnexion.getConnection() ;
		try {
			PreparedStatement ps = dbConnection.prepareStatement("INSERT INTO Client values(?,?,?,?,?);");
			ps.setInt(1, c.getCni());
			//ps.setInt(2, c.getPret());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getNom());
			ps.setString(4, c.getAdresse());
			ps.setInt(5, c.getTelephone());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delClient(int cni) {
		// TODO Auto-generated method stub
		Connection dbConnection = DBconnexion.getConnection() ;
		try {
			PreparedStatement ps = dbConnection.prepareStatement("DELETE FROM Client WHERE cni=?");
			ps.setInt(1, cni);
			ps.executeQuery();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Client> getClients() {
		
		List<Client> clients = new ArrayList<>();
		Connection dbConnection = DBconnexion.getConnection() ;
		try {
			PreparedStatement ps = dbConnection.prepareStatement("SELECT * FROM Client;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int cni = rs.getInt("cni");
				
				String prenom = rs.getString("prenom");
				String nom = rs.getString("nom");
				String adresse = rs.getString("adresse");
				int tel = rs.getInt("telephone") ;
				
				clients.add(new Client(cni, prenom, nom, adresse, tel)) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return clients;
	}

	@Override
	public Client getClient(int cni) {
		// TODO Auto-generated method stub
		Connection dbConnection = DBconnexion.getConnection() ;
		try {
			PreparedStatement ps = dbConnection.prepareStatement("SELECT * FROM Client WHERE cni=?");
			ps.setInt(1, cni);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				int c = rs.getInt("cni");
			//	int idpret = rs.getInt("idpret");
				String prenom = rs.getString("prenom");
				String nom = rs.getString("nom");
				String adresse = rs.getString("adresse");
				int tel = rs.getInt("telephone") ;
				
				return new Client(c, prenom, nom, adresse, tel) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateClient(int cni, Client c) {
		// TODO Auto-generated method stub
		Connection dbConnection = DBconnexion.getConnection() ;
		try {
			PreparedStatement ps = dbConnection.prepareStatement("UPDATE Client SET prenom=?,nom=?,adresse=?,"
					+ "telephone=? WHERE cni=?");
			ps.setString(1, c.getPrenom());
			ps.setString(2, c.getNom());
			ps.setString(3, c.getAdresse());
			ps.setInt(4, c.getTelephone());
			//ps.setInt(5, c.getPret());
			ps.setInt(5, cni);
			
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
