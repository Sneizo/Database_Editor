
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
 * @author Damien & Mael
 * This class launch the different class and run the dataBase editor
 */
public class Launcher {

	/**
	 * The main 
	 * @param args
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		
		System.out.println("Welcome to the MDSql monitor. Commands end with : close.");
		initConsole();	
		System.out.println("Thank you for using the MDSql monitor.");

	}
	
	/**
	 * This class initialize the program
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	public static void initConsole () throws SQLException, InterruptedException{
		JDBCConnexion co;
		Scanner in = new Scanner(System.in);
		System.out.print("[user] ");
		String choose = in.nextLine();
		while(!choose.toUpperCase().equals("CLOSE")){			
			if(choose.toUpperCase().equals("CONNECT")){
				co = new JDBCConnexion();
				co.connexion();
				JDBCResultat res = new JDBCResultat(co);
				if(res.getExit().toUpperCase().equals("DISCONNECT")){
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
					System.out.println("[user] Entrez le login de l'utilisateur � suprimer");
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
