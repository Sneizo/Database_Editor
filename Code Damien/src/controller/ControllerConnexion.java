package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.ConnexionJDBC;
import model.CreateUserJDBC;
import model.TableJDBC;
import view.Connexion;
import view.InformationBar;
import view.Interface;
import view.MainPanel;
import view.PanelQuery;
import view.TitleBar;

public class ControllerConnexion implements FocusListener, ActionListener, MouseListener {

	private Connexion connexion;
	private Interface interf;
	private TitleBar titleBar;
	private MainPanel mainPanel;
	private PanelQuery panelQuery;
	private InformationBar ib;
	private ConnexionJDBC con;

	public ControllerConnexion(Connexion connexion, Interface interf, TitleBar titleBar, MainPanel mainPanel,
			PanelQuery panelQuery, InformationBar ib, ConnexionJDBC con) {

		this.connexion = connexion;
		this.interf = interf;
		this.titleBar = titleBar;
		this.mainPanel = mainPanel;
		this.panelQuery = panelQuery;
		this.ib = ib;
		this.con = con;

	}

	public void focusLost(FocusEvent fe) {
		if (fe.getSource() == this.connexion.getUserLog()) {
			if (this.connexion.getUserLog().getText().equals(""))
				this.connexion.setUserLog("Login");
		}

		if (fe.getSource() == this.connexion.getPassLog()) {
			if (this.connexion.getPassLog().getText().equals(""))
				this.connexion.setPassLog("Password");
		}

		if (fe.getSource() == this.connexion.getDataNameLog()) {
			if (this.connexion.getDataNameLog().getText().equals(""))
				this.connexion.setDataNameLog("URL of the data base");
		}

		if (fe.getSource() == this.connexion.getUserSub()) {
			if (this.connexion.getUserSub().getText().equals(""))
				this.connexion.setUserSub("Name of the new user");
		}

		if (fe.getSource() == this.connexion.getPassSub()) {
			if (this.connexion.getPassSub().getText().equals(""))
				this.connexion.setPassSub("Password");
		}

		if (fe.getSource() == this.connexion.getConfirmPassSub()) {
			if (this.connexion.getConfirmPassSub().getText().equals(""))
				this.connexion.setConfirmPassSub("Password");
		}

		if (fe.getSource() == this.connexion.getDataNameSub()) {
			if (this.connexion.getDataNameSub().getText().equals(""))
				this.connexion.setDataNameSub("URL of the data base");
		}

	}

	public void focusGained(FocusEvent fe) {
		if (fe.getSource() == this.connexion.getUserLog()) {
			if (this.connexion.getUserLog().getText().equals("Login"))
				this.connexion.setUserLog("");
		}

		if (fe.getSource() == this.connexion.getPassLog()) {
			if (this.connexion.getPassLog().getText().equals("Password"))
				this.connexion.setPassLog("");
		}

		if (fe.getSource() == this.connexion.getDataNameLog()) {
			if (this.connexion.getDataNameLog().getText().equals("URL of the data base"))
				this.connexion.setDataNameLog("");
		}

		if (fe.getSource() == this.connexion.getUserSub()) {
			if (this.connexion.getUserSub().getText().equals("Name of the new user"))
				this.connexion.setUserSub("");
		}

		if (fe.getSource() == this.connexion.getPassSub()) {
			if (this.connexion.getPassSub().getText().equals("Password"))
				this.connexion.setPassSub("");
		}

		if (fe.getSource() == this.connexion.getConfirmPassSub()) {
			if (this.connexion.getConfirmPassSub().getText().equals("Password"))
				this.connexion.setConfirmPassSub("");
		}

		if (fe.getSource() == this.connexion.getDataNameSub()) {
			if (this.connexion.getDataNameSub().getText().equals("URL of the data base"))
				this.connexion.setDataNameSub("");
		}
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == this.connexion.getConnect()) {

			if (!this.connexion.getUserLog().getText().equals("Login")
					&& !this.connexion.getUserLog().getText().equals("")) {
				if (!this.connexion.getPassLog().getText().equals("Password")
						&& !this.connexion.getPassLog().getText().equals("")) {
					if (!this.connexion.getDataNameLog().getText().equals("URL of the data base")
							&& !this.connexion.getDataNameLog().getText().equals("")) {
						
						con.connexion(this.connexion.getUserLog().getText(),this.connexion.getPassLog().getText(),this.connexion.getDataNameLog().getText());

						if (con.getConnect()) {

							JPanel pane = new JPanel();
							JPanel main = new JPanel();
							ib.getUser().setText(connexion.getUserLog().getText());
							pane.setLayout(new BorderLayout());
							main.setLayout(new BorderLayout());
							pane.add(titleBar, BorderLayout.NORTH);
							pane.add(mainPanel, BorderLayout.CENTER);
							main.add(pane, BorderLayout.NORTH);
							main.add(panelQuery, BorderLayout.CENTER);
							main.add(ib, BorderLayout.SOUTH);

							this.interf.setPanel(main);
							
							TableJDBC table = new TableJDBC(con);
							if(table.getVector() != null){
								Vector<String> vec = table.getVector();
								this.panelQuery.setVector(vec);
								this.interf.repaint();
								this.interf.revalidate();
							}
						}
					} else {
						connexion.getAttente().setText("Incorrect Data Base");
					}
				} else {
					connexion.getAttente().setText("Incorrect Password");
				}
			} else {
				connexion.getAttente().setText("Incorrect login");
			}

		}

		if (ae.getSource() == this.connexion.getSubscribe()) {
			CreateUserJDBC create = new CreateUserJDBC(this.connexion.getUserSub().getText(),
					this.connexion.getPassSub().getText(), this.connexion.getConfirmPassSub().getText(),
					this.connexion.getDataNameSub().getText());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource().equals(connexion.getConnect())){
			connexion.getConnect().setBorder(BorderFactory.createLineBorder(Color.WHITE));
			connexion.getConnect().setBackground(new Color(120,120,120));
			connexion.getConnect().setForeground(Color.WHITE);
		
		}
		
		if(e.getSource().equals(connexion.getSubscribe())){
			connexion.getSubscribe().setBorder(BorderFactory.createLineBorder(Color.WHITE));
			connexion.getSubscribe().setBackground(new Color(120,120,120));
			connexion.getSubscribe().setForeground(Color.WHITE);			
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource().equals(connexion.getConnect())){
			connexion.getConnect().setBorder(BorderFactory.createLineBorder(Color.WHITE));
			connexion.getConnect().setBackground(new Color(80,80,80));
			connexion.getConnect().setForeground(Color.WHITE);
		
		}
		
		if(e.getSource().equals(connexion.getSubscribe())){
			connexion.getSubscribe().setBorder(BorderFactory.createLineBorder(Color.WHITE));
			connexion.getSubscribe().setBackground(new Color(80,80,80));
			connexion.getSubscribe().setForeground(Color.WHITE);			
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
