package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import view.PanelQuery;

/**
 * This class write in a file to save the query sql.
 * @author Mael and Damien
 *
 */
public class SaveFileJDBC {

	private String pass;
	private PanelQuery pq;

	/**
	 * The constructor of the SaveFileJDBC class.
	 * @param pq the panelQuery
	 */
	public SaveFileJDBC(PanelQuery pq) {
		this.pq = pq;
	}

	/**
	 * This void write in a file to save the sql query.
	 */
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
			JOptionPane option = new JOptionPane();
			option.showMessageDialog(null, "Error with saving file as", "ERREUR", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	/**
	 * This void write in a file to save the sql query.
	 */
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
			JOptionPane option = new JOptionPane();
			option.showMessageDialog(null, "Error with saving file", "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	/**
	 * 
	 * @return this pass.
	 */
	public String getPass() {
		return this.pass;
	}

}
