package tictactoe;

public class ColumnIterator extends LineIterator {
	protected int column;

	public ColumnIterator(int column, Board board) {
		super(board);
		this.column = column;
	}

	@Override
	public Position getPosition() {
		return new Position(itPosition, column);
	}
}
