package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * This class create a user
 * Create a connection, create the user with the parameter and disconnect
 * @author Mael and Damien
 */
public class CreateUser {

	private Connection conn;
	private Statement stmt;

	public CreateUser(String login, String mdp) {

		connexion();

		create(login, mdp);

		disconect();
		
	}

	/**
	 * This method create a connection with the data base
	 */
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

	/**
	 * This method create the new user with the sql script and the parameter
	 * @param login the login od the new user
	 * @param mdp the password of the new user
	 */
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

	/**
	 * This method disconnect the user of the dataBase
	 */
	private void disconect() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
