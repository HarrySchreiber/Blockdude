package blockdude;

/**
 * 
 * @author Henry Valentine Schreiber IV, Thomas Benjamin Clement, Jacob Thomas Dybas, Eric Spencer Lisle, Ethan Luke Harvey
 *	This class extends entity and is for the player 
 */
public class Player extends Entity{
	private boolean isFacingLeft = true;
	private boolean isHoldingBlock;
	
	/**
	 * 
	 * @param xPos is the x coordinate of the top left corner
	 * @param yPos is the y coordinate of the top left corner
	 * @param facingLeft determines whether the player is facing left or right 
	 */
	public Player(int xPos, int yPos, boolean isFacingLeft) {
		super(xPos, yPos, false, "PlayerLeft.png");
		this.isFacingLeft = isFacingLeft;
		if(!isFacingLeft) {
			this.setFileName("PlayerRight.png");
		}
		this.setHoldingBlock(false);
	}
	
	/**
	 * 
	 * @param isFacingLeft changes whether the player is facing left or not
	 */
	public void setIsFacingLeft(boolean facingLeft) {
		this.isFacingLeft = facingLeft;
		if(!isFacingLeft) {
			this.setFileName("PlayerRight.png");
		}
	}
	
	/**
	 * 
	 * @return whether or not the player is facing left
	 */
	public boolean getIsFacingLeft() {
		return isFacingLeft;
	}
	
	/**
	 * @return whether or not the player is holding a block
	 */
	public boolean isHoldingBlock() {
		return isHoldingBlock;
	}
	
	/**
	 * @param isHoldingBlock changes when the player picks up or places a block
	 */
	public void setHoldingBlock(boolean isHoldingBlock) {
		this.isHoldingBlock = isHoldingBlock;
	}
	
}
