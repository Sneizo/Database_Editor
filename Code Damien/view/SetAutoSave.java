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

public class SetAutoSave extends JPanel {

	private boolean autoSave;
	private int boucle;
	private JCheckBox check;
	private JTextField tmp;

	private JLabel temps;
	private JLabel question;
	private JButton confirmer;
	
	public SetAutoSave() {
		autoSave = true;
		this.boucle = 10;
		initSetAutoSave();
		
	}
	
	
	private void initSetAutoSave() {
		
		setBackground(new Color(80,80,80));
		
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
	
	public void setAutoSave(boolean boole) {
		this.autoSave = boole;
	}
	
	public boolean getAutoSave() {
		return this.autoSave;
	}
	
	public JButton getConfirmer() {
		return this.confirmer;
	}
	
	public JCheckBox getCheck() {
		return this.check;
	}
	
	public void setBoucle(int i) {
		if(i >= 1) {
			this.boucle = i;
		}
	}
	
	public int getBoucle() {
		return this.boucle;
	}
	
	public JTextField getTmp() {
		return tmp;
	}


	public void setTmp(JTextField tmp) {
		this.tmp = tmp;
	}
}
