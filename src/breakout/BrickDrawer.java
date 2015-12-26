package breakout;

import java.awt.Graphics2D;

/**
 * This class draws a given brick
 *
 * @author ChrisBerryman
 */
public class BrickDrawer {

    /**
     * Instance variable
     */
    private Brick brick;

    /**
     * Constructs a brick drawer
     *
     * @param theBrick the brick to draw
     */
    public BrickDrawer(Brick theBrick) {
        brick = theBrick;
    }

    /**
     * Draws the brick
     *
     * @param g2 the graphics context
     */
    public void draw(Graphics2D g2) {
        if (brick != null) {
            g2.setColor(brick.getColor());
            g2.fill(brick.getRectangle());
        }
    }

    /**
     * Returns the brick for this brick drawer
     *
     * @return the brick
     */
    public Brick getBrick() {
        return brick;
    }
}
