/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ConnexionJDBC;
import model.ResultatJDBC;
import view.Connexion;
import view.Interface;
import view.PanelQuery;
import view.TitleBar;

/**
 * This class allows to manage the exchanges between the database and the application by means of a text box.
 * @author Mael and Damien
 *
 */
public class ControllerQuery implements ActionListener {
	
	private Connexion connexion;
	private Interface interf;
	private TitleBar titleBar;
	private PanelQuery panelQuery;
	private ConnexionJDBC con;
	
	/**
	 * The constructor of the ControllerQuery class.
	 * @param connexion The connexion class.
	 * @param interf The main frame.
	 * @param titleBar The titleBar class.
	 * @param panelQuery The panelQuery class.
	 * @param con The connexionJDBC class.
	 */
	public ControllerQuery(Connexion connexion, Interface interf, TitleBar titleBar, PanelQuery panelQuery, ConnexionJDBC con) {
		
		this.connexion = connexion;
		this.interf = interf;
		this.titleBar = titleBar;
		this.panelQuery = panelQuery;
		this.con = con;
		
	}

	/**
	 * Performs an action if the button pressed is the reference button.
	 */
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(panelQuery.getExecute())){
			try {
				panelQuery.getQueryResult().setText("");
				panelQuery.getQueryResult().replaceRange("",panelQuery.getQueryResult().getSelectionStart(),panelQuery.getQueryResult().getSelectionEnd());
				new ResultatJDBC(con, panelQuery);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}			
			
	}
		
}

	
	

