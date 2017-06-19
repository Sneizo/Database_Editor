package controller;

import java.awt.event.*;


import vue.*;

public class ControllerConnexion implements FocusListener, ActionListener{
	
	private Connexion connexion;
	
	public ControllerConnexion(Connexion connexion) {
		
		this.connexion = connexion;
		
	}
	
	
	public void focusLost(FocusEvent fe) {
		
	}
	
	public void focusGained(FocusEvent fe) {
		if(fe.getSource() == this.connexion.getUserLog()) {
			
		}
		
		if(fe.getSource() == this.connexion.getPassLog()) {
			
		}
		
		if(fe.getSource() == this.connexion.getDataNameLog()) {
			
		}
		
		
		
		if(fe.getSource() == this.connexion.getUserSub()) {
			
		}
		if(fe.getSource() == this.connexion.getPassSub()) {
			
		}
		if(fe.getSource() == this.connexion.getConfirmPassSub()) {
			
		}
		if(fe.getSource() == this.connexion.getDataNameLogSub()) {
			
		}
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == this.connexion.getConnect()) {
			
		}
		
		if(ae.getSource() == this.connexion.getSubscribe()) {
			
		}
	}

}
