package blockdude;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * @author Henry Valentine Schreiber IV, Thomas Benjamin Clement, Jacob Thomas Dybas, Eric Spencer Lisle, Ethan Luke Harvey
 * this class holds all of the levels
 */
public class Levels {
	private HashMap<Integer,Stage> levels;
	
	/**
	 * this constructor creates a new hashmap for levels
	 */
	public Levels(String file) {
		HashMap <Integer, Stage> levels = new HashMap<Integer, Stage>();
		Scanner in = new Scanner(file);
		in.useDelimiter(".");
		Integer counter = 1;
		
		while(in.hasNext()) {
			levels.put(counter, new Stage(in.next()));
			counter ++;
		}
		in.close();
	}
	
}
