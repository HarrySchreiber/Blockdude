package blockdude;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

/**
 * 
 * @author Henry Valentine Schreiber IV, Thomas Benjamin Clement, Jacob Thomas Dybas, Eric Spencer Lisle, Ethan Luke Harvey
 *	This class is for the stage and contains all of the blocks
 */
public class Stage extends JFrame implements KeyListener{
	private ArrayList<ArrayList<Entity>> stage;
	private int doorXPos;
	private int doorYPos;
	
	/**
	 * 
	 * @param level is the string from which the level is created
	 */
	public Stage(String level) {
		
		//FIXME This is far from finished yet, but necessary to get key events
		super("Blockdude");
		this.addKeyListener(this);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setVisible(true);
		
		
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
		
		this.doorXPos = findDoorXPos();
		this.doorYPos = findDoorYPos();
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
	 * Takes an entity and drops it down to the floor, like gravity
	 * 
	 * @param e An Entity to be moved to the floor
	 */
	public void floorEntity(Entity e) {
		while(!stage.get(e.getyPos() + 1).get(e.getxPos()).isBarrier()) {
			swap(stage.get(e.getyPos() + 1).get(e.getxPos()), stage.get(e.getyPos()).get(e.getxPos()));
			if(e instanceof Player) {
				Player temp = (Player) e;
				if(temp.isHoldingBlock()) {
					floorEntity(stage.get(e.getyPos() - 2).get(e.getxPos()));
				}
			}
		}
	}
	
	/**
	 * @return The Width of the stage
	 */
	public int stageWidth() {
		return stage.get(0).size();
	}
	
	/**
	 * @return The Height of the stage
	 */
	public int stageHeight() {
		return stage.size();
	}
	
	public int findPlayerXPos() {
		for(ArrayList<Entity> x : stage) {
			for(Entity y : x) {
				if(y instanceof Player) {
					return y.getxPos();
				}
			}
		}
		return -1;
	}
	
	public int findPlayerYPos() {
		for(ArrayList<Entity> x : stage) {
			for(Entity y : x) {
				if(y instanceof Player) {
					return y.getyPos();
				}
			}
		}
		return -1;
	}
	
	public int findDoorXPos() {
		for(ArrayList<Entity> x : stage) {
			for(Entity y : x) {
				if(y instanceof Door) {
					return y.getxPos();
				}
			}
		}
		return -1;
	}
	
	public int findDoorYPos() {
		for(ArrayList<Entity> x : stage) {
			for(Entity y : x) {
				if(y instanceof Door) {
					return y.getyPos();
				}
			}
		}
		return -1;
	}
	
	public boolean levelWin() {
		return (findPlayerXPos() == doorXPos) && (findPlayerYPos() == doorYPos);
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Figure out logic for these... Print Statements Just check if statements work
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_LEFT) {
			System.out.println("Left");
			//Changes Player Direction
			Player temp = (Player) stage.get(findPlayerYPos()).get(findPlayerXPos());
			temp.setIsFacingLeft(true);
			stage.get(findPlayerYPos()).set(findPlayerXPos(), temp);
			
			//Moves Left
			if(!stage.get(findPlayerYPos()).get(findPlayerXPos() - 1).isBarrier()) {
				swap(stage.get(findPlayerYPos()).get(findPlayerXPos() - 1),stage.get(findPlayerYPos()).get(findPlayerXPos()));
				if(temp.isHoldingBlock()) {
					if(!stage.get(findPlayerYPos() - 1).get(findPlayerXPos()).isBarrier()) {
						swap(stage.get(findPlayerYPos() - 1).get(findPlayerXPos() + 1),stage.get(findPlayerYPos() - 1).get(findPlayerXPos()));
					}else {
						temp.setHoldingBlock(false);
						stage.get(findPlayerYPos()).set(findPlayerXPos(), temp);
						floorEntity(stage.get(findPlayerYPos() - 1).get(findPlayerXPos() + 1));
					}
				}
			}
			
			
			floorEntity(stage.get(findPlayerYPos()).get(findPlayerXPos()));
		}
		if(keyCode == KeyEvent.VK_RIGHT) {
			System.out.println("Right");
			System.out.println("Left");
			//Changes player direction
			Player temp = (Player) stage.get(findPlayerYPos()).get(findPlayerXPos());
			temp.setIsFacingLeft(false);
			stage.get(findPlayerYPos()).set(findPlayerXPos(), temp);
			
			//Moves Right
			if(!stage.get(findPlayerYPos()).get(findPlayerXPos() + 1).isBarrier()) {
				swap(stage.get(findPlayerYPos()).get(findPlayerXPos() + 1),stage.get(findPlayerYPos()).get(findPlayerXPos()));
				if(temp.isHoldingBlock()) {
					if(!stage.get(findPlayerYPos() - 1).get(findPlayerXPos()).isBarrier()) {
						swap(stage.get(findPlayerYPos() - 1).get(findPlayerXPos() - 1),stage.get(findPlayerYPos() - 1).get(findPlayerXPos()));
					}else {
						temp.setHoldingBlock(false);
						stage.get(findPlayerYPos()).set(findPlayerXPos(), temp);
						floorEntity(stage.get(findPlayerYPos() - 1).get(findPlayerXPos() - 1));
					}
				}
			}
			
			
			floorEntity(stage.get(findPlayerYPos()).get(findPlayerXPos()));
		}
		if(keyCode == KeyEvent.VK_UP) {
			System.out.println("Up");
			Player temp = (Player) stage.get(findPlayerYPos()).get(findPlayerXPos());
			if(temp.getIsFacingLeft()) {
				if(stage.get(findPlayerYPos()).get(findPlayerXPos() - 1).isBarrier() && !stage.get(findPlayerYPos() - 1).get(findPlayerXPos() - 1).isBarrier()) {
					swap(stage.get(findPlayerYPos()).get(findPlayerXPos()),stage.get(findPlayerYPos() - 1).get(findPlayerXPos() - 1));
					if(temp.isHoldingBlock()) {
						swap(stage.get(findPlayerYPos()).get(findPlayerXPos() + 1), stage.get(findPlayerYPos() - 1).get(findPlayerXPos()));
					}
				}
			}else {
				if(stage.get(findPlayerYPos()).get(findPlayerXPos() + 1).isBarrier() && !stage.get(findPlayerYPos() - 1).get(findPlayerXPos() + 1).isBarrier()) {
					swap(stage.get(findPlayerYPos()).get(findPlayerXPos()),stage.get(findPlayerYPos() - 1).get(findPlayerXPos() + 1 ));
					if(temp.isHoldingBlock()) {
						swap(stage.get(findPlayerYPos()).get(findPlayerXPos() - 1), stage.get(findPlayerYPos() - 1).get(findPlayerXPos()));
					}
				}
			}
		}
		if(keyCode == KeyEvent.VK_DOWN) {
			System.out.println("Down");
			Player temp = (Player) stage.get(findPlayerYPos()).get(findPlayerXPos());
			if(!temp.isHoldingBlock()) {
				if(temp.getIsFacingLeft()) {
					if(stage.get(findPlayerYPos()).get(findPlayerXPos() - 1) instanceof MovableBlock && !stage.get(findPlayerYPos() - 1).get(findPlayerXPos()).isBarrier() && !stage.get(findPlayerYPos() - 1).get(findPlayerXPos() - 1).isBarrier()) {
						swap(stage.get(findPlayerYPos()).get(findPlayerXPos() - 1),stage.get(findPlayerYPos() - 1).get(findPlayerXPos()));
						temp.setHoldingBlock(true);
						stage.get(findPlayerYPos()).set(findPlayerXPos(), temp);
					}
				}else {
					if(stage.get(findPlayerYPos()).get(findPlayerXPos() + 1) instanceof MovableBlock && !stage.get(findPlayerYPos() - 1).get(findPlayerXPos()).isBarrier() && !stage.get(findPlayerYPos() - 1).get(findPlayerXPos() + 1).isBarrier()) {
						swap(stage.get(findPlayerYPos()).get(findPlayerXPos() + 1),stage.get(findPlayerYPos() - 1).get(findPlayerXPos()));
						temp.setHoldingBlock(true);
						stage.get(findPlayerYPos()).set(findPlayerXPos(), temp);
					}
				}
			}else {
				if(temp.getIsFacingLeft()) {
					if(!stage.get(findPlayerYPos()).get(findPlayerXPos() - 1).isBarrier() && !stage.get(findPlayerYPos() - 1).get(findPlayerXPos() - 1).isBarrier()) {
						swap(stage.get(findPlayerYPos()).get(findPlayerXPos() - 1),stage.get(findPlayerYPos() - 1).get(findPlayerXPos()));
						floorEntity(stage.get(findPlayerYPos()).get(findPlayerXPos() - 1));
						temp.setHoldingBlock(false);
						stage.get(findPlayerYPos()).set(findPlayerXPos(), temp);
					}
				}else {
					if(!stage.get(findPlayerYPos()).get(findPlayerXPos() + 1).isBarrier() && !stage.get(findPlayerYPos() - 1).get(findPlayerXPos() + 1).isBarrier()) {
						swap(stage.get(findPlayerYPos()).get(findPlayerXPos() + 1),stage.get(findPlayerYPos() - 1).get(findPlayerXPos()));
						floorEntity(stage.get(findPlayerYPos()).get(findPlayerXPos() + 1));
						temp.setHoldingBlock(false);
						stage.get(findPlayerYPos()).set(findPlayerXPos(), temp);
					}
				}
			}
		}
		
		//FIXME Shows an Updated board after every move
		printBoardCharacters();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	//FIXME Testing Material Begins
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
	
	public void printBoardCharacters() {
		String result = "";
		for(ArrayList<Entity> x : stage) {
			for(Entity y : x) {
				if(y instanceof AirBlock) {
					//Using " " instead of "A" to make things less cluttered
					result += " ";
				}else if(y instanceof Door) {
					result += "D";
				}else if(y instanceof ImmovableBlock) {
					result += "I";
				}else if(y instanceof MovableBlock) {
					result += "M";
				}else if(y instanceof Player) {
					//Using arrows rather then "L" and "R" so its easier to determine
					if(((Player) y).getIsFacingLeft()) {
						result += "<";
					}else {
						result += ">";
					}
				}
			}
			result += "\n";
		}
		System.out.println(result);
	}
	
	
	//FIXME End Testing Material

}