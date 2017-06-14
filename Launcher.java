
/**
 * 
 */
import java.sql.SQLException;
import java.util.Scanner;

import model.JDBCConnexion;
import model.JDBCOperation;
import model.JDBCResultat;
import model.CreateUser;
import model.DeleteUser;

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
		
		initConsole();	
		
		/*
		 * 
		 * System.out.println(">"); String s = in.nextLine();
		 * 
		 * if(s.equals("exit")){ co.deconnexion(); }
		 */

		// System.out.println(co.getConn());
	}
	
	public static void initConsole () throws SQLException, InterruptedException{
		boolean exit = false;
		Scanner in = new Scanner(System.in);
		System.out.print("[user] ");
		String choose = in.nextLine();
		while(!choose.toUpperCase().equals("CLOSE")){			
			if(choose.toUpperCase().equals("CONNECT") && !exit){
				JDBCConnexion co = new JDBCConnexion();
				co.connexion();
				JDBCResultat res = new JDBCResultat(co);
				if(res.getExit().toUpperCase().equals("EXIT")){
					exit = true;
					co.deconnexion();
					choose = " ";
					}
			}
			
			if(choose.toUpperCase().equals("CREATEUSER")) {
				String login = null;
				String passwd = null;
				while(login == null || passwd == null) {
					System.out.println("[user] Entrez le login du nouvel utilisateur");
					System.out.print("[user] ");
					login = in.nextLine();
					System.out.println("[user] Entrez le mot de passe du nouvel utilisateur");
					System.out.print("[user] ");
					passwd = in.nextLine();
				}
				CreateUser create = new CreateUser(login,passwd);
				choose = " ";
			}
			
			
			if(choose.toUpperCase().equals("DELETEUSER")) {
				String login = null;
				while(login == null) {
					System.out.println("[user] Entrez le login de l'utilisateur à suprimer");
					System.out.print("[user] ");
					login = in.nextLine();
				}
				DeleteUser delete = new DeleteUser(login);
				choose = " ";
			}
			System.out.print("[user] ");
			choose = in.nextLine();
		}
	}

}
