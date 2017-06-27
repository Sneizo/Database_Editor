package model;

import java.sql.SQLException;
import java.sql.Statement;

import view.Rename;

/**
 * This class delete an user
 * @author Mael and Damien
 */
public class RenameTableJDBC {
	
	
	private Statement stmt;
	private ConnexionJDBC connexion;
	private Rename rename;
	
	/**
	 * The constructor of the class.
	 * @param connexion The connexionJDBC class.
	 * @param rename The rename class.
	 */
	public RenameTableJDBC(ConnexionJDBC connexion, Rename rename) {
		this.connexion = connexion;
		this.rename = rename;
	}

	/**
	 * This method rename a table.
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
