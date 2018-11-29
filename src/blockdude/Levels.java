package blockdude;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
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
    	 //System.out.println(file);
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
                             
         levels.put(counter, new Stage(in.next(), frame));
         while(in.hasNext()) {
        	 if (levels.get(1).levelWin()){
        		 levels.get(1).setWinT();
        		 levels.remove(1);
        		 frame.getContentPane().removeAll();
        		 levels.put(1, new Stage(in.next(), frame));
        	 }
         }
                             
         in.close();
     }

     public TreeMap<Integer, Stage> getLevels() {
    	 return levels;
     }

}
