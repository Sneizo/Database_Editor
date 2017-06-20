package vue;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.CompoundBorder;

public class Create extends JPanel{
	
	private JTextField newTableName;
	
	private JLabel newName;
	
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
		this.pane = new JPanel();
		//4 colonnes pour éviter que le JTextField soit trop grand
		this.pane.setLayout(new GridLayout(4,1,0,0));
		
		Font font = new Font("arimo",Font.BOLD,20);
		Font fontJT = new Font("arimo",Font.PLAIN,20);
		
		this.newName = new JLabel("Enter the name of new table : ");
		this.newName.setFont(font);
		this.newName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		this.newTableName = new JTextField();
		this.newTableName.setFont(fontJT);
		
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
	

	public JButton getConfirmer() {
		return confirmer;
	}

	public JButton getAnnuler() {
		return annuler;
	}
	
	public JTextField getNewTableName() {
		return newTableName;
	}
}
