/**
 * 
 */
package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.MainController;
import controller.MouseListenerJFrame;
import controller.MouseMotionListenner;

/**
 * @author Damien
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

	private MainController mainController;

	public Interface() {
		init();
		connexion = new Connexion();
		rename = new Rename();
		create = new Create();
		panelQuery = new PanelQuery();
		mainPanel = new MainPanel();
		titleBar = new TitleBar();

		mainController = new MainController(connexion, create, rename, mainPanel, titleBar, panelQuery, this);

		this.setSize(1080, 720);
		// Recupere la taille de l'ecran et fait en fonction
		// Dimension dimension =
		// java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		// int height = (int)dimension.getHeight();
		// int width = (int)dimension.getWidth();
		this.setLayout(new BorderLayout());
		this.add(titleBar, BorderLayout.NORTH);
		this.add(connexion, BorderLayout.CENTER);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void init() {
		setUndecorated(true);
		setResizable(false);
		setBackground(Color.WHITE);
	}
	
	public void setPanel(JPanel pane) {
		
		this.setContentPane(pane);
		this.repaint();
		this.revalidate();
	}

	/**
	 * @param posX
	 *            the posX to set
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * @param posY
	 *            the posY to set
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
