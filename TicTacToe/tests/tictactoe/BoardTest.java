package tictactoe;

import junit.framework.TestCase;

public class BoardTest extends TestCase {
	
	public void testToStringAfterConstruccionReturnEmptyBoard() {
		Board board = new Board(3);
		String expected = " .  .  . \n .  .  . \n .  .  . \n";
		String value = board.toString();
		assertEquals(expected, value);
	}
	
	public void testIsEmptyCellAfterConstruccionReturnsTrueForAPosition21() {
		Board board = new Board(3);
		assertTrue(board.isEmptyCell(new Position(2,1)));
	}
}
