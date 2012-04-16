package tictactoe;

import junit.framework.TestCase;

public class LineCheckerTests extends TestCase {
	private Board board;
	private LineChecker lineChecker;
	
	protected void setUp() { 
		board = new Board(3);
		lineChecker = new LineChecker(board);
	}

	public void testIsRowComplete_AtTheBeginning_ReturnsFalse() {
		assertFalse(lineChecker.isRowComplete(0));
	}

	public void testIsColumnComplete_AtTheBeginning_ReturnsFalse() {
		assertFalse(lineChecker.isColumnComplete(0));
	}

	public void testIsTopLeftDiagonalComplete_AtTheBeginning_ReturnsFalse() {
		assertFalse(lineChecker.isTopLeftDiagonalComplete());
	}

	public void testIsTopRightDiagonalComplete_AtTheBeginning_ReturnsFalse() {
		assertFalse(lineChecker.isTopRightDiagonalComplete());
	}
	
	/**
	 *  x  x  x 
	 *  .  .  .
	 *  .  .  .
	 */
	public void testIsRowComplete_IfFirstRowCompleteWithFirstValue_ReturnsTrue() {
		board.setValue(new Position(0,0), CellValue.FIRST_VALUE);
		board.setValue(new Position(0,1), CellValue.FIRST_VALUE);
		board.setValue(new Position(0,2), CellValue.FIRST_VALUE);
		assertTrue(lineChecker.isRowComplete(0));
	}
	
	/**
	 *  .  .  .
	 *  o  o  o 
	 *  .  .  .
	 */
	public void testIsRowComplete_IfSecondRowCompleteWithSecondValue_ReturnsTrue() {
		board.setValue(new Position(1,0), CellValue.SECOND_VALUE);
		board.setValue(new Position(1,1), CellValue.SECOND_VALUE);
		board.setValue(new Position(1,2), CellValue.SECOND_VALUE);
		assertTrue(lineChecker.isRowComplete(1));
	}
	
	/**
	 *  .  .  x
	 *  .  .  x
	 *  .  .  x
	 */
	public void testIsColumnComplete_IfThirdColumnCompleteWithFirstValue_ReturnsTrue() {
		board.setValue(new Position(0,2), CellValue.FIRST_VALUE);
		board.setValue(new Position(1,2), CellValue.FIRST_VALUE);
		board.setValue(new Position(2,2), CellValue.FIRST_VALUE);
		assertTrue(lineChecker.isColumnComplete(2));
	}
	
	/**
	 *  o  .  . 
	 *  .  o  .
	 *  .  .  o
	 */
	public void testIsTopLeftDiagonalComplete_IfCompleteWithSecondValue_ReturnsTrue() {
		board.setValue(new Position(0,0), CellValue.SECOND_VALUE);
		board.setValue(new Position(1,1), CellValue.SECOND_VALUE);
		board.setValue(new Position(2,2), CellValue.SECOND_VALUE);
		assertTrue(lineChecker.isTopLeftDiagonalComplete());
	}
	
	/**
	 *  .  .  x 
	 *  .  x  .
	 *  x  .  .
	 */
	public void testIsTopRightDiagonalComplete_IfCompleteWithFirstValue_ReturnsTrue() {
		board.setValue(new Position(0,2), CellValue.FIRST_VALUE);
		board.setValue(new Position(1,1), CellValue.FIRST_VALUE);
		board.setValue(new Position(2,0), CellValue.FIRST_VALUE);
		assertTrue(lineChecker.isTopRightDiagonalComplete());
	}
	
	public void testLineExist__AtTheBeginning_ReturnsFalse(){
		assertFalse(lineChecker.lineExist(new Position(1, 1)));
	}
	
	/**
	 *  .  .  .
	 *  .  .  .
	 *  x  x  x 
	 */
	public void testLineExist_IfThirdRowCompleteWithFirstValue_ReturnsTrue() {
		board.setValue(new Position(2,0), CellValue.FIRST_VALUE);
		board.setValue(new Position(2,1), CellValue.FIRST_VALUE);
		board.setValue(new Position(2,2), CellValue.FIRST_VALUE);
		assertTrue(lineChecker.lineExist(new Position(2, 1)));
	}
	
	/**
	 *  .  o  .
	 *  .  o  .
	 *  .  o  .
	 */
	public void testLineExist_IfThirdColumnCompleteWithFirstValue_ReturnsTrue() {
		board.setValue(new Position(0,1), CellValue.SECOND_VALUE);
		board.setValue(new Position(1,1), CellValue.SECOND_VALUE);
		board.setValue(new Position(2,1), CellValue.SECOND_VALUE);
		assertTrue(lineChecker.lineExist(new Position(2, 1)));
	}
	
	/**
	 *  x  .  . 
	 *  .  x  .
	 *  .  .  x
	 */
	public void testLineExist_IfCompleteWithSecondValue_ReturnsTrue() {
		board.setValue(new Position(0,0), CellValue.FIRST_VALUE);
		board.setValue(new Position(1,1), CellValue.FIRST_VALUE);
		board.setValue(new Position(2,2), CellValue.FIRST_VALUE);
		assertTrue(lineChecker.lineExist(new Position(0, 0)));
	}
	
	/**
	 *  .  .  o 
	 *  .  o  .
	 *  o  .  .
	 */
	public void testLineExist_IfCompleteWithFirstValue_ReturnsTrue() {
		board.setValue(new Position(0,2), CellValue.SECOND_VALUE);
		board.setValue(new Position(1,1), CellValue.SECOND_VALUE);
		board.setValue(new Position(2,0), CellValue.SECOND_VALUE);
		assertTrue(lineChecker.lineExist(new Position(2, 0)));
	}
	
	/**
	 *  .  .  o 
	 *  .  o  .
	 *  o  .  .
	 */
	public void testLineExist_IfCompleteWithFirstValueButPositionDoesntBelongs_ReturnsFalse() {
		board.setValue(new Position(0,2), CellValue.SECOND_VALUE);
		board.setValue(new Position(1,1), CellValue.SECOND_VALUE);
		board.setValue(new Position(2,0), CellValue.SECOND_VALUE);
		assertFalse(lineChecker.lineExist(new Position(1, 0)));
	}
}
