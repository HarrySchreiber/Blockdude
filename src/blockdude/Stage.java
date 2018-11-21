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
		stage = new ArrayList<ArrayList<Entity>>();
		
		// starting x and y position
		int xPos = 0;
		int yPos = 0;
		
		Scanner getLine = new Scanner(level);
		
		while(getLine.hasNext()) {
			// creates a string of the line
			String line = getLine.nextLine();
			
			// empty array list for line declared
			ArrayList<Entity> oneRow = new ArrayList<Entity>();
			
			// a scanner of the line is declared
			Scanner lineScan = new Scanner(line);
			lineScan.useDelimiter("");
			
			while(lineScan.hasNext()) {

				// grabs a single character from the line
				char temp = lineScan.next().charAt(0);
				
				// when calling entity we need to use x and y position
				if (temp == 'A') {
					oneRow.add(new AirBlock(xPos, yPos));
					xPos = xPos + 1;
				} else if (temp == 'I') {
					oneRow.add(new ImmovableBlock(xPos, yPos));
					xPos = xPos + 1;
				} else if (temp == 'M') {
					oneRow.add(new MovableBlock(xPos, yPos));
					xPos = xPos + 1;
				} else if (temp == 'D') {
					oneRow.add(new Door(xPos,yPos));
					xPos = xPos + 1;
				} else if (temp == 'R') {
					boolean isLeftFacing = false;
					oneRow.add(new Player(xPos, yPos, isLeftFacing));
					xPos = xPos + 1;
				} else if (temp == 'L') {
					boolean isLeftFacing = true;
					oneRow.add(new Player(xPos, yPos, isLeftFacing));
					xPos = xPos + 1;
				}
			}
			
			stage.add(oneRow);
			xPos = 0;
			yPos = yPos + 1;
			lineScan.close();

		}
		
		getLine.close();
	}
	
	/**
	 * 
	 * @param first is the entity to be swapped
	 * @param second the entity to be swapped with
	 */
	public void swap(Entity first, Entity second) {
		
		int xPos1 = first.getxPos();
		int yPos1 = first.getyPos();
		
		int xPos2 = second.getxPos();
		int yPos2 = second.getyPos();

		Entity temp = first;
		stage.get(yPos1).set(xPos1, second);
		stage.get(yPos2).set(xPos2, temp);
		
		stage.get(yPos1).get(xPos1).setxPos(xPos1);
		stage.get(yPos1).get(xPos1).setyPos(yPos1);
		
		stage.get(yPos2).get(xPos2).setxPos(xPos2);
		stage.get(yPos2).get(xPos2).setyPos(yPos2);
		
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
	
	public int stageWidth() {
		return stage.get(0).size();
	}
	
	public int stageHeight() {
		return stage.size();
	}
	
	//FIXME Testing Material
	public void printClasses() {
		String result = "";
		for(ArrayList<Entity> x : stage) {
			for(Entity y : x) {
				result += y.getClass() + "\t";
			}
			result += "\n";
		}
		System.out.println(result);
	}
	
	public void testSwap() {
		Entity first = stage.get(2).get(1);
		Entity second = stage.get(2).get(2);
		this.swap(first, second);
	}
	
	public void printLocations() {
		String result = "";
		for(ArrayList<Entity> x : stage) {
			for(Entity y : x) {
				result += "(" + y.getxPos() + "," + y.getyPos() + ")";
			}
			result += "\n";
		}
		System.out.println(result);
	}

}