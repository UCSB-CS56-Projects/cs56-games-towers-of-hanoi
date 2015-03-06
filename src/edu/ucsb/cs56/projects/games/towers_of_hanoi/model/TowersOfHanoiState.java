package edu.ucsb.cs56.projects.games.towers_of_hanoi.model;
import java.util.ArrayList;
import java.util.Arrays;

/** TowersOfHanoiState models the state of a game based on Towers of Hanoi.
    
    
 */


public class TowersOfHanoiState{
    
    
    private boolean isGameSolved = false;
    private int numOfMoves = 0;
    private int numOfDisks;
    private ArrayList<ArrayList<Integer>> towers 
	= new ArrayList<ArrayList<Integer>>(3); //the 3 towers and their disks will be stored here
    
    
    /**
       Inner class, defining a specific exception for TowersOfHanoiState where move is illegal
    */

    public static class TowersOfHanoiIllegalMoveException extends Exception{
	
	public TowersOfHanoiIllegalMoveException(){}
	
	public TowersOfHanoiIllegalMoveException(String message){
	    
	    super(message);
	}
	
	public TowersOfHanoiIllegalMoveException(Throwable cause){
	    
	    super(cause);
	}

    }
    
    
    /**
       No argument constructor which initializes a game starting with 3 disks.
     */
    
    public TowersOfHanoiState(){
	
	towers = new ArrayList<ArrayList<Integer>>(3);
        towers.add(0, new ArrayList<Integer>(Arrays.asList(0, 1, 2)));
        towers.add(1, new ArrayList<Integer>(3));
        towers.add(2, new ArrayList<Integer>(3));
	this.numOfDisks = 3;
    }

    /**
     *TowersOfHanoiState constructor with argument for number of disks.
     *Should initialize game with number of disks specified.
     *@param numOfDisks is an integer number specifying number of disks for game
     */
    
    public TowersOfHanoiState(int numOfDisks){
	
	if (numOfDisks <= 3 ){ // Want a minimum of 3 disks

	    towers = new ArrayList<ArrayList<Integer>>(3);
	    towers.add(0, new ArrayList<Integer>(Arrays.asList(0, 1, 2)));
	    towers.add(1, new ArrayList<Integer>(3));
	    towers.add(2, new ArrayList<Integer>(3));
	    this.numOfDisks = 3;
	}
	
	else { // else user input is number of disks
	    
	    towers = new ArrayList<ArrayList<Integer>>(3);
            towers.add(0, new ArrayList<Integer>(numOfDisks));
            towers.add(1, new ArrayList<Integer>(numOfDisks));
            towers.add(2, new ArrayList<Integer>(numOfDisks));
	    for (int x = 0; x < numOfDisks; x++){
		towers.get(0).add(x);
	    }
	    this.numOfDisks = numOfDisks;
	}
	
    }

    /**
     Getter method which returns the boolean value isGameSolved
     @return boolean value isGameSolved in TowersOfHanoiState
     */
    
    public boolean getIsGameSolved(){


	return isGameSolved; 
    }

    /**
     Getter method which returns the integer value numOfMoves.
     @return integer value numOfMoves in TowersOfHanoiState
     */

    public int getNumOfMoves(){

	return numOfMoves;
    }


    /**
     Getter method which returns the ArrayList reference towers.
     @return ArrayList value towers in TowersOfHanoiState
     */

    public ArrayList<ArrayList<Integer>> getTowers(){

	return towers;

    }

    /**
     Given the index of two towers, this  method determines whether a given move is legal.
     @param indexFromTower is an integer representing which tower you want to move a disk from.
     @param indexToTower is an integer representing which tower you want to move a disk to.
     @return boolean value true if move is legal, false if illegal.
     */


    public boolean isMoveLegal(int indexFromTower, int indexToTower){

	if (towers.get(indexFromTower).isEmpty())
	    return false;

        else if (towers.get(indexToTower).isEmpty())
            return true;

	else if (towers.get(indexFromTower).get(0) < towers.get(indexToTower).get(0))
	    return true;

	else 
	    return false;

    }

