package controler;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import launcher.Utils;
import view.TabbedPane;

/**
 * Listener allowing to close tab on the TabbedPane by clicking the 
 * close button is the tab
 * @author Daphnis
 *
 */
public class CloseButtonListener extends MouseAdapter {
	
	/**
	 * The JLabel serving as a button to close the InformationPanel assigned to it
	 */
	private JLabel closeButton;
	
	/**
	 * The TabbedPane, allowing to get the InformationPanel currently displayed
	 */
	private TabbedPane pane;
	
	/**
	 * The icon in the button when it is not hovered
	 */
	private Icon closeIcon;

	/**
	 * The icon in the button when it is hovered
	 */
	private Icon closeIconHovered;

	/**
	 * Constructor, initialize all the fields and load the icons
	 * @param button
	 * @param pane
	 */
	public CloseButtonListener(JLabel button, TabbedPane pane) {
		loadImages();
		
		this.pane = pane;
		this.closeButton = button;
		this.closeButton.setIcon(closeIcon);
	}

	/**
	 * Close the currently displayed InformationPanel
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		pane.closeCurrent();
	}

	/**
	 * Set the icon to hovered
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		closeButton.setIcon(closeIconHovered);
	}

	/**
	 * Reset the icon to it's default state
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		closeButton.setIcon(closeIcon);
	}
	
	
	/**
	 * Load the images for the icons
	 */
	private void loadImages() {
		try {

			BufferedImage closeImage = ImageIO.read(new File("images/fermer.png"));
			closeIcon = new ImageIcon(
					Utils.replaceColors(Utils.resizeImage(closeImage, 15, 15,
							BufferedImage.TYPE_INT_ARGB), Color.GRAY));
			closeIconHovered = new ImageIcon(
					Utils.replaceColors(Utils.resizeImage(closeImage,
							15, 15, BufferedImage.TYPE_INT_ARGB), Color.RED));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
