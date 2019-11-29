import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GUI extends Canvas{ 

	/**
	 * 
	 */
	private static final long serialVersionUID = 2235181881929910430L;

	/**
	 * 
	 */
	
	
	
	public GUI(Visualizer vis, int w, int h){
		JFrame frame = new JFrame("Application"); // Creates the frame and gives it a title
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		  // Sets it so it closes when you press 'X'
		
		frame.setPreferredSize(new Dimension(w, h)); // All 3 of these commands are related to size
		frame.setMaximumSize(new Dimension(w, h));	 // sets max size
		frame.setMinimumSize(new Dimension(w, h));	 // sets min size
		
		frame.setResizable(false);					// makes it so you can't change the size
		frame.setLocationRelativeTo(null);			// makes it so it starts in the middle of the screen
		frame.add(vis);							// adds the application into the frame
		frame.setVisible(true);						// sets it to visible
	}
}