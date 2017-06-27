package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import view.Connexion;
import view.InformationBar;
import view.Interface;
import view.MainPanel;
import view.ModifPassword;
import view.PanelQuery;
import view.TitleBar;

/**
 * This class manages the change of password control.
 * @author Mael and Damien
 *
 */
public class ControllerModifPassword implements ActionListener {

	private ModifPassword modifPassword;
	private MainPanel mainPanel;
	private TitleBar titleBar;
	private Interface interf;
	private Connexion connexion;
	private PanelQuery panelQuery;
	private InformationBar ib;
	
	/**
	 * The constructor of the ControllerModifPassword class.
	 * @param modifPassword The modifPassword class.
	 * @param mainPanel The mainPanel class.
	 * @param titleBar The titleBar class.
	 * @param interf The main frame.
	 * @param connexion The connexion class.
	 * @param panelQuery The panelquery class.
	 * @param ib The informationBar class.
	 */
	public ControllerModifPassword(ModifPassword modifPassword, MainPanel mainPanel, TitleBar titleBar,
			Interface interf, Connexion connexion, PanelQuery panelQuery, InformationBar ib) {
		this.modifPassword = modifPassword;
		this.mainPanel = mainPanel;
		this.titleBar = titleBar;
		this.interf = interf;
		this.connexion = connexion;
		this.panelQuery = panelQuery;
		this.ib = ib;

	}

	/**
	 * Performs an action if the button pressed is the reference button.
	 */
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == this.modifPassword.getConfirmer()) {

			if (this.modifPassword.getNewPasswordF().getText().equals(this.modifPassword.getConfirmNewPasswordF().getText())) {

				JPanel pane = new JPanel();
				JPanel main = new JPanel();
				ib.getUser().setText(connexion.getUserLog().getText());
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
}
