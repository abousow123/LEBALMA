package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnexion {
	
	/*String url = "jdbc:mysql://localhost:3306/bdd_sdzee";

	String utilisateur = "java";

	String motDePasse = "SdZ_eE";

	Connection  connexion = null;
	
	
	public static Connection getConnection() throws ClassNotFoundException {
		try {
			// Connection connect = (Connection)
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/orientation",
			// "root", "");
			
			Class.forName("com.mysql.jdbc.Driver"); 

			Connection connect = (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/orientation",
					"postgres", "postgres");
			return connect;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ssssss");
		}
		return null;
	}
*/
	
	private static final String PILOTE= "com.mysql.jdbc.Driver";
	private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/lebalma?useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "sow";
	
	private static Connection myConnection;
	
	private DBconnexion(){
		
	}
	public static Connection getConnection(){
		if( myConnection==null){
			try {
				//Class.forName("com.mysql.jdbc.Driver");
				Class.forName(PILOTE);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				//myConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/CATALOG-PRODUIT","root","");
				myConnection=DriverManager.getConnection(URL_DATABASE,USER,PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return myConnection;
	}
}

