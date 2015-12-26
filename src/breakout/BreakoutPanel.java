package breakout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

/**
 * This class contains and draws the graphical objects
 *
 * @author ChrisBerryman
 */
public class BreakoutPanel extends JPanel {

    /**
     * Instance variables
     */
    private final List<BrickDrawer> brickDrawers = new LinkedList<>();
    private PaddleDrawer paddleDrawer;
    private BallDrawer ballDrawer;

    /**
     * Constructs a breakout panel
     *
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public BreakoutPanel(int width, int height) {
        super();
        this.setPreferredSize(new Dimension(width, height));
    }

    /**
     * Paints the panel
     *
     * @param g the graphics context
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, getSize().width, getSize().height);

        for (BrickDrawer b : brickDrawers) {
            b.draw(g2);
        }
        if (paddleDrawer != null) {
            paddleDrawer.draw(g2);
        }

        if (ballDrawer != null) {
            ballDrawer.draw(g2);
        }
    }

    /**
     * Adds a brick drawer to the panel
     *
     * @param bd the brick drawer to add
     */
    public void addBrickDrawer(BrickDrawer bd) {
        brickDrawers.add(bd);
    }

    /**
     * Adds a paddle drawer to the panel
     *
     * @param thePaddleDrawer the paddle drawer to add
     */
    public void addPaddleDrawer(PaddleDrawer thePaddleDrawer) {
        paddleDrawer = thePaddleDrawer;
    }

    /**
     * Adds a ball drawer to the panel
     *
     * @param theBallDrawer the ball drawer to add
     */
    public void addBallDrawer(BallDrawer theBallDrawer) {
        ballDrawer = theBallDrawer;
    }

    /**
     * Removes a drawable object from the panel
     *
     * @param bd the object encapsulated by the drawable
     */
    public void removeBrickDrawer(BrickDrawer bd) {
        brickDrawers.remove(bd);
    }

}
