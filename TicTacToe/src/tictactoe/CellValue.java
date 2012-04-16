package tictactoe;

public enum CellValue {	
	EMPTY_VALUE, FIRST_VALUE, SECOND_VALUE;
	
	public char charValue(){
		switch(this) {
		case FIRST_VALUE:
			return 'x';
		case SECOND_VALUE:
			return 'o';
		default:
			return '.';
		}
	}
}
