package model;

import java.util.Scanner;

/**
 * This class create an object JDBCOperation who get the SQL script. This class
 * can also set a default SQL script like SELECT(*).
 * 
 * @author Mael & Damien
 */
public class JDBCOperation {

	private String operation;
	private JDBCConnexion co;

	/**
	 * The constructor of the class set the connection
	 * 
	 * @param co
	 *            the connection to the database
	 */
	public JDBCOperation(JDBCConnexion co) {
		if (co != null) {
			this.co = co;
		}
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
		Scanner sc = new Scanner(System.in);
		String end = "";
		Thread.sleep(500);
		setOperation();
		System.out.println("[" + co.getUser() + "] Enter your query: ");
		// System.out.print("[" + co.getUser() + "] ");
		while (!end.equals(";") && !operation.equalsIgnoreCase("disconnect")) {
			System.out.print("[" + co.getUser() + "] ");
			end = sc.nextLine();
			if (!end.equals(";")) {
				this.operation += end;
			}

			if (end.toUpperCase().equals("DISCONNECT")) {
				this.operation = "disconnect";
				end = ";";

			}

		}

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
