package blockdude;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String levels = parseFile("levels.txt");
		Levels game = new Levels(levels);
		//System.out.println(levels);
		//randStage random = new randStage();
		//Stage myStage = new Stage(random.getRandStage());
	}
		
		
	/**
	 * 
	 * @param file is the file with all of the levels
	 * @return a string for each level
	 */
	public static String parseFile(String file) throws FileNotFoundException{
		File input = new File(file); 
		String board = "";
		Scanner fr = new Scanner(input); 
		fr.useDelimiter("");
		
		while(fr.hasNext()) {
			board += fr.next();
		}
		fr.close();
		return board;
	}
	
}
