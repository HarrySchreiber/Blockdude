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
		Stage test = new Stage("AAAAAIIIAAAAIIIIIIIIIA\r\n" + 
				"AIIIIAAAIIIIAAAAAAAAAI\r\n" + 
				"IAAAAAAAAAAAAAAAAAAAAI\r\n" + 
				"IAAAAAAAAAAAAAAAAAAAAI\r\n" + 
				"IAAAAAAAAAAAAAAAAAAAAI\r\n" + 
				"IAAAAAIAAAAAAAAAAAAAAI\r\n" + 
				"IAAAAAIAAAAAAAAAAAAAAI\r\n" + 
				"IAAAAAIMMMMAAAAAAAAAAI\r\n" + 
				"IDAAAIIIIIIILAAAAAAAAI\r\n" + 
				"IIAIIIAAAAAIIAIAAAAAMI\r\n" + 
				"AIAIAAAAAAAAIAIIAAAMMI\r\n" + 
				"AIAIAAAAAAAAIAIIAAMMMI\r\n" + 
				"AIIIAAAAAAAAIAIIIIIIII\r\n" + 
				"AAAAAAAAAAAAIIIAAAAAAA");
		
		randStage randTest = new randStage();
		System.out.println(randTest.getRandStage());
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
		while(fr.hasNextLine()) {
			board += fr.nextLine();
		}
		fr.close();
		return board;
	}
	
}
