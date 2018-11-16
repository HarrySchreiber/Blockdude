package blockdude;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

/**
 * 
 * @author Henry Valentine Schreiber IV, Thomas Benjamin Clement, Jacob Thomas Dybas, Eric Spencer Lisle, Ethan Luke Harvey
 *	This class is for the stage and contains all of the blocks
 */
public class Stage extends JFrame{
	private ArrayList<ArrayList<Entity>> stage;
	
	/**
	 * 
	 * @param level is the string from which the level is created
	 */
	public Stage(String level) {
		ArrayList<Entity> stage = null;
		Scanner nextScan = new Scanner(level);
		
		// starting x and y position
		int xPos = 0;
		int yPos = 0;
		
		// delimiter
		nextScan.useDelimiter("");
		
		while(nextScan.hasNext()) {
			char temp = nextScan.next().charAt(0);
			
			// when calling entity we need to use x and y position
			if (temp == 'A') {
				stage.add(new AirBlock(xPos, yPos));
				xPos = xPos + 1;
			} else if (temp == 'I') {
				stage.add(new ImmovableBlock(xPos, yPos));
				xPos = xPos + 1;
			} else if (temp == 'M') {
				stage.add(new ImmovableBlock(xPos, yPos));
				xPos = xPos + 1;
			} else if (temp == 'R') {
				boolean isLeftFacing = false;
				stage.add(new Player(xPos, yPos, isLeftFacing));
				xPos = xPos + 1;
			} else if (temp == 'L') {
				boolean isLeftFacing = true;
				stage.add(new Player(xPos, yPos, isLeftFacing));
				xPos = xPos + 1;
			} else if (temp == '/') {
				yPos = yPos + 1;
			} else {
				// empty statement is for n's when there is a newline
			}	
		}
		
		nextScan.close();
		
	}
	
	/**
	 * 
	 * @param first is the entity to be swapped
	 * @param second the entity to be swapped with
	 */
	public void swap(Entity first, Entity second) {
		
		Entity temp = first;
		stage.get(first.getyPos()).set(first.getxPos(), second);
		stage.get(second.getyPos()).set(second.getyPos(), temp);
		
		}
	
	/**
	 * displays all of the block in the stage in an updated GUI
	 */
	public void displaysLevel() {
		
	}
	
	/**
	 * move the player block
	 */
	public void move() {
		
	}

}