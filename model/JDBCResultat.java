package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * This class get the SQL request and execute it for display the sesult
 */
 
public class JDBCResultat {
	
	private JDBCOperation jdbcOperation;
	private ResultSet resultat;
	private PreparedStatement rep;
	private JDBCConnexion con;
	
	/**
	 * the constructor of the class
	 * set the variable jdbcOperation
	 */
	public JDBCResultat(JDBCOperation operation, JDBCConnexion con) {
		if(operation != null) {
			this.jdbcOperation = operation;
		}
		if(con != null) {
			this.con = con;
		}
		getResultat();
	}
	
	private void getResultat() {
		try {
				
			//Statement str = con.getConn().createStatement();

			
			Statement stmt = con.getConn().createStatement();
			
			String str = jdbcOperation.getOperation();
			String[] tab = str.split(" ");
			String premier;
			premier = tab[0];
			if(premier.toUpperCase().equals("SELECT")){
				stmt.setFetchSize(0);
				resultat = stmt.executeQuery(jdbcOperation.getOperation());
				ResultSetMetaData metadata = resultat.getMetaData(); 
				int columnIndex = 1;	
				int nombreColonnes = metadata.getColumnCount();
				System.out.println("[user] Résultat de l'execution:");
				while (resultat.next()){
					System.out.print("[user] ");
						while(columnIndex < nombreColonnes){
							System.out.print(resultat.getString(columnIndex) + "\t");
							columnIndex ++;
						}	
				System.out.println();
				columnIndex = 1;
				}
				resultat.close();
				stmt.close();
			} else if((premier.toUpperCase().equals("UPDATE")) || (premier.toUpperCase().equals("INSERT")) || (premier.toUpperCase().equals("DELETE")) || (premier.toUpperCase().equals("CREATE")) || (premier.toUpperCase().equals("DROP"))){
				stmt.executeUpdate(jdbcOperation.getOperation());
				if((premier.toUpperCase().equals("DROP"))){
					System.out.println("[user] Table supprimé.");
				} else if((premier.toUpperCase().equals("INSERT"))){
					System.out.println("[user] Insertion de ligne effectué.");
				} else if((premier.toUpperCase().equals("CREATE"))){
					System.out.println("[user] Table créée.");
				}
			}
			
			//System.out.println(resultat);
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("> Erreur dans la requête SQL.");	
			e.printStackTrace();
		}
		
	}
	
	public ResultSet Display() {
		return this.resultat;
	}
}

