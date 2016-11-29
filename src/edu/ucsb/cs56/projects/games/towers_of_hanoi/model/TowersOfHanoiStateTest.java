package edu.ucsb.cs56.projects.games.towers_of_hanoi.model;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 *The Test class TowersOfHanoiStateTest for TowersOfHanoiState class.
 *@author Roeland Singer-Heinze
 *@version CS56, 13S, proj1
 *@see TowersOfHanoiState
 */


public class TowersOfHanoiStateTest{

    /**
     Test no argument constructor TowersOfHanoiState.
     Should initialize game with 3 starting disks.
     @see TowersOfHanoiState#TowersOfHanoiState
     */

    @Test public void noArgumentConstructorTest(){

	TowersOfHanoiState letsPlay = new TowersOfHanoiState();
	ArrayList<ArrayList<Integer>> towers = new ArrayList<ArrayList<Integer>>(3);
	towers.add(0, new ArrayList<Integer>(Arrays.asList(0, 1, 2)));
	towers.add(1, new ArrayList<Integer>(3));
	towers.add(2, new ArrayList<Integer>(3));

	assertEquals(towers, letsPlay.getTowers());

    }
      
    /**
     Test constructor TowersOfHanoiState with argument for number of disks.
     Should initialize game with number of disks specified.
     @see TowersOfHanoiState#TowersOfHanoiState
     */

    @Test public void constructorWithArgument1(){
        TowersOfHanoiState letsPlay = new TowersOfHanoiState(-5);
	ArrayList<ArrayList<Integer>> towers = new ArrayList<ArrayList<Integer>>(3);
        towers.add(0, new ArrayList<Integer>(Arrays.asList(0, 1, 2)));
        towers.add(1, new ArrayList<Integer>(3));
        towers.add(2, new ArrayList<Integer>(3));

        assertEquals(towers, letsPlay.getTowers());
    }

    /**
     Test constructor TowersOfHanoiState with argument for number of disks.
     Should initialize game with number of disks specified.
     @see TowersOfHanoiState#TowersOfHanoiState
     */


