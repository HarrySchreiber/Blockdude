package blockdude;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 
 * @author Henry Valentine Schreiber IV, Thomas Benjamin Clement, Jacob Thomas Dybas, Eric Spencer Lisle, Ethan Luke Harvey
 * this class holds all of the levels
 */
public class Levels {
	private TreeMap<Integer,Stage> levels;
	
	/**
	 * this constructor creates a new treemap for levels
	 */
	public Levels(String file) {
		levels = new TreeMap<Integer, Stage>();
		Scanner in = new Scanner(file);
		in.useDelimiter(".");
		Integer counter = 1;
		
		while(in.hasNext()) {
			levels.put(counter, new Stage(in.next()));
			counter ++;
		}
		in.close();
	}

	public TreeMap<Integer, Stage> getLevels() {
		return levels;
	}

}
