package model;

import java.sql.SQLException;
import java.sql.Statement;

import view.Rename;

/**
 * This class delete an user
 * @author Mael & Damien
 */
public class RenameTableJDBC {
	
	
	private Statement stmt;
	private ConnexionJDBC connexion;
	private Rename rename;
	
	/**
	 * The constructor of the class
	 * connect to the database, delete the user and disconnect to the database
	 * @param login the login of the user 
	 */	
	public RenameTableJDBC(ConnexionJDBC connexion, Rename rename) {
		this.connexion = connexion;
		this.rename = rename;
	}

	

	/**
	 * This method delete the user of the database
	 * @param login the login of the user to delete
	 */
	public void renameTable() {
		try {

			stmt = connexion.getConn().createStatement();
			String sql = "ALTER TABLE " + rename.getOldTableName().getText() + " RENAME TO " + rename.getNewTableName().getText();
			System.out.println(stmt);
			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			 e.printStackTrace();
		}
	}

	
}
