package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
		this.initConponent();
		this.initClass();

	}

	private void initClass() {
		setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),(BorderFactory.createEmptyBorder(16,16,16,16))));
		this.setLayout(new BorderLayout());
		this.add(conPane, BorderLayout.WEST);
		this.add(subPane, BorderLayout.EAST);

		this.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),(BorderFactory.createEmptyBorder(50,200,50,200))));
	}

	private void initConponent() {

		// premier panneau
		this.image = new ImageIcon("data/images/user.png");
		
		this.user1 = new JLabel(image);
		try {
			this.user1.setIcon(new ImageIcon(ImageIO.read(new File("data/images/user.png")).getScaledInstance(38,38,BufferedImage.TYPE_INT_ARGB)));
		}catch (IOException io) {
			io.printStackTrace();
		}
			Font font = new Font("Arimo", Font.ITALIC, 12);

		this.conPane = new JPanel();
		this.conPane.setLayout(new GridLayout(6, 1));

		this.conPane.setLayout(new GridLayout(6, 1, 0, 65));
		this.conPane.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY),(BorderFactory.createEmptyBorder(0,0,0,200))));
		
		this.userLog = new JTextField();
		this.userLog.setFont(font);
		this.userLog.setText("Login");
		this.passLog = new JPasswordField();
		this.passLog.setFont(font);
		this.passLog.setText("Password");
		this.dataNameLog = new JTextField();
		this.dataNameLog.setFont(font);
		this.dataNameLog.setText("Name of the data base");
		this.attente = new JLabel();
		this.attente.setText("");
		this.connect = new JButton();
		this.connect.setText("CONNECT");

		this.conPane.add(this.user1);
		this.conPane.add(this.userLog);
		this.conPane.add(this.passLog);
		this.conPane.add(this.dataNameLog);
		this.conPane.add(this.attente);
		this.conPane.add(this.connect);

		//this.conPane.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY),(BorderFactory.createEmptyBorder(16,16,16,200))));
		
		// second panneau
		this.user2 = new JLabel(image);
		try {
			this.user2.setIcon(new ImageIcon(ImageIO.read(new File("data/images/user.png")).getScaledInstance(38,38,BufferedImage.TYPE_INT_ARGB)));
		}catch (IOException io) {
			io.printStackTrace();
		}

		this.subPane = new JPanel();
		this.subPane.setLayout(new GridLayout(6, 1, 0, 65));

		this.userSub = new JTextField();
		this.userSub.setFont(font);
		this.userSub.setText("Name of the new user");
		this.passSub = new JPasswordField();
		this.passSub.setFont(font);
		this.passSub.setText("Password");
		this.confirmPassSub = new JPasswordField("");
		this.confirmPassSub.setFont(font);
		this.confirmPassSub.setText("Password");
		this.dataNameLogSub = new JTextField();
		this.dataNameLogSub.setFont(font);
		this.dataNameLogSub.setText("Name of the data base");
		this.subscribe = new JButton();
		this.subscribe.setText("SUBSCRIBE");

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

}
