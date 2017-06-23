package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ProfilPanel extends JPanel {
	
	private JButton mdp;
	private JButton droit;
	private JButton autosave;
	
	
	public ProfilPanel() {
		initPane();
	}
	
	private void initPane() {
		this.mdp = new JButton("Password");
		this.droit = new JButton("Law");
		this.autosave = new JButton("AutoSave");
		this.setLayout(new GridLayout(1,3));
		this.add(this.mdp);
		this.add(this.droit);
		this.add(autosave);
	}
	
	public JButton getMdp() {
		return this.mdp;
	}
	
	public JButton getDroit() {
		return this.droit;
	}
	
	public JButton getAutoSave() {
		return this.autosave;
	}

}
