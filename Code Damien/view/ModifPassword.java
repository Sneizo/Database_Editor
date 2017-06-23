package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;

public class ModifPassword extends JPanel {
	
	private JLabel changement;
	private JLabel oldPassword;
	private JLabel newPassword;
	private JLabel confirmNewPassword;
	
	private JTextField oldPasswordF;
	private JTextField newPasswordF; 
	private JTextField confirmNewPasswordF;
	
	private JButton confirmer;
	private JButton annuler;
	
	
	public ModifPassword() {
		initModifPassword();
	}
	
	private void initModifPassword() {
		
		Font fontTitle = new Font("arimo", Font.BOLD, 26);
		this.changement = new JLabel("Changing your password");
		this.changement.setFont(fontTitle);
		this.changement.setForeground(Color.WHITE);
		
		Font font = new Font("arimo", Font.PLAIN, 15);
		this.oldPassword = new JLabel("Old Password :");
		this.oldPassword.setFont(font);
		this.oldPassword.setForeground(Color.WHITE);
		
		
		this.newPassword = new JLabel("New Password :");
		this.newPassword.setFont(font);
		this.newPassword.setForeground(Color.WHITE);
		
		this.confirmNewPassword = new JLabel("Confirm New Password");
		this.confirmNewPassword.setFont(font);
		this.confirmNewPassword.setForeground(Color.WHITE);
		
		this.oldPasswordF = new JTextField();
		this.oldPasswordF.setBackground(new Color(80,80,80));
		this.oldPasswordF.setForeground(Color.WHITE);
		this.oldPasswordF.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		this.oldPasswordF.setHorizontalAlignment(JTextField.CENTER);
		this.oldPasswordF.setCaretColor(Color.WHITE);
		
		this.newPasswordF = new JTextField();
		this.newPasswordF.setBackground(new Color(80,80,80));
		this.newPasswordF.setForeground(Color.WHITE);
		this.newPasswordF.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		this.newPasswordF.setHorizontalAlignment(JTextField.CENTER);
		this.newPasswordF.setCaretColor(Color.WHITE);
		
		this.confirmNewPasswordF = new JTextField();
		this.confirmNewPasswordF.setBackground(new Color(80,80,80));
		this.confirmNewPasswordF.setForeground(Color.WHITE);
		this.confirmNewPasswordF.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		this.confirmNewPasswordF.setHorizontalAlignment(JTextField.CENTER);
		this.confirmNewPasswordF.setCaretColor(Color.WHITE);
		
		JPanel pane = new JPanel();
		pane.setBackground(new Color(80,80,80));
		GridLayout gr = new GridLayout(3,2);
		pane.setLayout(gr);
		pane.add(this.oldPassword);
		pane.add(this.oldPasswordF);
		pane.add(this.newPassword);
		pane.add(this.newPasswordF);
		pane.add(this.confirmNewPassword);
		pane.add(this.confirmNewPasswordF);
		pane.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),(BorderFactory.createEmptyBorder(30,30,30,30))));
		
		
		JPanel bot = new JPanel();
		bot.setBackground(new Color(80,80,80));
		this.confirmer = new JButton("Confirm");
		this.confirmer.setFont(font);
		this.confirmer.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		this.confirmer.setBackground(new Color(80,80,80));
		this.confirmer.setForeground(Color.WHITE);
		
		this.annuler = new JButton("Cancel");
		this.annuler.setFont(font);
		this.annuler.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		this.annuler.setBackground(new Color(80,80,80));
		this.annuler.setForeground(Color.WHITE);
		
		bot.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),(BorderFactory.createEmptyBorder(30,30,30,30))));
		
		bot.setLayout(new BorderLayout());
		bot.add(this.confirmer, BorderLayout.EAST);
		bot.add(this.annuler, BorderLayout.WEST);
		
		this.setLayout(new BorderLayout());
		this.add(this.changement, BorderLayout.NORTH);
		this.add(pane, BorderLayout.CENTER);
		this.add(bot, BorderLayout.SOUTH);
		
		setBackground(new Color(80,80,80));
	}

	/**
	 * @return the changement
	 */
	public JLabel getChangement() {
		return changement;
	}

	/**
	 * @param changement the changement to set
	 */
	public void setChangement(JLabel changement) {
		this.changement = changement;
	}

	/**
	 * @return the oldPassword
	 */
	public JLabel getOldPassword() {
		return oldPassword;
	}

	/**
	 * @param oldPassword the oldPassword to set
	 */
	public void setOldPassword(JLabel oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * @return the newPassword
	 */
	public JLabel getNewPassword() {
		return newPassword;
	}

	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(JLabel newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * @return the confirmNewPassword
	 */
	public JLabel getConfirmNewPassword() {
		return confirmNewPassword;
	}

	/**
	 * @param confirmNewPassword the confirmNewPassword to set
	 */
	public void setConfirmNewPassword(JLabel confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}

	/**
	 * @return the oldPasswordF
	 */
	public JTextField getOldPasswordF() {
		return oldPasswordF;
	}

	/**
	 * @param oldPasswordF the oldPasswordF to set
	 */
	public void setOldPasswordF(JPasswordField oldPasswordF) {
		this.oldPasswordF = oldPasswordF;
	}

	/**
	 * @return the newPasswordF
	 */
	public JTextField getNewPasswordF() {
		return newPasswordF;
	}

	/**
	 * @param newPasswordF the newPasswordF to set
	 */
	public void setNewPasswordF(JPasswordField newPasswordF) {
		this.newPasswordF = newPasswordF;
	}

	/**
	 * @return the confirmNewPasswordF
	 */
	public JTextField getConfirmNewPasswordF() {
		return confirmNewPasswordF;
	}

	/**
	 * @param confirmNewPasswordF the confirmNewPasswordF to set
	 */
	public void setConfirmNewPasswordF(JPasswordField confirmNewPasswordF) {
		this.confirmNewPasswordF = confirmNewPasswordF;
	}

	/**
	 * @return the confirmer
	 */
	public JButton getConfirmer() {
		return confirmer;
	}

	/**
	 * @param confirmer the confirmer to set
	 */
	public void setConfirmer(JButton confirmer) {
		this.confirmer = confirmer;
	}

	/**
	 * @return the annuler
	 */
	public JButton getAnnuler() {
		return annuler;
	}

	/**
	 * @param annuler the annuler to set
	 */
	public void setAnnuler(JButton annuler) {
		this.annuler = annuler;
	}
	
	
	

}
