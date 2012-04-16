package tictactoe;

public class TicTacToe {
	private Board board;
	private int turnCounter;
	
	public TicTacToe() {
		board = new Board(3);
		turnCounter = 0;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void playFirst(Position position) {
		play(position, CellValue.FIRST_VALUE, 0);
	}
	
	public void playSecond(Position position) {
		play(position, CellValue.SECOND_VALUE, 1);
	}
	
	private void play(Position position, CellValue value, int playerNumber){
		if(!board.isEmptyCell(position) ) 
			throw new IllegalArgumentException("Cell is Not Empty!");
		if(!isPlayerTurn(playerNumber))
			throw new IllegalArgumentException();
		board.setValue(position, value);
		turnCounter++;
		LineChecker lineChecker = new LineChecker(board);
		if(lineChecker.lineExist(position))
			setGameOver();
	}
	
	public void play(Position position) {
		if(turnCounter % 2 == 0)
			playFirst(position);
		else
			playSecond(position);
	}
	
	private boolean isPlayerTurn(int playerNumber) {
		return turnCounter % 2 == playerNumber;
	}
	
	public boolean isGameOver(){
		if(turnCounter >= 9)
			return true;
		return false;
	}
	
	public void setGameOver() {
		turnCounter = 9;
	}
}
