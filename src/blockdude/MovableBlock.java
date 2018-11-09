package blockdude;

/**
 * 
 * @author Henry Valentine Schreiber IV, Thomas Benjamin Clement, Jacob Thomas Dybas, Eric Spencer Lisle, Ethan Luke Harvey
 *	This class extends Entity and is for blocks which can be moved
 */
public class MovableBlock extends Entity{
	
	/**
	 * 
	 * @param xPos the x coordinate of the top left corner
	 * @param yPos the y coordinate of the top left corner
	 */
	public MovableBlock(int xPos, int yPos) {
		super(xPos, yPos, true, "MoveableBlock.png");
	}
	
}
