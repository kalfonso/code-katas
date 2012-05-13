package tictactoe;

public class GameParser {
	public static final String ROW_DIVIDER = "---+---+---\n";
	private Game game;
	
	public GameParser() {
		game = new Game();
	}
	
	public String boardToString() {
		String str = "";
		for(int row = 0; row < 3; row++) {
			str += rowToString(row) + '\n';
			if(row != 2)
				str += ROW_DIVIDER;
		}
		return str;
	}
	
	private String rowToString(int row){
		String str = "";
		for(int column = 0; column < 3; column++) {
			str += " " + game.getBoard().getValue(new Position(row,column)).getValue();
			str += column == 2 ?  " " : " |";
		}
		return str;
	}
	
	private static Position parsePosition(String position) {	
		try {
			String[] str = position.split(",");
			int row = Integer.parseInt(str[0].trim()) - 1;
			int column = Integer.parseInt(str[1].trim()) - 1;
			return new Position(row, column);
		} catch(Exception e) {
			throw new IllegalArgumentException("Invalid Position String");
		}
	}
	
	public String processPosition(String positionString) {
		String outputString = "Invalid move!!";
		try {
			Position position = GameParser.parsePosition(positionString);
			if(game.play(position))
				outputString = boardToString();
		} catch (Exception e) {	}
		return outputString;
	}
	
	public String getResult() {
		String result = "Player 1 : " + game.getPlayer(0).getStatus().toString() + "\t";
		result += "Player 2: " + game.getPlayer(1).getStatus().toString();
		return result;
	}
	
	public boolean isGameOver() {
		return game.isGameOver();
	}
}
