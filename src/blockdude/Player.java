package blockdude;

/**
 * 
 * @author Henry Valentine Schreiber IV, Thomas Benjamin Clement, Jacob Thomas Dybas, Eric Spencer Lisle, Ethan Luke Harvey
 *	This class extends entity and is for the player 
 */
public class Player extends Entity{
	private boolean isFacingLeft = true;
	
	/**
	 * 
	 * @param xPos is the x coordinate of the top left corner
	 * @param yPos is the y coordinate of the top left corner
	 * @param facingLeft determines whether the player is facing left or right 
	 */
	public Player(int xPos, int yPos, boolean isFacingLeft) {
		super(xPos, yPos, false, "Player.png");
		this.isFacingLeft = isFacingLeft;
	}
	
	/**
	 * 
	 * @param facingLeft changes whether the player is facing left or not
	 */
	public void setIsFacingLeft(boolean facingLeft) {
		this.isFacingLeft = facingLeft;
	}
	
	/**
	 * 
	 * @return whether or no the player is facing left
	 */
	public boolean getIsFacingLeft() {
		return isFacingLeft;
	}
	
}
