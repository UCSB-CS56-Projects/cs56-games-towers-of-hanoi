package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility;
import java.io.*;
public class GameSetting implements Serializable{
    boolean instruction;
    public GameSetting(){
	instruction = true;}
    public boolean getInstruction(){
	return instruction;}
    public void setInstruction(boolean t){
	instruction = t;}
	
}
    
