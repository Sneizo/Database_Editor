package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPanel;

import view.Connexion;
import view.InformationBar;
import view.Interface;
import view.MainPanel;
import view.PanelQuery;
import view.SetAutoSave;
import view.TitleBar;

public class ControllerSetAutoSave implements ActionListener, FocusListener {

	private SetAutoSave setAutoSave;
	private Connexion connexion;
	private TitleBar titleBar;
	private MainPanel mainPanel;
	private PanelQuery panelQuery;
	private InformationBar ib;
	private Interface interf;

	public ControllerSetAutoSave(SetAutoSave setAutoSave, Connexion connexion, TitleBar titleBar, MainPanel mainPanel,
			PanelQuery panelQuery, InformationBar ib, Interface interf) {
		this.setAutoSave = setAutoSave;
		this.connexion = connexion;
		this.titleBar = titleBar;
		this.mainPanel = mainPanel;
		this.panelQuery = panelQuery;
		this.ib = ib;
		this.interf = interf;

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == this.setAutoSave.getConfirmer()) {
			this.setAutoSave.setAutoSave(this.setAutoSave.getCheck().isSelected());
			if (this.setAutoSave.getCheck().isSelected()) {
				this.setAutoSave.setBoucle(Integer.parseInt(this.setAutoSave.getTmp().getText()));
			}

			JPanel pane = new JPanel();
			JPanel main = new JPanel();
			ib.getUser().setText(connexion.getUserLog().getText());
			pane.setLayout(new BorderLayout());
			main.setLayout(new BorderLayout());
			pane.add(titleBar, BorderLayout.NORTH);
			pane.add(mainPanel, BorderLayout.CENTER);
			main.add(pane, BorderLayout.NORTH);
			main.add(panelQuery, BorderLayout.CENTER);
			main.add(ib, BorderLayout.SOUTH);

			this.interf.setPanel(main);
		}

	}

	public void focusGained(FocusEvent fe) {

	}

	public void focusLost(FocusEvent fe) {
		if (fe.getSource() == this.setAutoSave.getTmp()) {
			if (!(this.setAutoSave.getTmp().getText() == "[a-f]")) {
				if (Integer.parseInt(this.setAutoSave.getTmp().getText()) < 1) {
					this.setAutoSave.getTmp().setText("10");
				}
			}
		}
	}

}
