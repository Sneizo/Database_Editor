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
import model.JDBCResultat;
import model.ResultatJDBC;
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
			try {
				panelQuery.getQueryResult().replaceRange("",panelQuery.getQueryResult().getSelectionStart(),panelQuery.getQueryResult().getSelectionEnd());
				new ResultatJDBC(con, panelQuery);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}			
			
	}
		
}

	
	

