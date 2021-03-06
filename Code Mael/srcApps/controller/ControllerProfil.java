/**
 * 
 */
package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import view.Connexion;
import view.InformationBar;
import view.Interface;
import view.MainPanel;
import view.PanelQuery;
import view.Profil;
import view.ProfilPanel;
import view.TitleBar;

/**
 * This class allows to manage the graphical components located in the profile panel
 * @author Mael and Damien
 *
 */
public class ControllerProfil implements ActionListener, MouseListener{

	private MainPanel mainPanel;
	private Interface interf;
	private TitleBar titleBar;
	private Profil profil;
	private PanelQuery panelQuery;
	private InformationBar informationBar;
	private Connexion connexion;
	private ProfilPanel profilPanel;
	
	/**
	 * The constructor of the ControllerProfil class.
	 * @param mainPanel The mainPanel class.
	 * @param interf The main frame.
	 * @param titleBar The titleBar class.
	 * @param profil The profil class.
	 * @param panelQuery The panelQuery class.
	 * @param informationBar The informationBar class.
	 * @param connexion The connexion class.
	 * @param profilPanel The profilPanel class.
	 */
	public ControllerProfil(MainPanel mainPanel, Interface interf, TitleBar titleBar, Profil profil, PanelQuery panelQuery, InformationBar informationBar, Connexion connexion, ProfilPanel profilPanel){
		this.mainPanel = mainPanel;
		this.interf = interf;
		this.titleBar = titleBar;
		this.profil = profil;
		this.panelQuery = panelQuery;
		this.informationBar = informationBar;
		this.connexion = connexion;
		this.profilPanel = profilPanel;
	}
	

	/**
	 * Performs an action if the button pressed is the reference button.
	 */
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(profil.getHome())){
			JPanel frame = new JPanel();
			BorderLayout br = new BorderLayout();
			JPanel toolBar = new JPanel();
			BorderLayout cr = new BorderLayout();
			toolBar.setLayout(cr);
			
			frame.setLayout(br);
			frame.add(panelQuery, BorderLayout.CENTER);
			frame.add(informationBar, BorderLayout.SOUTH);
			
			toolBar.add(titleBar, BorderLayout.NORTH);
			toolBar.add(mainPanel, BorderLayout.SOUTH);
			
			JPanel principal = new JPanel();
			BorderLayout prcpl = new BorderLayout();
			principal.setLayout(prcpl);
			principal.add(toolBar, BorderLayout.NORTH);
			principal.add(frame, BorderLayout.CENTER);
			interf.setPanel(principal);
		}
		
		if(arg0.getSource().equals(profil.getDisconnect())){
//			JPanel frame = new JPanel();
//			frame.setLayout(new BorderLayout());
//			frame.add(titleBar, BorderLayout.NORTH);
//			frame.add(connexion, BorderLayout.SOUTH);
//			this.connexion.setUserLog("Login");
//			this.connexion.setPassLog("Password");
//			this.connexion.setDataNameLog("URL of the data base");
//			this.connexion.setUserSub("Name of the new user");
//			this.connexion.setPassSub("Password");
//			this.connexion.setConfirmPassSub("Password");
//			this.connexion.setDataNameSub("URL of the data base");
//			interf.setPanel(frame);
			
			interf.dispose();
			
			try {
				new Interface().setVisible(true);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		
		}
		
		if(arg0.getSource() == this.profil.getSetting()) {
			JPanel frame = new JPanel();
			JPanel toolBar = new JPanel();
			BorderLayout cr = new BorderLayout();
			toolBar.setLayout(cr);
			
			frame.setLayout(new BorderLayout());
			frame.add(profilPanel, BorderLayout.CENTER);
			
			toolBar.add(titleBar, BorderLayout.NORTH);
			toolBar.add(mainPanel, BorderLayout.SOUTH);
			
			JPanel principal = new JPanel();
			principal.setLayout(new BorderLayout());
			principal.add(toolBar, BorderLayout.NORTH);
			principal.add(frame, BorderLayout.CENTER);
			interf.setPanel(principal);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Generate an action when the smile passes on the component.
	 */
	public void mouseEntered(MouseEvent arg0) {
		if(arg0.getSource().equals(profil.getHome())){
			profil.getHome().setIcon(new ImageIcon("data/images/home2.png"));
		}
		
		if(arg0.getSource().equals(profil.getSetting())){
			profil.getSetting().setIcon(new ImageIcon("data/images/setting2.png"));
		}
		
		if(arg0.getSource().equals(profil.getDisconnect())){
			profil.getDisconnect().setIcon(new ImageIcon("data/images/disconnect2.png"));
		}
		
	}

	/**
	 * Generate an action when the smile leave the component.
	 */
	public void mouseExited(MouseEvent arg0) {
		if(arg0.getSource().equals(profil.getHome())){
			profil.getHome().setIcon(new ImageIcon("data/images/home.png"));
		}
		
		if(arg0.getSource().equals(profil.getSetting())){
			profil.getSetting().setIcon(new ImageIcon("data/images/setting.png"));
		}
		
		if(arg0.getSource().equals(profil.getDisconnect())){
			profil.getDisconnect().setIcon(new ImageIcon("data/images/disconnect.png"));
		}
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}

}
