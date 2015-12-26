package breakout;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

/**
 * This class keeps track of the state of the components in the world
 * 
 * @author ChrisBerryman
 */
public class BreakoutModel extends Observable {

    /**
     * Instance variables
     */
    private final List<Brick> bricks = new LinkedList<>();
    private Paddle paddle;
    private Ball ball;
    private final Random rgen = new Random();
    private double vy = 3;
    private double vx = 1.0 + (3.0 - 1.0) * rgen.nextDouble();

    /**
     * Adds a brick to the world
     *
     * @param b the brick to add
     */
    public void addBrick(Brick b) {
        bricks.add(b);
    }

    /**
     * Sets the paddle
     *
     * @param thePaddle the paddle to set
     */
    public void setPaddle(Paddle thePaddle) {
        paddle = thePaddle;
    }

    /**
     * Predicate method which returns true if the paddle contains a point
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @return true if the paddle contains the coordinates, false otherwise
     */
    public boolean selectPaddle(int x, int y) {
        return paddle.getRectangle().contains(x, y);
    }

    /**
     * Moves the paddle
     *
     * @param x the x coordinate to move the paddle to
     */
    public void movePaddle(int x) {
        paddle.move(x);
        setChanged();
        notifyObservers();
    }

    /**
     * Sets the ball for the game
     *
     * @param theBall the ball to set
     */
    public void setBall(Ball theBall) {
        ball = theBall;
    }

    /**
     * Moves the ball based on the x and y velocity
     *
     * @param panelWidth the width of the bounding panel
     * @param panelHeight the height of the bounding panel
     */
    public void moveBall(int panelWidth, int panelHeight) {
        if (ball.getX() <= 0) {
            vx = Math.abs(vx);
        }
        if (ball.getX() >= panelWidth - Ball.BALL_RADIUS * 2) {
            vx = -vx;
        }
        if (ball.getY() <= 0) {
            vy = Math.abs(vy);
            if (rgen.nextBoolean()) {
                vx = -vx;
            }
        }
        if (ball.getY() >= panelHeight - Ball.BALL_RADIUS * 2 || paddleCollided(panelHeight)) {
            vy = -vy;
            if (rgen.nextBoolean()) {
                vx = -vx;
            }
        }
        ball.move(vx, vy);
        setChanged();
        notifyObservers();
    }

    /**
     * Checks to see if the ball has collided with the paddle
     *
     * @param panelHeight the height of the bounding panel
     * @return true if the ball has collided with the panel false otherwise
     */
    public boolean paddleCollided(int panelHeight) {
        return ball.getY() >= panelHeight - (Ball.BALL_RADIUS * 2 + Paddle.PADDLE_HEIGHT
                + Paddle.PADDLE_Y_OFFSET)
                && (ball.getX() > paddle.getX() && ball.getX() < paddle.getX()
                + Paddle.PADDLE_WIDTH);
    }

    /**
     * Checks to see if the ball has collided with a brick
     *
     * @return the colliding brick or null if there has been no collision
     */
    public Brick checkForCollision() {
        Brick collider = null;
        for (Brick b : bricks) {
            if (b.getRectangle().contains(ball.getX(), ball.getY())
                    || b.getRectangle().contains(ball.getX()
                            + Ball.BALL_RADIUS * 2, ball.getY())) {
                vy = Math.abs(vy);
                if (rgen.nextBoolean()) {
                    vx = -vx;
                }
                collider = b;
            }
            if (b.getRectangle().contains(ball.getX(), ball.getY()
                    + Ball.BALL_RADIUS * 2)
                    || b.getRectangle().contains(ball.getX()
                            + Ball.BALL_RADIUS * 2, ball.getY()
                            + Ball.BALL_RADIUS * 2)) {
                vy = -vy;
                if (rgen.nextBoolean()) {
                    vx = -vx;
                }
                collider = b;
            }
        }
        return collider;
    }

    /**
     * Removes a brick from the world
     *
     * @param brick the brick to remove
     */
    public void remove(Brick brick) {
        bricks.remove(brick);
    }

}
