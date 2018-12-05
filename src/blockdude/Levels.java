package blockdude;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;
import javax.swing.*;
/**
* 
 * @author Henry Valentine Schreiber IV, Thomas Benjamin Clement, Jacob Thomas Dybas, Eric Spencer Lisle, Ethan Luke Harvey
* this class holds all of the levels
*/
public class Levels {
	private TreeMap<Integer,Stage> levels;
              
	/**
	 * this constructor creates a new TreeMap for levels
	 */
     public Levels(String file) {
         levels = new TreeMap<Integer, Stage>();
         Scanner in = new Scanner(file);
         in.useDelimiter("\\s*END\\s*");
         Integer counter = 1;
                             
         JFrame frame = new JFrame();
         JPanel panel = new JPanel();
         panel.setLayout(null);
         frame.setContentPane(panel);
         panel.validate();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.repaint();
         frame.setSize(500,500);
         frame.setVisible(true);
         
         long start = System.currentTimeMillis();
                             
         levels.put(counter, new Stage(in.next(), frame));
         while(in.hasNext()) {
        	 if (levels.get(1).levelWin()){
        		 levels.get(1).setWinT();
        		 levels.remove(1);
        		 frame.getContentPane().removeAll();
        		 levels.put(1, new Stage(in.next(), frame));
        	 }
         }
         
         //Waits for the last level to play out
         while(true) {
        	 if(levels.get(1).levelWin()) {
        		 break;
        	 }
         }
         
         levels.get(1).setWinT();
		 levels.remove(1);
		 frame.getContentPane().removeAll();
		 frame.dispose();
		 
		 long end = System.currentTimeMillis();
		 
		 System.out.println("Time in Seconds: \t" + (end - start)/1000.0);
		 
		 try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		//Starts the Game from the home screen 
		try {
			Main.main(null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
         
         in.close();
     }

     public TreeMap<Integer, Stage> getLevels() {
    	 return levels;
     }

}
