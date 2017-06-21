package model;

import java.util.Scanner;

import view.PanelQuery;

/**
 * This class create an object JDBCOperation who get the SQL script. This class
 * can also set a default SQL script like SELECT(*).
 * 
 * @author Mael & Damien
 */
public class OperationJDBC {

	private String operation;
	private ConnexionJDBC co;
	private PanelQuery panelQuery;
	

	/**
	 * The constructor of the class set the connection
	 * 
	 * @param co
	 *            the connection to the database
	 */
	public OperationJDBC(ConnexionJDBC co, PanelQuery panelQuery) {
		if (co != null) {
			this.co = co;
		}
		this.panelQuery = panelQuery;
	}

	/**
	 * This class set the operation
	 * 
	 * @param str
	 *            the string to set
	 */
	public void setOperation() {
	}

	/**
	 * this methode get the sql script you write and set it in operation
	 * 
	 * @throws InterruptedException
	 */
	public void operation() throws InterruptedException {
		this.operation = "";
		setOperation();			
		String op = this.operation;
		op= panelQuery.getQueryWrite().getText();
		
	}

	/**
	 * this methode get the operation
	 * 
	 * @return
	 * @return the operation
	 */
	public String getOperation() {
		return this.operation;
	}

}
