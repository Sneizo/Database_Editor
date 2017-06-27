package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;


/**
 * This class allows you to connect to a database from a java application
 * @author Mael and Damien
 *
 */
public class Connexion extends JPanel {

	private JPanel conPane;
	private JPanel subPane;

	private JTextField userLog;
	private JPasswordField passLog;
	private JTextField dataNameLog;
	private JButton connect;

	private JTextField userSub;
	private JPasswordField passSub;
	private JPasswordField confirmPassSub;
	private JTextField dataNameSub;
	private JButton subscribe;

	private ImageIcon image;
	private JLabel user1;
	private JLabel user2;
	private JLabel attente;

	
	/**
	 * The constructor of the connexion class.
	 */
	public Connexion() {
		try {
		this.initConponent();
		this.initClass();
		setBackground(new Color(80, 80, 80));
		}catch (IOException io) {
			System.out.print("ERREUR : Connexion.Conneion();");
		}

	}

	/**
	 * Creating different panels.
	 */
	private void initClass() {
		setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),(BorderFactory.createEmptyBorder(16,16,16,16))));
		this.setLayout(new BorderLayout());
		this.add(conPane, BorderLayout.WEST);
		this.add(subPane, BorderLayout.EAST);

		this.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),(BorderFactory.createEmptyBorder(50,200,50,200))));
	}

	/**
	 * Initializes the graphical components of the class.
	 * @throws IOException
	 */
	private void initConponent() throws IOException {

		// premier panneau
		this.image = new ImageIcon("data/images/user.png");
		
		this.user1 = new JLabel(image);
		this.user1.setIcon(new ImageIcon("data/images/user.png"));
			Font font = new Font("Arimo", Font.ITALIC, 12);

		this.conPane = new JPanel();
		this.conPane.setLayout(new GridLayout(6, 1));
		this.conPane.setBackground(new Color(80, 80, 80));
		this.conPane.setLayout(new GridLayout(6, 1, 0, 65));
		this.conPane.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.WHITE),(BorderFactory.createEmptyBorder(0,0,0,200))));
		
		this.userLog = new JTextField();
		this.userLog.setFont(font);
		this.userLog.setText("Login");
		this.userLog.setBackground(new Color(80,80,80));
		this.userLog.setForeground(Color.WHITE);
		//this.userLog.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.userLog.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		this.userLog.setHorizontalAlignment(JTextField.CENTER);
		this.userLog.setCaretColor(Color.WHITE);
		
		
		
		this.passLog = new JPasswordField();
		this.passLog.setFont(font);
		this.passLog.setText("Password");
		this.passLog.setBackground(new Color(80,80,80));
		this.passLog.setForeground(Color.WHITE);
		this.passLog.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		this.passLog.setHorizontalAlignment(JTextField.CENTER);
		this.passLog.setCaretColor(Color.WHITE);
		
		this.dataNameLog = new JTextField();
		this.dataNameLog.setFont(font);
		this.dataNameLog.setText("URL of the data base");
		this.dataNameLog.setBackground(new Color(80,80,80));
		this.dataNameLog.setForeground(Color.WHITE);
		this.dataNameLog.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		this.dataNameLog.setHorizontalAlignment(JTextField.CENTER);
		this.dataNameLog.setCaretColor(Color.WHITE);
		
		this.attente = new JLabel();
		this.attente.setForeground(Color.red);
		
		this.connect = new JButton();
		this.connect.setText("CONNECT");
		this.connect.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		this.connect.setBackground(new Color(80,80,80));
		this.connect.setForeground(Color.WHITE);

		this.conPane.add(this.user1);
		this.conPane.add(this.userLog);
		this.conPane.add(this.passLog);
		this.conPane.add(this.dataNameLog);
		this.conPane.add(this.attente);
		this.conPane.add(this.connect);
		
		// second panneau
		this.user2 = new JLabel(image);
		this.user2.setIcon(new ImageIcon("data/images/user.png"));

		this.subPane = new JPanel();
		this.subPane.setBackground(new Color(80, 80, 80));
		this.subPane.setLayout(new GridLayout(6, 1, 0, 65));
		this.userSub = new JTextField();
		this.userSub.setFont(font);
		this.userSub.setText("Name of the new user");
		this.userSub.setBackground(new Color(80,80,80));
		this.userSub.setForeground(Color.WHITE);
		this.userSub.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		this.userSub.setHorizontalAlignment(JTextField.CENTER);
		this.userSub.setCaretColor(Color.WHITE);
		
		//this.userSub.setBorder(null);
		
		this.passSub = new JPasswordField();
		this.passSub.setFont(font);
		this.passSub.setText("Password");
		this.passSub.setBackground(new Color(80,80,80));
		this.passSub.setForeground(Color.WHITE);
		this.passSub.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		this.passSub.setHorizontalAlignment(JTextField.CENTER);
		this.passSub.setCaretColor(Color.WHITE);
		
		this.confirmPassSub = new JPasswordField("");
		this.confirmPassSub.setFont(font);
		this.confirmPassSub.setText("Password");
		this.confirmPassSub.setBackground(new Color(80,80,80));
		this.confirmPassSub.setForeground(Color.WHITE);
		this.confirmPassSub.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		this.confirmPassSub.setHorizontalAlignment(JTextField.CENTER);
		this.confirmPassSub.setCaretColor(Color.WHITE);
		
		this.dataNameSub = new JTextField();
		this.dataNameSub.setFont(font);
		this.dataNameSub.setText("URL of the data base");
		this.dataNameSub.setBackground(new Color(80,80,80));
		this.dataNameSub.setForeground(Color.WHITE);
		this.dataNameSub.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		this.dataNameSub.setHorizontalAlignment(JTextField.CENTER);
		this.dataNameSub.setCaretColor(Color.WHITE);
		
		this.subscribe = new JButton();
		this.subscribe.setText("SUBSCRIBE");
		this.subscribe.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		this.subscribe.setBackground(new Color(80,80,80));
		this.subscribe.setForeground(Color.WHITE);
	

		this.subPane.add(this.user2);
		this.subPane.add(this.userSub);
		this.subPane.add(this.passSub);
		this.subPane.add(this.confirmPassSub);
		this.subPane.add(this.dataNameSub);
		this.subPane.add(this.subscribe);
	}

	/**
	 * Return the user log
	 * @return userLog
	 */
	public JTextField getUserLog() {
		return userLog;
	}

	/**
	 * Return passLog
	 * @return The JTextField passLog.
	 */
	public JTextField getPassLog() {
		return passLog;
	}

	/**
	 * @return the dataNameLog
	 */
	public JTextField getDataNameLog() {
		return dataNameLog;
	}

	/**
	 * @return the button connect
	 */
	public JButton getConnect() {
		return connect;
	}

	/**
	 * @return the getUserSub
	 */
	public JTextField getUserSub() {
		return userSub;
	}

	/**
	 * @return the passSub
	 */
	public JTextField getPassSub() {
		return passSub;
	}

	/**
	 * 
	 * @return the confirmPassSub
	 */
	public JTextField getConfirmPassSub() {
		return confirmPassSub;
	}
 
	/**
	 * 
	 * @return the dataNameSub
	 */
	public JTextField getDataNameSub() {
		return dataNameSub;
	}

	/**
	 * 
	 * @return the suscribe button
	 */
	public JButton getSubscribe() {
		return subscribe;
	}

	/**
	 * 
	 * @return the Label attente
	 */
	public JLabel getAttente() {
		return attente;
	}
	
	/**
	 * 
	 * @param userLog the userLog to set
	 */
	public void setUserLog(String userLog) {
		this.userLog.setText(userLog);
	}

	/**
	 * 
	 * @param passLog the passLog to set
	 */
	public void setPassLog(String passLog) {
		this.passLog.setText(passLog);
	}

	/**
	 * 
	 * @param dataNameLog the dataNameLog to set
	 */
	public void setDataNameLog(String dataNameLog) {
		this.dataNameLog.setText(dataNameLog);
	}

	/**
	 * 
	 * @param userSub the userSub to set
	 */
	public void setUserSub(String userSub) {
		this.userSub.setText(userSub);
	}

	/**
	 * 
	 * @param passSub the passSub to set
	 */
	public void setPassSub(String passSub) {
		this.passSub.setText(passSub);
	}

	/**
	 * 
	 * @param confirmPassSub the confirm pass to set
	 */
	public void setConfirmPassSub(String confirmPassSub) {
		this.confirmPassSub.setText(confirmPassSub);
	}

	/**
	 * 
	 * @param dataNameSub the dataNameSub to set
	 */
	public void setDataNameSub(String dataNameSub) {
		this.dataNameSub.setText(dataNameSub);
	}

}
