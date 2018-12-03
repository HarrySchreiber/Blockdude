package blockdude;


import java.util.Random;

public class randStage {
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
				if(j == 0 || j == NUM_COLS - 1) {
					stage[i+1][j] = 'I';
				}
				// if the block below is immovable, any kind of block can be used
				else if(stage[i][j] == 'I') {
					int randNum = rand.nextInt(3) + 1;
					switch(randNum) {
					// use the otehr three blocks as their numbers are randomly generated
					case 1: stage[i+1][j] = 'A';
							break;
					case 2: stage[i+1][j] = 'I';
							break;
					case 3: stage[i+1][j] = 'M';
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
		// add the player and the door to the stage
		int randNum = rand.nextInt(NUM_COLS/2);
		stage[1][randNum + 1] = 'R';
		stage[2][randNum] = 'A';
		stage[1][randNum + NUM_COLS/2 - 1] = 'D';
		stage[2][randNum + NUM_COLS/2] = 'A';
		
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
