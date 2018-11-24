package blockdude;

import java.util.ArrayList;
import java.util.Random;

public class randStage {
	// these boolean values ensure that there is only one player and one door
	boolean doorUsed = false;
	boolean playerUsed = false;
	
	//the size of the randomly generated levels
	final int NUM_ROWS = 7;
	final int NUM_COLS = 31;
	
	// the string which is the level
	String level = "";
	
	// the array in which the level is made
	char[][]stage;
	
	// this method generates a random level and returns it as a string
	public String getRandStage(){
		
		// initialize the array
		stage = new char[NUM_ROWS][NUM_COLS];
		
		// initialize the random number object
		Random rand = new Random();
		
		// make the bottom row of the level immovable blocks
		for(int i = 0; i < NUM_COLS; i ++) {
			stage[0][i] = 'I';
		}
		
		// populate the rest of the array with blocks
		for(int i = 0; i < NUM_ROWS - 1; i ++) {
			for(int j = 0; j < NUM_COLS; j++) {
				
				// if the block below is immovable, any kind of block can be used
				if(stage[i][j] == 'I') {
					int randNum = rand.nextInt(5) + 1;
					switch(randNum) {
					// check if the player block has already been used
					case 1: if(!playerUsed) {
								stage[i+1][j] = 'R';
								playerUsed = true;
								break;
							}
					// check if there is aready a door
					case 2: if(!doorUsed) {
								stage[i+1][j] = 'D';
								doorUsed = true;
								break;
							}
					// use the otehr three blocks as their numbers are randomly generated
					case 3: stage[i+1][j] = 'A';
							break;
					case 4: stage[i+1][j] = 'M';
							break;
					case 5: stage[i+1][j] = 'I';
							break;
					default: 
							break;
					}
				}
				
				// if the block below is movable, then only air blocks and movable blocks are allowed
				else if(stage[i][j] == 'M') {
					// check the blocks next to the block beneath
					if(j-1 >= 0 && j+1 < NUM_COLS) {
						// check that the payer can actually get past the movable blocks
						if(stage[i][j-1] != 'I' || stage[i][j-1] != 'M') {
							if(stage[i][j+1] != 'I' || stage[i][j+1] != 'M') {
								stage[i+1][j] = 'A';
							}
							else {
								stage[i+1][j] = 'M';
							}
						}
					}
				}
				
				// don't put blocks directly above the player, the door, or any air blocks
				else if(stage[i][j] == 'A' || stage[i][j] == 'R' || stage[i][j] == 'D') {
					stage[i+1][j] = 'A';
				}
			}
		}
		
		// turn the array into a string
		for(int i = NUM_ROWS; i > 0; i--) {
			for(int j = 0; j < NUM_COLS; j++) {
				level += stage[i-1][j];
			}
			level += "\n";
		}
		return level;
	}
}
