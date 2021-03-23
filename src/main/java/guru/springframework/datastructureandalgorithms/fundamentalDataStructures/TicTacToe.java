package guru.springframework.datastructureandalgorithms.fundamentalDataStructures;

public class TicTacToe {
    public static final int X = 1, O = -1;
    public static final int EMPTY = 0;
    private final int[][] board = new int[3][3];
    private int player;

    public TicTacToe() {
        initBoard();
        switchPlayer(X);
    }

    public int getWinner() {
        if (isWin(X)) {
            return X;
        } else if (isWin(O)) {
            return O;
        }
        return EMPTY;
    }

    private boolean isWin(int player) {
        return ((board[0][0] + board[0][1] + board[0][2] == player * 3)
                || (board[1][0] + board[1][1] + board[1][2] == player * 3)
                || (board[2][0] + board[2][1] + board[2][2] == player * 3)
                || (board[0][0] + board[1][0] + board[2][0] == player * 3)
                || (board[0][1] + board[1][1] + board[2][1] == player * 3)
                || (board[0][2] + board[1][2] + board[2][2] == player * 3)
                || (board[0][0] + board[1][1] + board[2][2] == player * 3)
                || (board[2][0] + board[1][1] + board[0][2] == player * 3));
    }

    public void markBoard(int row, int column) {
        validateBoard(row, column);
        board[row][column] = player;
        switchPlayer(-player);
    }

    public String reviewBoard() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                switch (board[i][j]) {
                    case X: stringBuilder.append("X"); break;
                    case O: stringBuilder.append("O"); break;
                    case EMPTY: stringBuilder.append(" "); break;
                }
                if (j < 2) stringBuilder.append("|");
            }
            if (i < 2) stringBuilder.append("\n-----\n");
        }
        return stringBuilder.toString();
    }

    private void validateBoard(int row, int column) {
        if (row > 2 || row < 0 || column > 2 || column < 0) {
            throw new IllegalArgumentException("Invalid board position");
        }

        if (board[row][column] != EMPTY) throw new IllegalArgumentException("Board position occupied");
    }

    private void switchPlayer(int newPlayer) {
        player = newPlayer;
    }

    private void initBoard() {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

}
