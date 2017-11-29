package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility;
import java.io.*;
import java.awt.*;
public class GameSetting implements Serializable{
    boolean instruction;
    boolean music;
    String DiskType;
    Color Diskcolor;
    String ColorS;
    public GameSetting(){
	instruction = true;
        music=true;
	DiskType = "Block";
	Diskcolor = Color.BLACK;
	ColorS = "Black";}
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
    public String getDiskType(){
	return DiskType;}
    public void setDiskType(){
	String c = DiskType;
	switch (c){
	case "Block":
	    DiskType = "Round";
	    break;
	case "Round":
	    DiskType = "Wood";
	    break;
	case "Wood":
	    DiskType = "Brick";
	    break;
	case "Brick":
	    DiskType = "Stone";
	    break;
	case "Stone":
	    DiskType = "Block";
	    break;
	}}
    public String getColorS(){
	return ColorS;}
    public Color getColor(){
	return Diskcolor;}
    public void setColor(){
	String c = ColorS;
	switch (c){
	case "Black":
	    Diskcolor = Color.BLUE;
	    ColorS = "Blue";
	    break;
	case "Blue":
	    Diskcolor = Color.RED;
	    ColorS = "Red";
	    break;
	case "Red":
	    Diskcolor = new Color(0x4C0099);
	    ColorS = "Purple";
	    break;
	case "Purple":
	    Diskcolor = Color.BLACK;
	    ColorS = "Black";
	    break;}}
	
}
    
