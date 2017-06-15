package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
			Scanner sc = new Scanner(System.in);
			System.out.println("[user] Admin password: ");
			System.out.print("[user] ");
			String passAdmin = sc.nextLine();
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Database","SYSTEM",passAdmin);
			stmt = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("[user] User login or password incorrect.");
		}
	}

	private void delete(String login) {
		try {
			String sql = "DROP USER " + login;
			stmt.executeUpdate(sql);
			System.out.println("[user] Utilisateur suprim�");
		} catch (SQLException e) {
			 e.printStackTrace();
			System.out.println("[user] Erreur dans la requ�te SQL.");
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