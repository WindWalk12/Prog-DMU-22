package logic;

public class TicTacToeLogic {
    /* Represent the state of a tic-tac-toe game including
    the current player.
     */

    private final int SIZE = 3;

    private int mCurrentPlayer = 1;

    private int usedFields = 0;

    //2D Array of int to see where players have set their symbol
    private final int[][] fields = new int[SIZE][SIZE];

    public TicTacToeLogic() {
    }

    /**
     * A mutator that must be called when a field is set by the
     * current player
     * Adds clicked fields to the 2D Array
     *
     * @param row is the x-coordinate of the field. Must be in 0..size-1
     * @param col is the y-coordinate of the field. Must be in 0..size-1
     */
    public void set(int row, int col) {
        fields[row][col] = mCurrentPlayer;
        mCurrentPlayer = 3 - mCurrentPlayer;
        usedFields++;
    }

    /**
     * Inspector used to get the current player; either 1 or 2.
     *
     * @return the current player
     */
    public int getCurrentPlayer() {
        return mCurrentPlayer;
    }

    /**
     * Inspector returning if there is a winner in the current state.
     *
     * @return either 1 or 2 if there is a winner, and 0 otherwise
     */
    public int anyWinner() {
        //Checking if someone has won in the vertical positions
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                if (fields[i][0] == fields[i][1] && fields[i][1] == fields[i][2] && fields[i][j] != 0) {
                    return 1;
                }
            }
        }
        //Checking if someone has won in the horizontal positions
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                if (fields[0][i] == fields[1][i] && fields[1][i] == fields[2][i] && fields[j][i] != 0) {
                    return 1;
                }
            }
        }
        //Checking if someone has won in the diagonal position starting from 0-0 to 2-2
        //Checking if someone has won in the diagonal position starting from 0-2 to 2-0
        if (fields[1][1] != 0) {
            int compare = fields[1][1];
            if (fields[0][0] == compare && fields[2][2] == compare) {
                return 1;
            } else if (fields[0][2] == compare && fields[2][0] == compare) {
                return 1;
            }
        }

        return 0;
    }


    /**
     * Inspector
     *
     * @return if gameboard is filled.
     */
    public boolean isGameOver() {
        return usedFields == SIZE * SIZE;
    }

}
