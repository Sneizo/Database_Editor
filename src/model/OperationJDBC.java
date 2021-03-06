package model;

import java.util.Scanner;

import view.PanelQuery;

/**
 * This class create an object JDBCOperation who get the SQL script. This class
 * can also set a default SQL script like SELECT(*).
 * 
 * @author Mael and Damien
 */
public class OperationJDBC {

	private String operation;
	private ConnexionJDBC co;
	private PanelQuery panelQuery;
	

	/**
	 * The constructor of the class set the connection
	 * 
	 * @param co The connection to the database
	 * @param panelQuery The panelQuery class.
	 */
	public OperationJDBC(ConnexionJDBC co, PanelQuery panelQuery) {
		if (co != null) {
			this.co = co;
		}
		this.panelQuery = panelQuery;
	}

	/**
	 * This class set the operation
	 */
	public void setOperation() {
	}

	/**
	 * this methode get the sql script you write and set it in operation
	 * 
	 * @throws InterruptedException Error
	 */
	public void operation() throws InterruptedException {
		this.operation = "";
		setOperation();				
		this.operation = panelQuery.getQueryWrite().getText();
	}

	/**
	 * This void get the operation.
	 * @return operation T	he operation
	 */
	public String getOperation() {
		return this.operation;
	}

}
