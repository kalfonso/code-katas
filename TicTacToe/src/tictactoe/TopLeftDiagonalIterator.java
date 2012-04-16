package tictactoe;

public class TopLeftDiagonalIterator extends LineIterator {

	public TopLeftDiagonalIterator(Board board) {
		super(board);
	}

	@Override
	public Position getPosition() {
		return new Position(itPosition, itPosition);
	}
}
