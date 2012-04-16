package tictactoe;

public class Board {
	private CellValue[][] values;
	
	public Board(int length) {
		values = new CellValue[length][length];
		initValues();
	}
	
	private void initValues(){
		for(int line = 0; line < values.length; line++)
			for(int column = 0; column < values[line].length; column++)
				values[line][column] = CellValue.EMPTY_VALUE;
	}
	
	public String toString() {
		String boardStr = "";
		for(int row = 0; row < values.length; row++)
			boardStr += getRow(row) + '\n';
		return boardStr;
	}
	
	private String getRow(int row) {
		String lineStr = "";
		for(int column = 0; column < values[row].length; column++)
			lineStr += " " + values[row][column].charValue() + " ";
		return lineStr;
	}
	
	public void setValue(Position position, CellValue value) {
		int row = position.getRow();
		int column = position.getColumn();
		values[row][column] = value;
	}
	
	public boolean isEmptyCell(Position position){
		int row = position.getRow();
		int column = position.getColumn();
		return values[row][column] == CellValue.EMPTY_VALUE;
	}
	
	public CellValue getValue(Position position) {
		int row = position.getRow();
		int column = position.getColumn();
		return values[row][column];
	}
	
	public int size() {
		return values.length;
	}
}
