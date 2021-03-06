package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import view.PanelQuery;

/**
 * This class get the SQL request and execute it for display the result
 * 
 * @author Mael and Damien
 */
public class ResultatJDBC {

	// private JDBCOperation jdbcOperation;
	private ResultSet resultat;
	private PreparedStatement rep;
	private ConnexionJDBC con;
	private String exit;
	private PanelQuery panelQuery;

	/**
	 * the constructor of the class set the variable jdbcOperation
	 * 
	 * @param con The connection to the database
	 * @param panelQuery The panelQuery class.
	 * @throws InterruptedException Error.
	 */
	public ResultatJDBC(ConnexionJDBC con, PanelQuery panelQuery) throws InterruptedException {

		if (con != null) {
			this.con = con;
		}
		this.panelQuery = panelQuery;
		getResultat();
	}

	private void getResultat() throws InterruptedException {

		OperationJDBC jdbcOperation = new OperationJDBC(con, panelQuery);
		try {

			// Statement str = con.getConn().createStatement();

			Statement stmt = con.getConn().createStatement();

			String premier = "next";
			jdbcOperation.operation();
			String str = jdbcOperation.getOperation();
			String[] tab = str.split(" ");
			premier = tab[0];

			if (premier.toUpperCase().equals("SELECT")) {
				resultat = stmt.executeQuery(jdbcOperation.getOperation());
				ResultSetMetaData metadata = resultat.getMetaData();
				while (resultat.next()) {
					for (int j = 0; j < metadata.getColumnCount(); j++) {
						panelQuery.getQueryResult().append(resultat.getObject(j + 1) + "\t | ");
						
					}
					panelQuery.getQueryResult().append("\n");
				}
				
			} else if ((premier.toUpperCase().equals("UPDATE")) || (premier.toUpperCase().equals("INSERT"))
					|| (premier.toUpperCase().equals("DELETE")) || (premier.toUpperCase().equals("CREATE"))
					|| (premier.toUpperCase().equals("DROP")) || (premier.toUpperCase().equals("GRANT"))) {
				stmt.executeUpdate(jdbcOperation.getOperation());
				if ((premier.toUpperCase().equals("DROP"))) {
					panelQuery.getQueryResult().setText("Table supprim�.");
				} else if ((premier.toUpperCase().equals("INSERT"))) {
					panelQuery.getQueryResult().setText("Insertion de ligne effectu�.");
				} else if ((premier.toUpperCase().equals("CREATE"))) {
					panelQuery.getQueryResult().setText("Table cr��e.");
				}

			} else if ((premier.toUpperCase().equals("DISCONNECT"))) {

			} else {
				panelQuery.getQueryResult().setText(("[" + con.getUser() + "] Erreur pr�sente dans la derniere requ�te\n"));
			}

			// String rtr = jdbcOperation.getOperation();
			// String[] tab2 = rtr.split(" ");
			// exit = tab2[0];
			exit = premier;

			// System.out.println(resultat);
		} catch (SQLException e) {
			JOptionPane option = new JOptionPane();
			option.showMessageDialog(null, "Error in the sql querry", "ERREUR", JOptionPane.ERROR_MESSAGE);

		}

	}

	/**
	 * return resultat
	 * 
	 * @return resultat
	 */
	public ResultSet Display() {
		return this.resultat;
	}

	/**
	 * return exit
	 * 
	 * @return the exit
	 */
	public String getExit() {
		return exit;
	}

}
