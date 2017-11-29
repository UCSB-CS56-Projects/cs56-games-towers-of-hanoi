package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.*;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import edu.ucsb.cs56.projects.games.towers_of_hanoi.model.TowersOfHanoiState;

public class savedSessionFrame{
    public static GameGUI gui;
    saveData saveState1 = ResourceManager.load("SavedGame1.ser");
    saveData saveState2 = ResourceManager.load("SavedGame2.ser");
    saveData saveState3 = ResourceManager.load("SavedGame3.ser");
    public saveData selectedSave = saveState1; //new saveData();
   
    public void go(){
	JFrame savedSessionFrame = new JFrame("Saved Sessions");
	savedSessionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	//create the three load state buttons and setup its actions 
	JButton loadState1 = new JButton("Load State 1");
	loadState1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
				
			selectedSave.state = saveState1.state;
			selectedSave.timer = saveState1.timer;
			savedSessionFrame.setVisible(false);
			TowersOfHanoiState gamestate = selectedSave.state;
			HanoiTimer gametimer = selectedSave.timer;
			int winx = gamestate.getNumOfDisks() * 50 + 200;
			int winy = 100 + gamestate.getNumOfDisks() * 20;
			int numMove = selectedSave.state.getNumOfMoves();
			gui = new GameGUI(winx,winy);
			gamestate.setContinuedGame(true);
			gamestate.setNewGame(false);
			gamestate.setNumOfMoves(numMove);
			gui.setState(gamestate);
			gui.setTimer(gametimer);	}});
	JButton loadState2 = new JButton("Load State 2");
	loadState2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){			
			selectedSave.state = saveState2.state;
	       		selectedSave.timer = saveState2.timer;
			savedSessionFrame.setVisible(false);
			TowersOfHanoiState gamestate = selectedSave.state;
			HanoiTimer gametimer = selectedSave.timer;
			int winx = gamestate.getNumOfDisks() * 50 + 200;
			int winy = 100 + gamestate.getNumOfDisks() * 20;
			int numMove = selectedSave.state.getNumOfMoves();
			gui = new GameGUI(winx,winy);
			gamestate.setContinuedGame(true);
			gamestate.setNewGame(false);
			gamestate.setNumOfMoves(numMove);
			gui.setState(gamestate);
			gui.setTimer(gametimer);	}});
	JButton loadState3 = new JButton("Load State 3");
	loadState3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			selectedSave.state = saveState3.state;
	       		selectedSave.timer = saveState3.timer;
			savedSessionFrame.setVisible(false);
			TowersOfHanoiState gamestate = selectedSave.state;
			HanoiTimer gametimer = selectedSave.timer;
			int winx = gamestate.getNumOfDisks() * 50 + 200;
			int winy = 100 + gamestate.getNumOfDisks() * 20;
			int numMove = selectedSave.state.getNumOfMoves();
			gui = new GameGUI(winx,winy);
			gamestate.setContinuedGame(true);
			gamestate.setNewGame(false);
			gamestate.setNumOfMoves(numMove);
			gui.setState(gamestate);
			gui.setTimer(gametimer);
    
	}});
	//create table showing the three states to allow user to pick from
	Object[] columns = {"Saved Session #",  "Number of Disks", "Number of Moves"};
	Object[][] objects = {
		{"Saved Session # " ,"Number of Disks", "Number of Moves"},
		{"Saved Session # 1",saveState1.state.getNumOfDisks(),saveState1.state.getNumOfMoves()},
		{"Saved Session # 2",saveState2.state.getNumOfDisks(),saveState2.state.getNumOfMoves()},
		{"Saved Session # 3",saveState3.state.getNumOfDisks(),saveState3.state.getNumOfMoves()}};
	JTable t = new JTable(objects,columns);
	savedSessionFrame.setLayout(new BorderLayout());
	savedSessionFrame.add(t,BorderLayout.PAGE_START);
	//savedSessionFrame.add(t.getTableHeader(),BorderLayout.PAGE_START);
	savedSessionFrame.add(loadState1,BorderLayout.LINE_START);
	savedSessionFrame.add(loadState2,BorderLayout.CENTER);
	savedSessionFrame.add(loadState3,BorderLayout.LINE_END);
	savedSessionFrame.setSize(425,125);
	savedSessionFrame.setLocationRelativeTo(null);
	savedSessionFrame.setVisible(true);
    	
	
	
    
    
    }}
