package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import view.ModifPassword;

/**
 * This class delete an user
 * @author Mael & Damien
 */
public class ChangePasswordJDBC {
	
	
	private Statement stmt;
	private ConnexionJDBC connexion;
	private ModifPassword pass;
	
	/**
	 * The constructor of the class
	 * connect to the database, delete the user and disconnect to the database
	 * @param login the login of the user 
	 */	
	public ChangePasswordJDBC(ConnexionJDBC connexion, ModifPassword pass) {
		this.connexion = connexion;
		this.pass = pass;
	}

	

	/**
	 * This method delete the user of the database
	 * @param login the login of the user to delete
	 */
	public void changePassword() {
		try {

			stmt = connexion.getConn().createStatement();
			String sql = "ALTER USER " + connexion.getUser() + " IDENTIFIED BY " + pass.getNewPasswordF().getText();
			System.out.println(stmt);
			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			 e.printStackTrace();
			System.out.println("[user] Erreur dans la requête SQL.");
		}
	}

	
}
