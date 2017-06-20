package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import vue.*;

public class ControllerMainPanel implements ActionListener {

	private MainPanel mainPanel;
	private Interface interf;
	private Create create;
	private TitleBar titleBar;
	private Rename rename;

	public ControllerMainPanel(MainPanel mainPanel, Interface interf,Create create, TitleBar titleBar, Rename rename) {
		this.mainPanel = mainPanel;
		this.interf = interf;
		this.create = create;
		this.titleBar = titleBar;
		this.rename = rename;
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == (mainPanel.getCreate())) {
			JPanel pane = new JPanel();
			pane.setLayout(new BorderLayout());
			pane.add(titleBar, BorderLayout.NORTH);
			pane.add(create, BorderLayout.CENTER);
			this.interf.setPanel(pane);
		}
		
		if (ae.getSource() == (mainPanel.getSave())) {

		}
		
		if (ae.getSource() == (mainPanel.getSaveAs())) {

		}
		
		if (ae.getSource() == (mainPanel.getOpen())) {

		}
		
		if (ae.getSource() == (mainPanel.getRename())) {
			JPanel pane = new JPanel();
			pane.setLayout(new BorderLayout());
			pane.add(titleBar, BorderLayout.NORTH);
			pane.add(rename, BorderLayout.CENTER);
			this.interf.setPanel(pane);
		}
		
		if (ae.getSource() == (mainPanel.getDisconnect())) {

		}






	}

}
