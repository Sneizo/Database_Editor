package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;

/**
 * This class creates the different button of the create class.
 * @author Mael and Damien
 *
 */
public class CreateColonne extends JPanel {

	private JTextField nameF;
	private JTextField typeF;

	private JLabel name;
	private JLabel type;

	private JPanel pane;
	private JPanel paneButtonConfirmer;

	private JButton continuer;

	/**
	 * The contructor of the class.
	 */
	public CreateColonne() {
		init();
	}

	/**
	 * This method resets the graphical components
	 */
	public void init() {

		setBackground(new Color(80, 80, 80));
		this.pane = new JPanel();
		pane.setBackground(new Color(80, 80, 80));
		// 4 colonnes pour éviter que le JTextField soit trop grand
		this.pane.setLayout(new GridLayout(4, 1, 0, 0));

		Font font = new Font("arimo", Font.BOLD, 20);
		Font fontJT = new Font("arimo", Font.PLAIN, 20);

		this.name = new JLabel("Enter the name of the column : ");
		this.name.setFont(font);
		this.name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		this.name.setForeground(Color.WHITE);
		
		this.nameF = new JTextField();
		this.nameF.setFont(fontJT);
		this.nameF.setBackground(new Color(80, 80, 80));
		this.nameF.setForeground(Color.WHITE);
		this.nameF.setHorizontalAlignment(JTextField.CENTER);
		this.nameF.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		
		this.type = new JLabel("Enter the type columns");
		this.type.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		this.type.setForeground(Color.WHITE);
		this.type.setFont(font);
		
		this.typeF = new JTextField();
		this.typeF.setFont(fontJT);
		this.typeF.setBackground(new Color(80, 80, 80));
		this.typeF.setForeground(Color.WHITE);
		this.typeF.setHorizontalAlignment(JTextField.CENTER);
		this.typeF.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

		this.pane.add(this.name);
		this.pane.add(this.nameF);
		this.pane.add(this.type);
		this.pane.add(this.typeF);

		this.pane.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),
				(BorderFactory.createEmptyBorder(200, 100, 200, 200))));

		Font buttonFont = new Font("arimo", Font.BOLD, 20);

		this.paneButtonConfirmer = new JPanel();
		this.paneButtonConfirmer.setLayout(new BorderLayout());

		this.continuer = new JButton("Continuer");
		this.continuer.setFont(buttonFont);
		this.continuer.setPreferredSize(new Dimension(150, 50));
		this.continuer.setBackground(new Color(80, 80, 80));
		this.continuer.setForeground(Color.WHITE);
		this.continuer.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
		this.paneButtonConfirmer.add(this.continuer, BorderLayout.CENTER);

		this.setLayout(new BorderLayout());
		this.add(pane, BorderLayout.CENTER);
		this.add(this.paneButtonConfirmer, BorderLayout.SOUTH);

	}

	/**
	 * 
	 * @return Return the name.
	 */
	public JTextField getNameF() {
		return nameF;
	}

	/**
	 * 
	 * @return Return the type.
	 */
	public JTextField getTypeF() {
		return typeF;
	}

	/**
	 * Return the validate button.
	 * @return The JButton continue.
	 */
	public JButton getContinuer() {
		return continuer;
	}

}
