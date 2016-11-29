package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility;
import java.io.*;
public class GameSetting implements Serializable{
    boolean instruction;
    boolean music;
    public GameSetting(){
	instruction = true;
        music=true;}
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
	
}
    
