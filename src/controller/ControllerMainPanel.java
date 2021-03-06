package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import model.ConnexionJDBC;
import model.OpenFileJDBC;
import model.SaveFileJDBC;
import model.TableJDBC;
import view.Create;
import view.Interface;
import view.MainPanel;
import view.PanelQuery;
import view.Profil;
import view.Rename;
import view.TitleBar;


/**
 * This class maintains the control of the main panel, it manages graphic changes, actions etc.
 * @author Mael and Damien
 *
 */
public class ControllerMainPanel implements ActionListener, MouseListener {

	private MainPanel mainPanel;
	private Interface interf;
	private Create create;
	private TitleBar titleBar;
	private Rename rename;
	private Profil profil;
	private SaveFileJDBC saveFile;
	private ConnexionJDBC con;
	private PanelQuery panelQuery;
	private OpenFileJDBC openFile;
	
	/**
	 * The constructor of the ControllerMainPanel class.
	 * @param mainPanel The mainPanel class.
	 * @param interf The main frame.
	 * @param create The create class.
	 * @param titleBar The titleBar class.
	 * @param rename The rename class.
	 * @param profil The profil class.
	 * @param saveFile The saveFile class.
	 * @param con The connexionJDBC class.
	 * @param panelQuery The panelQuery class.
	 * @param openFile The openFile class.
	 */
	public ControllerMainPanel(MainPanel mainPanel, Interface interf,Create create, TitleBar titleBar, Rename rename, Profil profil, SaveFileJDBC saveFile, ConnexionJDBC con, PanelQuery panelQuery, OpenFileJDBC openFile) {
		this.mainPanel = mainPanel;
		this.interf = interf;
		this.create = create;
		this.titleBar = titleBar;
		this.rename = rename;
		this.profil = profil;
		this.saveFile = saveFile;
		this.con = con;
		this.panelQuery = panelQuery;
		this.openFile = openFile;
		
	}

	
	/**
	 * Performs an action if the button pressed is the reference button.
	 */
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == (mainPanel.getCreate())) {
			JPanel pane = new JPanel();
			pane.setLayout(new BorderLayout());
			pane.add(titleBar, BorderLayout.NORTH);
			pane.add(create, BorderLayout.CENTER);
			this.interf.setPanel(pane);
		}
		
		if (ae.getSource() == (mainPanel.getSave())) {
			saveFile.saveFile();			
		}
		
		if (ae.getSource() == (mainPanel.getSaveAs())) {
			saveFile.saveFileAs();
		}
		
		if (ae.getSource() == (mainPanel.getOpen())) {
			openFile.readFile();
		}
		
		if (ae.getSource() == (mainPanel.getRename())) {
			JPanel pane = new JPanel();
			pane.setLayout(new BorderLayout());
			pane.add(titleBar, BorderLayout.NORTH);
			pane.add(rename, BorderLayout.CENTER);
			this.interf.setPanel(pane);
		}
		
		if (ae.getSource() == (mainPanel.getDisconnect())) {
			JPanel pane = new JPanel();
			pane.setLayout(new BorderLayout());
			pane.add(titleBar, BorderLayout.NORTH);
			pane.add(profil, BorderLayout.CENTER);
			this.interf.setPanel(pane);
		}
		
		if (ae.getSource() == (mainPanel.getRefresh())) {
			TableJDBC table = new TableJDBC(con);
			Vector<String> vec = table.getVector();
			this.panelQuery.setVector(vec);
			this.interf.repaint();
			this.interf.revalidate();
		}
		
	}

	
	
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Generate an action when the smile passes on the component.
	 */
	public void mouseEntered(MouseEvent arg0) {
		if(arg0.getSource().equals(mainPanel.getDisconnect())){
			try {
				mainPanel.getDisconnect().setIcon(new ImageIcon(ImageIO.read(new File("data/images/userRed.png")).getScaledInstance(20,20,BufferedImage.TYPE_INT_ARGB)));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		if(arg0.getSource().equals(mainPanel.getRefresh())){
			try {
				mainPanel.getRefresh().setIcon(new ImageIcon(ImageIO.read(new File("data/images/refreshRed.png")).getScaledInstance(20,20,BufferedImage.TYPE_INT_ARGB)));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * Generate an action when the smile leave the component.
	 */
	public void mouseExited(MouseEvent arg0) {
		if(arg0.getSource().equals(mainPanel.getDisconnect())){
			try {
				mainPanel.getDisconnect().setIcon(new ImageIcon(ImageIO.read(new File("data/images/user.png")).getScaledInstance(20,20,BufferedImage.TYPE_INT_ARGB)));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		if(arg0.getSource().equals(mainPanel.getRefresh())){
			try {
				mainPanel.getRefresh().setIcon(new ImageIcon(ImageIO.read(new File("data/images/refresh.png")).getScaledInstance(20,20,BufferedImage.TYPE_INT_ARGB)));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}

	
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
