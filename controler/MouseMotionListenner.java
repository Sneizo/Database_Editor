package controler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import view.Interface;

public class MouseMotionListenner implements MouseMotionListener{

	private Interface ihm;
	
	
	public MouseMotionListenner(Interface ihm){
		this.ihm = ihm;
	}


	// A chaque deplacement on recalcul le positionnement de la fenetre
    public void mouseDragged(MouseEvent e) {
        int depX = e.getX() - ihm.getPosX();
        int depY = e.getY() - ihm.getPosY();
        ihm.setLocation(ihm.getX()+depX, ihm.getY()+depY);
    }

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
