package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

public class TableJDBC {

	private Vector<String> vec;
	private String result;
	private Connection con;
	private ResultSet resultat;
	private ConnexionJDBC connexion;
	private ResultSetMetaData metadata;
	
	public TableJDBC(ConnexionJDBC connexion) {
		this.connexion = connexion;
		this.con = this.connexion.getConn();
		recuperation();
	}
	
	public void recuperation() {
		
		String operation = "SELECT table_name FROM user_tables";
		
		try {
			Statement stmt = con.createStatement();
			resultat = stmt.executeQuery(operation);
			metadata = resultat.getMetaData();
			this.result = "";
			while (resultat.next()) {
                for (int j = 0; j < metadata.getColumnCount(); j++) {
                    result = result + resultat.getObject(j + 1) + " ";
                }
			}
		} catch (SQLException e) {
			JOptionPane option = new JOptionPane();
			option.showMessageDialog(null, "Error with the recuperation of table", "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		
		if((this.result.length() >= 1) && (this.result != null)) {
			
			 String[] tab = result.split(" ");
			 vec= new Vector();
			 this.vec.add("TABLE : ");
			 
			 for(int i = 0 ; i< tab.length ; i++) {
				 vec.add("   - " + tab[i]);
			 }
			
			
		}
	}
	
	public Vector<String> getVector() {
		return this.vec;
	}
	
}
