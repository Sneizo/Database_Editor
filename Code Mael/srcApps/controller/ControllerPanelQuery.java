package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Interface;
import view.PanelQuery;

/**
 * This class allows to manage the graphical components located in the panelQuery
 * @author Mael and Damien
 *
 */
public class ControllerPanelQuery implements ActionListener {
	
	private PanelQuery panelQuery;
	private Interface interf;
	
	/**
	 * The constructor of the ControllerPanelQuery class.
	 * @param panelQuery The panelQuery class.
	 * @param interf The main frame.
	 */
	public ControllerPanelQuery(PanelQuery panelQuery, Interface interf) {
		this.panelQuery = panelQuery;
		this.interf = interf;
	}

	/**
	 * Performs an action if the button pressed is the reference button.
	 */
	public void actionPerformed(ActionEvent ae) {
		
	}

}
