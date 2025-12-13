package it.unibo.es3;

import java.util.Random;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {
    private final int size;
    private boolean[][] grid;
    private final Random random = new Random();

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        this.size = size;
        this.grid = new boolean[size][size];

        int placed = 0;
        while (placed < 3) {
            int row = random.nextInt(size);
            int col = random.nextInt(size);
            if (!this.grid[row][col]) {
                this.grid[row][col] = true;
                placed++;
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void tick() {
        boolean[][] nextGrid = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // If already active, it stays active
                if (this.grid[i][j]) {
                    nextGrid[i][j] = true;
                } else {
                    // Check neighbors
                    if (hasActiveNeighbor(i, j)) {
                        nextGrid[i][j] = true;
                    }
                }
            }
        }
        this.grid = nextGrid;
    }

    private boolean hasActiveNeighbor(int r, int c) {
        for (int i = r - 1; i <= r + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {
                if (i >= 0 && i < size && j >= 0 && j < size) {
                    if (i == r && j == c) {
                        continue;
                    }
                    if (this.grid[i][j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isActive(int row, int col) {
        return this.grid[row][col];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!this.grid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
