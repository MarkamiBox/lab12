package it.unibo.es3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI for the game.
 */
public final class GUI extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final List<JButton> cells = new ArrayList<>();
    private final transient Logics logics;

    /**
     * Constructor.
     *
     * @param width the size of the grid
     */
    public GUI(final int width) {
        this.logics = new LogicsImpl(width);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Create a panel with a grid layout
        final JPanel panel = new JPanel(new GridLayout(width, width));
        this.getContentPane().add(panel, java.awt.BorderLayout.CENTER);
        // Create buttons and add them to the panel
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                final JButton button = new JButton();
                this.cells.add(button);
                panel.add(button);
            }
        }

        final JButton advance = new JButton(">");
        advance.addActionListener(e -> {
            this.logics.tick();
            this.updateView();
            if (this.logics.toQuit()) {
                this.dispose();
            }
        });
        this.getContentPane().add(advance, java.awt.BorderLayout.SOUTH);
        this.updateView();
        this.setVisible(true);
    }

    private void updateView() {
        final int width = (int) Math.sqrt(this.cells.size());
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                this.cells.get(i * width + j).setText(this.logics.isActive(i, j) ? "*" : " ");
            }
        }
    }
}
