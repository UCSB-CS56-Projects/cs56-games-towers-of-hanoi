package edu.ucsb.cs56.projects.games.towers_of_hanoi.utility;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private final int TOWER_WIDTH;//Width of the tower
	private final int TOWER_OFFSET;//Horizontal space between towers
	private final int INITIAL_OFFSET;//the offset from the top of the panel
	private int sideOffset;//The horizontal space between the side towers and the side of the Panel
	private final Color TOWER_COLOR = new Color(0xe4cbab);//color of towers
	private final Color DISK_COLOR = new Color(0x8c4f00);//color of disks
	private int maxDisk;//value of the biggest disk possible on the towers
	private int towerHeight;//vertical height of the towers
	private int toTower, fromTower;//toTower: the number of the tower that a disk is being moved to; fromTower: value of the tower that a disk is being moved from
	private TowersOfHanoiState state;
	
	private ArrayList<ArrayList<Integer>> towers;
	private HanoiTimer timer;
	
	public GamePanel() {
		super();
		
		TOWER_WIDTH = 80;
		DISK_HEIGHT = 10;
		TOWER_OFFSET = 20;
		DISK_OFFSET = 20;
		INITIAL_OFFSET = 50;
		
		sideOffset = (this.getWidth()-(3*TOWER_WIDTH) - (2 * TOWER_OFFSET))/2;
		
		//adds 3 buttons for each tower
		for (int tower = 1; tower <= 3; tower ++) {
			JButton temp = new JButton(Integer.toString(tower));
			temp.addActionListener(new TowerButtonListener(tower));
			this.add(temp);
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (towers == null) {
			return;
		} else {
			sideOffset = (this.getWidth()-(3*TOWER_WIDTH) - (2 * TOWER_OFFSET))/2;
			
			for(int tower = 1; tower <= towers.size(); tower++) {
				g.setColor(TOWER_COLOR);
			
				// X coordinate of this tower
				int towerX = sideOffset + (TOWER_WIDTH+TOWER_OFFSET)*(tower-1);
				g.fillRect(towerX,INITIAL_OFFSET,TOWER_WIDTH,towerHeight);
			
				for (int j=towers.get(tower-1).size();j > 0;j--) {
					int offset =  DISK_OFFSET*((towers.get(tower-1).size()-j)-1);
					int y = (towerHeight + TOWER_OFFSET) - offset;
					
					//This is: (max disk width)-(ratio of width : # of disks)*(biggest disk value - this disk's value).  
					// Makes the bar width scale with # of disks and size of tower
					int diskWidth = TOWER_WIDTH - (TOWER_WIDTH/(maxDisk+1))*(maxDisk- towers.get(tower-1).get(j-1)); 
					
					int x = towerX+((TOWER_WIDTH-diskWidth)/2);
					g.setColor(DISK_COLOR);
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
	
	private class TowerButtonListener implements ActionListener {
	
		//this is the number that represents the tower
		int selectedTower;
	
		public TowerButtonListener(int selectedTower) {
			this.selectedTower = selectedTower;
		}
	
		@Override
		public void actionPerformed(ActionEvent arg0) {
		
			if(fromTower == 0) {
				
				if(arg0.getSource() instanceof JButton){
					//Disables the button clicked
					((JButton)arg0.getSource()).setEnabled(false);
				}

				fromTower = selectedTower;
				return;
			}
			
			if(toTower == 0){
				toTower = selectedTower;

				try {
					// -1 because the game calls the towers by 1-3 while the code calls them 0-2.  This also allows for 0 to represent unassigned for this method
					state.makeMove(fromTower-1, toTower-1);
				} catch (TowersOfHanoiIllegalMoveException e) {
					// Make this message display in the GUI
					System.out.println("Illegal Move");
				}
			
				for(Component c: GamePanel.this.getComponents()){//re-enables all the buttons so user can make next move
					c.setEnabled(true);
				}
		
				GamePanel.this.repaint();
			
				if (state.solved()) {
					state.handleWin();

					if (timer != null) {
						timer.stop();
					}

					Object[] options =  { "Replay", "Quit Game" };
			
					JOptionPane pane = new JOptionPane("Congratulations! You've won the game!", JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, options);

					JDialog dialog = pane.createDialog(GamePanel.this, "Towers");
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
			
			actionPerformed(arg0);
		}
	}
}

