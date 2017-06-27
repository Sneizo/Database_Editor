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
 * This class create a user Create a connection, create the user with the
 * parameter and disconnect
 * 
 * @author Mael and Damien
 */
public class CreateUserJDBC extends JOptionPane {

	private Connection conn;
	private Statement stmt;

	private JLabel lab1, lab2;
	private JTextField field1, field2;

	private String dataBase;
	
	private boolean create;
	private boolean connect;

	public CreateUserJDBC(String login, String pass, String confirm, String database) {

		this.create = false;
		this.connect = false;
		JPanel pane = new JPanel();
		lab1 = new JLabel("Login of the Administrator");
		lab2 = new JLabel("Password");

		field1 = new JTextField();
		field2 = new JTextField();
		pane.setLayout(new GridLayout(2, 2));
		pane.add(lab1);
		pane.add(field1);
		pane.add(lab2);
		pane.add(field2);

		JOptionPane option = new JOptionPane();

		option.showMessageDialog(null, pane);
		
		if (login != null) {
			if (pass != null) {
				if (confirm != null) {
					if (database != null) {
						this.dataBase = database;
						if (this.field1.getText() != null && !(this.field1.getText().equals(""))) {
							if (this.field2.getText() != null && !this.field2.getText().equals("")) {

								connexion(this.field1.getText(), this.field2.getText());

								if (this.connect = true) {
									
									create(login, pass);

									disconect();

								}
							}else {
								System.out.println("ERREUR : password Admin incorrect");
							}
						}else {
							System.out.println("ERREUR : login Admin incorrect");
						}
					}else {
						System.out.println("ERREUR : DataBase incorrect");
					}
				}else {
					System.out.println("ERREUR : ConfirmPassword incorrect");
				}
			}else {
				System.out.println("ERREUR : Password incorrect");
			}
		}else {
			System.out.println("ERREUR : login incorrect");
		}
	}

	/**
	 * This method create a connection with the data base
	 */
	private void connexion(String log, String pass) {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:" + dataBase,log,pass);
			stmt = conn.createStatement();
			this.connect = true;
		} catch (SQLException e) {
			JOptionPane option = new JOptionPane();
			option.showMessageDialog(null, "Password or login incorect ", "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * This method create the new user with the sql script and the parameter
	 * 
	 * @param login
	 *            the login of the new user
	 * @param mdp
	 *            the password of the new user
	 */
	private void create(String login, String mdp) {
		try {
			String sql = "CREATE USER " + login + " IDENTIFIED BY " + mdp;
			String grant = "GRANT ALL PRIVILEGES TO " + login;
			stmt.executeUpdate(sql);
			stmt.executeUpdate(grant);
				this.create = true;
		} catch (SQLException e) {
			JOptionPane option = new JOptionPane();
			option.showMessageDialog(null, "Error in the query ", "ERREUR", JOptionPane.ERROR_MESSAGE);
			this.create = false;
		}
	}

	/**
	 * This method disconnect the user of the dataBase
	 */
	private void disconect() {
		try {
			conn.close();
			this.connect = false;
		} catch (SQLException e) {
			JOptionPane option = new JOptionPane();
			option.showMessageDialog(null, "Error with the log off", "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	/**
	 * This method return the connect boolean
	 * @return connect
	 */
	public boolean getConnect() {
		return this.connect;
	}
	
	/**
	 * This method return the create boolean
	 * @return create
	 */
	public boolean getCreate() {
		return this.create;
	}
}
