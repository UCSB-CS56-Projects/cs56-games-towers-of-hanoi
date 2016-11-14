package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import java.util.ArrayList;
import edu.ucsb.cs56.projects.games.towers_of_hanoi.model.TowersOfHanoiState;
import edu.ucsb.cs56.projects.games.towers_of_hanoi.model.TowersOfHanoiState.TowersOfHanoiIllegalMoveException;

/**
 * This extends JPanel and draws the towers and disks on each tower, given a TowersOfHanoiState.  It also contains buttons to move the disks from tower to tower 
 * @author amwexler
 *
 */

public class GamePanel extends JPanel {

    private final int DISK_HEIGHT;//height of each disk
    private final int DISK_OFFSET;//vertical space between each disk
    private int TOWER_WIDTH;//Width of the tower
    private final int TOWER_OFFSET;//Horizontal space between towers
    private final int INITIAL_OFFSET;//the offset from the top of the panel
    private int sideOffset;//The horizontal space between the side towers and the side of the Panel
    private final Color TOWER_COLOR = new Color(0xe4cbab);//color of towers
    private final Color DISK_COLOR = new Color(0x8c4f00);//color of disks
    private final Color SELECTED_DISK_COLOR = new Color(0x21da35);
    private final Color TOWER_ON_COLOR = new Color(0xccffff);//color of tower you clicked on
    private int maxDisk;//value of the biggest disk possible on the towers
    private int towerHeight;//vertical height of the towers
    private int toTower, fromTower;//toTower: the number of the tower that a disk is being moved to; fromTower: value of the tower that a disk is being moved from
    public static TowersOfHanoiState state = new TowersOfHanoiState();
    private TowerPanel tower1;
    private TowerPanel tower2;
    private TowerPanel tower3;
    private ArrayList<ArrayList<Integer>> towers;
    private HanoiTimer timer;
    