    @Test public void constructorWithArgument2(){

        TowersOfHanoiState letsPlay = new TowersOfHanoiState(5);
	ArrayList<ArrayList<Integer>> towers = new ArrayList<ArrayList<Integer>>(3);
	towers.add(0, new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4)));
        towers.add(1, new ArrayList<Integer>(5));
        towers.add(2, new ArrayList<Integer>(5));

        assertEquals(towers, letsPlay.getTowers());
    }

    /**
     Test getIsGameSolved getter method which returns the boolean value isGameSolved
     @see TowersOfHanoiState#getIsGameSolved
     */

    @Test public void getIsGameSolved_Test(){

	TowersOfHanoiState letsPlay = new TowersOfHanoiState(5);

	assertFalse(letsPlay.getIsGameSolved());
    }

    /**
     *Test getNumOfMoves getter method which returns the integer value numOfMoves.
     *@see TowersOfHanoiState#getNumOfMoves
     */

    @Test public void getNumOfMoves_Test(){

	TowersOfHanoiState letsPlay = new TowersOfHanoiState(5);
	assertEquals(letsPlay.getNumOfMoves(), 0);
    }


    /**
     *Test isMoveLegal method (returns false if move is illegal)
     *@see TowersOfHanoiState#isMoveLegal
     */

    @Test public void isMoveLegal_Test1(){

        TowersOfHanoiState letsPlay = new TowersOfHanoiState();
	boolean aMove = letsPlay.isMoveLegal(0, 2);
	assertTrue(aMove);
    }

    /**
     *Test isMoveLegal method (returns false if move is illegal)
     *@see TowersOfHanoiState#isMoveLegal
     *@throws TowersOfHanoiState.TowersOfHanoiIllegalMoveException maybe thrown because the test may produce an illegal move in the game. 
     */

    @Test public void isMoveLegal_Test2() throws TowersOfHanoiState.TowersOfHanoiIllegalMoveException{

        TowersOfHanoiState letsPlay = new TowersOfHanoiState();
	try {
	letsPlay.makeMove(0, 2);
	} catch (TowersOfHanoiState.TowersOfHanoiIllegalMoveException e) {
	    System.err.println("TowersOfHanoiIllegalMoveException: " + e.getMessage());
	    throw new TowersOfHanoiState.TowersOfHanoiIllegalMoveException(e);

	} 

        boolean aMove = letsPlay.isMoveLegal(0, 2);
        assertFalse(aMove);
	
    }


    /**
     *Test makeMove method, which moves disk from one tower to another.
     *@see TowersOfHanoiState#makeMove
     *@throws TowersOfHanoiState.TowersOfHanoiIllegalMoveException maybe thrown because the test may produce an illegal move in the game. 
     */

    @Test public void makeMove_Test1() throws TowersOfHanoiState.TowersOfHanoiIllegalMoveException{

        TowersOfHanoiState letsPlay = new TowersOfHanoiState();
	try{
	letsPlay.makeMove(0, 2);
	} catch (TowersOfHanoiState.TowersOfHanoiIllegalMoveException e) {
            System.err.println("TowersOfHanoiIllegalMoveException: " + e.getMessage());
            throw new TowersOfHanoiState.TowersOfHanoiIllegalMoveException(e);

        }
	ArrayList<Integer> tower1 = new ArrayList<Integer>(Arrays.asList(1,2));
	ArrayList<Integer> tower2 = new ArrayList<Integer>(Arrays.asList(0));

	assertEquals(tower1, letsPlay.getTowers().get(0));
	assertEquals(tower2, letsPlay.getTowers().get(2));
	assertEquals(letsPlay.getNumOfMoves(), 1);
    }

    /**
     *Test makeMove method, which moves disk from one tower to another.
     *@see TowersOfHanoiState#makeMove
     *@throws TowersOfHanoiState.TowersOfHanoiIllegalMoveException maybe thrown because the test may produce an illegal move in the game. 
     */

    @Test public void makeMove_Test2() throws TowersOfHanoiState.TowersOfHanoiIllegalMoveException{

        TowersOfHanoiState letsPlay = new TowersOfHanoiState(5);
	try{
        letsPlay.makeMove(0, 2);
	letsPlay.makeMove(0, 1);
	} catch (TowersOfHanoiState.TowersOfHanoiIllegalMoveException e) {
	    System.err.println("TowersOfHanoiIllegalMoveException: " + e.getMessage());
	    throw new TowersOfHanoiState.TowersOfHanoiIllegalMoveException(e);

	}

        ArrayList<Integer> tower1 = new ArrayList<Integer>(Arrays.asList(2, 3, 4));
        ArrayList<Integer> tower2 = new ArrayList<Integer>(Arrays.asList(0));

        assertEquals(tower1, letsPlay.getTowers().get(0));
        assertEquals(tower2, letsPlay.getTowers().get(2));
	assertEquals(letsPlay.getNumOfMoves(), 2);
    }


    /**
     *Test makeMove method, which moves disk from one tower to another.
     *@see TowersOfHanoiState#makeMove
    */

    @Test public void makeMove_TestException(){

        TowersOfHanoiState letsPlay = new TowersOfHanoiState();
	try{
	letsPlay.makeMove(0, 2);
        letsPlay.makeMove(0, 2);// should cause exception
	} catch (TowersOfHanoiState.TowersOfHanoiIllegalMoveException e){

	}
    }

    /**
     *Test disksOnTower method, which returns an integer array of the disks on given tower.
     *@see TowersOfHanoiState#disksOnTower
     */

    @Test public void disksOnTower_Test(){

        TowersOfHanoiState letsPlay = new TowersOfHanoiState(5);

	int[] tower1 = letsPlay.disksOnTower(  letsPlay.getTowers().get(0));
 
	int[] TestArray = {0, 1, 2, 3, 4};

	assertArrayEquals(tower1, TestArray);

    }

    /**
     *Test toString method which returns an ASCII art representation of game state.
     *@see TowersOfHanoiState#toString
     */

    @Test public void toString_Test1(){

	TowersOfHanoiState letsPlay = new TowersOfHanoiState();

	String testString = "    |    \t    |    \t    |    \n"
                          + "   =|=   \t    |    \t    |    \n"
                          + "  ==|==  \t    |    \t    |    \n"
                          + " ===|=== \t    |    \t    |    \n"
                          + "----+----\t----+----\t----+----\n"
	                  + "    0    \t    1    \t    2    \n";

	assertEquals(testString, letsPlay.toString());
		     
    }

    /**
     *Test toString method which returns an ASCII art representation of game state.
     *@see TowersOfHanoiState#toString
     *@throws TowersOfHanoiState.TowersOfHanoiIllegalMoveException maybe thrown because the test may produce an illegal move in the game. 
     */

    @Test public void toString_Test2() throws TowersOfHanoiState.TowersOfHanoiIllegalMoveException{

	TowersOfHanoiState letsPlay = new TowersOfHanoiState(5);
	try {
        letsPlay.makeMove(0, 2);
        letsPlay.makeMove(0, 1);
        } catch (TowersOfHanoiState.TowersOfHanoiIllegalMoveException e) {
	    System.err.println("TowersOfHanoiIllegalMoveException: " + e.getMessage());
	    throw new TowersOfHanoiState.TowersOfHanoiIllegalMoveException(e);

	}

        String testString = "      |      \t      |      \t      |      \n"
                          + "      |      \t      |      \t      |      \n"
                          + "      |      \t      |      \t      |      \n"
                          + "   ===|===   \t      |      \t      |      \n"
                          + "  ====|====  \t      |      \t      |      \n"
                          + " =====|===== \t    ==|==    \t     =|=     \n"
                          + "------+------\t------+------\t------+------\n"
	                  + "      0      \t      1      \t      2      \n";

        assertEquals(testString, letsPlay.toString());
		     

    }    

    /**
     *Test solved method which returns boolean value indicating if game is solved.
     *@see TowersOfHanoiState#solved
     */

    @Test public void solved_Test1(){

        TowersOfHanoiState letsPlay = new TowersOfHanoiState(5);

	assertFalse(letsPlay.solved());

    }


    /**
     *Test solved method which returns boolean value indicating if game is solved.
     *@see TowersOfHanoiState#solved
     *@throws TowersOfHanoiState.TowersOfHanoiIllegalMoveException maybe thrown because the test may produce an illegal move in the game. 
     */

    @Test public void solved_Test2() throws TowersOfHanoiState.TowersOfHanoiIllegalMoveException{

        TowersOfHanoiState letsPlay = new TowersOfHanoiState();
	try{
        letsPlay.makeMove(0, 2);
        letsPlay.makeMove(0, 1);
	letsPlay.makeMove(2, 1);
        letsPlay.makeMove(0, 2);
        letsPlay.makeMove(1, 0);
        letsPlay.makeMove(1, 2);
        letsPlay.makeMove(0, 2);
	} catch (TowersOfHanoiState.TowersOfHanoiIllegalMoveException e) {
            System.err.println("TowersOfHanoiIllegalMoveException: " + e.getMessage());
            throw new TowersOfHanoiState.TowersOfHanoiIllegalMoveException(e);

        }

	
        assertTrue(letsPlay.solved());

    }


}
