package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteUser {
	
	private Connection conn;
	private Statement stmt;

	public DeleteUser(String login) {

		connexion();

		delete(login);

		disconect();
	}

	private void connexion() {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Database","SYSTEM","24u4kvkH-p05m9");
			stmt = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("[user] User login or password incorrect.");
		}
	}

	private void delete(String login) {
		try {
			String sql = "DROP USER " + login;
			stmt.executeUpdate(sql);
			System.out.println("[user] Utilisateur suprimé");
		} catch (SQLException e) {
			 e.printStackTrace();
			System.out.println("[user] Erreur dans la requête SQL.");
		}
	}

	private void disconect() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("L'utilisateur n'existe pas.");
		}
	}
}
