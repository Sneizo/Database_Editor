package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import view.Interface;

/**
 * This class allows to move the main window which is in undecorated.
 * @author Mael and Damien
 *
 */
public class MouseMotionListenner implements MouseMotionListener{

	private Interface ihm;	
	
	/**
	 * The constructor of the MouseMotionListenner class.
	 * @param ihm The main frame.
	 */
	public MouseMotionListenner(Interface ihm){
		this.ihm = ihm;
	}


	/**
	 * On each displacement, the positioning of the window is recalculated.
	 */
    public void mouseDragged(MouseEvent e) {
        int depX = e.getX() - ihm.getPosX();
        int depY = e.getY() - ihm.getPosY();
        ihm.setLocation(ihm.getX()+depX, ihm.getY()+depY);
    }

	
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
