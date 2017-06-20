/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import model.ConnexionJDBC;
import view.Connexion;
import view.Interface;
import view.PanelQuery;
import view.TitleBar;

/**
 * @author Damien
 *
 */
public class ControllerQuery implements ActionListener {
	
	
	
	
	private Connexion connexion;
	private Interface interf;
	private TitleBar titleBar;
	private PanelQuery panelQuery;
	private ConnexionJDBC con;
	
	public ControllerQuery(Connexion connexion, Interface interf, TitleBar titleBar, PanelQuery panelQuery, ConnexionJDBC con) {
		
		this.connexion = connexion;
		this.interf = interf;
		this.titleBar = titleBar;
		this.panelQuery = panelQuery;
		this.con = con;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(panelQuery.getExecute())){
			try{
				
			String exit;
			Statement stmt = con.getConn().createStatement();
			ResultSet resultat;
			String premier = "next";
			while (!premier.toUpperCase().equals("DISCONNECT")) {
				String str = panelQuery.getQueryWrite().getText();
				String[] tab = str.split(" ");
				premier = tab[0];

				if (premier.toUpperCase().equals("SELECT")) {
					resultat = stmt.executeQuery(str);
					ResultSetMetaData metadata = resultat.getMetaData();
					System.out.println("["+con.getUser()+"] Result of execution:");
					while (resultat.next()) {
                        System.out.print("\n["+con.getUser()+"]  ");
                        for (int j = 0; j < metadata.getColumnCount(); j++) {
                        	panelQuery.getResultQuery().setText(resultat.getObject(j + 1) + "\t");

                        }
					}
					System.out.println("\n["+con.getUser()+"]  End of the request.");
					System.out.println("["+con.getUser()+"] ");

				} else if ((premier.toUpperCase().equals("UPDATE")) || (premier.toUpperCase().equals("INSERT"))
						|| (premier.toUpperCase().equals("DELETE")) || (premier.toUpperCase().equals("CREATE"))
						|| (premier.toUpperCase().equals("DROP")) || (premier.toUpperCase().equals("GRANT"))) {
					stmt.executeUpdate(str);
					if ((premier.toUpperCase().equals("DROP"))) {
						System.out.println("["+con.getUser()+"] Table supprimé.");
					} else if ((premier.toUpperCase().equals("INSERT"))) {
						System.out.println("["+con.getUser()+"] Insertion de ligne effectué.");
					} else if ((premier.toUpperCase().equals("CREATE"))) {
						System.out.println("["+con.getUser()+"] Table créée.");
					}
				
				} else if((premier.toUpperCase().equals("DISCONNECT"))){
				
			 	} else {
                    System.out.print("["+con.getUser()+"] Erreur présente dans la derniere requête\n");
                }

			}
			//String rtr = jdbcOperation.getOperation();
//			String[] tab2 = rtr.split(" ");
//			exit = tab2[0];
			exit = premier;

			// System.out.println(resultat);
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("["+con.getUser()+"] Erreur dans la requête SQL.");
		}

	}
			
			
			
			
	}
		
}

	
	

