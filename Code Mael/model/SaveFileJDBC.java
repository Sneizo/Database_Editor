package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

import view.PanelQuery;

public class SaveFileJDBC {

	private String pass;
	private PanelQuery pq;

	public SaveFileJDBC(PanelQuery pq) {
		this.pq = pq;
	}

	public void saveFileAs() {

		try {

			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new File("." + File.separator));
			int reponse = chooser.showDialog(chooser, "Enregistrer sous");
			if (reponse == JFileChooser.APPROVE_OPTION) {
				pass = chooser.getSelectedFile().toString();
				File param = new File(pass);
				FileWriter writer = new FileWriter(param, false);
				BufferedWriter buf = new BufferedWriter(writer);
				PrintWriter out = new PrintWriter(buf);
				out.println(pq.getQueryWrite().getText());
				out.close();
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
	
	public void saveFile(){
		
		try {			
			if(pass != null){
				File param = new File(pass);
				FileWriter writer = new FileWriter(param, false);
				BufferedWriter buf = new BufferedWriter(writer);
				PrintWriter out = new PrintWriter(buf);
				out.println(pq.getQueryWrite().getText());
				out.close();
			} else { saveFileAs() ; }

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	public String getPass() {
		return this.pass;
	}

}
