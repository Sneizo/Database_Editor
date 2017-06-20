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
import view.TitleBar;

public class ControllerConnexion implements FocusListener, ActionListener{
	
	private Connexion connexion;
	private Interface interf;
	private TitleBar titleBar;
	private MainPanel mainPanel;
	private PanelQuery panelQuery;
	private InformationBar ib;
	
	public ControllerConnexion(Connexion connexion, Interface interf, TitleBar titleBar, MainPanel mainPanel, PanelQuery panelQuery, InformationBar ib) {
		
		this.connexion = connexion;
		this.interf = interf;
		this.titleBar = titleBar;
		this.mainPanel = mainPanel;
		this.panelQuery = panelQuery;
		this.ib = ib;
		
	}
	
	
	public void focusLost(FocusEvent fe) {
		if(fe.getSource() == this.connexion.getUserLog()) {
			if(this.connexion.getUserLog().getText().equals(""))
				this.connexion.setUserLog("Login");
		}
		
		if(fe.getSource() == this.connexion.getPassLog()) {
			if(this.connexion.getPassLog().getText().equals(""))
				this.connexion.setPassLog("Password");
		}
		
		if(fe.getSource() == this.connexion.getDataNameLog()) {
			if(this.connexion.getDataNameLog().getText().equals(""))
				this.connexion.setDataNameLog("URL of the data base");
		}
		
		if(fe.getSource() == this.connexion.getUserSub()) {
			if(this.connexion.getUserSub().getText().equals(""))
				this.connexion.setUserSub("Name of the new user");
		}
		
		if(fe.getSource() == this.connexion.getPassSub()) {
			if(this.connexion.getPassSub().getText().equals(""))
				this.connexion.setPassSub("Password");
		}
		
		if(fe.getSource() == this.connexion.getConfirmPassSub()) {
			if(this.connexion.getConfirmPassSub().getText().equals(""))
				this.connexion.setConfirmPassSub("Password");
		}
		
		if(fe.getSource() == this.connexion.getDataNameLogSub()) {
			if(this.connexion.getDataNameLogSub().getText().equals(""))
				this.connexion.setDataNameLogSub("URL of the data base");
		}
		
	}
	
	
	
	public void focusGained(FocusEvent fe) {
		if(fe.getSource() == this.connexion.getUserLog()) {
			if(this.connexion.getUserLog().getText().equals("Login"))
				this.connexion.setUserLog("");
		}
		
		if(fe.getSource() == this.connexion.getPassLog()) {
			if(this.connexion.getPassLog().getText().equals("Password"))
				this.connexion.setPassLog("");
		}
		
		if(fe.getSource() == this.connexion.getDataNameLog()) {
			if(this.connexion.getDataNameLog().getText().equals("URL of the data base"))
				this.connexion.setDataNameLog("");
		}
		
		if(fe.getSource() == this.connexion.getUserSub()) {
			if(this.connexion.getUserSub().getText().equals("Name of the new user"))
				this.connexion.setUserSub("");
		}
		
		if(fe.getSource() == this.connexion.getPassSub()) {
			if(this.connexion.getPassSub().getText().equals("Password"))
				this.connexion.setPassSub("");
		}
		
		if(fe.getSource() == this.connexion.getConfirmPassSub()) {
			if(this.connexion.getConfirmPassSub().getText().equals("Password"))
				this.connexion.setConfirmPassSub("");
		}
		
		if(fe.getSource() == this.connexion.getDataNameLogSub()) {
			if(this.connexion.getDataNameLogSub().getText().equals("URL of the data base"))
				this.connexion.setDataNameLogSub("");
		}
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == this.connexion.getConnect()) {
			JPanel pane = new JPanel();
			JPanel main = new JPanel();
			ib.getUser().setText(connexion.getUserLog().getText());
			pane.setLayout(new BorderLayout());
			main.setLayout(new BorderLayout());
			pane.add(titleBar,BorderLayout.NORTH);
			pane.add(mainPanel, BorderLayout.CENTER);
			main.add(pane, BorderLayout.NORTH);
			main.add(panelQuery, BorderLayout.CENTER);
			main.add(ib, BorderLayout.SOUTH);
			
			this.interf.setPanel(main);
		}
		
		if(ae.getSource() == this.connexion.getSubscribe()) {
			
		}
	}

}