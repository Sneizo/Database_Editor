/**
 * 
 */
package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import view.Create;
import view.Interface;
import view.MainPanel;
import view.TitleBar;

/**
 * @author Mael and Damien
 *
 */
public class MainPanelControler implements ActionListener{

	private MainPanel mp;
	private Interface ihm;
	
	/**
	 * The constructor of mainPanelController class.
	 * @param mp The mainPanel class.
	 * @param ihm The main frame.
	 */
	public MainPanelControler(MainPanel mp, Interface ihm){
		this.mp = mp;
		this.ihm = ihm;
	}
	
	/**
	 * Performs an action if the button pressed is the reference button.
	 */
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(mp.getCreate())){
			
			JPanel pan = new JPanel();
			pan.setLayout(new BorderLayout());
			pan.add(new Create(), BorderLayout.CENTER);
			pan.add(new TitleBar(), BorderLayout.NORTH);
			ihm.setContentPane(pan);
			ihm.repaint();
			ihm.revalidate();
		}
		
	}

	
	
}
