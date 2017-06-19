/**
 * 
 */
package controler;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;

import view.Create;
import view.Interface;
import view.MainPanel;
import view.TitleBar;

/**
 * @author Damien
 *
 */
public class MainPanelControler implements ActionListener{

	private MainPanel mp;
	private Interface ihm;
	
	public MainPanelControler(MainPanel mp, Interface ihm){
		this.mp = mp;
		this.ihm = ihm;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(mp.getCreate())){
			
			try {
				JPanel pan = new JPanel();
				pan.setLayout(new BorderLayout());
				pan.add(new Create(), BorderLayout.CENTER);
				pan.add(new TitleBar(), BorderLayout.NORTH);
				ihm.setContentPane(pan);
				ihm.repaint();
				ihm.revalidate();
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	
	
}
