package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import view.Create;
import view.Interface;

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
