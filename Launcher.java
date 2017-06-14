
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
		
		boolean exit = false;
		Scanner in = new Scanner(System.in);
		System.out.print("[user] ");
		String choose = in.nextLine();
		while(!choose.equals("close")){			
			if(choose.equals("connect") && !exit){
				JDBCConnexion co = new JDBCConnexion();
				co.connexion();				
				JDBCResultat res = new JDBCResultat(co);
				if(res.Display().equals("exit")){
					exit = true;
					co.deconnexion();
				}
			}
			System.out.println("[user] ");
			choose = in.nextLine();
		}
		
		
		
		/*
		 * 
		 * System.out.println(">"); String s = in.nextLine();
		 * 
		 * if(s.equals("exit")){ co.deconnexion(); }
		 */

		// System.out.println(co.getConn());
	}

}
