package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vue.Interface;
import vue.PanelQuery;

public class ControllerPanelQuery implements ActionListener {
	
	private PanelQuery panelQuery;
	private Interface interf;
	public ControllerPanelQuery(PanelQuery panelQuery, Interface interf) {
		this.panelQuery = panelQuery;
		this.interf = interf;
	}


	public void actionPerformed(ActionEvent ae) {
		
	}

}
