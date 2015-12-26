package breakout;

import java.awt.Graphics2D;

/**
 * A paddle drawer draws the paddle
 *
 * @author ChrisBerryman
 */
public class PaddleDrawer {

    /**
     * Instance variable
     */
    private final Paddle paddle;

    /**
     * Constructs a paddle drawer
     *
     * @param thePaddle the paddle to draw
     */
    public PaddleDrawer(Paddle thePaddle) {
        paddle = thePaddle;
    }

    /**
     * Draws the paddle
     *
     * @param g2 the graphics context
     */
    public void draw(Graphics2D g2) {
        g2.setColor(paddle.getColor());
        g2.fill(paddle.getRectangle());
    }

}
