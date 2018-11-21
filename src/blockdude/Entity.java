package blockdude;

/**
 * 
 * @author Henry Valentine Schreiber IV, Thomas Benjamin Clement, Jacob Thomas Dybas, Eric Spencer Lisle, Ethan Luke Harvey
 *	This class is an abstract class for blocks are the player
 */
public abstract class Entity {
	private int xPos;
	private int yPos;
	private static int pixelWidth = 100;
	private static int pixelHeight = 100;
	private boolean barrier;
	private String fileName;
	
	/**
	 * 
	 * @param xPos is the x coordinate of the top left corner
	 * @param yPos is the y coordinate of the top left corner
	 * @param barrier whether or not the player can walk through the block
	 * @param fileName is the image file for the block
	 */
	public Entity(int xPos, int yPos, boolean barrier, String fileName) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.barrier = barrier;
		this.fileName = fileName;
	}
	
	/**
	 * @return the x coordinate of the top left corner
	 */
	public int getxPos() {
		return xPos;
	}
	
	/**
	 * 
	 * @param xPos the new x coordinate of the block
	 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	
	/**
	 * 
	 * @return the y coordinate of the top left corner
	 */
	public int getyPos() {
		return yPos;
	}
	
	/**
	 * 
	 * @param yPos is the new y coordinate of the top left corner
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
	/**
	 * 
	 * @return the width width of each block in pixels
	 */
	public static int getPixelWidth() {
		return pixelWidth;
	}

	/**
	 * 
	 * @param pixelWidth sets the width of the block, in pixels
	 */
	public void setPixelWidth(int pixelWidth) {
		this.pixelWidth = pixelWidth;
	}
	
	/**
	 * 
	 * @return the height of each block, in pixels
	 */
	public static int getPixelHeight() {
		return pixelHeight;
	}
	
	/**
	 * 
	 * @param pixelHeight is the new height of each block, in pixels
	 */
	public void setPixelHeight(int pixelHeight) {
		this.pixelHeight = pixelHeight;
	}
	
	/**
	 * 
	 * @return whether or not the entity is a barrier
	 */
	public boolean isBarrier() {
		return barrier;
	}
	
	/**
	 * 
	 * @param barrier is whether or not the block is npow a barrier
	 */
	public void setBarrier(boolean barrier) {
		this.barrier = barrier;
	}
	
	/**
	 * 
	 * @return the name of the picture file for the block
	 */
	public String getFileName() {
		return fileName;
	}
	
	/**
	 * 
	 * @param fileName is the new filename for the picture for the block
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
