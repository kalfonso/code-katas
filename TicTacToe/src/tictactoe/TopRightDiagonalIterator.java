package tictactoe;

public class TopRightDiagonalIterator extends LineIterator {

	public TopRightDiagonalIterator(Board board) {
		super(board);
	}

	@Override
	public Position getPosition() {
		int columnValue = board.size() - itPosition - 1;
		return new Position(itPosition, columnValue);
	}
}