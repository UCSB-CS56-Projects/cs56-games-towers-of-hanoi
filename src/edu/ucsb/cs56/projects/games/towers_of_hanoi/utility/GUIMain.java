package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.ucsb.cs56.projects.games.towers_of_hanoi.model.TowersOfHanoiState;

/**
 * Main class that launches a GUI version of Towers of Hanoi
 * @author Aaron
 *
 */

public class GUIMain {
	
	private static GameGUI gui;
		public static void main (String [] args){
		startGame();
	}	

	public static void startGame() {

		// This allows us to restart the game without quitting the program
		if (gui != null){ // Is a replay, close the old game, clear the disks prompt, show it
			gui.close();
		}

		// Contents of dialogue
		String[] options = {"Play"};
		JPanel panel = new JPanel();
		JLabel lbl = new JLabel("Number of Disks (3 to 25): ");
		JTextField txt = new JTextField(10);
		panel.add(lbl);
		panel.add(txt);
		
		int numberOfDisks = 0;

		// Keep looping through the dialogue until a valid number is entered
		while (numberOfDisks > 25 || numberOfDisks < 3) {

			// Show the dialogue
			int userResponse = JOptionPane.showOptionDialog(null, panel, "Towers of Hanoi", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options , options[0]);
			
			if (userResponse == JOptionPane.CLOSED_OPTION) {
            	// User clicked the 'x' button
            	System.exit(0);
        	}

			// Try to parse the number they entered
			try {
				numberOfDisks = Integer.parseInt(txt.getText());
			} catch (NumberFormatException nf) {
				continue; // NaN -> show dialogue again
			}
		}

		gui = new GameGUI();
		gui.setState(new TowersOfHanoiState(numberOfDisks));
	}
}
