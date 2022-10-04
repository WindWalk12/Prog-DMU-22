package logic;

public class TicTacToeLogic {
    /* Represent the state of a tic-tac-toe game including
    the current player.
     */

    private final int SIZE = 3;

    private int mCurrentPlayer = 1;

    private int usedFields = 0;

    public TicTacToeLogic() {
    }

    /**
     * A mutator that must be called when a field is set by the
     * current player
     * @param row is the x-coordinate of the field. Must be in 0..size-1
     * @param col is the y-coordinate of the field. Must be in 0..size-1
     */
    public void set(int row, int col) {
        //TODO
        mCurrentPlayer = 3 - mCurrentPlayer;
        usedFields++;
    }

    /**
     * Inspector used to get the current player; either 1 or 2.
     * @return the current player
     */
    public int getCurrentPlayer() {
        return mCurrentPlayer; }

    /**
     * Inspector returning if there is a winner in the current state.
     * @return either 1 or 2 if there is a winner, and 0 otherwise
     */
    public int anyWinner() {
        return 0; }


    /**
     * Inspector
     * @return if gameboard is filled.
     */
    public boolean isGameOver() {
        return usedFields == SIZE*SIZE; }

}
