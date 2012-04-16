package ktictactoe;

import org.junit.Test;

public class TicTacToeTest {
    @Test
    public void shouldAllowPlayingInAValidPosition() {
        Board board = new Board();
        board.marcPosition(1, 1, 'X');
        System.out.println(board);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowPlayingInAnOccupiedPosition() {
        Board board = new Board();
        board.marcPosition(1, 1, 'X');
        board.marcPosition(1, 1, 'O');
    }
}
