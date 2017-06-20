package model;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class create a user
 * Create a connection, create the user with the parameter and disconnect
 * @author Mael & Damien
 */
public class CreateUserJDBC extends JOptionPane {

	private Connection conn;
	private Statement stmt;
	
	private JLabel lab1, lab2;
	private JTextField field1, field2;

	public CreateUserJDBC(String login, String pass, String confirm, String database) {

		JPanel pane = new JPanel();
		lab1 = new JLabel("Login");
		lab2 = new JLabel("Password");
		
		field1 = new JTextField();
		field2 = new JTextField();
		pane.setLayout(new GridLayout(2,2));
		pane.add(lab1);
		pane.add(field1);
		pane.add(lab2);
		pane.add(field2);
		
		JOptionPane option = new JOptionPane();
		
		option.showInputDialog(pane);
		
//		connexion();
//		
//		create(login, pass);
//
//		disconect();
		
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
