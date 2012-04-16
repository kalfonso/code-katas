package ktictactoe;

import static java.lang.String.format;

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
        if (board[x][y] != '.') {
            throw new IllegalArgumentException(format("Position %s,%s is occupied", x, y));
        }
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
