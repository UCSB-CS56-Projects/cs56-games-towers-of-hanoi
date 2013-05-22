package edu.ucsb.cs56.projects.games.towers_of_hanoi.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

import java.awt.event.*;

class SwingHanoiJFrame extends JFrame{
	
	static int intFrom, intTo;
	static String from, to;
	static boolean init, stillGaming;
	
	static JPanel container = new JPanel();
	static SwingHanoiJFrame f = new SwingHanoiJFrame();
	
	private JButton makeMove = new JButton("make a move");

	
    public SwingHanoiJFrame() {

        super("Towers of Hanoi");
        setSize(500,500);
        setLocation(10,200);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
  
    }
    
	private void initComponents(){
		
		init = true;
		stillGaming = true;

			container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

			JPanel hanoi = new HanoiJPanel(init);
			container.add(hanoi);

			JButton makeMove = new JButton("make a move");
			container.add(makeMove);
			
			f.add(container);
			
			f.setSize(500,500);
			f.setVisible(true);
			
		makeMove.addActionListener( new ActionListener(){
			
			public void actionPerformed(ActionEvent actionEvent){
			
				makeMoveButtonActionPerformed( actionEvent );
			}
		});
	}
    
        
    private void makeMoveButtonActionPerformed(ActionEvent actionEvent) {
    
    	init = false;
    	stillGaming = true;
    	HanoiJPanel hanoi = new HanoiJPanel(init);// TODO Auto-generated method stub
    	updateFrame(hanoi);
			
    }

    
    private void updateFrame(HanoiJPanel panel){
    	container.add(panel);
    	
    	//container.add(makeMove);
    	stillGaming = true;
    	
		f.add(container);
		f.setSize(500,500);
		f.setVisible(true);
    }
    
    public void run(){
    	initComponents();
    	while(stillGaming && (init==false)){
    		f.removeAll();
    		HanoiJPanel hanoi = new HanoiJPanel(false);
    		updateFrame(hanoi);
    	}
    }


    public static void main(String[] args) {

    	SwingHanoiJFrame game = new SwingHanoiJFrame();
    	game.run();		

	}

    
    
}
