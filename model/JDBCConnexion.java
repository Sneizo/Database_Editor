/**
 * 
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * This class connect to the database
 * 
 * @author Damien
 *
 */
public class JDBCConnexion {

	private Connection conn;
	private boolean connect;
	private String database;
	private String user;
	private String pass;

	/**
	 * The constructor of the class set connect
	 */
	public JDBCConnexion() {
		this.connect = false;
	}

	/**
	 * crate a connection from the database
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void connexion() throws InterruptedException {
		if (connect == false) {

			/// *
			// New scanner for input
			Scanner in = new Scanner(System.in);

			// Choose DataBase
			System.out.println("[user] Database name:");
			System.out.print("[user] ");
			database = in.nextLine();

			// User input
			System.out.println("[user] User:");
			System.out.print("[user] ");
			user = in.nextLine();

			// Pass input
			System.out.println("[user] Password:");
			System.out.print("[user] ");
			pass = in.nextLine();

			// */
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			// Connexion initialisation
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:" + database, user, pass);
				System.out.println("[" + user + "] Connection...");
				Thread.sleep(1000);
				System.out.println("[" + user + "] Please wait...");
				Thread.sleep(1000);
				Statement stmt = conn.createStatement();
				System.out.println("[" + user + "] Connection established.");
				// Change de state of the boolean connect
				this.connect = true;
			} catch (SQLException e) {
				System.out.println("[" + user + "] User login or password incorrect.");
				connexion();
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
