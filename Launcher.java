/**
 * 
 */
import java.sql.SQLException;
import java.util.Scanner;

import model.JDBCConnexion;
import model.JDBCOperation;
import model.JDBCResultat;
/**
 * @author Damien
 *
 */
public class Launcher {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		
		JDBCConnexion co = new JDBCConnexion();
		
		JDBCOperation op = new JDBCOperation();
		
	
		
		co.connexion();
		
		op.operation();
		
	
		
		//Scanner in = new Scanner(System.in);
		
		/*
	
		System.out.println(">");
		String s = in.nextLine();
		
		if(s.equals("exit")){
			co.deconnexion();
		} */
		
	
		
		
//		System.out.println(co.getConn());
	}

}