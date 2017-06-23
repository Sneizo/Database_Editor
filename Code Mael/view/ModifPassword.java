package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class ModifPassword extends JPanel {
	
	private JLabel changement;
	private JLabel oldPassword;
	private JLabel newPassword;
	private JLabel confirmNewPassword;
	
	private JPasswordField oldPasswordF;
	private JPasswordField newPasswordF; 
	private JPasswordField confirmNewPasswordF;
	
	private JButton confirmer;
	private JButton annuler;
	
	
	public ModifPassword() {
		initModifPassword();
	}
	
	private void initModifPassword() {
		
		Font fontTitle = new Font("arimo", Font.BOLD, 26);
		this.changement = new JLabel("Changing your password");
		this.changement.setFont(fontTitle);
		
		Font font = new Font("arimo", Font.PLAIN, 15);
		this.oldPassword = new JLabel("Old Password :");
		this.oldPassword.setFont(font);
		
		this.newPassword = new JLabel("New Password :");
		this.newPassword.setFont(font);
		
		this.confirmNewPassword = new JLabel("Confirm New Password");
		this.confirmNewPassword.setFont(font);
		
		this.oldPasswordF = new JPasswordField();
		this.newPasswordF = new JPasswordField();
		this.confirmNewPasswordF = new JPasswordField();
		
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(3,2));
		pane.add(this.oldPassword);
		pane.add(this.oldPasswordF);
		pane.add(this.newPassword);
		pane.add(this.newPasswordF);
		pane.add(this.confirmNewPassword);
		pane.add(this.confirmNewPasswordF);
		
		JPanel bot = new JPanel();
		
		this.confirmer = new JButton("Confirm");
		this.confirmer.setFont(font);
		this.annuler = new JButton("Cancel");
		this.annuler.setFont(font);
		
		bot.setLayout(new BorderLayout());
		bot.add(this.confirmer, BorderLayout.EAST);
		bot.add(this.annuler, BorderLayout.WEST);
		
		this.setLayout(new BorderLayout());
		this.add(this.changement, BorderLayout.NORTH);
		this.add(pane, BorderLayout.CENTER);
		this.add(bot, BorderLayout.SOUTH);
	}

}
