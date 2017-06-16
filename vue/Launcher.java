package vue;

import java.awt.BorderLayout;

import javax.swing.*;

public class Launcher extends JFrame{
	
	public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                    new Launcher().setVisible(true);
            }
        });
    }
	
	
	public Launcher() {
		Connexion con = new Connexion();
		Rename rename = new Rename();
		Create create = new Create();
		this.setSize(1080, 720);
		this.setLayout(new BorderLayout());
		this.add(create,BorderLayout.CENTER);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
}

