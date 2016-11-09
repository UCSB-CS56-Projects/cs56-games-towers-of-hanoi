package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility;

import javax.swing.*;

import edu.ucsb.cs56.projects.games.towers_of_hanoi.model.TowersOfHanoiState;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Example class of how to use HanoiTimer.  Uses buttons and a 
 * JLabel.  ActionListeners call the HanoiTimer's start/restart/stop methods.
*/
public class GameGUI {
	public static Sound song = new Sound("music/backgroundSong.wav");
    private HanoiTimer gameTimer;
    private JPanel timePanel;
    private JLabel timeDisplay;
    private JFrame frame;
    private JPanel mainTimePanel;
    public static GamePanel gamePanel;
    public static JLabel countDisplay;
    public static JButton pauseTimer;
    public static JButton resetGame;
    public static String RESET_STR_LIT = "Reset";
    public static String PAUSE_STR_LIT = "Pause"; 
    public static String RESUME_STR_LIT = "Resume"; 
    public GameGUI(int window_x, int window_y) {
	frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
	System.out.flush();
	timeDisplay = new JLabel("Time:"+ "0",JLabel.CENTER);
	timeDisplay.setForeground(Color.black);
	timeDisplay.setBackground(Color.white);
	timeDisplay.setOpaque(true);
	timeDisplay.setFont(new Font("SansSerif", Font.BOLD, 20));
	timeDisplay.setPreferredSize(new Dimension(100, 50));
	
	countDisplay = new JLabel("Move Count: " + GamePanel.state.getNumOfMoves(), JLabel.CENTER);
	countDisplay.setForeground(Color.WHITE);
	countDisplay.setBackground(Color.DARK_GRAY);
	countDisplay.setOpaque(true);
	countDisplay.setFont(new Font("SansSerif", Font.BOLD, 20));
	countDisplay.setPreferredSize(new Dimension(170, 50));

	pauseTimer = new JButton(PAUSE_STR_LIT);
	resetGame = new JButton(RESET_STR_LIT);

	mainTimePanel = new JPanel(new BorderLayout());
	timePanel = new JPanel(new BorderLayout());
	timePanel.add(countDisplay, BorderLayout.NORTH);
	timePanel.add(timeDisplay, BorderLayout.CENTER);
	timePanel.add(pauseTimer, BorderLayout.WEST);
	timePanel.add(resetGame, BorderLayout.EAST);

	gameTimer = new HanoiTimer(timeDisplay);
	gameTimer.SetTimeElapsedText();
	mainTimePanel.add(timePanel, BorderLayout.NORTH);
	
	gamePanel = new GamePanel();
	gamePanel.setPreferredSize(new Dimension(window_x,window_y));
	gamePanel.setTimer(gameTimer);


	JLabel instructions = new JLabel("To pick up a disk, click on a tower, then click on another tower to deposit it.");
	instructions.setFont(new Font("Verdana",1,14));
	frame.add(gamePanel,BorderLayout.CENTER);
	frame.add(mainTimePanel,BorderLayout.NORTH);
	if (GUIMain.gamesetting.getInstruction()){
	    frame.add(instructions,BorderLayout.SOUTH);}
	frame.pack();
	System.out.flush();
	
	// centers the window
	frame.setLocationRelativeTo(null);
	
	frame.setVisible(true);
	gameTimer.start();
    }
    
    public void setState(TowersOfHanoiState s){
	gamePanel.setState(s);		
    }
    
    public void close() {
	frame.dispose();
    }
}
     
