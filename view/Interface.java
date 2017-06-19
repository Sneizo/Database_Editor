/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Damien
 *
 */
public class Interface extends JFrame {
	
	
	
	public Interface() throws IOException{
	
		initComponent();
		
	}
	
	private void initComponent() throws IOException{
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(1080,720);
		setLocationRelativeTo(null);
		setResizable(false);
		setBackground(Color.WHITE);
		
		BorderLayout border = new BorderLayout();
		setLayout(border);
		//add(new TitleBar(), BorderLayout.NORTH);
		add(new MainPanel(this), BorderLayout.NORTH);
		add(new PanelQuery(), BorderLayout.CENTER);
		
		
		
	}
	
	
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Interface().setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	

}
