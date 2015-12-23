package breakout;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

/**
 * This class describes the attributes of a brick.
 *
 * @author ChrisBerryman
 */
public class Brick {

    /**
     * Separation between bricks
     */
    public static final int BRICK_SEP = 4;

    /**
     * Width of a brick
     */
    public static final int BRICK_WIDTH = (Breakout.APPLICATION_WIDTH - (Breakout.NBRICKS_PER_ROW - 1) * BRICK_SEP) / Breakout.NBRICKS_PER_ROW;

    /**
     * Height of a brick
     */
    public static final int BRICK_HEIGHT = 8;

    /**
     * Instance variables
     */
    private final Rectangle2D.Double rectangle;
    private Color color;
    private int positionX;
    private int positionY;

    /**
     * Constructs a brick
     *
     * @param x the x location of the brick
     * @param y the y location of the brick
     * @param theColor the colour of the brick
     */
    public Brick(int x, int y, Color theColor) {
        positionX = x;
        positionY = y;
        rectangle = new Rectangle2D.Double(positionX, positionY, BRICK_WIDTH, BRICK_HEIGHT);
        color = theColor;
    }

    /**
     * Returns the rectangle of the brick
     *
     * @return the rectangle
     */
    public Rectangle2D getRectangle() {
        return rectangle;
    }

    /**
     * Returns the colour of the brick
     *
     * @return the colour
     */
    public Color getColor() {
        return color;
    }

}
