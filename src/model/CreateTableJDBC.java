package model;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * This class allows you to create tables to assist.
 * @author Mael and Damien
 *
 */
public class CreateTableJDBC {
	
	private ConnexionJDBC conn;
	private boolean execute;
	private boolean existe;
	
	/**
	 * The constructor of the class.
	 * @param conn The connexion.
	 */
	public CreateTableJDBC(ConnexionJDBC conn) {
		this.conn = conn;
		this.execute = false;
		this.existe = true;
	}
	
	/**
	 * This void create a new table into the database.
	 * @param name The name of table.
	 */
	public void createTable(String name) {
		String requette = "CREATE TABLE " + name + "(num" + name +" NUMBER CONSTRAINT pkNum" + name + " PRIMARY KEY) ";
		//String requette = "CREATE TABLE Test1(numTest1 NUMBER CONSTRAINT PKNum PRIMARY KEY)";
		try {
			Statement stm = conn.getConn().createStatement();
			stm.executeUpdate(requette);
			this.existe = false;
		} catch (SQLException e) {
			JOptionPane option = new JOptionPane();
			option.showMessageDialog(null, "The Name of the Table is wrong", "ERREUR", JOptionPane.ERROR_MESSAGE);
			this.existe = true;
		}
	}
	
	/**
	 * This void create a new columns in the table.
	 * @param name The name of columns.
	 * @param namecol The nameCol.
	 * @param type The type of columns.
	 */
	public void createColonne(String name,String namecol, String type) {
		String requette = "ALTER TABLE " + name +" ADD " + namecol + " " +  type;
		try {
			Statement stm = conn.getConn().createStatement();
			stm.executeUpdate(requette);
			this.execute = true;
		} catch (SQLException e) {
			JOptionPane option = new JOptionPane();
			option.showMessageDialog(null, "Name of the colomn or type is wrong", "ERREUR", JOptionPane.ERROR_MESSAGE);
			this.execute = false;
		}
	}
	
	/**
	 * 
	 * @return the boolean execute
	 */
	public boolean getExecute() {
		return this.execute;
	}
	
	/**
	 * 
	 * @return the exit boolean.
	 */
	public boolean getExiste() {
		return this.existe;
	}

}
