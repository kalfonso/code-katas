package tictactoe;

import junit.framework.TestCase;

public class PositionTests extends TestCase {

	public void testParse_ForStringValuesSeparatedWithoutSpace_CreateRightRow() {
		Position position = Position.parse("2,1");
		assertEquals(position.getRow(), 2);
	}

	public void testParse_ForStringValuesSeparatedWithoutSpace_CreateRightColumn() {
		Position position = Position.parse("2,1");
		assertEquals(position.getColumn(), 1);
	}
	
	public void testParse_ForStringValuesWitSpace_CreatePosition() {
		Position position = Position.parse(" 2 , 1 ");
		assertEquals(position.getRow(), 2);
		assertEquals(position.getColumn(), 1);
	}
}
