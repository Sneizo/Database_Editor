package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;

/**
 * This class creates the panel to set the automatic backup.
 * @author Mael and Damien
 *
 */
public class SetAutoSave extends JPanel {

	private boolean autoSave;
	private int boucle;
	private JCheckBox check;
	private JTextField tmp;

	private JLabel temps;
	private JLabel question;
	private JButton confirmer;
	
	public SetAutoSave() {
		this.autoSave = true;
		this.boucle = 10;
		initSetAutoSave();
	}
	
	/**
	 * Initializes the graphical components.
	 */
	private void initSetAutoSave() {
		
		this.setBackground(new Color(80,80,80));
		
		Font font = new Font("arimo", Font.PLAIN, 24);
		this.check = new JCheckBox();
		this.check.setBackground(new Color(80,80,80));
		
		this.tmp = new JTextField();
		this.tmp.setFont(font);
		this.tmp.setText("10");
		this.tmp.setBackground(new Color(80,80,80));
		this.tmp.setForeground(Color.WHITE);
		this.tmp.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		this.tmp.setHorizontalAlignment(JTextField.CENTER);
		this.tmp.setCaretColor(Color.WHITE);
		
		this.temps = new JLabel("The time between each autoSave :");
		this.temps.setFont(font);
		this.temps.setForeground(Color.WHITE);
		
		this.question = new JLabel("Do you want autoSave ? ");
		this.question.setFont(font);
		this.question.setForeground(Color.WHITE);
		
		this.confirmer = new JButton("Confirm");
		this.confirmer.setFont(font);
		this.confirmer.setForeground(Color.WHITE);
		this.confirmer.setFont(font);
		this.confirmer.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		this.confirmer.setBackground(new Color(80,80,80));
		this.confirmer.setForeground(Color.WHITE);
		this.confirmer.setBorder(BorderFactory.createMatteBorder(2, 0,0 , 0, Color.WHITE));
		
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(2,2));
		pane.add(this.question);
		pane.add(this.check);
		pane.add(this.temps);
		pane.add(this.tmp);
		pane.setBackground(new Color(80,80,80));
		pane.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),(BorderFactory.createEmptyBorder(150,150,150,150))));
		
		this.setLayout(new BorderLayout());
		this.add(pane, BorderLayout.CENTER);
		this.add(this.confirmer, BorderLayout.SOUTH);
		
		
	}
	
	/**
	 * 
	 * @param boole the boolean to set.
	 */
	public void setAutoSave(boolean boole) {
		this.autoSave = boole;
	}
	
	/**
	 * 
	 * @return the autoSave boolean
	 */
	public boolean getAutoSave() {
		return this.autoSave;
	}
	
	/**
	 * 
	 * @return the confirm button
	 */
	public JButton getConfirmer() {
		return this.confirmer;
	}
	
	/**
	 * 
	 * @return the checkBox
	 */
	public JCheckBox getCheck() {
		return this.check;
	}
	
	/**
	 * This void set the loop
	 * @param i Int i
	 */
	public void setBoucle(int i) {
		if(i >= 1) {
			this.boucle = i;
		}
	}
	
	/**
	 * 
	 * @return return the loop
	 */
	public int getBoucle() {
		return this.boucle;
	}
	
	/**
	 * 
	 * @return the Tmp JTextField
	 */
	public JTextField getTmp() {
		return tmp;
	}

	/**
	 * 
	 * @param tmp the tmp to set.
	 */
	public void setTmp(JTextField tmp) {
		this.tmp = tmp;
	}
}
