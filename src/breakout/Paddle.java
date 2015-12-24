package breakout;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

/**
 * This class describes the paddle used to direct the ball.
 *
 * @author ChrisBerryman
 */
public class Paddle {

    /**
     * Dimensions of the paddle
     */
    public static final int PADDLE_WIDTH = 60;
    public static final int PADDLE_HEIGHT = 10;
    /**
     * Offset of the paddle up from the bottom
     */
    public static final int PADDLE_Y_OFFSET = 30;
    /**
     * The start position of the paddle
     */
    public static final int PADDLE_START_POSITION_X = 30;

    /**
     * Instance variables
     */
    private Rectangle2D.Double rectangle;
    private Color color;
    private int positionX = PADDLE_START_POSITION_X;
    private int positionY = ((Breakout.APPLICATION_HEIGHT - PADDLE_Y_OFFSET) - PADDLE_HEIGHT);

    /**
     * Constructs a paddle
     *
     * @param theColor the colour of the paddle
     */
    public Paddle(Color theColor) {
        rectangle = new Rectangle2D.Double(positionX, positionY, PADDLE_WIDTH, PADDLE_HEIGHT);
        color = theColor;
    }

    /**
     * Moves the paddle along the x axis
     *
     * @param x the x location to move the paddle to
     */
    public void move(int x) {
        positionX = x;
        rectangle.x = positionX;
    }

    /**
     * Returns the rectangle which describes the paddle
     *
     * @return the rectangle
     */
    public Rectangle2D getRectangle() {
        return rectangle;
    }

    /**
     * Returns the colour of the paddle
     *
     * @return the colour
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * Returns the x position of the paddle
     *
     * @return the x position
     */
    public int getX() {
        return positionX;
    }

}
