package it.unibo.es2;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {
    private final int size;
    private final boolean[][] grid;

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        this.size = size;
        this.grid = new boolean[size][size];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String hit(final int row, final int col) {
        if (this.grid[row][col]) {
            this.grid[row][col] = false;
            return " ";
        }
        this.grid[row][col] = true;
        return "*";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        // Check rows
        for (int i = 0; i < size; i++) {
            boolean rowFull = true;
            for (int j = 0; j < size; j++) {
                if (!this.grid[i][j]) {
                    rowFull = false;
                    break;
                }
            }
            if (rowFull) {
                return true;
            }
        }
        // Check columns
        for (int j = 0; j < size; j++) {
            boolean colFull = true;
            for (int i = 0; i < size; i++) {
                if (!this.grid[i][j]) {
                    colFull = false;
                    break;
                }
            }
            if (colFull) {
                return true;
            }
        }
        return false;
    }
}
