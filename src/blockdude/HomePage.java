package blockdude;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HomePage extends JFrame {
	private javax.swing.JLabel untitled;
	private int nextScreen;
	
    public HomePage() {
    	nextScreen = 0;

    	// Creates window size
        setSize(400, 410);
        
        // Create JPanel
        JPanel panel = new JPanel();
        
        // Place "Dino Escape" image in home page
        untitled = new JLabel(new ImageIcon(getClass().getResource("Untitled.png")));
        untitled.setBounds(0,0,400,300);
        
        // Create JButton
        JButton button1 = new JButton("Play");
        JButton button2 = new JButton("Play Random Level");
        
        // Add button to JPanel
        panel.add(untitled);
        panel.add(button1);
        panel.add(button2);
        
        // Adds JPanel to JFrame
        this.getContentPane().add(panel);

        // Button to start at level 1
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (button1.isEnabled()) {
                	getNextScreen(1);
                } else {
                }
            }
        });
        
        // Button to play random level
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (button2.isEnabled()) {
                	getNextScreen(2);
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
