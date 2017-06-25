package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import view.PanelQuery;

public class DisplayTableJDBC {

	
	private Statement stmt;
	private ResultSet resultat;
	private ConnexionJDBC connexion;
	private PanelQuery panelQuery;

	public DisplayTableJDBC(PanelQuery panelQuery, ConnexionJDBC connexion) {

		this.panelQuery = panelQuery;
		this.connexion = connexion;
	}

	/**
	 * This method create the new user with the sql script and the parameter
	 * 
	 * @param login
	 *            the login od the new user
	 * @param mdp
	 *            the password of the new user
	 */
	public void display() {
		try {
			System.out.println("DEBUG");
			String sql = "SELECT * FROM " + ((String) panelQuery.getTable().getSelectedValue());
			Statement stmt = connexion.getConn().createStatement();
			resultat = stmt.executeQuery(sql);
			ResultSetMetaData metadata = resultat.getMetaData();
			while (resultat.next()) {
				for (int j = 0; j < metadata.getColumnCount(); j++) {

					panelQuery.getQueryResult().append(resultat.getObject(j + 1) + "\t | ");

				}
				panelQuery.getQueryResult().append("\n");
			}

			stmt.executeUpdate(sql);
			System.out.println("[user] Utilisateur créé");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("[user] Erreur dans la requête SQL.");
		}
	}

	
}
