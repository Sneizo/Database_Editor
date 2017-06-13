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
 * @author Damien
 *
 */
public class JDBCConnexion {

	private Connection conn;
	private boolean connect;
	
	/**
	 * 
	 */
	public JDBCConnexion() {
		this.connect = false;
	}

	/**
	 * @throws InterruptedException 
	 * 
	 */
	public void connexion() throws InterruptedException {
		if (connect == false) {
			
			/*
			//New scanner for input
			Scanner in = new Scanner(System.in);
			
			//User input
			System.out.println("User:");
			System.out.println(">");
			String user = in.nextLine();
			
			//Pass input
			System.out.println("Password:");
			System.out.println(">");
			String pass = in.nextLine();
			
			*/
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			//Connexion initialisation
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Database", "SYSTEM", "24u4kvkH-p05m9");
				System.out.println("[user] Connection...");
				Thread.sleep(1000);
				System.out.println("[user] Please wait...");
				Thread.sleep(1000);
				Statement stmt = conn.createStatement();
				System.out.println("[user] Connexion établie.");
				//Change de state of the boolean connect
				this.connect = true;
			} catch (SQLException e) {
				System.out.println("Nom d'utilisateur ou mot de passe incorrect.");
			}
		}
	}

	/**
	 * 
	 * @throws SQLException
	 */
	public void deconnexion() throws SQLException {
		conn.close();
		if(conn.isClosed()){ 
			   //We try to reset the connection 
			   conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Database", "SYSTEM", "24u4kvkH-p05m9"); 
			   System.out.println("Déconnexion effectué.");
		}

	}

	public Boolean getConnect() {
		return this.connect;
	}

	public Connection getConn() {
		return this.conn;
	}
	
	

}
