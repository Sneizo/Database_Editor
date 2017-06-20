package controller;

import java.awt.event.*;

import vue.Create;

public class ControllerCreate implements FocusListener, ActionListener{
	
	private Create create;
	
	public ControllerCreate(Create create) {
		this.create = create;
	}

	public void focusLost(FocusEvent fe) {
		
	}
	public void focusGained(FocusEvent fe) {
		if(fe.getSource() == this.create.getNewTableName()) {
			
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == this.create.getConfirmer()) {
			
		}
		
		if(ae.getSource() == this.create.getAnnuler()) {
			
		}
	}
}
