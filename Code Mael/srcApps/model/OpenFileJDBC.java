/**
 * 
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import view.PanelQuery;

/**
 * This class allows you to open files by reading 
 * @author Mael and Damien
 *
 */
public class OpenFileJDBC {	
	
	private PanelQuery panelQuery;	
	
	private boolean open;
	
	/**
	 * The constructor of the class
	 * @param panelQuery the panelQuery
	 */
	public OpenFileJDBC(PanelQuery panelQuery){
		this.panelQuery = panelQuery;
		this.open = false;
	}
	
	/**
	 * This void read in file selected.
	 */
	public void readFile(){
		
		try{
			this.open = false;
			JFileChooser chooser = new JFileChooser();
			int reponse = chooser.showDialog(chooser, "Open");
			if (reponse == JFileChooser.APPROVE_OPTION) {
				File file = chooser.getSelectedFile();
				FileReader readFile = new FileReader(file);
				BufferedReader in = new BufferedReader(readFile);
				String s = in.readLine();
				while (s != null) {
					panelQuery.getQueryWrite().append(s);
					panelQuery.getQueryWrite().append("\n");
					s = in.readLine();					
				}
			}
			this.open = true;
		} catch (IOException e){
			JOptionPane option = new JOptionPane();
			option.showMessageDialog(null, "Error with the file", "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	
	/**
	 * This method return the open boolean
	 * @return open
	 */
	public boolean getOpen() {
		return this.open;
	}
}
	
	
	

