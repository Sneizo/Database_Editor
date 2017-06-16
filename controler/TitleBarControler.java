/**
 * 
 */
package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TitleBar;

/**
 * @author Damien
 *
 */
public class TitleBarControler implements ActionListener{

	private TitleBar titleB;
	
	public TitleBarControler(TitleBar titleB){
		this.titleB = titleB;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		 
		if(arg0.getSource().equals(titleB.getExit())){
			System.exit(0);
		}
		
	}

	
	
}
