package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;
import controller.MainController;

public class Launcher extends JFrame{
	
	private Connexion connexion;
	private Rename rename;
	private Create create;
	private PanelQuery panelQuery;
	
	private MainController mainController;
	
	public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                    new Launcher().setVisible(true);
            }
        });
    }
	
	
	public Launcher() {
		
		connexion = new Connexion();
		rename = new Rename();
		create = new Create();
		panelQuery = new PanelQuery();
		
		mainController = new MainController(connexion,create,rename);
		
		
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		System.out.println(height);
		int width  = (int)dimension.getWidth();
		System.out.println(width);
		
		this.setSize(1080 / width * 1080, 720 / height * 720);
//		Recupere la taille de l'ecran et fait en fonction
//		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
//		int height = (int)dimension.getHeight();
//		int width  = (int)dimension.getWidth();
		this.setLayout(new BorderLayout());
		this.add(panelQuery,BorderLayout.CENTER);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
}

