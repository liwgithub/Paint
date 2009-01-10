package net.coobird.paint.brush;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import net.coobird.paint.image.ImageLayer;

public class BrushFilter
{
	private Brush brush;
	private static int DEFAULT_TYPE = 0;
	
	/**
	 * 
	 * @param brush
	 */
	public BrushFilter(Brush brush)
	{
		this.brush = brush;
	}
	
	/**
	 * 
	 * @param layer
	 * @param x
	 * @param y
	 */
	public void drawBrush(ImageLayer layer, int x, int y)
	{
		drawBrush(layer, x, y, DEFAULT_TYPE);
	}
	
	/**
	 * 
	 * @param layer
	 * @param x
	 * @param y
	 * @param type
	 */
	public void drawBrush(ImageLayer layer, int x, int y, int type)
	{
		//TODO
		// handle TYPE
		
		BufferedImage brushImg = brush.getBrush();
		Graphics2D g = layer.getGraphics();
	
		g.drawImage(
				brushImg,
				x - (brushImg.getWidth() / 2),
				y - (brushImg.getHeight() / 2),
				null
		);
	}

}
