/**
 * 
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * This class connect to the database
 * 
 * @author Mael and Damien
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
	 * Create a connection from the database.
	 * @param user The user connexion.
	 * @param password The password of user.
	 * @param dataBase The databaseName.
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
				conn = DriverManager.getConnection(database, user, pass);
				
				Statement stmt = conn.createStatement();
				// Change de state of the boolean connect
				this.connect = true;
			} catch (SQLException e) {
				JOptionPane option = new JOptionPane();
				option.showMessageDialog(null, "Password or login incorect ", "ERREUR", JOptionPane.ERROR_MESSAGE);
				
			}
		}
	}

	/**
	 * Disconnect from the database
	 * @throws SQLException Error
	 */
	public void deconnexion() throws SQLException {
		conn.close();
		this.connect = false;
		if (conn.isClosed()) {
			// We try to reset the connection
			conn = DriverManager.getConnection(database, user, pass);
			System.out.println("[" + user + "]  D�connexion effectu�.");
		}

	}

	/**
	 * return connect
	 * 
	 * @return connect The boolean connect
	 */
	public Boolean getConnect() {
		return this.connect;
	}

	/**
	 * return conn
	 * 
	 * @return conn The connexion.
	 */
	public Connection getConn() {
		return this.conn;
	}

	/**
	 * return user
	 * 
	 * @return user the user
	 */
	public String getUser() {
		return user;
	}

}
