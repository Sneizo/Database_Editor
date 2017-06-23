package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		initSetAutoSave();
	}
	
	
	private void initSetAutoSave() {
		
		Font font = new Font("arimo", Font.PLAIN, 18);
		this.check = new JCheckBox();
		this.tmp = new JTextField();
		this.tmp.setFont(font);
		this.tmp.setText("10");
		this.temps = new JLabel("The time between each autoSave :");
		this.temps.setFont(font);
		this.question = new JLabel("Do you want autoSave ? ");
		this.question.setFont(font);
		this.confirmer = new JButton("Confirm");
		this.confirmer.setFont(font);
		
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(2,2));
		pane.add(this.question);
		pane.add(this.check);
		pane.add(this.temps);
		pane.add(this.tmp);
		
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
