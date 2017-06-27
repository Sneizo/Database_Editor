package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.ChangePasswordJDBC;
import view.Connexion;
import view.InformationBar;
import view.Interface;
import view.MainPanel;
import view.ModifPassword;
import view.PanelQuery;
import view.TitleBar;

/**
 * This class manages the change of password control.
 * 
 * @author Mael and Damien
 *
 */
public class ControllerChangePassword implements ActionListener {

	private Connexion con;
	private ModifPassword pass;
	private ChangePasswordJDBC changePass;
	private InformationBar ib;
	private TitleBar titleBar;
	private MainPanel mainPanel;
	private PanelQuery panelQuery;
	private Interface interf;
	private ModifPassword modifPassword;

	/**
	 * The constructor of the ControllerChangePassword class.
	 * 
	 * @param con
	 *            The connection.
	 * @param pass
	 *            The modifPassword class.
	 * @param changePass
	 *            The changePasswordJDBC class.
	 * @param ib
	 *            The InformationBar class.
	 * @param titleBar
	 *            The TitleBar class.
	 * @param mainPanel
	 *            The MainPanel class.
	 * @param panelQuery
	 *            The PanelQuery class.
	 * @param interf
	 *            The Interface class.
	 */
	public ControllerChangePassword(Connexion con, ModifPassword pass, ChangePasswordJDBC changePass, InformationBar ib,
			TitleBar titleBar, MainPanel mainPanel, PanelQuery panelQuery, Interface interf,
			ModifPassword modifPassword) {
		super();
		this.con = con;
		this.pass = pass;
		this.changePass = changePass;
		this.ib = ib;
		this.titleBar = titleBar;
		this.mainPanel = mainPanel;
		this.panelQuery = panelQuery;
		this.interf = interf;
		this.modifPassword = modifPassword;
	}

	/**
	 * Performs an action if the button pressed is the reference button.
	 */
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(pass.getConfirmer())) {
			if (this.modifPassword.getNewPasswordF().getText()
					.equals(this.modifPassword.getConfirmNewPasswordF().getText())) {

				JPanel pane = new JPanel();
				JPanel main = new JPanel();
				ib.getUser().setText(con.getUserLog().getText());
				pane.setLayout(new BorderLayout());
				main.setLayout(new BorderLayout());
				pane.add(titleBar, BorderLayout.NORTH);
				pane.add(mainPanel, BorderLayout.CENTER);
				main.add(pane, BorderLayout.NORTH);
				main.add(panelQuery, BorderLayout.CENTER);
				main.add(ib, BorderLayout.SOUTH);

				this.interf.setPanel(main);
				this.changePass.changePassword();
			} else {
				JOptionPane option = new JOptionPane();
				option.showMessageDialog(null, "New password and confirm new password not identic", "ERREUR",
						JOptionPane.ERROR_MESSAGE);
			}

		}

		if (arg0.getSource() == this.modifPassword.getAnnuler()) {

			JPanel pane = new JPanel();
			JPanel main = new JPanel();
			ib.getUser().setText(con.getUserLog().getText());
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
}
