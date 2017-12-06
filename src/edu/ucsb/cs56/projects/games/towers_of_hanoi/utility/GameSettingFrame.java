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

public class GameSettingFrame{
    GameSetting gamesetting;
    public void setSetting(GameSetting s){
	this.gamesetting = s;
    }
    public void go(){
	JFrame settingFrame = new JFrame("Setting");
	settingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	JButton instruction = new JButton("Instruction");
	JLabel playOrStop = new JLabel();
	if (gamesetting.getMusic())
	    playOrStop.setText("On");
	else
	    playOrStop.setText("Off");
            JLabel OnOrOff = new JLabel();
		if (gamesetting.getInstruction())
		    OnOrOff.setText("On");
		else
		    OnOrOff.setText("Off");
		    JLabel diskType = new JLabel(gamesetting.getdiskType());
		    JLabel colorS = new JLabel(gamesetting.getcolorS());
		    instruction.addActionListener(new ActionListener(){
			    public void actionPerformed(ActionEvent e){
				if (OnOrOff.getText() == "On"){
				    OnOrOff.setText("Off");
				    gamesetting.setInstruction(false);
                                 }
				else {
				OnOrOff.setText("On");
				gamesetting.setInstruction(true);
				}}
      });
    
    JButton Save = new JButton("Save");
    Save.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
	try{
	FileOutputStream fos = new FileOutputStream("GameSetting.ser");
	ObjectOutputStream os = new ObjectOutputStream(fos);
	os.writeObject(gamesetting);
	os.close();
	}
	catch(IOException ex){ex.printStackTrace();
	}}
	});

    JButton Music = new JButton("Music");
    Music.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
	if (playOrStop.getText() == "On"){
	playOrStop.setText("Off");
	gamesetting.setMusic(false);
	GameGUI.song.stop();}
	else{
	playOrStop.setText("On");
	gamesetting.setMusic(true);
	GameGUI.song.play();
	GameGUI.song.loop();
	}}
    });

    JButton Shape = new JButton("Shape");
    Shape.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
	gamesetting.setdiskType();
	diskType.setText(gamesetting.getdiskType());}});
	JButton Color = new JButton("Color");
	Color.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
	gamesetting.setColor();
	colorS.setText(gamesetting.getcolorS());}});
	settingFrame.setLayout(new GridLayout(5,2,20,10));
	settingFrame.add(instruction);
	settingFrame.add(OnOrOff);
	settingFrame.add(Music);
	settingFrame.add(playOrStop);
	settingFrame.add(Shape);
	settingFrame.add(diskType);
	settingFrame.add(Color);
	settingFrame.add(colorS);
	settingFrame.add(Save);
	settingFrame.setSize(400,200);
	settingFrame.setLocationRelativeTo(null);
	settingFrame.setVisible(true);
    }
}

