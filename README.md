# cs56-games-towers-of-hanoi

project history
===============
```
 YES | mastergberry | amwexler | (jstaahl) A towers of hanoi GAME (not a solver or a simulation or an animation of the algorithm!)

 W14 | bkiefer13 5pm | amwexler | (jstaahl) A towers of hanoi GAME (not a solver or a simulation or an animation of the algorithm!)
```

A command line towers of hanoi game---not just a simulation, but a GAME

## Launching the Game

To launch the game using the command line, simply use the command:
```
ant run
```
When prompted by ant for the input-runargs, type in the number of starting disks you would like there to be and hit enter.


To launch the game using the GUI, simply use the command:
```
ant run-GUI
```

## Description

### ASCII Version

![](http://i.imgur.com/T2eKHVT.png)

#### Instructions for ASCII Version

At each step, the game displays an ASCII representation of the current state of the towers.
To move a disk from one tower to another, the user types in the start tower number and the end tower number separated by a space.

The game counts the user's moves. When the user completes the puzzle, the game tells the user how many moves it took him/her, as well as how many moves the optimal solution would have been.

### GUI Version

![](http://i.imgur.com/f0Slw59.png)

When game is first run. Menu frame pops up with a Play Button, Continue Button, Settings Button, and Exit Button. 

### Play Button

When play button is first clicked an Instructional window pops up like the one shown below. 

![](http://i.imgur.com/yswp0gG.png)

If you would like to continue playing the game after reading the instruction click yes. Else if you would like to go back to the main menu click no. 

After you have clicked yes. A new window will pop up asking you to enter how many disks you want each tower to have.  The minimum is 3.  When you have entered a valid number, click "Play". But if you would like to go back to the main menu click "Done".

![](http://i.imgur.com/HLflReh.png)

Once you click play the game window pops up. You are given a timer on top that continues to run until you are finished or pause the game.You are also given some instructions on the bottom part of the window. Everytime you click a tower the topmost block is highlighted with a particular color. Color of blocks can be changed in the settings button which is located in the main menu. 

There is also an options button that allows you to pause the game, reset the game by taking you to the main menu, a help button that gives you instructions of the game and save button that allows you to save the game data. 

![](http://i.imgur.com/1uKPXgZ.png)

If you make an illegal move, the game provides an alert. Tap the spacebar to dismiss it.

![](http://i.imgur.com/sVU2cVv.png)

Upon completion, the game provides feedback.

![](http://i.imgur.com/55AbwOY.png)

### Continue Button

When clicking the Continue button you are able to continue the last game state that you have saved after saving the game on the game frame using the options button. 

### Setting Button

When clicking the settings button you can change many features such as the shape of the block, the color of the block, turn music on or off, and turn the instructions on or off. After changing each feature on the settings frame you must make sure to click the save button before exiting out of the frame. 

![](http://i.imgur.com/cFVj15G.png)

#### Instructions for GUI Version

When the game starts, so will the timer.  Click on a tower to select its top disk and then click on another tower to move that disk there. Move all three disks to another tower to win the game.

GUI Audio

Because we included audio into the GUI version of this game, this game will not run through ssh but works perfectly fine on local computer or on CSIL computers (without ssh).

### F16 Final Remarks
This version of Tower of Hanoi game fulfils the basic requirement for a game, which has features like save and load, change of color of the blocks, pause and resume, restart, and instructions. However, there are some bugs exist in the current system. When the player pauses the game, just the timer pauses, which means that the player can still play with the blocks. This should not happen for a real pause, and should be fixed in later version.

Moreover, there are two features can be improved, save and load, and the graphics of the tower. In current version, only one game can be saved and it can be improved to have multiple game saved in same time and load by the choice of players.For the graphics, different skins of disks and the background of the tower  are prefered.