    /**
     Given the index number of two towers, this method will move the top disk from one tower to the other. Throws input/output exception if move is illegal.
     @param indexFromTower is an integer representing which tower you want to move a disk from.
     @param indexToTower is an integer representing which tower you want to move a disk to.
     */

    public void makeMove(int indexFromTower, int indexToTower) throws TowersOfHanoiIllegalMoveException {


	if ( !(this.isMoveLegal(indexFromTower, indexToTower)) )
	    throw new TowersOfHanoiIllegalMoveException();

	else {

	    int x = towers.get(indexFromTower).get(0);
	    towers.get(indexFromTower).remove(0); //Remove top disc of fromTower
	    towers.get(indexToTower).add(0,x); //Put this disc on top of toTower

	    numOfMoves++;
	}

    }

    /**
     Given a tower, this method returns an array with the disk numbers on the tower.
     @param tower is an ArrayList which contains the disks on the tower
     @return an integer array containing the disks of the given tower
     */

    public int [] disksOnTower(ArrayList<Integer> tower){


	int [] arr = new int[tower.size()];
	for (int i = 0; i < tower.size(); i ++)
	    arr[i] = tower.get(i);
	return arr; 
    }

    /**
     A toString method that returns an ASCII art representation of the towers as a string.
     @return a String that represents the game state complete with newline characters.
     */

    public String toString(){

	String picture = "";
	String assister = ""; //Used solely to help us draw
	String assister2 = ""; //Another helper	
	String assister3 = "";
	String assister4 = "";


	for (int x = 0; x <= numOfDisks; x++){
	    assister = assister +" ";
	    assister3 = assister3 + "-";
	}

	assister2 = assister;	
	assister4 = assister;

	picture = assister + "|" + assister +"\t" + assister + "|" + assister + "\t" 
	        + assister +"|" + assister +"\n"; //top line

	for ( int i = numOfDisks - 1; i >= 0 ; i--){
	    for (int k = 0; k < 3; k++){
		int a;
		if (towers.get(k).size() <= i)
		    a = -1;
		else
		    a = towers.get(k).get(towers.get(k).size() - i -1); //number of "="'s

		for (int b = 0; b <= a; b++){

		    assister = assister.substring(1, numOfDisks+1)+ "=";
		    assister2 = "=" + assister2.substring(0,numOfDisks);
		}

		picture = picture + assister + "|" + assister2;

		assister = assister4; 
		assister2 = assister4; //reset them

		if ( (k % 3) == 2)
		    picture = picture + "\n";
		else 
		    picture = picture + "\t";

	    }
	}


	picture = picture + assister3 + "+" + assister3 +"\t" + assister3 + "+" + assister3 + "\t" + assister3                    + "+" + assister3 +"\n";

	picture = picture + assister4 + "0" + assister4 +"\t" + assister4 + "1" + assister4 + "\t"+ assister4                     + "2" + assister4 +"\n";

	return picture;

    }


    /**
     This is a method to determine whether the game has been solved yet.
     @return a boolean value true if game is solved, false otherwise.
     */
    
    public boolean solved(){
	
	int [] arr = new int[numOfDisks];
	for (int x = 0; x < numOfDisks; x++)
	    arr[x] = x;
	
	if (Arrays.equals(arr, disksOnTower(towers.get(1))) || Arrays.equals(arr, disksOnTower(towers.get(2)))){
	    isGameSolved = true;
	    return true;
	}
	else 
	    return false;
    }
    
    /**
     * 
     */
    public void handleWin(){
    	int optimalSolution = (int) Math.pow(2,numOfDisks) - 1; // 2^n - 1 is the optimal solution for the game
    	System.out.println("Congratulations! You solved the game in " + this.getNumOfMoves()
                               + " steps. Optimal solution would have been " + optimalSolution
			   + " steps." ); 
    }   
}
