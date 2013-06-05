package edu.ucsb.cs56.projects.games.towers_of_hanoi.view;
import edu.ucsb.cs56.projects.games.towers_of_hanoi.model.TowersOfHanoiState;
import java.util.Scanner;


public class CmdLineHanoi{





    public static void main(String [] args) throws TowersOfHanoiState.TowersOfHanoiIllegalMoveException{

	int disks, fromTower, toTower;
	String[] input; // For while loop later where we prompt user for a move

	if (args.length == 0){

	    System.out.println("Proper Usage: CmdLineHanoi is a command line interface that takes in an integer (Number of disks) for a Towers of Hanoi game.");

	    System.exit(0);
	}

	else if (args.length > 0) {
	    try {
		disks = Integer.parseInt(args[0]);
	    } catch (NumberFormatException e) {
		disks = 0;
		System.err.println("Argument must be an integer");
		return;
	    }
	}

	disks = Integer.parseInt(args[0]); //Redudant, but compiler
					   //gives might not have been
					   //initliazed error
					   //otherwise
	if (disks < 3) //minimum 3 disks
	    disks = 3;
    
	TowersOfHanoiState letsPlay = new TowersOfHanoiState(disks); // Our instance of the game

	loops: //For redirecting code if input is correct, kind of like a goto statement
	while (! letsPlay.getIsGameSolved()){ //While game is not solved


	    System.out.println(letsPlay); // Print game state with tostring method to System.out


	    System.out.println("Please input two integers for the from tower and to tower to indicate a move. (Type 'q' to quit).");

	    Scanner userInput = new Scanner(System.in);

	    input = userInput.nextLine().split(" +"); //input string array split between spaces
            if (input[0].equals("q"))
                return; //Quit program if they typed q


	    for ( int x = 0; x < 2; x++ ){
		input[x] = input[x].replaceAll("[-\\D+]",""); //Get rid of anything in string that's not a digit
		if ( input[x].equals("")){ //If there were no digits, then it's incorrect format.

		    System.out.println("Incorrect format. Please input two integers seperated with a space (i.e. \"0 2\").");
		    continue loops; // go to loops: above and we can input integers again
		}

	    }

	
	    fromTower = Integer.parseInt(input[0]);
	    toTower = Integer.parseInt(input[1]);
	    
	    if ( fromTower < 0 || fromTower > 2 ){
                System.out.println("Illegal move. Towers are labelled 0, 1, 2.");
                continue;
	    }

            if ( toTower < 0 || toTower > 2 ){
                System.out.println("Illegal move. Towers are labelled 0, 1, 2.");
                continue;
            }


	    if ( ! letsPlay.isMoveLegal(fromTower, toTower) ){
		System.out.println("Illegal move. Cannot move this disk to that tower.");
		continue;
	    }
 
	    letsPlay.makeMove(fromTower,toTower);
	    letsPlay.solved();// Check if game is solved

	}

	int optimalSolution = (int) Math.pow(2,disks) - 1; // 2^n - 1 is the optimal solution for the game

	System.out.println(letsPlay); // game is solved now
	System.out.println("Congratulations! You solved the game in " + letsPlay.getNumOfMoves()
                           + " steps. Optimal solution would have been " + optimalSolution
                           + " steps." ); 
    

    }





}
