package blockdude;

import java.util.ArrayList;
import java.util.Random;

public class randStage {
	boolean doorUsed = false;
	boolean playerUsed = false;
	String level = "";
	char[][]stage;
	public randStage(){
		stage = new char[7][31];
		Random rand = new Random();
		
		
		for(int i = 0; i < 31; i ++) {
			stage[0][i] = 'I';
		}
		
		for(int i = 0; i < 6; i ++) {
			for(int j = 0; j < 31; j++) {
				if(stage[i][j] == 'I' || stage[i][j] == 'M') {
					int randNum = rand.nextInt(5) + 1;
					switch(randNum) {
					case 1: if(!playerUsed) {
								stage[i+1][j] = 'P';
								playerUsed = true;
								break;
							}	
					case 2: if(!doorUsed) {
								stage[i+1][j] = 'D';
								doorUsed = true;
								break;
							}
					case 3: stage[i+1][j] = 'A';
							break;
					case 4: stage[i+1][j] = 'I';
							break;
					case 5: stage[i+1][j] = 'M';
							break;
					default: 
							break;
					}
				}
				else if(stage[i][j] == 'M') {
					int randNum = rand.nextInt(2) + 1;
					switch(randNum) {
						case 1: stage[i+1][j] = 'A';
							break; 
						case 2: stage[i+1][j] = 'M';
							break;
						default:
							break;
					}
				}
				else if(stage[i][j] == 'A' || stage[i][j] == 'P' || stage[i][j] == 'D') {
					stage[i+1][j] = 'A';
				}
			}
		}
	}
	
	public String getRandStage() {
		for(int i = 6; i >= 0; i--) {
			for(int j = 0; j < 31; j++) {
				level += stage[i][j];
			}
			level += "\n";
		}
		return level;
	}
}
