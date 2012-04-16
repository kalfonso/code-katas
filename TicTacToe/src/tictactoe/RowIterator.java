package tictactoe;

public class RowIterator extends LineIterator {
	private int row;
	
	public RowIterator(int row, Board board) {
		super(board);
		this.row = row;
	}

	@Override
	public Position getPosition() {
		return new Position(row, itPosition);
	}
}
