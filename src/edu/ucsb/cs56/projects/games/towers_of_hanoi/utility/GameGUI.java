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
    
    private HanoiTimer gameTimer;
    private JPanel timePanel;
    private JLabel timeDisplay;
    private JFrame frame;
    private JPanel mainTimePanel;
    private GamePanel gamePanel;
    
    
    public GameGUI() {
	frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	System.out.flush();
	timeDisplay = new JLabel("0",JLabel.CENTER);
        timeDisplay.setForeground(Color.black);
        timeDisplay.setBackground(Color.white);
        timeDisplay.setOpaque(true);
        timeDisplay.setFont(new Font("SansSerif", Font.BOLD, 20));
        timeDisplay.setPreferredSize(new Dimension(100, 50));
		
	mainTimePanel = new JPanel(new BorderLayout());
		
	timePanel = new JPanel(new BorderLayout());
	timePanel.add(timeDisplay, BorderLayout.CENTER);
	gameTimer = new HanoiTimer(timeDisplay);
	gameTimer.SetTimeElapsedText();
	mainTimePanel.add(timePanel, BorderLayout.NORTH);
	
	gamePanel = new GamePanel();
	gamePanel.setPreferredSize(new Dimension(500,200));
	gamePanel.setTimer(gameTimer);

	frame.add(gamePanel,BorderLayout.CENTER);	
	frame.add(mainTimePanel,BorderLayout.NORTH);
	frame.pack();
	
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
