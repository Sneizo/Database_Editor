package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * This class get the SQL request and execute it for display the sesult
 */
 
public class JDBCResultat {
	
	private JDBCOperation jdbcOperation;
	private ResultSet resultat;
	private JDBCConnexion con;
	
	/**
	 * the constructor of the class
	 * set the variable jdbcOperation
	 */
	public JDBCResultat(JDBCOperation operation, JDBCConnexion con) {
		if(operation != null) {
			this.jdbcOperation = operation;
		}
		if(con != null) {
			this.con = con;
		}
		getResultat();
	}
	
	private void getResultat() {
		try {
			Statement stmt = con.getConn().createStatement();
			resultat = stmt.executeQuery(jdbcOperation.getOperation());
			//while (stmt.next ()){
			//	System.out.println(stmt.getString (1));
			//}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ResultSet Display() {
		return this.resultat;
	}
}

