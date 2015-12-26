package breakout;

import java.awt.Graphics2D;

/**
 * This class draws a given ball
 *
 * @author ChrisBerryman
 */
public class BallDrawer {

    /**
     * Instance variable
     */
    private final Ball ball;

    /**
     * Constructs a ball drawer
     *
     * @param theBall the ball to draw
     */
    public BallDrawer(Ball theBall) {
        ball = theBall;
    }

    /**
     * Draws the ball
     *
     * @param g2 the graphics context
     */
    public void draw(Graphics2D g2) {
        g2.fill(ball.getCircle());
    }
}
