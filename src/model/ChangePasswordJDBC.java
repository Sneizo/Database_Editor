package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import view.ModifPassword;

/**
 * This class change de password of an user
 * @author Mael and Damien
 */
public class ChangePasswordJDBC {
	
	
	private Statement stmt;
	private ConnexionJDBC connexion;
	private ModifPassword pass;
	
	/**
	 * The constructor of the class
	 * @param connexion The connexionJDBC class.
	 * @param pass THe ModifPassword class.
	 */
	public ChangePasswordJDBC(ConnexionJDBC connexion, ModifPassword pass) {
		this.connexion = connexion;
		this.pass = pass;
	}

	

	/**
	 * This method change the user password.
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
