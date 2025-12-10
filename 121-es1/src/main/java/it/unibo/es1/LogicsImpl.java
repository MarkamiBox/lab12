package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private final int size;
    private final List<Integer> values;
    private final List<Boolean> enabledStates;

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        this.size = size;
        this.values = new ArrayList<>(size);
        this.enabledStates = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.values.add(0);
            this.enabledStates.add(true);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> values() {
        return this.values.stream().toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> enabledStates() {
        return this.enabledStates.stream().toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {
        int val = this.values.get(elem);
        val++;
        // if val == size -> disable the button
        this.values.set(elem, val);
        if (val == this.size) {
            this.enabledStates.set(elem, false);
        }
        return val;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String result() {
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            result.append(this.values.get(i));
            if (i < this.size - 1) {
                result.append('|');
            }
        }
        return "<<" + result + ">>";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        if (this.values.isEmpty()) {
            return false;
        }
        // if all values are the same -> return true
        final int first = this.values.get(0);
        for (int i = 1; i < this.size; i++) {
            if (this.values.get(i) != first) {
                return false;
            }
        }
        return true;
    }
}
