package tictactoe;

import java.util.Iterator;

public abstract class LineIterator implements Iterator<CellValue> {
	protected Board board;
	protected int itPosition;
	
	public LineIterator(Board board) {
		this.board = board;
		itPosition = -1;
	}
	
	@Override
	public boolean hasNext() {
		return itPosition + 1 < board.size();
	}
	
	@Override
	public CellValue next() {
		itPosition++;
		return board.getValue(getPosition());
	}

	@Override
	public void remove() {
		// No sé qué poner aquí
	}
	
	public abstract Position getPosition();
}
