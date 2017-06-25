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
 * @author Damien
 *
 */
public class OpenFileJDBC {

	
	private PanelQuery panelQuery;
	
	
	public OpenFileJDBC(PanelQuery panelQuery){
		this.panelQuery = panelQuery;
	}
	
	public void readFile(){
		
		try{
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new File("C:/Users/Damien/workspace/Database_Editor_Graphical"));
			int reponse = chooser.showDialog(chooser, "Open");
			if (reponse == JFileChooser.APPROVE_OPTION) {
				File file = chooser.getSelectedFile();
				FileReader readFile = new FileReader(file);
				BufferedReader in = new BufferedReader(readFile);
				String s = in.readLine();
				while (s != null) {
					panelQuery.getQueryWrite().setText(s);
					s = in.readLine();					
				}
			}
		} catch (IOException e){
			JOptionPane option = new JOptionPane();
			option.showMessageDialog(null, "Error with the file", "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
}
	
	