    public GamePanel() {
    	super();
		GameGUI.pauseTimer.addMouseListener(new PauseTimerListener());
   		GameGUI.resetGame.addMouseListener(new ResetGameListener());
    	DISK_HEIGHT = 10;
    	TOWER_OFFSET = 20;
    	DISK_OFFSET = 20;
    	INITIAL_OFFSET = 50;

    	sideOffset = (this.getWidth()-(3*TOWER_WIDTH) - (2 * TOWER_OFFSET))/2;
    }
    
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);

    	if (towers == null) {
    		return;
    	} else {
	    TOWER_WIDTH = 80 + maxDisk * 10;
    		sideOffset = (this.getWidth()-(3*TOWER_WIDTH) - (2 * TOWER_OFFSET))/2;

    		for(int tower = 1; tower <= towers.size(); tower++) {
    			g.setColor(TOWER_COLOR);

		// X coordinate of this tower
    			int towerX = sideOffset + (TOWER_WIDTH+TOWER_OFFSET)*(tower-1);
    			g.fillRect(towerX,INITIAL_OFFSET,TOWER_WIDTH,towerHeight);

    			if (tower == 1) {
    				if (tower1 == null) {
    					this.tower1 = new TowerPanel();
    					tower1.addMouseListener(new TowerPanelListener(1));
    				}

    				tower1.setBounds(towerX,INITIAL_OFFSET,TOWER_WIDTH,towerHeight);
    				this.tower1.setOpaque(false);
    				this.add(this.tower1); 
    			} else if (tower == 2) {
    				if (tower2 == null){
    					this.tower2 = new TowerPanel();
    					tower2.addMouseListener(new TowerPanelListener(2));
    				} 

    				tower2.setBounds(towerX,INITIAL_OFFSET,TOWER_WIDTH,towerHeight);
    				this.tower2.setOpaque(false);
    				this.add(this.tower2);
    			} else {
    				if (tower3 == null) {
    					this.tower3 = new TowerPanel();
    					tower3.addMouseListener(new TowerPanelListener(3));
    				}

    				tower3.setBounds(towerX,INITIAL_OFFSET,TOWER_WIDTH,towerHeight);
    				this.tower3.setOpaque(false);
    				this.add(this.tower3);
    			}

    			for (int j=towers.get(tower-1).size();j > 0;j--) {
    				int offset =  DISK_OFFSET*((towers.get(tower-1).size()-j)-1);
    				int y = (towerHeight + TOWER_OFFSET) - offset;

		    //This is: (max disk width)-(ratio of width : # of disks)*(biggest disk value - this disk's value).  
		    // Makes the bar width scale with # of disks and size of tower
    				int diskWidth = TOWER_WIDTH - (TOWER_WIDTH/(maxDisk+1))*(maxDisk- towers.get(tower-1).get(j-1)); 

    				int x = towerX+((TOWER_WIDTH-diskWidth)/2);
			        g.setColor(DISK_COLOR);
				if (tower == fromTower && j == 1)
				    {g.setColor(SELECTED_DISK_COLOR);}
    				g.fillRect(x,y,diskWidth,DISK_HEIGHT);
    			}
    		}
    	}
    }
    
    public void setState(TowersOfHanoiState s) {

    	state = s;
    	towers = s.getTowers();

	// This assigns maxBar to the # of bars - 1 which is the same as the max # that represents a bar 
	// (ie: max possible value returned by towers.get(a).get(b) )
    	maxDisk = towers.get(0).size()-1;
    	towerHeight = (maxDisk + 1) * 2 * DISK_HEIGHT;
    }
    
    public void setTimer(HanoiTimer timer) {
    	this.timer = timer;
    }
    
    public class PauseTimerListener implements MouseListener {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		if(GameGUI.pauseTimer.getText().equals(GameGUI.PAUSE_STR_LIT)){
    			//Pauses the time and changes the text of button to "Resume"
    			timer.pause();
    			GameGUI.pauseTimer.setText(GameGUI.RESUME_STR_LIT);
    			return;
    		}

    		else if(GameGUI.pauseTimer.getText().equals(GameGUI.RESUME_STR_LIT)){
    			//Resumes the time and changes the text of button to "Pause"
    			timer.resume();
    			GameGUI.pauseTimer.setText(GameGUI.PAUSE_STR_LIT);
    			return;
    		}
    	}

    	@Override
    	public void mouseReleased(MouseEvent e) {
    	}
    	@Override
    	public void mousePressed(MouseEvent e) {
    	}
    	@Override
    	public void mouseExited(MouseEvent e) {
    	}
    	@Override
    	public void mouseEntered(MouseEvent e) {
    	}
    }

    public class ResetGameListener implements MouseListener {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		//restarts the game
    		GUIMain.startGame();
    	}

    	@Override
    	public void mouseReleased(MouseEvent e) {
    	}
    	@Override
    	public void mousePressed(MouseEvent e) {
    	}
    	@Override
    	public void mouseExited(MouseEvent e) {
    	}
    	@Override
    	public void mouseEntered(MouseEvent e) {
    	}
    }


    private class TowerPanelListener implements MouseListener {
    	int selectedTower;


    	public TowerPanelListener(int selectedTower){
    		this.selectedTower = selectedTower;
    	}

    	@Override
    	public void mouseClicked(MouseEvent e) {

    		if(fromTower == 0) {
    			fromTower = selectedTower;
			GamePanel.this.repaint();
    			return;
    		}

    		if(toTower == 0){
    			toTower = selectedTower;

    			try {
		    // -1 because the game calls the towers by 1-3 while the code calls them 0-2.  This also allows for 0 to represent unassigned for this method
    				state.makeMove(fromTower-1, toTower-1);
    				GameGUI.countDisplay.setText(state.getNumOfMoves()+"");
		    //GameGUI.gamePanel.add(GameGUI.countDisplay, BorderLayout.CENTER);
    			} catch (TowersOfHanoiIllegalMoveException ex) {
    				JOptionPane.showMessageDialog(null, "This is an illegal move. You may not place a larger disk on top of a smaller disk.\nPlease place a smaller disk on a larger disk or place it on top of an empty tower.", "Illegal Move", JOptionPane.ERROR_MESSAGE);
    			}

    			GamePanel.this.repaint();

		// Check to see if game solved
    			if (state.solved()) {
    				state.handleWin();

    				if (timer != null) {
    					timer.stop();
    				}

    				Object[] options =  { "Replay", "Quit Game" };

		    int optimalSolution = (int) Math.pow(2,state.numOfDisks) - 1; // 2^n - 1 is the optimal solution for the game
		    
		    String winMessage = "Congratulations! You won the game in " + state.getNumOfMoves() + " moves!\n Optimal solution would have been " + optimalSolution + " moves.";
		    

		    JOptionPane pane = new JOptionPane(winMessage, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, options);
		    
		    JDialog dialog = pane.createDialog(GamePanel.this, "Towers of Hanoi");
		    dialog.show();
		    
		    Object selectedValue = pane.getValue();
		    
		    if (selectedValue.equals("Replay")) {
		    	System.out.println("Selected Replay");
		    	GUIMain.startGame();
		    } else {
		    	System.out.println("Selected Quit");
		    	System.exit(0);
		    }
		}
		toTower = 0;  fromTower = 0;
		return;
	}
	toTower = 0;  fromTower = 0;
}

@Override
public void mouseReleased(MouseEvent e) {
}
@Override
public void mousePressed(MouseEvent e) {
}
@Override
public void mouseExited(MouseEvent e) {
}
@Override
public void mouseEntered(MouseEvent e) {
}

}
}

