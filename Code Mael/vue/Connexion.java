package vue;

import java.awt.BorderLayout;
import java.awt.Button;
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
	private JTextField dataNameLogSub;
	private JButton subscribe;

	private ImageIcon image;
	private JLabel user1;
	private JLabel user2;
	private JLabel attente;

	public Connexion() {
		try {
		this.initConponent();
		this.initClass();
		setBackground(new Color(80, 80, 80));
		}catch (IOException io) {
			System.out.print("ERREUR : Connexion.Conneion();");
		}

	}

	private void initClass() {
		setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),(BorderFactory.createEmptyBorder(16,16,16,16))));
		this.setLayout(new BorderLayout());
		this.add(conPane, BorderLayout.WEST);
		this.add(subPane, BorderLayout.EAST);

		this.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),(BorderFactory.createEmptyBorder(50,200,50,200))));
	}

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
		
		
		
		this.passLog = new JPasswordField();
		this.passLog.setFont(font);
		this.passLog.setText("Password");
		this.passLog.setBackground(new Color(80,80,80));
		this.passLog.setForeground(Color.WHITE);
		this.passLog.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		this.passLog.setHorizontalAlignment(JTextField.CENTER);
		
		this.dataNameLog = new JTextField();
		this.dataNameLog.setFont(font);
		this.dataNameLog.setText("Name of the data base");
		this.dataNameLog.setBackground(new Color(80,80,80));
		this.dataNameLog.setForeground(Color.WHITE);
		this.dataNameLog.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		this.dataNameLog.setHorizontalAlignment(JTextField.CENTER);
		
		
		

		
		
		this.attente = new JLabel();
	//	this.attente.setIcon(new ImageIcon(ImageIO.read(new File("data/images/wait.gif")).getScaledInstance(20,20,BufferedImage.TYPE_INT_ARGB)));
		//this.attente.setText("");
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

		//this.conPane.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),(BorderFactory.createEmptyBorder(16,16,16,200))));
		
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
		
		//this.userSub.setBorder(null);
		
		this.passSub = new JPasswordField();
		this.passSub.setFont(font);
		this.passSub.setText("Password");
		this.passSub.setBackground(new Color(80,80,80));
		this.passSub.setForeground(Color.WHITE);
		this.passSub.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		this.passSub.setHorizontalAlignment(JTextField.CENTER);
		
		this.confirmPassSub = new JPasswordField("");
		this.confirmPassSub.setFont(font);
		this.confirmPassSub.setText("Password");
		this.confirmPassSub.setBackground(new Color(80,80,80));
		this.confirmPassSub.setForeground(Color.WHITE);
		this.confirmPassSub.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		this.confirmPassSub.setHorizontalAlignment(JTextField.CENTER);
		
		this.dataNameLogSub = new JTextField();
		this.dataNameLogSub.setFont(font);
		this.dataNameLogSub.setText("Name of the data base");
		this.dataNameLogSub.setBackground(new Color(80,80,80));
		this.dataNameLogSub.setForeground(Color.WHITE);
		this.dataNameLogSub.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		this.dataNameLogSub.setHorizontalAlignment(JTextField.CENTER);
		
		this.subscribe = new JButton();
		this.subscribe.setText("SUBSCRIBE");
		this.subscribe.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		this.subscribe.setBackground(new Color(80,80,80));
		this.subscribe.setForeground(Color.WHITE);

		this.subPane.add(this.user2);
		this.subPane.add(this.userSub);
		this.subPane.add(this.passSub);
		this.subPane.add(this.confirmPassSub);
		this.subPane.add(this.dataNameLogSub);
		this.subPane.add(this.subscribe);
	}


	public JTextField getUserLog() {
		return userLog;
	}

	public JTextField getPassLog() {
		return passLog;
	}

	public JTextField getDataNameLog() {
		return dataNameLog;
	}

	public JButton getConnect() {
		return connect;
	}

	public JTextField getUserSub() {
		return userSub;
	}

	public JTextField getPassSub() {
		return passSub;
	}

	public JTextField getConfirmPassSub() {
		return confirmPassSub;
	}

	public JTextField getDataNameLogSub() {
		return dataNameLogSub;
	}

	public JButton getSubscribe() {
		return subscribe;
	}

	public JLabel getAttente() {
		return attente;
	}
	
	public void setUserLog(String userLog) {
		this.userLog.setText(userLog);
	}

	public void setPassLog(String passLog) {
		this.passLog.setText(passLog);
	}

	public void setDataNameLog(String dataNameLog) {
		this.dataNameLog.setText(dataNameLog);
	}

	public void setUserSub(String userSub) {
		this.userSub.setText(userSub);
	}

	public void setPassSub(String passSub) {
		this.passSub.setText(passSub);
	}

	public void setConfirmPassSub(String confirmPassSub) {
		this.confirmPassSub.setText(confirmPassSub);
	}

	public void setDataNameLogSub(String dataNameLogSub) {
		this.dataNameLogSub.setText(dataNameLogSub);
	}

}
