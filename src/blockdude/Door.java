package blockdude;

/**
 * 
 * @author Henry Valentine Schreiber IV, Thomas Benjamin Clement, Jacob Thomas Dybas, Eric Spencer Lisle, Ethan Luke Harvey
 *	This class extends entity and is for the door block, which is the pin at the end of the level
 */
public class Door extends Entity {
	
	/**
	 * Constructor for door
	 *
	 * @param xPos is the x coordinate of the top left corner
	 * @param yPos is the y coordinate of the top left corner
	 */
	public Door(int xPos, int yPos) {
		super(xPos, yPos, false, "Door.png");
	}
	
}
