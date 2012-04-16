package ktictactoe;

public class Board {

    private final char[][] board;

    public Board() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '.';
            }
        }
    }

    public void marcPosition(int x, int y, char value) {
        board[x][y] = value;
    }

    @Override
    public String toString() {
        StringBuffer boardString = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            boardString.append(board[i]);
            boardString.append(System.getProperty("line.separator"));
        }
        return boardString.toString();
    }
}
