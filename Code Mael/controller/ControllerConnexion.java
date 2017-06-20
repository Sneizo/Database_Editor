package controller;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

import vue.*;

public class ControllerConnexion implements FocusListener, ActionListener{
	
	private Connexion connexion;
	private Interface interf;
	private TitleBar titleBar;
	private MainPanel mainPanel;
	private PanelQuery panelQuery;
	
	public ControllerConnexion(Connexion connexion, Interface interf, TitleBar titleBar, MainPanel mainPanel, PanelQuery panelQuery) {
		
		this.connexion = connexion;
		this.interf = interf;
		this.titleBar = titleBar;
		this.mainPanel = mainPanel;
		this.panelQuery = panelQuery;
		
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
				this.connexion.setDataNameLog("Name of the data base");
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
				this.connexion.setDataNameLogSub("Name of the data base");
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
			if(this.connexion.getDataNameLog().getText().equals("Name of the data base"))
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
			if(this.connexion.getDataNameLogSub().getText().equals("Name of the data base"))
				this.connexion.setDataNameLogSub("");
		}
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == this.connexion.getConnect()) {
			JPanel pane = new JPanel();
			JPanel main = new JPanel();
			pane.setLayout(new BorderLayout());
			main.setLayout(new BorderLayout());
			pane.add(titleBar,BorderLayout.NORTH);
			pane.add(mainPanel, BorderLayout.CENTER);
			main.add(pane, BorderLayout.NORTH);
			main.add(panelQuery, BorderLayout.CENTER);
			
			this.interf.setPanel(main);
		}
		
		if(ae.getSource() == this.connexion.getSubscribe()) {
			
		}
	}

}
