package launcher;

import view.Interface;

/**
 * This method launch the program
 * @author Mael and Damien
 *
 */
public class Launcher {
	
	public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                    try {
						new Interface().setVisible(true);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
            }
        });
    }
	
		
}

