
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

		Scanner in = new Scanner(System.in);

		JDBCConnexion co = new JDBCConnexion();

		JDBCOperation op = new JDBCOperation();

		
		co.connexion();
		//System.out.print("[user] ");
		//String next = in.nextLine();
		
		//while(next.equals("")){
			
			op.operation();
			JDBCResultat res = new JDBCResultat(op, co);
		//	System.out.print("[user] ");
		//	next = in.nextLine();
		//}
		
		
		
		/*
		 * 
		 * System.out.println(">"); String s = in.nextLine();
		 * 
		 * if(s.equals("exit")){ co.deconnexion(); }
		 */

		// System.out.println(co.getConn());
	}

}
