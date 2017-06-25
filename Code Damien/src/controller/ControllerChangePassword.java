package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ChangePasswordJDBC;
import view.Connexion;
import view.ModifPassword;

public class ControllerChangePassword implements ActionListener{

	private Connexion con;
	private ModifPassword pass;
	private ChangePasswordJDBC changePass;
	
	/**
	 * @param con
	 * @param pass
	 * @param changePass
	 */
	public ControllerChangePassword(Connexion con, ModifPassword pass, ChangePasswordJDBC changePass) {
		super();
		this.con = con;
		this.pass = pass;
		this.changePass = changePass;
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource().equals(pass.getConfirmer())){
			this.changePass.changePassword();
		}
		
	}

}
