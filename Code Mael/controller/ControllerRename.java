package controller;

import java.awt.event.*;

import vue.Interface;
import vue.Rename;

public class ControllerRename implements FocusListener, ActionListener{
	
	private Rename rename;
	private Interface interf;
	
	public ControllerRename(Rename rename, Interface interf) {
		this.rename = rename;
		this.interf = interf;
	}
	

	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == this.rename.getConfirmer()) {
			
		}
		if(ae.getSource() == this.rename.getAnnuler()) {
			
		}
	}

	
	public void focusGained(FocusEvent fe) {
		if(fe.getSource() == this.rename.getOldTableName()) {
			
		}
		if(fe.getSource() == this.rename.getNewTableName()) {
			
		}
		
	}

	public void focusLost(FocusEvent fe) {
		
	}

}
