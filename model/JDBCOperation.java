package model;


import java.util.Scanner;


/**
 * This class create an object JDBCOperation who get the SQL script.
 * This class can also set a default SQL script like SELECT(*).
 * @author Mael & Damien
 */
public class JDBCOperation {
	
	private String operation;
	private JDBCConnexion co;
	
	

	/**
	 * The constructor of the class 
	 * set the connection
	 * @param co the connection to the database
	 */
	public JDBCOperation(JDBCConnexion co) {
		if(co != null){this.co = co;}
	}

	/**
	 * This class set the operation 
	 * @param str the string to set
	 */
	public void setOperation() {
		this.operation = "";		
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
		String end = "";
		String tmp = "";
		Thread.sleep(500);
		setOperation();
		System.out.println("["+co.getUser()+"]  Enter your query: ");
		while(!end.equals(";") && (!end.toUpperCase().equals("DISCONNECT"))){
			System.out.print("["+co.getUser()+"] ");
			tmp = sc.nextLine();
			end = tmp;
			if(!end.equals(";")){
				this.operation = this.operation + tmp;
			}			
		}
		
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
