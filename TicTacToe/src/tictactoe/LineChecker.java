package tictactoe;

public class LineChecker {
	private Board board;
	
	public LineChecker(Board board) {
		this.board = board;
	}
	
	public boolean lineExist(Position position) {
		if(isRowComplete(position.getRow()))
			return true;
		if(isColumnComplete(position.getColumn()))
			return true;
		if(position.belongsToTopLeftDiagonal() && isTopLeftDiagonalComplete())
			return true;
		if(position.belongsToTopRightDiagonal(board.size()) && isTopRightDiagonalComplete())
			return true;
		return false;
	}
	
	public boolean isComplete(LineIterator lineIt) {
		if(!lineIt.hasNext())
			return false;
		CellValue value = lineIt.next();
		if(value == CellValue.EMPTY_VALUE)
			return false;
		while(lineIt.hasNext())
			if(lineIt.next() != value)
				return false;
		return true;
	}
	
	public boolean isRowComplete(int row){
		RowIterator rowIterator = new RowIterator(row, board);
		return isComplete(rowIterator);
	}
	
	public boolean isColumnComplete(int column) {
		ColumnIterator columnIterator = new ColumnIterator(column, board);
		return isComplete(columnIterator);
	}
	
	public boolean isTopLeftDiagonalComplete(){
		TopLeftDiagonalIterator topLeftDiagonaIterator = new TopLeftDiagonalIterator(board);
		return isComplete(topLeftDiagonaIterator);
	}
	
	public boolean isTopRightDiagonalComplete(){
		TopRightDiagonalIterator topRightDiagonaIterator = new TopRightDiagonalIterator(board);
		return isComplete(topRightDiagonaIterator);
	}
}
