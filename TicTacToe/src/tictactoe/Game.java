package tictactoe;

public class Game {
	private Player[] players = new Player[2];
	private int turnCounter;
	private Board board;
	
	public Game() {
		board = new Board();
		players[0] = new Player(CellValue.CROSS);
		players[1] = new Player(CellValue.NOUGHT);
	}
		
	public boolean play(Position position) {
		if(board.getValue(position) != CellValue.EMPTY || isGameOver())
			return false;
		CellValue value = activePlayer().geValue();
		board.setValue(position, value);
		turnCounter++;
		checkGameOver(position);
		return true;
	}
	
	private boolean checkGameOver(Position position) {
		if(board.completesLine(position)) {
			activePlayer().setStatus(PlayerStatus.Loser);
			inactivePlayer().setStatus(PlayerStatus.Winner);
			turnCounter = 9;
			return true;
		}
		if(isGameOver()) {
			activePlayer().setStatus(PlayerStatus.Tie);
			inactivePlayer().setStatus(PlayerStatus.Tie);
			return true;
		}
		return false;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public boolean isGameOver() {
		return turnCounter >= 9;
	}
	
	public Player activePlayer() {
		return players[turnCounter % 2];
	}
	
	public Player inactivePlayer() {
		return players[(turnCounter + 1) % 2];
	}
	
	public Player getPlayer(int index) {
		return players[index];
	}
}
