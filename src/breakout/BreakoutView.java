package breakout;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class displays the graphics in the game.
 *
 * @author ChrisBerryman
 */
public class BreakoutView implements Observer {

    /**
     * Instance variables
     */
    private final JFrame frame;
    private final BreakoutPanel panel;
    private final BreakoutModel model;

    /**
     * Constructs a break out view
     *
     * @param width the width of the view
     * @param height the height of the view
     * @param model the model
     */
    public BreakoutView(int width, int height, BreakoutModel model) {
        this.model = model;
        this.model.addObserver(this);
        frame = new JFrame("Breakout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new BreakoutPanel(width, height);
        frame.setContentPane(panel);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    /**
     * Repaints the view
     *
     * @param o the model
     * @param arg the change in state
     */
    @Override
    public void update(Observable o, Object arg) {
        panel.repaint();
    }

    /**
     * Adds a brick drawer
     *
     * @param bd the brick drawer to add
     */
    public void addBrickDrawer(BrickDrawer bd) {
        panel.addBrickDrawer(bd);
    }

    /**
     * Adds a paddle drawer
     *
     * @param pd the paddle drawer to add
     */
    public void addPaddleDrawer(PaddleDrawer pd) {
        panel.addPaddleDrawer(pd);
    }

    /**
     * Adds a ball drawer
     *
     * @param bd the ball drawer to add
     */
    public void addBallDrawer(BallDrawer bd) {
        panel.addBallDrawer(bd);
    }

    /**
     * Returns the panel
     *
     * @return the breakout panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * Removes a drawable object from the panel
     *
     * @param bd the object encapsulated by the drawable
     */
    public void removeBrickDrawer(BrickDrawer bd) {
        panel.removeBrickDrawer(bd);
    }

}
