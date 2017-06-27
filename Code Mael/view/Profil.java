package view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This class creates the user profile panel.
 * @author Mael and Damien
 *
 */
public class Profil extends JPanel{

	
	private JButton setting;
	private JButton disconnect;
	private JButton home;
	
	/**
	 * The constructor of the profil class.
	 */
	public Profil(){
		initComponent();
	}
	
	/**
	 * Initializes the graphical components.
	 */
	public void initComponent(){
	
		setBackground(new Color(80,80,80));
		
		setting = new JButton(new ImageIcon("data/images/setting.png"));
		setting.setBorderPainted(false);
		setting.setBorder(null);
		setting.setContentAreaFilled(false);
		setting.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.WHITE));
		
		disconnect = new JButton(new ImageIcon("data/images/disconnect.png"));
		disconnect.setBorderPainted(false);
		disconnect.setBorder(null);
		disconnect.setContentAreaFilled(false);
		
		home = new JButton(new ImageIcon("data/images/home.png"));
		home.setBorderPainted(false);
		home.setBorder(null);
		home.setContentAreaFilled(false);
		
		GridLayout gr = new GridLayout(1,3);
		setLayout(gr);
		add(setting);
		add(home);
		add(disconnect);
		
	}

	/**
	 * @return the setting
	 */
	public JButton getSetting() {
		return setting;
	}

	/**
	 * @return the disconnect
	 */
	public JButton getDisconnect() {
		return disconnect;
	}



	/**
	 * @return the home
	 */
	public JButton getHome() {
		return home;
	}	
	
}
