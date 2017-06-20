/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Damien
 *
 */
public class Profil extends JPanel{

	
	private JButton setting;
	private JButton disconnect;
	private JButton home;
	
	public Profil(){
		initComponent();
	}
	
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
	 * @param setting the setting to set
	 */
	public void setSetting(JButton setting) {
		this.setting = setting;
	}

	/**
	 * @return the disconnect
	 */
	public JButton getDisconnect() {
		return disconnect;
	}

	/**
	 * @param disconnect the disconnect to set
	 */
	public void setDisconnect(JButton disconnect) {
		this.disconnect = disconnect;
	}

	/**
	 * @return the home
	 */
	public JButton getHome() {
		return home;
	}

	/**
	 * @param home the home to set
	 */
	public void setHome(JButton home) {
		this.home = home;
	}
	
	
}
