package it.unibo.es3;

/**
 * Interface defining the logic for the application.
 */
public interface Logics {

    /**
     * Advance the simulation by one step.
     */
    void tick();

    /**
     * @param row the row
     * @param col the column
     * @return the cell at (row, col) that is active
     */
    boolean isActive(int row, int col);

    /**
     * @return true if all cells are active
     */
    boolean toQuit();
}
