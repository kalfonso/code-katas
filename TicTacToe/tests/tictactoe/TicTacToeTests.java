package tictactoe;

import junit.framework.TestCase;

public class TicTacToeTests extends TestCase {

	public void testGetBoard_AfterPlayFirstInPosition00_ReturnXFollowsByEmptyCells() {
		TicTacToe tictactoe = new TicTacToe();
		tictactoe.playFirst(new Position(0, 0));
		String expected = " x  .  . \n .  .  . \n .  .  . \n";
		String value = tictactoe.getBoard().toString();
		assertEquals(expected, value);
	}
	
	public void testPlay_TheFirstTimeInPosition00_ReturnXFollowsByEmptyCells() {
		TicTacToe tictactoe = new TicTacToe();
		tictactoe.play(new Position(0, 0));
		String expected = " x  .  . \n .  .  . \n .  .  . \n";
		String value = tictactoe.getBoard().toString();
		assertEquals(expected, value);
	}
	
	public void testGetBoard_AfterPlayFirst12AndSecond20_ReturnXAndOInThePositionAndTheRestEmpty() {
		TicTacToe tictactoe = new TicTacToe();
		tictactoe.playFirst(new Position(1, 2));
		tictactoe.playSecond(new Position(2, 0));
		String expected = " .  .  . \n .  .  x \n o  .  . \n";
		String value = tictactoe.getBoard().toString();
		assertEquals(expected, value);
	}
	
	public void testPlaySecond_IfSecondPlaysInANotEmptyCell_ThrowsIllegalArgumentException() {
		TicTacToe tictactoe = new TicTacToe();
		tictactoe.playFirst(new Position(1, 2));
		try {
			tictactoe.playSecond(new Position(1, 2));
			fail();
		} catch(IllegalArgumentException e) {
			assert(true);
		}
	}
	
	public void testPlayFirst_IfFirstPlaysInANotEmptyCell_ThrowsIllegalArgumentException() {
		TicTacToe tictactoe = new TicTacToe();
		tictactoe.playFirst(new Position(1, 2));
		tictactoe.playSecond(new Position(1, 1));
		try {
			tictactoe.playFirst(new Position(1, 2));
			fail();
		} catch(IllegalArgumentException e) {
			assert(true);
		}
	}
	
	public void testPlayFirst_IfFirstPlaysAfterFirst_ThrowsIllegalArgumentException() {
		TicTacToe tictactoe = new TicTacToe();
		tictactoe.playFirst(new Position(1, 2));
		try {
			tictactoe.playFirst(new Position(1, 1));
			fail();
		} catch(IllegalArgumentException e) {
			assert(true);
		}
	}
	
	public void testPlaySecond_IfSecondPlaysInFirstTurn_ThrowsIllegalArgumentException() {
		TicTacToe tictactoe = new TicTacToe();
		try {
			tictactoe.playSecond(new Position(1, 1));
			fail();
		} catch(IllegalArgumentException e) {
			assert(true);
		}
	}
	
	public void testPlaySecond_IfSecondPlaysAfterSecond_ThrowsIllegalArgumentException() {
		TicTacToe tictactoe = new TicTacToe();
		tictactoe.playFirst(new Position(1, 2));
		tictactoe.playSecond(new Position(2, 2));
		try {
			tictactoe.playSecond(new Position(1, 1));
			fail();
		} catch(IllegalArgumentException e) {
			assert(true);
		}
	}
	
	public void testIsGameOver_AtTheBegining_ReturnsFalse() {
		TicTacToe tictactoe = new TicTacToe();
		assertFalse(tictactoe.isGameOver());
	}
	
	/**
	 *  x  o  x
	 *  x  o  o
	 *  o  x  x
	 */
	public void testIsGameOver_WithAFullBoard_ReturnsTrue() {
		TicTacToe tictactoe = new TicTacToe();
		tictactoe.playFirst(new Position(0, 0));
		tictactoe.playSecond(new Position(0, 1));
		tictactoe.playFirst(new Position(0, 2));
		tictactoe.playSecond(new Position(1, 1));
		tictactoe.playFirst(new Position(1, 0));
		tictactoe.playSecond(new Position(1, 2));
		tictactoe.playFirst(new Position(2, 1));
		tictactoe.playSecond(new Position(2, 0));
		tictactoe.playFirst(new Position(2, 2));
		assertTrue(tictactoe.isGameOver());
	}
	
	/**
	 *  x  o  x
	 *  x  o  o
	 *  o  x  .
	 */
	public void testIsGameOver_WithAAlmostButNotFullBoard_ReturnsFalse() {
		TicTacToe tictactoe = new TicTacToe();
		tictactoe.playFirst(new Position(0, 0));
		tictactoe.playSecond(new Position(0, 1));
		tictactoe.playFirst(new Position(0, 2));
		tictactoe.playSecond(new Position(1, 1));
		tictactoe.playFirst(new Position(1, 0));
		tictactoe.playSecond(new Position(1, 2));
		tictactoe.playFirst(new Position(2, 1));
		tictactoe.playSecond(new Position(2, 0));
		assertFalse(tictactoe.isGameOver());
	}
	
	/**
	 *  x  x  x
	 *  .  o  o
	 *  .  .  .
	 */
	public void testIsGameOver_AfterCompleteALine_ReturnsTrue() {
		TicTacToe tictactoe = new TicTacToe();
		tictactoe.playFirst(new Position(0, 0));
		tictactoe.playSecond(new Position(1, 1));
		tictactoe.playFirst(new Position(0, 1));
		tictactoe.playSecond(new Position(1, 2));
		tictactoe.playFirst(new Position(0, 2));
		assertTrue(tictactoe.isGameOver());
	}
}
