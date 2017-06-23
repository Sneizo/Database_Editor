package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.TimerTask;
import java.util.Timer;

import model.SaveFileJDBC;
import view.Connexion;
import view.MainPanel;
import view.Profil;
import view.SetAutoSave;

public class ControllerAutoSave implements ActionListener {

	private Connexion connexion;
	private Profil profil;
	private SetAutoSave setAutoSave;
	public SaveFileJDBC saveFileJDBC;
	private MainPanel mainPanel;
	private Timer timer = new Timer();

	public ControllerAutoSave(Connexion connexion, Profil profil, SaveFileJDBC saveFileJDBC, MainPanel mainPanel, SetAutoSave setAutoSave) {
		this.connexion = connexion;
		this.profil = profil;
		this.saveFileJDBC = saveFileJDBC;
		this.mainPanel = mainPanel;
		this.setAutoSave = setAutoSave;

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == this.mainPanel.getSaveAs() || ae.getSource() == this.mainPanel.getSave()) {
			if(this.setAutoSave.getAutoSave()) {
				timer.schedule(new RemindTask(), this.setAutoSave.getBoucle() * 60 * 1000, this.setAutoSave.getBoucle() * 60 * 1000);
			}
		}
	}
	
	 class RemindTask extends TimerTask {
		 

			public void run() {
		      saveFileJDBC.saveFile();
		    }
	 }

}
