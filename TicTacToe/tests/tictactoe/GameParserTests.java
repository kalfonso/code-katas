package tictactoe;

import junit.framework.TestCase;

public class GameParserTests extends TestCase {

	public void testToString_AtTheBeginningOfTheGame_ReturnEmptyBoard() {
		GameParser parser = new GameParser();
		String value = parser.boardToString();
		String expected = " . | . | . \n"+ GameParser.ROW_DIVIDER + " . | . | . \n"+ GameParser.ROW_DIVIDER + " . | . | . \n";
		assertEquals(expected, value);
	}

	/**
	 *  X | X | O 
	 * ---+---+---
	 *  . | X | .
	 * ---+---+---
	 *  O | O | X
	 */
	public void testBoardToString() {
		GameParser parser = new GameParser();
		parser.processPosition("1, 1");
		parser.processPosition("1, 3");
		parser.processPosition("1, 2");
		parser.processPosition("3, 1");
		parser.processPosition("2, 2");
		parser.processPosition("3, 2");
		parser.processPosition("3, 3");
		String actual = parser.boardToString();
		String expected = " X | X | O \n"+ GameParser.ROW_DIVIDER + " . | X | . \n"+ GameParser.ROW_DIVIDER + " O | O | X \n";
		assertEquals(expected, actual);
	}
	
	public void testProcessPosition() {
		GameParser parser = new GameParser();
		parser.processPosition("1, 1");
		String actual = parser.boardToString();
		String expected = " X | . | . \n"+ GameParser.ROW_DIVIDER + " . | . | . \n"+ GameParser.ROW_DIVIDER + " . | . | . \n";
		assertEquals(expected, actual);
	}
}
