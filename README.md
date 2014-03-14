# cs56-games-towers-of-hanoi

W14 ready! (Jakob Staahl)

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

//ASCII Version//

![](http://i.imgur.com/T2eKHVT.png)

At each step, the game displays an ASCII representation of the current state of the towers.
To move a disk from one tower to another, the user types in the start tower number and the end tower number separated by a space.

The game counts the user's moves. When the user completes the puzzle, the game tells the user how many moves it took him/her, as well as how many moves the optimal solution would have been.

///GUI Version///

![](http://i.imgur.com/B8Cu2Vj.png)

First, enter how many disks you want for each tower to have.  The minimum is 3.  When you have entered a valid number, click "Done".

![](http://i.imgur.com/tKzJWyB.png)

When the game starts, so will the timer.  Click on a button to select that tower as the "from" tower and click on another button to select that as the "to" tower.  This will move the disk from the "from" Tower and to the "to" tower.  The "from" tower's button will deactivate upon selection so you cannot go from and to the same tower, plus it makes it easier to keep track of whether you are on the "to" or "from" selection.
