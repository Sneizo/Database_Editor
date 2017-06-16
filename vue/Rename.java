package vue;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.CompoundBorder;

public class Rename extends JPanel{
	
	private JTextField newTableName1;
	private JTextField newTableName2;
	private JTextField newTableName3;
	
	private JLabel newName;
	
	private JPanel pane;
	private JPanel paneButton;
	private JPanel paneButtonAnnuler;
	private JPanel paneButtonConfirmer;
	
	private JLabel vide1;
	private JLabel vide2;
	
	private JButton confirmer;
	private JButton annuler;
	
	public Rename() {
		init();
	}
	
	public void init() {
		this.pane = new JPanel();
		this.pane.setLayout(new GridLayout(3,2,0,50));
		
		Font font = new Font("arimo",Font.BOLD,20);
		
		this.newName = new JLabel("Enter the new name of the table : ");
		this.newName.setFont(font);
		this.newTableName1 = new JTextField();
		this.newTableName2 = new JTextField();
		this.newTableName3 = new JTextField();
		this.vide1 = new JLabel();
		this.vide2 = new JLabel();
		
		this.pane.add(this.newName);
		this.pane.add(this.newTableName1);
		this.pane.add(this.vide1);
		this.pane.add(this.newTableName2);
		this.pane.add(this.vide2);
		this.pane.add(this.newTableName3);
		
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
		
		this.confirmer = new JButton("RENAME");
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
		return newTableName1;
	}

	public JTextField getNewTableName2() {
		return newTableName2;
	}

	public JTextField getNewTableName3() {
		return newTableName3;
	}

	public JButton getConfirmer() {
		return confirmer;
	}

	public JButton getAnnuler() {
		return annuler;
	}
}
