package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility;
import javax.swing.*;
import edu.ucsb.cs56.projects.games.towers_of_hanoi.utility.*;
import edu.ucsb.cs56.projects.games.towers_of_hanoi.model.TowersOfHanoiState;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameOption{
    public static JFrame Secondframe;
    public GameOption()
    {JFrame Secondframe = new JFrame("Game Option");
	Secondframe.add(GameGUI.pauseTimer,BorderLayout.WEST);
	Secondframe.add(GameGUI.resetGame,BorderLayout.EAST);
	Secondframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	Secondframe.setSize(300,100);
	Secondframe.setLocationRelativeTo(null);
	Secondframe.setVisible(true);}
    public static void closeFrame(){
	Secondframe.dispose();}
}
