package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * This class delete an user
 * @author Mael & Damien
 */
public class DeleteUser {
	
	private Connection conn;
	private Statement stmt;

	/**
	 * The constructor of the class
	 * connect to the database, delete the user and disconnect to the database
	 * @param login the login of the user 
	 */
	public DeleteUser(String login) {

		connexion();

		delete(login);

		disconect();
	}

	/**
	 * This method create a connection with the database
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
	 * This method delete the user of the database
	 * @param login the login of the user to delete
	 */
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

	/**
	 * This methode disconnect from the database
	 */
	private void disconect() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("L'utilisateur n'existe pas.");
		}
	}
}
