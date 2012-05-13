package tictactoe;

import junit.framework.TestCase;

public class BoardTests extends TestCase {

	/**
	 *  X | X | O
	 * ---+---+--- 
	 *  . | . | .
	 * ---+---+---
	 *  O | O | X
	 */
	private Board getBoard() {
		Board board = new Board();
		board.setValue(new Position(0,0), CellValue.CROSS);
		board.setValue(new Position(0,1), CellValue.CROSS);
		board.setValue(new Position(0,2), CellValue.NOUGHT);
		board.setValue(new Position(2,0), CellValue.NOUGHT);
		board.setValue(new Position(2,1), CellValue.NOUGHT);
		board.setValue(new Position(2,2), CellValue.CROSS);
		return board;
	}
	
	
	public void testCompleteLine_IfNoLineComplete_ReturnFalse() {
		assertFalse(getBoard().completesLine(new Position(0,0)));
	}
	
	public void testCompleteLine_IfLineComplete_ReturnTrue() {
		assertTrue(getBoard().completesLine(new Position(1,2)));
	}
	
	/**
	 *  X | X | O 
	 * ---+---+---
	 *  . | O | .
	 * ---+---+---
	 *  O | O | X
	 */
	private Board getLinesDiagonal() {
		Board board = new Board();
		board.setValue(new Position(0,0), CellValue.CROSS);
		board.setValue(new Position(0,1), CellValue.CROSS);
		board.setValue(new Position(0,2), CellValue.NOUGHT);
		board.setValue(new Position(2,0), CellValue.NOUGHT);
		board.setValue(new Position(2,1), CellValue.NOUGHT);
		board.setValue(new Position(1,1), CellValue.NOUGHT);
		board.setValue(new Position(2,2), CellValue.CROSS);
		return board;
	}
	
	public void testCompleteLine_IfDiagonalLineCompleteAndPositionNotBelongsTo_ReturnFalse() {
		assertFalse(getLinesDiagonal().completesLine(new Position(0,0)));
	}
	
	public void testCompleteLine_IfDiagonalLineCompleteAndPositionBelongsTo_ReturnTrue() {
		assertTrue(getLinesDiagonal().completesLine(new Position(2,0)));
	}
}
