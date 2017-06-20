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

import controler.MouseListenerJFrame;
import controler.MouseMotionListenner;

/**
 * @author Damien
 *
 */
public class Interface extends JFrame {
	
	private int posX = 0;   //Position X de la souris au clic
    private int posY = 0;   //Position Y de la souris au clic
	
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
		setBackground(new Color(80, 80, 80));
		
		BorderLayout border = new BorderLayout();
		setLayout(border);
		add(new TitleBar(), BorderLayout.NORTH);
		//add(new MainPanel(this), BorderLayout.NORTH);
		add(new PanelQuery(), BorderLayout.CENTER);
		//add(new InformationBar(), BorderLayout.SOUTH);
		
		
	
		
		
	}
		
	/**
	 * @param posX the posX to set
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * @param posY the posY to set
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * @return the posX
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * @return the posY
	 */
	public int getPosY() {
		return posY;
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
