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
public class JDBCConnection {

	private Connection conn;
	private boolean connect;
	
	/**
	 * 
	 */
	public JDBCConnection() {
		this.connect = false;
	}

	/**
	 * 
	 */
	public void connexion() {
		if (connect == false) {
			
			
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
			
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			//Connexion initialisation
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Database", user, pass);
				System.out.println("Connexion..");
				Statement stmt = conn.createStatement();
				System.out.println("Connexion établie");
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
		if (conn != null) {
			try {
				conn.close();
				this.connect = false;
				if (conn.isClosed() == true) {
					System.out.println("Déconnexion effectué");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public Boolean getConnect() {
		return this.connect;
	}

	public Connection getConn() {
		return this.conn;
	}

}
