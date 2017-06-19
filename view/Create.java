package view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.CompoundBorder;

public class Create extends JPanel{
	
	private JTextField tableName1;
	private JTextField tableName2;
	private JTextField tableName3;
	
	private JLabel newName;
	
	private JPanel pane;
	private JPanel paneButton;
	private JPanel paneButtonAnnuler;
	private JPanel paneButtonConfirmer;
	
	private JLabel vide1;
	private JLabel vide2;
	
	private JButton confirmer;
	private JButton annuler;
	
	public Create() {
		init();
	}
	
	public void init() {
		this.pane = new JPanel();
		this.pane.setLayout(new GridLayout(3,2,0,50));
		
		Font font = new Font("arimo",Font.BOLD,20);
		
		this.newName = new JLabel("Enter the name of the table : ");
		this.newName.setFont(font);
		this.tableName1 = new JTextField();
		this.tableName2 = new JTextField();
		this.tableName3 = new JTextField();
		this.vide1 = new JLabel();
		this.vide2 = new JLabel();
		
		this.pane.add(this.newName);
		this.pane.add(this.tableName1);
		this.pane.add(this.vide1);
		this.pane.add(this.tableName2);
		this.pane.add(this.vide2);
		this.pane.add(this.tableName3);
		
		this.pane.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),(BorderFactory.createEmptyBorder(200,100,200,200))));
		
		Font buttonFont = new Font("arimo",Font.BOLD,20);
		this.paneButtonAnnuler = new JPanel();
		this.paneButtonAnnuler.setLayout(new BorderLayout());
		
		this.annuler = new JButton("CANCEL");
		this.annuler.setFont(buttonFont);
		this.annuler.setPreferredSize(new Dimension(150,50));
		this.paneButtonAnnuler.add(this.annuler);
		
		
		this.paneButtonConfirmer = new JPanel();
		this.paneButtonConfirmer.setLayout(new BorderLayout());
		
		this.confirmer = new JButton("CREATE");
		this.confirmer.setFont(buttonFont);
		this.confirmer.setPreferredSize(new Dimension(150,50));
		this.paneButtonConfirmer.add(this.confirmer);
		
		
		this.paneButton = new JPanel();
		this.paneButton.setLayout(new BorderLayout());
		this.paneButton.add(this.paneButtonAnnuler, BorderLayout.WEST);
		this.paneButton.add(this.paneButtonConfirmer, BorderLayout.EAST);
		this.paneButton.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),(BorderFactory.createEmptyBorder(0,50,35,50))));
		
		this.setLayout(new BorderLayout());
		this.add(pane, BorderLayout.CENTER);
		this.add(paneButton, BorderLayout.SOUTH);
		
	}

	public JTextField getNewTableName1() {
		return tableName1;
	}

	public JTextField getNewTableName2() {
		return tableName2;
	}

	public JTextField getNewTableName3() {
		return tableName3;
	}

	public JButton getConfirmer() {
		return confirmer;
	}

	public JButton getAnnuler() {
		return annuler;
	}
}
