package blockdude;

/**
 * 
 * @author Henry Valentine Schreiber IV, Thomas Benjamin Clement, Jacob Thomas Dybas, Eric Spencer Lisle, Ethan Luke Harvey
 *	this c;lass extends entity and is for air blocks
 */
public class AirBlock extends Entity{
	
	/**
	 * 
	 * @param xPos the x coordinate of the top left corner
	 * @param yPos the y coordinate of the top left corner
	 */
	public AirBlock(int xPos, int yPos) {
		super(xPos, yPos, false, "AirBlock.png");
	}

}
