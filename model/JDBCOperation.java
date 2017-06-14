package model;


import java.util.Scanner;


/**
 * This class create an object JDBCOperation who get the SQL script.
 * This class can also set a default SQL script like SELECT(*).
 */
public class JDBCOperation {
	
	private String operation;
	

	/**
	 * This class set the operation 
	 * @param str the string to set
	 */
	public void setOperation(String str) {
		if(str != null) {
			this.operation = str;
		}
	}
	
	/**
	 * this methode get the sql script you write and set it in operation
	 * @throws InterruptedException 
	 */
	/*Creer un boucle qui entre les opérations à la suite tant 
	 * que le caratere ';' n'est pas rencontré, enregistre tout dans operation
	 */
	public void operation() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		Thread.sleep(500);
		System.out.println("[user] Enter your query: ");
		System.out.print("[user] ");
		setOperation(sc.nextLine());
		
	}
	
	/**
	 * this methode get the operation
	 * @return 
	 * @return the operation
	 */
	 public String getOperation() {
		return this.operation;
	}
	
}
