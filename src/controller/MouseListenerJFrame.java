/**
 * 
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Interface;

/**
 * @author Mael and Damien
 *
 */


public class MouseListenerJFrame implements MouseListener {

	private Interface ihm;
	private int posX;
	private int posY;
	
	/**
	 * Constructor of the MouseListenerJFrame.
	 * Takes in parameters the coordinates of the mouse.
	 * @param ihm The main frame.
	 * @param posX posX of the frame.
	 * @param posY posY of the frame.
	 */
	public MouseListenerJFrame(Interface ihm,int posX, int posY){
		this.ihm = ihm;
		this.posX = posX;
		this.posY = posY;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Retrieve mouse coordinates.
	 */
	public void mousePressed(MouseEvent e) {
        posX = e.getX();    //Position X de la souris au clic
        posY = e.getY();    //Position Y de la souris au clic
        ihm.setPosX(posX);
        ihm.setPosY(posY);
    }

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	 
}
