package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import view.Interface;
import view.MainPanel;
import view.ModifPassword;
import view.ProfilPanel;
import view.SetAutoSave;
import view.TitleBar;


/**
 * This class allows to manage the graphical components located in the profile panel.
 * @author Mael and Damien
 *
 */
public class ControllerProfilPanel implements ActionListener{
	
	
	private ProfilPanel profilPanel;
	private TitleBar titleBar;
	private MainPanel mainPanel;
	private Interface interf;
	private ModifPassword modifPassword;
	private SetAutoSave setAutoSave;
	
	/**
	 * The constructor of the ControllerProfilPanel class.
	 * @param profilPanel The profilPanel class.
	 * @param interf The main frame.
	 * @param mainPanel The mainPanel class.
	 * @param titleBar The titleBar class.
	 * @param modifPassword The modifPassword class.
	 * @param setAutoSave The setAutoSave class.
	 */
	public ControllerProfilPanel(ProfilPanel profilPanel, Interface interf, MainPanel mainPanel, TitleBar titleBar, ModifPassword modifPassword, SetAutoSave setAutoSave) {
		this.profilPanel = profilPanel;
		this.interf = interf;
		this.mainPanel = mainPanel;
		this.titleBar = titleBar;
		this.modifPassword = modifPassword;
		this.setAutoSave = setAutoSave;
	}

	/**
	 * Performs an action if the button pressed is the reference button.
	 */
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == this.profilPanel.getMdp()) {
			JPanel pane = new JPanel();
			pane.setLayout(new BorderLayout());
			pane.add(this.titleBar, BorderLayout.NORTH);
			pane.add(this.mainPanel, BorderLayout.SOUTH);
			
			JPanel frame = new JPanel();
			frame.setLayout(new BorderLayout());
			frame.add(pane, BorderLayout.NORTH);
			frame.add(this.modifPassword, BorderLayout.CENTER);
			this.interf.setPanel(frame);
		}
		
		if(ae.getSource() == this.profilPanel.getAutoSave()) {
			JPanel pane = new JPanel();
			pane.setLayout(new BorderLayout());
			pane.add(this.titleBar, BorderLayout.NORTH);
			pane.add(this.mainPanel, BorderLayout.SOUTH);
			
			JPanel frame = new JPanel();
			frame.setLayout(new BorderLayout());
			frame.add(pane, BorderLayout.NORTH);
			frame.add(this.setAutoSave, BorderLayout.CENTER);
			this.interf.setPanel(frame);
		}
		
		
	}
	
	

}
