package tictactoe;
import java.util.Arrays;

public class Board {
	private CellValue[][] values;

	public Board() {
		values = new CellValue[3][3];
		for(int i = 0; i < 3; i++)
			Arrays.fill(values[i], CellValue.EMPTY);
	}

	public CellValue getValue(Position position) {
		return values[position.getRow()][position.getColumn()];
	}

	public void setValue(Position position, CellValue value) {
		values[position.getRow()][position.getColumn()] = value;
	}
	
	public boolean completesLine(Position position) {
		if(completesRow(position.getRow()))
			return true;
		if(completesColumn(position.getColumn()))
			return true;
		if(completesDiagonal(Diagonals.TopLeft, position))
			return true;
		if(completesDiagonal(Diagonals.TopRight, position))
			return true;
		return false;
	}
	
	private boolean completesRow(int row) {
		CellValue value = values[row][0];
		for(int column = 1; column < 3; column++)
			if(values[row][column] != value)
				return false;
		return true;
	}

	private boolean completesColumn(int column) {
		CellValue value = values[0][column];
		for(int row = 0; row < 3; row++)
			if(values[row][column] != value)
				return false;
		return true;
	}
	
	private boolean completesDiagonal(Diagonals diagonal, Position position) {
		if(!diagonal.containsPosition(position))
			return false;
		CellValue value = values[position.getRow()][position.getColumn()];
		for(int row = 0; row < values.length; row++)
			if(values[row][diagonal.getColumnIndex(row)] != value)
				return false;
		return true;
	}
}