package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.border.CompoundBorder;

import controler.MainPanelControler;

public class MainPanel extends JPanel{
	
	//Toolbar component
	private JToolBar toolBar;
	private JButton create;
	private JButton open;
	private JButton save;
	private JButton saveAs;
	private JButton rename;
	private JButton disconnect;	
	
	private JButton consol;
	private Interface ihm;
	
	private int posX = 0;   //Position X de la souris au clic
    private int posY = 0;   //Position Y de la souris au clic
	
	
	public MainPanel(Interface ihm) throws IOException{
		this.ihm = ihm;
		initComponent();
	}
	
	private void initComponent() throws IOException{
		
		//Buton consol
		consol = new JButton("   |");
		consol.setForeground(Color.WHITE);
		consol.setIcon(new ImageIcon(ImageIO.read(new File("data/images/create.png")).getScaledInstance(20,20,BufferedImage.TYPE_INT_ARGB)));
		consol.setBorderPainted(false);
		consol.setBorder(null);
		consol.setContentAreaFilled(false);
		
		//Button create
		create = new JButton("Create    |");
		create.setForeground(Color.WHITE);
		create.setIcon(new ImageIcon(ImageIO.read(new File("data/images/create.png")).getScaledInstance(20,20,BufferedImage.TYPE_INT_ARGB)));
		create.setBorderPainted(false);
		create.setBorder(null);
		create.setContentAreaFilled(false);
	
		//Button open
		open = new JButton("Open   |");
		open.setIcon(new ImageIcon(ImageIO.read(new File("data/images/open.png")).getScaledInstance(20,20,BufferedImage.TYPE_INT_ARGB)));
		open.setForeground(Color.WHITE);
		open.setBorderPainted(false);
		open.setBorder(null);
		open.setContentAreaFilled(false);
		//Button save
		save = new JButton("Save   |");
		save.setIcon(new ImageIcon(ImageIO.read(new File("data/images/save.png")).getScaledInstance(20,20,BufferedImage.TYPE_INT_ARGB)));
		save.setForeground(Color.WHITE);
		save.setBorderPainted(false);
		save.setBorder(null);
		save.setContentAreaFilled(false);
		//Button saveAs
		saveAs = new JButton("Save as   |");
		saveAs.setIcon(new ImageIcon(ImageIO.read(new File("data/images/saveAs.png")).getScaledInstance(20,20,BufferedImage.TYPE_INT_ARGB)));
		saveAs.setForeground(Color.WHITE);
		saveAs.setBorderPainted(false);
		saveAs.setBorder(null);
		saveAs.setContentAreaFilled(false);
		//Button rename 
		rename = new JButton("Rename");
		rename.setIcon(new ImageIcon(ImageIO.read(new File("data/images/rename.png")).getScaledInstance(20,20,BufferedImage.TYPE_INT_ARGB)));
		rename.setForeground(Color.WHITE);
		rename.setBorderPainted(false);
		rename.setBorder(null);
		rename.setContentAreaFilled(false);
		//Button disconnect
		disconnect = new JButton();
		disconnect.setIcon(new ImageIcon(ImageIO.read(new File("data/images/user.png")).getScaledInstance(20,20,BufferedImage.TYPE_INT_ARGB)));
		disconnect.setBorderPainted(false);
		disconnect.setBorder(null);
		disconnect.setContentAreaFilled(false);
		
		//Creation of toolbar and add Button		
		JPanel east = new JPanel();
		east.setBackground(new Color(0,76,153));
		GridLayout a = new GridLayout(1,6);
		east.setLayout(a);		
		east.add(create);	
		east.add(open);		
		east.add(save);		
		east.add(saveAs);		
		east.add(rename);
		
		
		
		
		JPanel west = new JPanel();
		west.setBackground(new Color(0,76,153));
		west.add(disconnect);
		west.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),(BorderFactory.createEmptyBorder(5,5,5,5))));
		
		JPanel cen = new JPanel();
		cen.setBackground(new Color(0,76,153));
		
		toolBar = new JToolBar();
		toolBar.setBackground(new Color(0,76,153));
		toolBar.setFloatable(false);
		
		JPanel o = new JPanel();
		o.setLayout(new BorderLayout());
		o.add(west, BorderLayout.EAST);
		o.add(east, BorderLayout.WEST);
		o.add(cen, BorderLayout.CENTER);
		
		toolBar.setLayout(new BorderLayout());
		toolBar.add(new TitleBar(), BorderLayout.NORTH);
		toolBar.add(o, BorderLayout.SOUTH);
		

		
		BorderLayout border = new BorderLayout();
		setLayout(border);
		add(toolBar, BorderLayout.NORTH);
		
		addMouseListener(new MouseAdapter() {
            @Override
            //on recupere les coordonnées de la souris
            public void mousePressed(MouseEvent e) {
                posX = e.getX();    //Position X de la souris au clic
                posY = e.getY();    //Position Y de la souris au clic
            }
        });
         
        addMouseMotionListener(new MouseMotionAdapter() {
            // A chaque deplacement on recalcul le positionnement de la fenetre
            @Override
            public void mouseDragged(MouseEvent e) {
                int depX = e.getX() - posX;
                int depY = e.getY() - posY;
                setLocation(getX()+depX, getY()+depY);
            }
        });	
		
		create.addActionListener(new MainPanelControler(this, ihm));
	}

	/**
	 * @return the toolBar
	 */
	public JToolBar getToolBar() {
		return toolBar;
	}

	/**
	 * @return the create
	 */
	public JButton getCreate() {
		return create;
	}

	/**
	 * @return the open
	 */
	public JButton getOpen() {
		return open;
	}

	/**
	 * @return the save
	 */
	public JButton getSave() {
		return save;
	}

	/**
	 * @return the saveAs
	 */
	public JButton getSaveAs() {
		return saveAs;
	}

	/**
	 * @return the rename
	 */
	public JButton getRename() {
		return rename;
	}

	/**
	 * @return the disconnect
	 */
	public JButton getDisconnect() {
		return disconnect;
	}


	/**
	 * @return the consol
	 */
	public JButton getConsol() {
		return consol;
	}

	
	
}
