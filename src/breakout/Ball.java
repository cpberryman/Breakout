package breakout;

import java.awt.geom.Ellipse2D;

/**
 * This class represents the ball
 *
 * @author ChrisBerryman
 */
public class Ball {

    /**
     * Radius of the ball in pixels
     */
    public static final int BALL_RADIUS = 10;

    /**
     * Instance variables
     */
    private final Ellipse2D.Double circle;
    private double ballLocationX;
    private double ballLocationY;

    /**
     * Constructs a ball
     *
     * @param x the x position of the ball
     * @param y the y position of the ball
     */
    public Ball(int x, int y) {
        ballLocationX = x;
        ballLocationY = y;
        circle = new Ellipse2D.Double(ballLocationX, ballLocationY, BALL_RADIUS, BALL_RADIUS);
    }

    /**
     * Returns the circle of the ball
     *
     * @return the circle
     */
    public Ellipse2D getCircle() {
        return circle;
    }

    /**
     * Moves the ball to a given point.
     *
     * @param x the x location.
     * @param y the y location.
     */
    public void move(double x, double y) {
        ballLocationX += x;
        ballLocationY += y;
        circle.x = ballLocationX;
        circle.y = ballLocationY;
    }

    /**
     * Returns the x location of the ball
     *
     * @return the x location
     */
    public double getX() {
        return ballLocationX;
    }

    /**
     * Returns the y location of the ball
     *
     * @return the y location
     */
    public double getY() {
        return ballLocationY;
    }

}
