package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility;

import java.net.*;
import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
    public Clip clip;
    public Sound(String soundFile) {
        //soundFile is a .wav audio file from music file
    	try {
    		File file = new File(soundFile);
    		if (file.exists()) {
    			AudioInputStream sound = AudioSystem.getAudioInputStream(file);
    			clip = AudioSystem.getClip();
    			clip.open(sound);
    		}
    		else {
    			throw new RuntimeException("Sound: RuntimeException Error: " + soundFile);
    		}
		}
		catch (MalformedURLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("Sound: Malformed URL Exception Error: " + ex);
		}
    	catch (UnsupportedAudioFileException ex) {
    		ex.printStackTrace();
    		throw new RuntimeException("Sound: Unsupported Audio File Exception Error: " + ex);
    	}
    	catch (IOException ex) {
    		ex.printStackTrace();
    		throw new RuntimeException("Sound: IOException Error: " + ex);
    	}
    	catch (LineUnavailableException ex) {
    		ex.printStackTrace();
    		throw new RuntimeException("Sound: Line Unavailable Exception Error: " + ex);
    	}
    }

    //starts the song for the beginning
    public void play(){
        clip.setFramePosition(0);
        clip.start();
    }

    public void stop(){
        clip.stop();
    }
    //continuously loops the sound track
    public void loop(){
    	clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
