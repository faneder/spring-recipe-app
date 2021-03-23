
package guru.springframework.datastructureandalgorithms.fundamentalDataStructures;

import lombok.var;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicTacToeTest {

    @Test
    void shouldGetWinnerForPlayer1() {
        TicTacToe game = new TicTacToe();

        game.markBoard(0, 0);
        game.markBoard(0, 1);
        game.markBoard(1, 1);
        game.markBoard(0, 2);
        game.markBoard(2, 2);

        int winner = game.getWinner();

        assertThat(winner).isEqualTo(TicTacToe.X);
    }

    @Test
    void shouldGetWinnerForPlayer2() {
        TicTacToe game = new TicTacToe();

        game.markBoard(0, 1);
        game.markBoard(0, 0);
        game.markBoard(0, 2);
        game.markBoard(1, 1);
        game.markBoard(1, 2);
        game.markBoard(2, 2);

        int winner = game.getWinner();

        assertThat(winner).isEqualTo(TicTacToe.O);
    }

    @Test
    void shouldMarkUnfinishedGameWhenNoWinner() {
        TicTacToe game = new TicTacToe();

        game.markBoard(0, 1);

        int winner = game.getWinner();

        assertThat(winner).isEqualTo(TicTacToe.EMPTY);
    }

    @Test
    void shouldThrowExceptionWhenBoardIsInvalid() {
        TicTacToe game = new TicTacToe();

        var exception = assertThrows(IllegalArgumentException.class, () -> game.markBoard(0, 7));

        assertThat(exception.getMessage()).isEqualTo("Invalid board position");
    }

    @Test
    void shouldThrowExceptionWhenBoardIsOccupied() {
        TicTacToe game = new TicTacToe();

        var exception = assertThrows(IllegalArgumentException.class, () -> {
            game.markBoard(0, 1);
            game.markBoard(0, 1);
        });

        assertThat(exception.getMessage()).isEqualTo("Board position occupied");
    }

    @Test
    void shouldPrintBoard() {
        TicTacToe game = new TicTacToe();

        game.markBoard(1,1);
        game.markBoard(2,2);
        game.markBoard(0,1);
        game.markBoard(1,2);
        game.markBoard(2,0);
        game.markBoard(0,2);
        game.markBoard(0,0);
        game.markBoard(2,1);
        game.markBoard(1,0);

        assertThat(game.reviewBoard()).isEqualTo("X|X|O\n" +
            "-----\n" +
            "X|X|O\n" +
            "-----\n" +
            "X|O|O");
    }

}