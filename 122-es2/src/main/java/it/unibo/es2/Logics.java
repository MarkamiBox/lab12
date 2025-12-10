package it.unibo.es2;

/**
 * Interface defining the logic for the application.
 */
public interface Logics {

    /**
     * @param row the row
     * @param col the column
     * @return the new value
     */
    String hit(int row, int col);

    /**
     * True if it is time to quit (i.e., all slots have the same value).
     *
     * @return whether it is time to quit
     */
    boolean toQuit();
}
