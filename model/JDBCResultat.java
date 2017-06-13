package model;

import java.sql.*;


/**
 * This class get the SQL request and execute it for display the sesult
 */
 
public class JDBCResultat {
	
	private JDBCOperation jdbcOperation;
	private String resultat;
	private JDBCConnexion connexion;
	
	/**
	 * the constructor of the class
	 * set the variable jdbcOperation
	 */
	public JDBCResultat(JDBCOperation operation, JDBCConnexion con) {
		if(opration != null) {
			this.jdbcOperation = operation;
		}
		if(con != null) {
			this.connexion = con;
		}
		getResultat();
	}
	
	private void getResultat() {
		try {
			Statement stmt = connexion.createStatement();
			resultat = stmt.executeQuery(jdbcOperation.getOperation());
		} catch (SQLException e) {
			resultat = e.printStackTrace();
		}
	}
	
	public String Display() {
		return this.resultat;
	}
}

