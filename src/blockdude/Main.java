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
		
		HomePage a = new HomePage();
		
		int x = a.returnNextScreen();
		
		while(x == 0) {
			x = a.returnNextScreen();
			System.out.print(x);
		}
		
		if (x == 1) {
			a.setVisible(false);
			a = null;
			String levels = parseFile("levels.txt");
			Levels game = new Levels(levels);
		} else if (x == 2) {
			a.setVisible(false);
			a = null;
			String result = "";
			for(int i = 0; i < 11; i++) {
				randStage random = new randStage();
				result += random.getRandStage();
				result += "END\n";
			}
			Levels myStage = new Levels(result);
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
