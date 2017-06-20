package vue;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.CompoundBorder;

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
	
	public Rename() {
		init();
	}
	
	public void init() {
		this.pane = new JPanel();
		this.pane.setLayout(new GridLayout(2,2,0,50));
		
		Font font = new Font("arimo",Font.BOLD,20);
		Font fontJT = new Font("arimo",Font.PLAIN,20);
		
		this.oldName = new JLabel("Enter the old name of table : ");
		this.oldName.setFont(font);
		this.oldTableName = new JTextField();
		this.oldTableName.setFont(fontJT);
		this.newTableName = new JTextField();
		this.newTableName.setFont(fontJT);
		this.newName = new JLabel("Enter the new name of table : ");
		this.newName.setFont(font);
		
		this.pane.add(this.oldName);
		this.pane.add(this.oldTableName);
		this.pane.add(this.newName);
		this.pane.add(this.newTableName);
		
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


	public JTextField getOldTableName() {
		return oldTableName;
	}

	public JTextField getNewTableName() {
		return newTableName;
	}

	public JButton getConfirmer() {
		return confirmer;
	}

	public JButton getAnnuler() {
		return annuler;
	}
}
