package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.*;

// import javax.swing.JFrame;
// import javax.swing.JOptionPane;
// import javax.swing.JTextField;
// import javax.swing.JLabel;
// import javax.swing.JButton;
// import javax.swing.JPanel;
import javax.swing.*;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import edu.ucsb.cs56.projects.games.towers_of_hanoi.model.TowersOfHanoiState;


import edu.ucsb.cs56.projects.games.towers_of_hanoi.model.TowersOfHanoiState;

/**
 * Main class that launches a GUI version of Towers of Hanoi
 * @author Aaron
 *
 */

public class GUIMain {
    
    public static GameGUI gui;
    public static GameSetting gamesetting;
    public static void main (String [] args){
	startGame();
    }
    
    public static void startGame() {
	    GameGUI.song.play();
        GameGUI.song.loop();
	try{
	    ObjectInputStream is = new ObjectInputStream(new FileInputStream("GameSetting.ser"));
	    gamesetting = (GameSetting) is.readObject();}
	catch (Exception ex){
	    gamesetting = new GameSetting();}
       	// This allows us to restart the game without quitting the program
	if (gui != null){ // Is a replay, close the old game, clear the disks prompt, show it
	    gui.close();
	}
	
	// Contents of dialogue
	final String[] options = {"Play","Main"};
	final JPanel panel = new JPanel();
	JLabel lbl = new JLabel("Number of Disks (3 to 25): ");
	final JTextField txt = new JTextField(10);
	final JPanel title = new JPanel();
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(3,1,0,10));
	JButton playbutton =new JButton("Play");
	JButton setting = new JButton("Setting");
	JButton exit = new JButton("Exit");
	buttons.add(playbutton);
	buttons.add(setting);
	buttons.add(exit);
	
	title.setLayout( new BorderLayout());

	final JFrame frame = new JFrame();
	try{
	BufferedImage myPicture = ImageIO.read(new File("src/edu/ucsb/cs56/projects/games/towers_of_hanoi/utility/images/ToHtitle.png"));
	JLabel picLabel = new JLabel (new ImageIcon(myPicture));

	title.add(picLabel, BorderLayout.NORTH);
	title.add(buttons, BorderLayout.SOUTH);
	}catch(IOException ioe) {
	    System.err.println("yo, error foo");
	    System.exit(0);
	}
       	panel.add(lbl);
	panel.add(txt);
        frame.add(title);
	frame.setSize(300,300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	frame.pack();
	frame.setVisible(true);

	//when you hit play, calls the dialogs preceding play

        playbutton.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e)
		{
		    // title.removeAll();
		    //frame.revalidate();
		    // frame.repaint();
		    frame.setVisible(false);
		    int numberOfDisks = 0;
		    int choice = JOptionPane.showOptionDialog(null,"Tower of Hanoi: \n\nThe goal of this game is to move all the disks from the leftmost tower to either the middle tower or rightmost tower, adhering to the following rules:\n   1) Move only one disk at a time.\n   2) A larger disk may not be placed ontop of a smaller disk.\n   3) All disks, except the one being moved, must be on a tower. \n\n Please press the OK button to continue","CHOOSE AN OPTION?", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Yes","No"}, null);

		    if(choice ==1){
			frame.removeAll();
			frame.validate();
			frame.setVisible(false);
			GUIMain.startGame();
			return;
		    }
		    
			
	// Keep looping through the dialogue until a valid number is entered
	while (numberOfDisks > 25 || numberOfDisks < 3) {
	    
	    // Show the dialogue
	    int userResponse = JOptionPane.showOptionDialog(null, panel, "Towers of Hanoi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
	    
	    if (userResponse == 1) {
		frame.removeAll();
		frame.validate();
	     	frame.setVisible(false);
       		GUIMain.startGame();
		return;	
	    }
	    
	    // Try to parse the number they entered
	    try {
		numberOfDisks = Integer.parseInt(txt.getText());
		if (numberOfDisks < 3 || numberOfDisks >25) {
		    JOptionPane.showMessageDialog(frame, "Please input a valid integer between 3 and 25 (inclusive)");
		    continue;
		}
	    } catch (NumberFormatException nf) {
		JOptionPane.showMessageDialog(frame,"Please input a valid integer between 3 and 25 (inclusive)");
		continue; // NaN -> show dialogue again
	    }
	}
	int winx = numberOfDisks * 50 + 200;
	int winy = 100 + (numberOfDisks)*20;
	gui = new GameGUI(winx, winy);
	gui.setState(new TowersOfHanoiState(numberOfDisks));
		}		
	    
	    });

	setting.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{JFrame settingFrame = new JFrame("Setting");
		    settingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    JButton instruction = new JButton("Instruction");
		    JLabel OnOrOff = new JLabel();
		    if (gamesetting.getInstruction())
			OnOrOff.setText("On");
		    else
			OnOrOff.setText("Off");
		    instruction.addActionListener(new ActionListener(){
			    public void actionPerformed(ActionEvent e)
			    {if (OnOrOff.getText() == "On")
				    {OnOrOff.setText("Off");
					gamesetting.setInstruction(false);}
				else
				    {OnOrOff.setText("On");
					gamesetting.setInstruction(true);}
			    }
			});
		    JButton Save = new JButton("Save");
		    Save.addActionListener(new ActionListener(){
			    public void actionPerformed(ActionEvent e)
			    {try{
				FileOutputStream fos = new FileOutputStream("GameSetting.ser");
				ObjectOutputStream os = new ObjectOutputStream(fos);
				os.writeObject(gamesetting);
				os.close();}
				catch(IOException ex){ex.printStackTrace();}}
			});
		    settingFrame.setLayout(new GridLayout(2,2,20,10));
		    settingFrame.add(instruction);
		    settingFrame.add(OnOrOff);
		    settingFrame.add(Save);
		    settingFrame.setSize(400,100);
		    settingFrame.setLocationRelativeTo(null);
		    settingFrame.setVisible(true);
		}
		
	    });
	
	exit.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e)
		{
		    System.exit(0);  
		}
	    });
    }
}
