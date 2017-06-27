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
import view.Interface;
import view.TitleBar;

/**
 * This class allows to control the highest bar of the software, notably by adding the action to frame the window or even that to unlace it.
 * @author Mael and Damien
 *
 */
public class ControllerTitleBar implements ActionListener, MouseListener {

	private TitleBar titleBar;
	private Interface interf;

	/**
	 * The constructor of the ControllerTitleBar class.
	 * @param titleBar The titleBar class.
	 * @param interf The main frame.
	 */
	public ControllerTitleBar(TitleBar titleBar, Interface interf) {
		this.titleBar = titleBar;
		this.interf = interf;
	}

	/**
	 * Performs an action if the button pressed is the reference button.
	 */
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == titleBar.getExit()) {
			System.exit(0);
			try {
				titleBar.getExit().setIcon(new ImageIcon(ImageIO.read(new File("data/images/close2.png")).getScaledInstance(30,30,BufferedImage.TYPE_INT_ARGB)));
			}catch (IOException io) {
				System.out.println("ERREUR : ControllerTitleBar.actionPerformed");
			}
		}

		if (ae.getSource() == titleBar.getExtend()) {

		}

		if (ae.getSource() == titleBar.getReduce()) {

		}
		

	}
	
	/**
	 * Generate an action when the smile click on the component.
	 */
	public void mouseClicked(MouseEvent me) {
		
	}

	/**
	 * Generate an action when the smile passes on the component.
	 */
	public void mouseEntered(MouseEvent arg0) {
		
		if(arg0.getSource().equals(titleBar.getExit())){
			try {
				titleBar.getExit().setIcon(new ImageIcon(ImageIO.read(new File("data/images/crossRed.png")).getScaledInstance(30,30,BufferedImage.TYPE_INT_ARGB)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Generate an action when the smile leave the component.
	 */
	public void mouseExited(MouseEvent arg0) {
		if(arg0.getSource().equals(titleBar.getExit())){
			try {
				titleBar.getExit().setIcon(new ImageIcon(ImageIO.read(new File("data/images/close.png")).getScaledInstance(30,30,BufferedImage.TYPE_INT_ARGB)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * Generate an action when the smile press the component.
	 */
	public void mousePressed(MouseEvent me) {
		
		
	}

	public void mouseReleased(MouseEvent me) {
		
	}

}
