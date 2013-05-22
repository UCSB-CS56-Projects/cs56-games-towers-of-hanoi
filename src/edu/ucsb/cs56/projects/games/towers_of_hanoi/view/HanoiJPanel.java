import java.awt.Graphics;
import javax.swing.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.Color;

class HanoiJPanel extends JPanel {
	String from, to;
	int iFrom, iTo, coordFrom, coordTo;
	String numDisks;
	int intNumDisks = 0;
	static boolean firstScreen;
	
	
	private BufferedImage bufferedImage;

    
    public HanoiJPanel(){
    	
	}
    
    	
    
    
    public HanoiJPanel(boolean firstScreen){
    	
    	this.firstScreen = firstScreen;
    	if(firstScreen == false){
    		setPreferredSize(new Dimension(300,-350));
    		setBackground(Color.CYAN);
    		ActionListener al = new ActionListener(){
    			public void actionPerformed(ActionEvent ae){
    				repaint();
    			}
    		}; // action event for the Timer
		
    		
    		setPreferredSize( new Dimension(300,-350));
    		setBackground(Color.CYAN);
		
    		from = JOptionPane.showInputDialog("Which column do you want to move from?");
    		to = JOptionPane.showInputDialog("move to where?");
    		
    		this.iFrom = Integer.parseInt(from);
		this.iTo = Integer.parseInt(to);
		if (this.iFrom < 1 || this.iFrom > 3 || this.iTo < 1 || this.iTo > 3)
				JOptionPane.showMessageDialog(null,"Wrong Input");
			else{
				this.coordFrom = iFrom * 100;
				this.coordTo = iTo * 100;

				firstScreen = false;
			}

			System.out.println("2nd constructor");

    	}
    	else if(firstScreen == true){
        	setPreferredSize(new Dimension(300,100));
        	setBackground(Color.CYAN);
    		ActionListener al = new ActionListener(){
    			public void actionPerformed(ActionEvent ae){
    				repaint();
    			}
    		}; // action event for the Timer
    		
    			numDisks = JOptionPane.showInputDialog("input number of disks (anything over 3 is probably a bad idea)");
    			this.intNumDisks = Integer.parseInt(numDisks);
    			firstScreen = true;
    	}
    }
    
    public void paintComponent(Graphics g){
    	super.paintComponent(g);
    	g.setColor(Color.MAGENTA);
    	g.fillRect(100, 50, 10, 450);
    	g.setColor(Color.YELLOW);
    	g.fillRect(245, 50, 10, 450);
    	g.setColor(Color.RED);
    	g.fillRect(390, 50, 10, 450);
    	
    	g.setColor(Color.BLACK);
    	g.drawString("1", 100, 40);
    	g.drawString("2", 245, 40);
    	g.drawString("3", 390, 40);
    	
    	g.setColor(Color.WHITE);
    	if(firstScreen == true){
    		for (int i = 0; i< intNumDisks; i++){
    			g.fillRect(95 -i*5, 450 -(intNumDisks -i)*20 , 20 + i*10, 10);
    		}
    	}
    	else if(firstScreen == false){
    		for(int i = 0; i< intNumDisks; i++){ //stub for testing whether repainted JPanel
    			int move = (iTo - 1) * 150;
    			g.fillRect(95 -i*5 - move, 450 -(intNumDisks -i)*20 , 20 + i*10, 10);
    			//g.setColor(Color.BLACK);
    			//g.fillRect(0, 0 , 300, 300);
    		}
    	}

    	
    }

}
