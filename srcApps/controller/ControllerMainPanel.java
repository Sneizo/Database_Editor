package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vue.MainPanel;

public class ControllerMainPanel implements ActionListener {

	private MainPanel mainPanel;

	public ControllerMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == (mainPanel.getCreate())) {

		}
		
		if (ae.getSource() == (mainPanel.getSave())) {

		}
		
		if (ae.getSource() == (mainPanel.getSaveAs())) {

		}
		
		if (ae.getSource() == (mainPanel.getOpen())) {

		}
		
		if (ae.getSource() == (mainPanel.getRename())) {

		}
		
		if (ae.getSource() == (mainPanel.getDisconnect())) {

		}






	}

}
