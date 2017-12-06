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

public class SavedSessionFrame {
    public static GameGUI gui;
    SaveData saveState1 = ResourceManager.load("SavedGame1.ser");
    SaveData saveState2 = ResourceManager.load("SavedGame2.ser");
    SaveData saveState3 = ResourceManager.load("SavedGame3.ser");
	
    public SaveData selectedSave = saveState1; //new saveData();
  
    public void go(){
	JFrame SavedSessionFrame = new JFrame("Saved Sessions");
	SavedSessionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	//create the three load state buttons and setup its actions 
    	JButton loadState1 = new JButton("Load State 1");	
    	loadState1.addActionListener(new ActionListener() {		
    	public void actionPerformed(ActionEvent e) {
		selectedSave = saveState1;	
		gui = setGUI(selectedSave);
   		SavedSessionFrame.dispose();
    	}});
    	JButton loadState2 = new JButton("Load State 2");
    	loadState2.addActionListener(new ActionListener(){	
    	public void actionPerformed(ActionEvent e){
		selectedSave = saveState2;	
		gui = setGUI(selectedSave);
   		SavedSessionFrame.dispose();
    	}});
    	JButton loadState3 = new JButton("Load State 3");
    	loadState3.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
		selectedSave = saveState3;	
		gui = setGUI(selectedSave);
   		SavedSessionFrame.dispose();
	}});
 
	//create table showing the three states to allow user to pick from
    	Object[] columns = {"Saved Session #",  "Number of Disks", "Number of Moves"};
    	Object[][] objects = {
		{"Saved Session # " ,"Number of Disks", "Number of Moves"},
		{"Saved Session # 1",saveState1.state.getNumOfDisks(),saveState1.state.getNumOfMoves()},
		{"Saved Session # 2",saveState2.state.getNumOfDisks(),saveState2.state.getNumOfMoves()},
		{"Saved Session # 3",saveState3.state.getNumOfDisks(),saveState3.state.getNumOfMoves()}};

	JTable t = new JTable(objects,columns);
	SavedSessionFrame.setLayout(new BorderLayout());
	SavedSessionFrame.add(t,BorderLayout.PAGE_START);
	SavedSessionFrame.add(loadState1,BorderLayout.LINE_START);
	SavedSessionFrame.add(loadState2,BorderLayout.CENTER);
	SavedSessionFrame.add(loadState3,BorderLayout.LINE_END);
	SavedSessionFrame.setSize(425,125);
	SavedSessionFrame.setLocationRelativeTo(null);
	SavedSessionFrame.setVisible(true);
        }

    public GameGUI setGUI(SaveData selectedSave){
	//set the GameGUI for the selected save 
	int winx = selectedSave.state.getNumOfDisks() * 50 + 200;
	int winy = 100 + selectedSave.state.getNumOfDisks() * 20;
	gui = new GameGUI(winx,winy);	
	gui.setState(selectedSave.state);
	gui.setTimer(selectedSave.timer);	
	return gui;
	}

}


