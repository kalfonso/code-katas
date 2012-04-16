package ktictactoe;

import org.junit.Test;

public class TicTacToeTest {
    @Test
    public void shouldAllowPlayingInAValidPosition() {
        Board board = new Board();
        board.marcPosition(1, 1, 'x');
        System.out.println(board);
    }
}
