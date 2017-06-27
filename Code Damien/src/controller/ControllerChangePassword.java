package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ChangePasswordJDBC;
import view.Connexion;
import view.ModifPassword;

/**
 * This class manages the change of password control.
 * @author Mael and Damien
 *
 */
public class ControllerChangePassword implements ActionListener{

	private Connexion con;
	private ModifPassword pass;
	private ChangePasswordJDBC changePass;
	
	/**
	 * The constructor of the ControllerChangePassword class.
	 * @param con The connection.
	 * @param pass The modifPassword class.
	 * @param changePass The changePasswordJDBC class.
	 */
	public ControllerChangePassword(Connexion con, ModifPassword pass, ChangePasswordJDBC changePass) {
		super();
		this.con = con;
		this.pass = pass;
		this.changePass = changePass;
	}



	/**
	 * Performs an action if the button pressed is the reference button.
	 */
	public void actionPerformed(ActionEvent arg0) {		
		if(arg0.getSource().equals(pass.getConfirmer())){
			this.changePass.changePassword();
		}		
	}
}
