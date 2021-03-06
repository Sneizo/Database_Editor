package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * The profil panel class.
 * @author Mael and Damien
 *
 */
public class ProfilPanel extends JPanel {
	
	private JButton mdp;
	private JButton autosave;
	
	/** 
	 * The constructor of the profilPanel class.
	 */
	public ProfilPanel() {
		initPane();
	}
	
	/**
	 * Initializes the graphical components.
	 */
	private void initPane() {
		
		setBackground(new Color(80,80,80));
		
		this.mdp = new JButton();
		this.mdp.setIcon(new ImageIcon("data/images/pass.png"));
		this.mdp.setBorderPainted(false);
		this.mdp.setBorder(null);
		this.mdp.setContentAreaFilled(false);
		this.mdp.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.WHITE));
		
		
		
		this.autosave = new JButton();
		this.autosave.setIcon(new ImageIcon("data/images/autoSave.png"));
		this.autosave.setBorderPainted(false);
		this.autosave.setBorder(null);
		this.autosave.setContentAreaFilled(false);
		this.autosave.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.WHITE));
		
		
		this.setLayout(new GridLayout(1,2));
		this.add(this.mdp);
		this.add(this.autosave);
	}
	
	/**
	 * 
	 * @return the password
	 */
	public JButton getMdp() {
		return this.mdp;
	}
	
	/**
	 * 
	 * @return the autoSaveButton
	 */
	public JButton getAutoSave() {
		return this.autosave;
	}

}
