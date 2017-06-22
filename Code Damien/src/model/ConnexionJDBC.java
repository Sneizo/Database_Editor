/**
 * 
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import view.Connexion;

/**
 * This class connect to the database
 * 
 * @author Damien
 *
 */
public class ConnexionJDBC {

	private Connection conn;
	private boolean connect;
	private String database;
	private String user;
	private String pass;

	/**
	 * The constructor of the class set connect
	 */
	public ConnexionJDBC() {
	
		this.connect = false;
	}

	/**
	 * crate a connection from the database
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void connexion(String user, String password, String dataBase) {
		if (connect == false) {		
			if (user != null) {
				this.user = user;
			}
			if (password != null) {
				this.pass = password;
			}
			if (dataBase != null) {
				this.database = dataBase;
			}

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			// Connexion initialisation
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:" + database, user, pass);
				
				Statement stmt = conn.createStatement();
				// Change de state of the boolean connect
				this.connect = true;
			} catch (SQLException e) {
				System.out.println("ERREUR : ConnexionJDBC.connexion() \nUser login or password incorrect.");
			}
		}
	}

	/**
	 * Disconnect from the database
	 * 
	 * @throws SQLException
	 */
	public void deconnexion() throws SQLException {
		conn.close();
		if (conn.isClosed()) {
			// We try to reset the connection
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:" + database, user, pass);
			System.out.println("[" + user + "]  Déconnexion effectué.");
		}

	}

	/**
	 * return connect
	 * 
	 * @return connect
	 */
	public Boolean getConnect() {
		return this.connect;
	}

	/**
	 * return conn
	 * 
	 * @return conn
	 */
	public Connection getConn() {
		return this.conn;
	}

	/**
	 * return user
	 * 
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

}
