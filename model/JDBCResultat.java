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

	// private JDBCOperation jdbcOperation;
	private ResultSet resultat;
	private PreparedStatement rep;
	private JDBCConnexion con;
	private String exit;

	/**
	 * the constructor of the class set the variable jdbcOperation
	 * 
	 * @throws InterruptedException
	 */
	public JDBCResultat(JDBCConnexion con) throws InterruptedException {
		
		if (con != null) {
			this.con = con;
		}
		getResultat();
	}

	private void getResultat() throws InterruptedException {

		JDBCOperation jdbcOperation = new JDBCOperation(con);
		try {

			// Statement str = con.getConn().createStatement();

			Statement stmt = con.getConn().createStatement();

			String premier = "next";
			while (!premier.toUpperCase().equals("EXIT")) {
				jdbcOperation.operation();
				String str = jdbcOperation.getOperation();
				String[] tab = str.split(" ");
				premier = tab[0];

				if (premier.toUpperCase().equals("SELECT")) {
					resultat = stmt.executeQuery(jdbcOperation.getOperation());
					ResultSetMetaData metadata = resultat.getMetaData();
					System.out.println("["+con.getUser()+"] Result of execution:");
					while (resultat.next()) {
                        System.out.print("\n["+con.getUser()+"]  ");
                        for (int j = 0; j < metadata.getColumnCount(); j++) {
                            System.out.print(resultat.getObject(j + 1) + "\t");

                        }
					}
					System.out.println("\n["+con.getUser()+"]  End of the request.");
					System.out.println("["+con.getUser()+"] ");

				} else if ((premier.toUpperCase().equals("UPDATE")) || (premier.toUpperCase().equals("INSERT"))
						|| (premier.toUpperCase().equals("DELETE")) || (premier.toUpperCase().equals("CREATE"))
						|| (premier.toUpperCase().equals("DROP")) || (premier.toUpperCase().equals("GRANT"))) {
					stmt.executeUpdate(jdbcOperation.getOperation());
					if ((premier.toUpperCase().equals("DROP"))) {
						System.out.println("["+con.getUser()+"] Table supprimé.");
					} else if ((premier.toUpperCase().equals("INSERT"))) {
						System.out.println("["+con.getUser()+"] Insertion de ligne effectué.");
					} else if ((premier.toUpperCase().equals("CREATE"))) {
						System.out.println("["+con.getUser()+"] Table créée.");
					}
				
				} else if((premier.toUpperCase().equals("EXIT"))){
				
			 	} else {
                    System.out.print("["+con.getUser()+"] Erreur présente dans la derniere requête\n");
                }

			}
			String rtr = jdbcOperation.getOperation();
			String[] tab2 = rtr.split(" ");
			exit = tab2[0];

			// System.out.println(resultat);
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("["+con.getUser()+"] Erreur dans la requête SQL.");
			getResultat();
		}

	}

	public ResultSet Display() {
		return this.resultat;
	}

	/**
	 * @return the exit
	 */
	public String getExit() {
		return exit;
	}
	
	
}
