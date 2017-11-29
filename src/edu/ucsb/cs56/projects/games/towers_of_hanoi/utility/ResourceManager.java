package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility;

import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import java.util.ArrayList;
import edu.ucsb.cs56.projects.games.towers_of_hanoi.model.TowersOfHanoiState;

public class ResourceManager {

	public static void save(Serializable state,Serializable timer,Serializable moveCount, String fileName)  {
		
	try{
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream os = new ObjectOutputStream(fos);
		os.writeObject(state);
		os.writeObject(timer);
		os.writeObject(moveCount);
		os.close();
	}
        catch(IOException ex){ex.printStackTrace();}        
       	}
	
	public static saveData load(String fileName) { 
	try{
		ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
	        saveData save  = new saveData();
		save.state =  (TowersOfHanoiState) is.readObject();
		save.timer = (HanoiTimer) is.readObject();   
		
		return save;
	   }
	catch(Exception ex){
		ex.printStackTrace();
		saveData save = new saveData();
		save.state = new TowersOfHanoiState();
		save.timer = new HanoiTimer();
		
		return save;
	}
	}
}
