package view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.CompoundBorder;

/**
 * This class creates the panel for rename a table.
 * @author Mael and Damien
 *
 */
public class Rename extends JPanel{
	
	private JTextField oldTableName;
	private JTextField newTableName;
	
	private JLabel oldName;
	private JLabel newName;
	
	private JPanel pane;
	private JPanel paneButton;
	private JPanel paneButtonAnnuler;
	private JPanel paneButtonConfirmer;
	
	
	private JButton confirmer;
	private JButton annuler;
	
	/**
	 * The constructor of the Rename class.
	 */
	public Rename() {
		init();
	}
	
	/**
	 * Initializes the graphical components.
	 */
	public void init() {
		this.pane = new JPanel();
		this.pane.setLayout(new GridLayout(2,2,0,50));
		pane.setBackground(new Color(80,80,80));
		Font font = new Font("arimo",Font.BOLD,20);
		Font fontJT = new Font("arimo",Font.PLAIN,20);
		
		this.oldName = new JLabel("Enter the old name of table : ");
		this.oldName.setFont(font);
		this.oldName.setForeground(Color.WHITE);
		this.oldTableName = new JTextField();
		this.oldTableName.setFont(fontJT);
		this.oldTableName.setBackground(new Color(80,80,80));
		this.oldTableName.setForeground(Color.WHITE);
		this.oldTableName.setHorizontalAlignment(JTextField.CENTER);
		this.oldTableName.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		this.oldTableName.setCaretColor(Color.WHITE);
		
		this.newTableName = new JTextField();
		this.newTableName.setFont(fontJT);
		this.newTableName.setBackground(new Color(80,80,80));
		this.newTableName.setForeground(Color.WHITE);
		this.newTableName.setHorizontalAlignment(JTextField.CENTER);
		this.newTableName.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		this.newTableName.setCaretColor(Color.WHITE);
		
		this.newName = new JLabel("Enter the new name of table : ");
		this.newName.setFont(font);
		this.newName.setForeground(Color.WHITE);
		
		this.pane.add(this.oldName);
		this.pane.add(this.oldTableName);
		this.pane.add(this.newName);
		this.pane.add(this.newTableName);
		
		this.pane.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),(BorderFactory.createEmptyBorder(200,100,200,200))));
		
		Font buttonFont = new Font("arimo",Font.BOLD,20);
		this.paneButtonAnnuler = new JPanel();
		this.paneButtonAnnuler.setBackground(new Color(80,80,80));
		this.paneButtonAnnuler.setLayout(new BorderLayout());
		
		this.annuler = new JButton("CANCEL");
		this.annuler.setFont(buttonFont);
		this.annuler.setPreferredSize(new Dimension(150,50));
		this.annuler.setBackground(new Color(80,80,80));
		this.annuler.setForeground(Color.WHITE);
		this.annuler.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
		this.paneButtonAnnuler.add(this.annuler);
		
		
		
		this.paneButtonConfirmer = new JPanel();
		this.paneButtonConfirmer.setLayout(new BorderLayout());
		this.paneButtonConfirmer.setBackground(new Color(80,80,80));
		
		this.confirmer = new JButton("RENAME");
		this.confirmer.setFont(buttonFont);
		this.confirmer.setPreferredSize(new Dimension(150,50));
		this.confirmer.setBackground(new Color(80,80,80));
		this.confirmer.setForeground(Color.WHITE);
		this.confirmer.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
		this.paneButtonConfirmer.add(this.confirmer);
		
		
		this.paneButton = new JPanel();
		this.paneButton.setBackground(new Color(80,80,80));
		this.paneButton.setLayout(new BorderLayout());
		this.paneButton.add(this.paneButtonAnnuler, BorderLayout.WEST);
		this.paneButton.add(this.paneButtonConfirmer, BorderLayout.EAST);
		this.paneButton.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),(BorderFactory.createEmptyBorder(0,50,35,50))));
		
		this.setLayout(new BorderLayout());
		this.add(pane, BorderLayout.CENTER);
		this.add(paneButton, BorderLayout.SOUTH);
		
	}

	/**
	 * 
	 * @return The oldTableName
	 */
	public JTextField getOldTableName() {
		return oldTableName;
	}
	
	/**
	 * 
	 * @return The newTableName
	 */
	public JTextField getNewTableName() {
		return newTableName;
	}

	/**
	 * 
	 * @return The button validate.
	 */
	public JButton getConfirmer() {
		return confirmer;
	}

	/**
	 * 
	 * @return The cancel button.
	 */
	public JButton getAnnuler() {
		return annuler;
	}
}
