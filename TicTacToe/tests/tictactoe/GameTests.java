package tictactoe;

import junit.framework.TestCase;

public class GameTests extends TestCase {
	
	public void testPlayFirst(){
		Game tictactoe = new Game();
		tictactoe.play(new Position(0,1));
		char actual = tictactoe.getBoard().getValue(new Position(0,1)).getValue();
		char expected = 'X';
		assertEquals(expected, actual);
	}
	
	public void testPlayFirstAndSecond(){
		Game tictactoe = new Game();
		tictactoe.play(new Position(1,1));
		tictactoe.play(new Position(0,0));
		char actual = tictactoe.getBoard().getValue(new Position(0,0)).getValue();
		char expected = 'O';
		assertEquals(expected, actual);
	}
	
	public void testIsGameOverAtTheBeginigReturnFalse() {
		Game tictactoe = new Game();
		assertFalse(tictactoe.isGameOver());
	}
	
	private Game playArray(Position[] positions) {
		Game tictactoe = new Game();
		for(int i = 0; i < positions.length; i++)
			tictactoe.play(positions[i]);
		return tictactoe;
	}
	
	/**
	 *  X | X | O 
	 * ---+---+--- 
 		O | O | X 
 	   ---+---+---
 		X | O | X   
	 */
	
	private Game tieGame() {
		Position[] positions = {new Position(0, 0), new Position(1, 1), 
				new Position(2, 2), new Position(0, 2), 
				new Position(0, 1), new Position(1, 0),
				new Position(2, 0), new Position(2, 1), 
				new Position(1, 2)};
		return playArray(positions);
	}
	
	public void testIsGameOverAtTheEndReturnTrue() {
		
		assertTrue(tieGame().isGameOver());
	}
	
	public void testPlayInANonEmptyCellReturnFalse() {
		Game tictactoe = new Game();
		tictactoe.play(new Position(2,1));
		assertFalse(tictactoe.play(new Position(2,1)));
	}
	
	/**
	 *  X | . | O 
	 * ---+---+---
 		O | X | . 
 	   ---+---+---
 		. | . | X  
	 */
	
	private Game gameWon() {
		Position[] positions = {new Position(0, 0), new Position(0, 2), 
				new Position(1, 1), new Position(1, 0), 
				new Position(2, 2)};
		return playArray(positions);
	}
	
	public void testIsGameOverIfAPlayerWinsReturnTrue() {
		assertTrue(gameWon().isGameOver());
	}
	
	public void testWinnerPlayerStatusIfAPlayerWins() {
		Game ticTacToe = gameWon();
		assertEquals(PlayerStatus.Winner, ticTacToe.inactivePlayer().getStatus());
	}
	
	public void testLoserPlayerStatusIfAPlayerWins() {
		Game ticTacToe = gameWon();
		assertEquals(PlayerStatus.Loser, ticTacToe.activePlayer().getStatus());
	}
	
	public void testPlayerStatusAfterATieGame() {
		assertEquals(PlayerStatus.Tie, tieGame().activePlayer().getStatus());
		assertEquals(PlayerStatus.Tie, tieGame().inactivePlayer().getStatus());
	}
	
	public void testIfGameOverReturnsFalse() {
		assertFalse(gameWon().play(new Position(0,1)));
	}
}
