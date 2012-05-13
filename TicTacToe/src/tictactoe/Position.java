package tictactoe;

public class Position {
	private int row;
	private int column;

	public Position(int row, int column) {
		if(row < 0 || row > 2 || column < 0 || column > 2)
			throw new IllegalArgumentException();
		this.row = row;
		this.column = column;
	}
	
	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
}
