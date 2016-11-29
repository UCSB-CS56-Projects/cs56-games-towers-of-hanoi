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

public class GamesettingFrame{
    GameSetting gamesetting;
    public void setSetting(GameSetting s)
    {this.gamesetting = s;}
    public void go(){
	JFrame settingFrame = new JFrame("Setting");
		    settingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    JButton instruction = new JButton("Instruction");
		    JLabel PlayOrStop = new JLabel();
                    if (gamesetting.getMusic())
			PlayOrStop.setText("On");
		    else
			PlayOrStop.setText("Off");
		    JLabel OnOrOff = new JLabel();
		    if (gamesetting.getInstruction())
			OnOrOff.setText("On");
		    else
			OnOrOff.setText("Off");
		    instruction.addActionListener(new ActionListener(){
			    public void actionPerformed(ActionEvent e)
			    {if (OnOrOff.getText() == "On")
				    {OnOrOff.setText("Off");
					gamesetting.setInstruction(false);}
				else
				    {OnOrOff.setText("On");
					gamesetting.setInstruction(true);}
			    }
			});
		    JButton Save = new JButton("Save");
		    Save.addActionListener(new ActionListener(){
			    public void actionPerformed(ActionEvent e)
			    {try{
				FileOutputStream fos = new FileOutputStream("GameSetting.ser");
				ObjectOutputStream os = new ObjectOutputStream(fos);
				os.writeObject(gamesetting);
				os.close();}
				catch(IOException ex){ex.printStackTrace();}}
			});
                    JButton Music = new JButton("Music");
                    Music.addActionListener(new ActionListener(){
			    public void actionPerformed(ActionEvent e)
			    {if (PlayOrStop.getText() == "On")
				    {PlayOrStop.setText("Off");
					gamesetting.setMusic(false);
                                        GameGUI.song.stop();}
				else
				    {PlayOrStop.setText("On");
					gamesetting.setMusic(true);
                                        GameGUI.song.play();
        				GameGUI.song.loop();}
			    }
			});
				
		    settingFrame.setLayout(new GridLayout(3,2,20,10));
		    settingFrame.add(instruction);
		    settingFrame.add(OnOrOff);
                    settingFrame.add(Music);
		    settingFrame.add(PlayOrStop);
		    settingFrame.add(Save);
		    settingFrame.setSize(400,100);
		    settingFrame.setLocationRelativeTo(null);
		    settingFrame.setVisible(true);}}
