package blockdude;

/**
 * 
 * @author Henry Valentine Schreiber IV, Thomas Benjamin Clement, Jacob Thomas Dybas, Eric Spencer Lisle, Ethan Luke Harvey
 * This class extends Entity and is for blocks which cannot be moved
 */
public class ImmovableBlock extends Entity{
	
	/**
	 * 
	 * @param xPos the x coordinate of the top left corner
	 * @param yPos the y coordinate of the top left corner
	 */
	public ImmovableBlock(int xPos, int yPos) {
		super(xPos, yPos, true, "ImmoveableBlock.png");
	}
	
}
