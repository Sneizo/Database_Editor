package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;

public class MainPanel extends JPanel{
	
	//Toolbar component
	private JToolBar toolBar;
	private JButton create;
	private JButton open;
	private JButton save;
	private JButton saveAs;
	private JButton rename;
	private JButton disconnect;
	
	
	//MainPanel
	private JPanel mainPanelText;
	
	//PanelTextInPut
	private JPanel panelInputText;
	private JTextArea queryWrite;
	private JButton execute;
	private JLabel nameDataBase;
	private JScrollPane scrollPane1;
	
	//PanelResult
	private JPanel panelResult;
	private JTextArea queryResult;
	private JScrollPane scrollPane2;
	private JLabel resultQuery;
	
	private JPanel titlePanel;
	private JPanel executePanel;
	
	private JTable table;
	private JScrollPane scrollPane3;
	
	
	
	public MainPanel() throws IOException{
		
		initComponent();
	}
	
	private void initComponent() throws IOException{
		
		
		
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
		
		
		
		//Creation of JTextArea
		queryWrite = new JTextArea(8,20);
		queryWrite.setLineWrap(true);
        queryWrite.setWrapStyleWord(true);
        queryWrite.setOpaque(true);	
		//Creation of JButton execute
		execute = new JButton("Execute query");
		execute.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY),(BorderFactory.createEmptyBorder(5,5,5,5))));
		
		executePanel = new JPanel();
		GridLayout grid = new GridLayout(1,1);
		executePanel.setLayout(grid);
		executePanel.add(execute);
		executePanel.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),(BorderFactory.createEmptyBorder(10,40,10,40))));
		
		
		
		//Creation of DatabaseName label
		nameDataBase = new JLabel("Database_Name");
		//Creation of ScrollBar
		scrollPane1 = new JScrollPane(queryWrite);
		
		titlePanel = new JPanel();
		GridLayout grd = new GridLayout(1,2);
		titlePanel.setLayout(grd);
		titlePanel.add(nameDataBase);
		titlePanel.add(executePanel);
		titlePanel.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY),(BorderFactory.createEmptyBorder(10,10,10,10))));
        
		//Creation panelInputText and addButton
		panelInputText = new JPanel();
		BorderLayout br = new BorderLayout();
		panelInputText.setLayout(br);
		//panelInputText.add(scrollPane1, BorderLayout.CENTER);
		panelInputText.add(scrollPane1, BorderLayout.CENTER);
		panelInputText.add(titlePanel, BorderLayout.NORTH);
		panelInputText.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),(BorderFactory.createEmptyBorder(16,16,16,16))));
				
		//Creation of queryResult textArea
		queryResult = new JTextArea(8,20);
		queryResult.setEditable(false);
		//Creation of scrollPane2
		scrollPane2 = new JScrollPane(queryResult);
		//Creation of label Result
		resultQuery = new JLabel("Result");
		resultQuery.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Creation of resultQuery Panel
		panelResult = new JPanel();
		GridLayout gp = new GridLayout(2,1);
		panelResult.setLayout(gp);
		panelResult.add(resultQuery);
		panelResult.add(scrollPane2);
		panelResult.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),(BorderFactory.createEmptyBorder(16,16,16,16))));
		
		//Creation of mainPanelText
		mainPanelText = new JPanel();
		GridLayout gr = new GridLayout(2,1);
		mainPanelText.setLayout(gr);
		mainPanelText.add(panelInputText);
		mainPanelText.add(panelResult);
		mainPanelText.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY),(BorderFactory.createEmptyBorder(16,16,16,16))));
		
		//Les données du tableau
	    Object[][] data = {
	      {"Agent"},
	      {"Client"},
	      {"Opération"},
	      {"Agence"}
	    };

	    //Les titres des colonnes
	    String  title[] = {"Name of table"};
		
		table = new JTable(data, title);
		scrollPane3 = new JScrollPane(table);
		
		JPanel tablePan = new JPanel();
		tablePan.add(scrollPane3);
		
		BorderLayout border = new BorderLayout();
		setLayout(border);
		add(toolBar, BorderLayout.NORTH);
		add(mainPanelText, BorderLayout.CENTER);
		add(tablePan, BorderLayout.WEST);
	}
}
