package tictactoe;

import junit.framework.TestCase;

public class CellValueTests extends TestCase {
	public void testValue() {
		assertEquals('.', CellValue.EMPTY.getValue());
	}
}
