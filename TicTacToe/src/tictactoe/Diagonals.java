package tictactoe;

public enum Diagonals {
	TopLeft, TopRight;
	
	public int getColumnIndex(int rowIndex) {
		if(rowIndex > 2 || rowIndex < 0)
			throw new IllegalArgumentException();
		switch(this) {
		case TopLeft:
			return rowIndex;
		case TopRight:
			return 2 - rowIndex;
		}
		return rowIndex;
	}
	
	public boolean containsPosition(Position position) {
		return getColumnIndex(position.getRow()) == position.getColumn();
	}
}
