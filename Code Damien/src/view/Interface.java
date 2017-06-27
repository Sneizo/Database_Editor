package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.MainController;

/**
 * Create the main window
 * @author Mael and Damien
 *
 */
public class Interface extends JFrame {

	private int posX = 0; // Position X de la souris au clic
	private int posY = 0; // Position Y de la souris au clic

	private Connexion connexion;
	private Rename rename;
	private Create create;
	private PanelQuery panelQuery;
	private MainPanel mainPanel;
	private TitleBar titleBar;
	private InformationBar informationBar;
	private Profil profil;
	private ProfilPanel profilPanel;
	private ModifPassword modifPassword;
	private SetAutoSave setAutoSave;
	private CreateColonne createColonne;
	private MainController mainController;

	/**
	 * The constructor of the Interface class
	 * @throws InterruptedException Exception.
	 */
	public Interface() throws InterruptedException {
		init();
		connexion = new Connexion();
		rename = new Rename();
		create = new Create();
		panelQuery = new PanelQuery();
		mainPanel = new MainPanel();
		titleBar = new TitleBar();
		informationBar = new InformationBar();
		profil = new Profil();
		profilPanel = new ProfilPanel();
		modifPassword = new ModifPassword();
		setAutoSave = new SetAutoSave();
		createColonne = new CreateColonne();
		
		setIconImage(new ImageIcon("data/images/logo.png").getImage());
		setTitle("MDSql Database Editor");

		mainController = new MainController(connexion, create, rename, mainPanel, titleBar, panelQuery, this, informationBar, profil,profilPanel,modifPassword, setAutoSave, createColonne);
		
		this.setSize(1080, 720);
		// Recupere la taille de l'ecran et fait en fonction
		// Dimension dimension =
		// java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		// int height = (int)dimension.getHeight();
		// int width = (int)dimension.getWidth();
		this.setLayout(new BorderLayout());
		this.add(titleBar, BorderLayout.NORTH);
		this.add(connexion, BorderLayout.CENTER);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	/**
	 * This method sets the window settings
	 */
	public void init() {
		setUndecorated(true);
		setResizable(false);
		setBackground(Color.WHITE);
	}
	
	/**
	 * This method initializes the different panel of the window
	 * @param pane The panel
	 */
	public void setPanel(JPanel pane) {		
		this.setContentPane(pane);
		this.repaint();
		this.revalidate();
	}

	/**
	 * @param posX The posX to set
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * @param posY The posY to set
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * @return the posX
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * @return the posY
	 */
	public int getPosY() {
		return posY;
	}

}
