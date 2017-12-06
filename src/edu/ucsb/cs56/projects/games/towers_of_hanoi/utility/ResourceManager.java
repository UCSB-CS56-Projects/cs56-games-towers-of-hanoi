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
    public static void save(Serializable state,Serializable timer,Serializable moveCount, String fileName){	
	try{
	//open choosen file 
	FileOutputStream fos = new FileOutputStream(fileName);
	//alllow objects to be written into the file 	
	ObjectOutputStream os = new ObjectOutputStream(fos);
	//write the objects we need to save to continue from a saved game
	os.writeObject(state);
	os.writeObject(timer);
	os.writeObject(moveCount);
	//close file
	os.close();
	}
        catch(IOException ex){ex.printStackTrace();}        
       	}
	
    public static SaveData load(String fileName) { 
	try{
	//open choosen file
	ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
	//initialize new SaveData type to return 
	SaveData save  = new SaveData();
	//write into save the objects needed to continue from a saved game
	save.state =  (TowersOfHanoiState) is.readObject();
	save.timer = (HanoiTimer) is.readObject();   
	return save;
	}
	catch(Exception ex){
	//if no file is found, return basic TowerOfHanoi State and a timer at 0
	ex.printStackTrace();
	SaveData save = new SaveData();
	save.state = new TowersOfHanoiState();
	save.timer = new HanoiTimer();
	return save;
	}
	}
 	
}
