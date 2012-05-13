package tictactoe;

public enum CellValue {
	EMPTY('.'), CROSS('X'), NOUGHT('O');
	
	private char value;
	private CellValue(char value) {
		this.value = value;
	}
	
	public char getValue() {
		return value;
	}
}
