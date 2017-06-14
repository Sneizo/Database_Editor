package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateUser {

	private Connection conn;
	private Statement stmt;

	public CreateUser(String login, String mdp) {

		connexion();

		create(login, mdp);

		disconect();
		
	}

	private void connexion() {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Database","SYSTEM","L4kjR3Xzo");
			stmt = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("[user] User login or password incorrect.");
		}
	}

	private void create(String login, String mdp) {
		try {
			String sql = "CREATE USER " + login + " IDENTIFIED BY " + mdp;
			String grant = "GRANT CONNECT TO " + login;
			stmt.executeUpdate(sql);
			stmt.executeUpdate(grant);
			System.out.println("[user] Utilisateur créé");
		} catch (SQLException e) {
			 e.printStackTrace();
			System.out.println("[user] Erreur dans la requête SQL.");
		}
	}

	private void disconect() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
