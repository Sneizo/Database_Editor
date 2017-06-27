/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import view.TitleBar;

/**
 * This class allows to control the title Bar
 * @author Mael and Damien
 *
 */
public class TitleBarControler implements ActionListener, MouseListener{

	private TitleBar titleB;
	
	/**
	 * The constructor of the TitleBarControler.
	 * @param titleB The titleBar controller.
	 */
	public TitleBarControler(TitleBar titleB){
		this.titleB = titleB;
	}
	
	/**
	 * Performs an action if the button pressed is the reference button.
	 */
	public void actionPerformed(ActionEvent arg0) {
		 
		if(arg0.getSource().equals(titleB.getExit())){
			System.exit(0);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	/**
	 * Performs the action when the cursor clicks the component.
	 */
	public void mouseEntered(MouseEvent arg0) {
		
		if(arg0.getSource().equals(titleB.getExit())){
			try {
				titleB.getExit().setIcon(new ImageIcon(ImageIO.read(new File("data/images/crossRed.png")).getScaledInstance(30,30,BufferedImage.TYPE_INT_ARGB)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Performs the action when the cursor leave the component.
	 */
	public void mouseExited(MouseEvent arg0) {
		if(arg0.getSource().equals(titleB.getExit())){
			try {
				titleB.getExit().setIcon(new ImageIcon(ImageIO.read(new File("data/images/close.png")).getScaledInstance(30,30,BufferedImage.TYPE_INT_ARGB)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	
	
}
