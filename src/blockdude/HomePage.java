package blockdude;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import blockdude.HomePage;
import blockdude.Levels;

public class HomePage extends JFrame {
	private javax.swing.JLabel untitled;
	private int nextScreen;
	
    public HomePage() {
    	nextScreen = 0;

        setSize(400, 375);
        
        JPanel panel = new JPanel();
        
        untitled = new JLabel(new ImageIcon(getClass().getResource("Untitled.png")));
        untitled.setBounds(0,0,400,300);
        
        // Create JButton and JPanel
        JButton button1 = new JButton("Play");
        JButton button2 = new JButton("Random Level Generator");
        
        // Add button to JPanel
        panel.add(untitled);
        panel.add(button1);
        panel.add(button2);
        
        // And JPanel needs to be added to the JFrame itself!
        this.getContentPane().add(panel);

        // Button to start at level 1
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (button1.isEnabled()) {
                	getNextScreen(1);
                	System.out.println(nextScreen);
                } else {
                }
            }
        });
        
        // Button to play random level
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (button2.isEnabled()) {
                	getNextScreen(2);
                	System.out.println(nextScreen);
                } else {
                }
            }
        });
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }
    
    public void getNextScreen(int n) {
    	this.nextScreen = n;
    }
    
    public int returnNextScreen() {
    	return nextScreen;
    }
    
}
