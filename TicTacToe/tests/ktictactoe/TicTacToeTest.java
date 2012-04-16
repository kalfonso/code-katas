package ktictactoe;

import org.junit.Test;

public class TicTacToeTest {
    @Test
    public void shouldAllowPlayingInAValidPosition() {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board [i][j] = '.';
            }
        }

        board[1][1] = 'x';

        for (int i = 0; i < 3; i++) {
            System.out.println(board[i]);
        }
    }
}
