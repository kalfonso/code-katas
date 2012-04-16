package tictactoe;

public class Position {
	private int row;
	private int column;
	
	public Position(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}
	
	public int getRow() {
		return row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public void setColumn(int column) {
		this.column = column;
	}
	
	public boolean belongsToTopLeftDiagonal() {
		return row == column;
	}
	
	public boolean belongsToTopRightDiagonal(int squareLength) {
		return column == squareLength - row - 1;
	}
	
	public static Position parse(String values) {
		String[] positionValues = values.split(",");
		int row = Integer.parseInt(positionValues[0].trim());
		int column = Integer.parseInt(positionValues[1].trim());
		return new Position(row, column);
	} 
}
