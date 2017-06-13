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
	 */
	/*Creer un boucle qui entre les opérations à la suite tant 
	 * que le caratere ';' n'est pas rencontré, enregistre tout dans operation
	 */
	public void operation() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez votre requete");
		setOperation(sc.nextLine());
		
		sc.close();
	}
	
	/**
	 * this methode get the operation
	 * @return the operation
	 */
	 public void getOperation() {
		return this.operation;
	}
	
}
