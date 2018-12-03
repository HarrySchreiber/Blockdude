package blockdude;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Henry Valentine Schreiber IV, Thomas Benjamin Clement, Jacob Thomas Dybas, Eric Spencer Lisle, Ethan Luke Harvey
 * this the main class
 */
public class Main {
	
	/**
	 * 
	 * @param args is the arguments
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		// Creates new home page
		HomePage a = new HomePage();
		
		int gameChoice = a.returnNextScreen();
		
		// Waits for user to click "Play" or "Random Level Generator"
		while(gameChoice == 0) {
			gameChoice = a.returnNextScreen();
		}
		
		// Starts level or goes to random level generator based off users click
		if (gameChoice == 1) {
			// Clears home page
			a.setVisible(false);
			a = null;
			String levels = parseFile("levels.txt");
			Levels game = new Levels(levels);
		} else if (gameChoice == 2) {
			// Clears home page
			a.setVisible(false);
			a = null;
			randStage random = new randStage();
			Levels myStage = new Levels(random.getRandStage());
		}
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
