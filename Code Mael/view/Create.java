package view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.CompoundBorder;

public class Create extends JPanel{
	
	private JTextField newTableName;
	private JTextField nbCol;
	
	private JLabel newName;
	private JLabel nb;
	
	private JPanel pane;
	private JPanel paneButton;
	private JPanel paneButtonAnnuler;
	private JPanel paneButtonConfirmer;
	
	private JButton confirmer;
	private JButton annuler;

	
	public Create() {
		init();
	}
	
	public void init() {
		
		setBackground(new Color(80,80,80));
		this.pane = new JPanel();
		pane.setBackground(new Color(80,80,80));
		//4 colonnes pour éviter que le JTextField soit trop grand
		this.pane.setLayout(new GridLayout(5,1,0,0));
		
		Font font = new Font("arimo",Font.BOLD,20);
		Font fontJT = new Font("arimo",Font.PLAIN,20);
		
		this.newName = new JLabel("Enter the name of new table : ");
		this.newName.setFont(font);
		this.newName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		this.newName.setForeground(Color.WHITE);
		this.newTableName = new JTextField();
		this.newTableName.setFont(fontJT);
		this.newTableName.setBackground(new Color(80,80,80));
		this.newTableName.setForeground(Color.WHITE);
		this.newTableName.setHorizontalAlignment(JTextField.CENTER);
		this.newTableName.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		this.nb = new JLabel("Enter the number of columns");
		this.nb.setFont(font);
		this.nb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		this.nb.setForeground(Color.WHITE);
		this.nbCol = new JTextField();
		this.nbCol.setFont(fontJT);
		this.nbCol.setBackground(new Color(80,80,80));
		this.nbCol.setForeground(Color.WHITE);
		this.nbCol.setHorizontalAlignment(JTextField.CENTER);
		this.nbCol.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		
		
		this.pane.add(this.newName);
		this.pane.add(this.newTableName);
		this.pane.add(new JLabel());
		this.pane.add(this.nb);
		this.pane.add(this.nbCol);
		
		this.pane.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),(BorderFactory.createEmptyBorder(200,100,200,200))));
		
		Font buttonFont = new Font("arimo",Font.BOLD,20);
		this.paneButtonAnnuler = new JPanel();
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
		
		this.confirmer = new JButton("CREATE");
		this.confirmer.setFont(buttonFont);
		this.confirmer.setPreferredSize(new Dimension(150,50));
		this.confirmer.setBackground(new Color(80,80,80));
		this.confirmer.setForeground(Color.WHITE);
		this.confirmer.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
		this.paneButtonConfirmer.add(this.confirmer);
		
		
		
		this.paneButton = new JPanel();
		paneButton.setBackground(new Color(80,80,80));
		this.paneButton.setLayout(new BorderLayout());
		this.paneButton.add(this.paneButtonAnnuler, BorderLayout.WEST);
		this.paneButton.add(this.paneButtonConfirmer, BorderLayout.EAST);
		this.paneButton.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),(BorderFactory.createEmptyBorder(0,50,35,50))));
		
		this.setLayout(new BorderLayout());
		this.add(pane, BorderLayout.CENTER);
		this.add(paneButton, BorderLayout.SOUTH);
		
	}
	

	public JButton getConfirmer() {
		return confirmer;
	}

	public JButton getAnnuler() {
		return annuler;
	}
	
	public JTextField getNewTableName() {
		return newTableName;
	}
	
	
	public JTextField getNbCol() {
		return this.nbCol;
	}
}
