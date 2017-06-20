package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.CompoundBorder;





public class TitleBar extends JPanel {

	
	private JButton exit;
	private JButton extend;
	private JButton reduce;
	private JLabel logo;
	
	public TitleBar() {
		try {
			initComponent();
		}catch (IOException io) {
			System.out.println("ERREUR : TitleBar.TitleBar();");
		}
	}
	
	private void initComponent() throws IOException{
		
	
		
		setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE),(BorderFactory.createEmptyBorder(5,5,5,5))));
		
		exit = new JButton();
		exit.setIcon(new ImageIcon(ImageIO.read(new File("data/images/close.png")).getScaledInstance(30,30,BufferedImage.TYPE_INT_ARGB)));
		exit.setBorderPainted(false);
		exit.setBorder(null);
		exit.setContentAreaFilled(false);
		
		
		extend = new JButton();
		extend.setIcon(new ImageIcon(ImageIO.read(new File("data/images/extend.png")).getScaledInstance(30,30,BufferedImage.TYPE_INT_ARGB)));
		extend.setBorderPainted(false);
		extend.setBorder(null);
		extend.setContentAreaFilled(false);
		
		reduce = new JButton();
		reduce.setIcon(new ImageIcon(ImageIO.read(new File("data/images/reduce.png")).getScaledInstance(30,30,BufferedImage.TYPE_INT_ARGB)));
		reduce.setBorderPainted(false);
		reduce.setBorder(null);
		reduce.setContentAreaFilled(false);
		reduce.setOpaque(false);
		
		
		logo = new JLabel();
		logo.setIcon(new ImageIcon(ImageIO.read(new File("data/images/logo.png")).getScaledInstance(30,30,BufferedImage.TYPE_INT_ARGB)));
		
		JPanel panFinal = new JPanel();
		panFinal.setLayout(new GridLayout(1,3));
		panFinal.add(reduce);
		panFinal.add(extend);
		panFinal.add(exit);
		
		JPanel panFinal2 = new JPanel();
		panFinal2.setLayout(new GridLayout(1,1));
		panFinal2.add(logo);
		
		
		panFinal2.setBackground(new Color(80,80,80));
		panFinal.setBackground(new Color(80,80,80));		
		setLayout(new BorderLayout());
		add(panFinal2, BorderLayout.WEST);
		add(panFinal, BorderLayout.EAST);
		
		setBackground(new Color(80,80,80));
		
	}

	/**
	 * @return the exit
	 */
	public JButton getExit() {
		return exit;
	}

	/**
	 * @return the extend
	 */
	public JButton getExtend() {
		return extend;
	}

	/**
	 * @return the reduce
	 */
	public JButton getReduce() {
		return reduce;
	}
	
	
	
}
