package blockdude;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import java.util.Scanner;

import javax.swing.JFrame;

/**
 * 
 * @author Henry Valentine Schreiber IV, Thomas Benjamin Clement, Jacob Thomas Dybas, Eric Spencer Lisle, Ethan Luke Harvey
 * this the main class
 */
public class main {
	
	/**
	 * 
	 * @param args is the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stage test = new Stage("IAAAAAAAAAAAAAAAAAAAAAAAAAAAAAI\r\n" + 
				"IAAAAAAAAAAAAAAAAAAAAAAAAAAAAAI\r\n" + 
				"IAAAAAAAAAAAAAAAAAAAAAAAAAAAMAI\r\n" + 
				"IAAAAAAAAIIIIIAAAAIAAAAAAAAMMAI\r\n" + 
				"DAAAAAAAAAAAAAAAAAIAAAIARAMMMAI\r\n" + 
				"IIIAAAAIIIIIIIIIIIIIIIIIIIIIIII\r\n" + 
				"IIIAAAAIIIIIIIIIIIIIIIIIIIIIIII\r\n" + 
				"IIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
	}
	
	/**
	 * 
	 * @param file is the file with all of the levels
	 * @return a string for each level
	 */
	public String parseFile(String file) throws FileNotFoundException{
		File input = new File(file); 
		String board = "";
		Scanner fr = new Scanner(input); 
		fr.useDelimiter("END");
		while(fr.hasNext()) {
			board += fr.next();
		}
		return board;
	}
	
	/**
	 * 
	 * @param file is the file with all of the levels
	 * @return a hashmap with all of the levels from the file
	 */
	public HashMap<Integer,Stage> addLevels(String file){
		HashMap <Integer, Stage> levels = new HashMap<Integer, Stage>();
		Scanner in = new Scanner(file);
		in.useDelimiter(".");
		Integer counter = 1;
		
		while(in.hasNext()) {
			
			levels.put(counter, new Stage(in.next()));
			counter = counter * 37;
		}
		in.close();
		return levels;
		
	}

}
