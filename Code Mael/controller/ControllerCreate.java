package controller;

import java.awt.event.*;

import vue.Create;
import vue.Interface;

public class ControllerCreate implements FocusListener, ActionListener{
	
	private Create create;
	private Interface interf;
	
	public ControllerCreate(Create create, Interface interf) {
		this.create = create;
		this.interf = interf;
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
