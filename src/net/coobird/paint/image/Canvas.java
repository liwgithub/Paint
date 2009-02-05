package net.coobird.paint.image;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Canvas
{
	private List<ImageLayer> layers;
	private int width;
	private int height;
	// private LayerNamer --> names the new layer
	
	/**
	 * Cannot instantiate a {@code Canvas} object without specification of size.
	 */
	@SuppressWarnings("unused")
	private Canvas() {};
	
	/**
	 * Instantiates a {@code Canvas} object with the specified dimensions.
	 * @param width			The width of the canvas.
	 * @param height		The height of the canvas.
	 */
	public Canvas(int width, int height)
	{
		// TODO Determine appropriate List to use.
		layers = new ArrayList<ImageLayer>();
		this.width = width;
		this.height = height;
	}

	/**
	 * Returns the width of the {@link Canvas} object.
	 * @return 				The width of the canvas.
	 */
	public int getWidth()
	{
		return width;
	}

	/**
	 * Sets the width of the {@link Canvas} object.
	 * @param width 		The width to set the canvas to.
	 */
	public void setWidth(int width)
	{
		this.width = width;
	}

	/**
	 * Returns the height of the {@link Canvas} object.
	 * @return 				The height of the canvas.
	 */
	public int getHeight()
	{
		return height;
	}

	/**
	 * Sets the height of the {@link Canvas} object.
	 * @param height 		The height to set the canvas to.
	 */
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	/**
	 * Returns a {@link List} of {@link ImageLayer} objects which are contained
	 * in the {@link Canvas} object.
	 * @return				A {@code List} containing {@code ImageLayer} objects
	 * 						contained in the {@code Canvas} object.
	 */
	public List<ImageLayer> getLayers()
	{
		return layers;
	}
	
	/**
	 * <p>
	 * Returns a {@link List} containing the {@link ImageLayer} objects present
	 * in the {@link Canvas} object, ordered by the rendering order used by
	 * an {@link ImageRenderer} during rendering.
	 * </p>
	 * <p>
	 * The returned {@code List} is in reverse order of the {@code List}
	 * returned by calling the {@link getLayers()} method.
	 * </p>
	 * @return				A {@code List} containing {@code ImageLayer} objects
	 * 						in the rendering order.
	 */
	public List<ImageLayer> getRenderOrder()
	{
		ImageLayer[] array = new ImageLayer[1];
		array = layers.toArray(array);
		
		List<ImageLayer> renderOrderList = new ArrayList<ImageLayer>();
		
		for (int i = array.length - 1; i >= 0; i--)
			renderOrderList.add(array[i]);
		
		return renderOrderList; 
	}
	
	/**
	 * Adds a specified layer to the canvas.
	 * @param layer			The ImageLayer to add to the canvas.
	 */
	public void addLayer(ImageLayer layer)
	{
		layers.add(layer);
	}
	
	/**
	 * Removes a specified layer from the canvas.
	 * @param layer			The ImageLayer to remove from the canvas.
	 */
	public void removeLayer(ImageLayer layer)
	{
		layers.remove(layer);
	}
	
	/**
	 * Move a layer from one position to another.
	 * @param fromIndex		The index of the layer to more.
	 * @param toIndex		The index to which the layer is to be moved.
	 */
	public void moveLayer(int fromIndex, int toIndex)
	{
		ImageLayer il = layers.remove(fromIndex);
		layers.add(toIndex, il);
	}
	
	/**
	 * Clears the current contents of the {@link Canvas} object.
	 */
	public void clear()
	{
		layers.clear();
	}

	/**
	 * Returns a {@code String} representation of the {@code Canvas} object. 
	 * @return				A {@code String} representation of the
	 * 						{@code Canvas} object.
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		String msg = "Canvas: items: " + layers.size() +
				" " + Arrays.toString(layers.toArray());
		
		return msg;
	}
}
