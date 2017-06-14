package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class get the SQL request and execute it for display the sesult
 */

public class JDBCResultat {

	private JDBCOperation jdbcOperation;
	private ResultSet resultat;
	private PreparedStatement rep;
	private JDBCConnexion con;

	/**
	 * the constructor of the class set the variable jdbcOperation
	 * @throws InterruptedException 
	 */
	public JDBCResultat(JDBCOperation operation, JDBCConnexion con) throws InterruptedException {
		if (operation != null) {
			this.jdbcOperation = operation;
		}
		if (con != null) {
			this.con = con;
		}
		getResultat();
	}

	private void getResultat() throws InterruptedException {
		try {

			// Statement str = con.getConn().createStatement();

			Statement stmt = con.getConn().createStatement();

			String str = jdbcOperation.getOperation();
			String[] tab = str.split(" ");
			String premier;
			premier = tab[0];
			if (premier.toUpperCase().equals("SELECT")) {
				resultat = stmt.executeQuery(jdbcOperation.getOperation());
				ResultSetMetaData metadata = resultat.getMetaData();
				System.out.println("[user] Result of execution:");
				int i = 0;
				while (resultat.next()) {
					for (int j = 0; j < metadata.getColumnCount(); j++) {
						System.out.print("[user] ");
						System.out.println(resultat.getObject(j + 1));
						
					}
					i++;
				}
				System.out.println("[user] End of the request.");
			//	resultat.close();
				//stmt.close();
				
			} else if ((premier.toUpperCase().equals("UPDATE")) || (premier.toUpperCase().equals("INSERT"))
					|| (premier.toUpperCase().equals("DELETE")) || (premier.toUpperCase().equals("CREATE"))
					|| (premier.toUpperCase().equals("DROP"))) {
				stmt.executeUpdate(jdbcOperation.getOperation());
				if ((premier.toUpperCase().equals("DROP"))) {
					System.out.println("[user] Table supprimé.");
				} else if ((premier.toUpperCase().equals("INSERT"))) {
					System.out.println("[user] Insertion de ligne effectué.");
				} else if ((premier.toUpperCase().equals("CREATE"))) {
					System.out.println("[user] Table créée.");
				}
			}

			// System.out.println(resultat);
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("> Erreur dans la requête SQL.");
			e.printStackTrace();
		}

	}

	public ResultSet Display() {
		return this.resultat;
	}
}
