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

public class ControllerTitleBar implements ActionListener, MouseListener {

	private TitleBar titleBar;
	private Interface interf;

	public ControllerTitleBar(TitleBar titleBar, Interface interf) {
		this.titleBar = titleBar;
		this.interf = interf;
	}

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
	
	
	public void mouseClicked(MouseEvent me) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		if(arg0.getSource().equals(titleBar.getExit())){
			try {
				titleBar.getExit().setIcon(new ImageIcon(ImageIO.read(new File("data/images/crossRed.png")).getScaledInstance(30,30,BufferedImage.TYPE_INT_ARGB)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if(arg0.getSource().equals(titleBar.getExit())){
			try {
				titleBar.getExit().setIcon(new ImageIcon(ImageIO.read(new File("data/images/close.png")).getScaledInstance(30,30,BufferedImage.TYPE_INT_ARGB)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void mousePressed(MouseEvent me) {
		
		
	}

	public void mouseReleased(MouseEvent me) {
		
	}

}
