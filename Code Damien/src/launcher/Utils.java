package launcher;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Utils {
	
	/**
	 * Replace colors from a BufferedImage
	 * @param im the source BufferedImage 
	 * @param replace the new color to set
	 * @return a new BufferedImage with the new color 
	 */
	public static BufferedImage replaceColors(BufferedImage im, Color replace) {
		
		BufferedImage image = new BufferedImage(im.getWidth(), im.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setColor(replace);
		g.fillRect(0, 0, im.getWidth(), im.getHeight());
		g.setComposite(AlphaComposite.DstIn);
		
		g.drawImage(im, 0, 0, null);
		g.dispose();
		return image;
		
	}
	
	
	/**
	 * Resize a BufferedImage
	 * @param originalImage the source image
	 * @param width the width for the new image
	 * @param height the height for the new image
	 * @param type the BufferedImage type
	 * @return the new BufferedImage resized according to parameters
	 */
	public static final BufferedImage resizeImage(BufferedImage originalImage, int width, int height, int type){

	    BufferedImage resizedImage = new BufferedImage(width, height, type);
	    Graphics2D g = resizedImage.createGraphics();
	    
	    g.setComposite(AlphaComposite.Src);

	    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
	            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g.setRenderingHint(RenderingHints.KEY_RENDERING,
	            RenderingHints.VALUE_RENDER_QUALITY);
	    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	            RenderingHints.VALUE_ANTIALIAS_ON);
	    
	    g.drawImage(originalImage, 0, 0, width, height, null);
	    g.dispose();    

	    return resizedImage;
	}   

}
