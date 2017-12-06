package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility;
import java.io.*;
import java.awt.*;

public class GameSetting implements Serializable{
	boolean instruction;
	boolean music;
	String diskType;
	Color diskColor;
	String colorS;
    public GameSetting(){
	instruction = true;
        music=true;
	diskType = "Block";
	diskColor = Color.BLACK;
	colorS = "Black";
    }
    public boolean getInstruction(){
	return instruction;}
    public void setInstruction(boolean t){
	instruction = t;}
    public boolean getMusic(){
        return music;
    }
    public void setMusic(boolean t){
	music=t;
    }
    public String getdiskType(){
	return diskType;}
    public void setdiskType(){
	String c = diskType;
	switch (c){
	case "Block":
	    diskType = "Round";
	    break;
	case "Round":
	    diskType = "Wood";
	    break;
	case "Wood":
	    diskType = "Brick";
	    break;
	case "Brick":
	    diskType = "Stone";
	    break;
	case "Stone":
	    diskType = "Block";
	    break;
	}
    }
    public String getcolorS(){
	return colorS;}
    public Color getColor(){
	return diskColor;}
    public void setColor(){
	String c = colorS;
	switch (c){
	case "Black":
	    diskColor = Color.BLUE;
	    colorS = "Blue";
	    break;
	case "Blue":
	    diskColor = Color.RED;
	    colorS = "Red";
	    break;
	case "Red":
	    diskColor = new Color(0x4C0099);
	    colorS = "Purple";
	    break;
	case "Purple":
	    diskColor = Color.BLACK;
	    colorS = "Black";
	    break;
	}
    }
}
    
