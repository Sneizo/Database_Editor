package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableJDBC {
	
	private ConnexionJDBC conn;
	private boolean execute;
	private boolean existe;
	
	public CreateTableJDBC(ConnexionJDBC conn) {
		this.conn = conn;
		this.execute = false;
		this.existe = true;
	}
	
	
	public void createTable(String name) {
		String requette = "CREATE TABLE " + name + "(num" + name +" NUMBER CONSTRAINT pkNum" + name + " PRIMARY KEY) ";
		//String requette = "CREATE TABLE Test1(numTest1 NUMBER CONSTRAINT PKNum PRIMARY KEY)";
		try {
			Statement stm = conn.getConn().createStatement();
			stm.executeUpdate(requette);
			this.existe = false;
		} catch (SQLException e) {
			e.printStackTrace();
			this.existe = true;
		}
	}
	
	public void createColonne(String name,String namecol, String type) {
		String requette = "ALTER TABLE " + name +" ADD " + namecol + " " +  type;
		try {
			Statement stm = conn.getConn().createStatement();
			stm.executeUpdate(requette);
			this.execute = true;
		} catch (SQLException e) {
			System.out.println("ERREUR : CreateTableJDBC.createColonne()");
			this.execute = false;
		}
	}
	
	public boolean getExecute() {
		return this.execute;
	}
	
	public boolean getExiste() {
		return this.existe;
	}

}
