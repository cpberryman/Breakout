package breakout;

import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.Timer;

/**
 * This class sets up the world and the corresponding graphical objects in the
 * view
 *
 * @author ChrisBerryman
 */
public class BreakoutController {

    /**
     * Instance variables
     */
    private BreakoutModel model;
    private BreakoutView view;
    private BreakoutMouseListener listener;
    private Ball ball;
    private Timer time;

    /**
     * Constructs a breakout controller
     *
     * @param theModel the model for the game
     * @param theView the view for the game
     */
    public BreakoutController(BreakoutModel theModel, BreakoutView theView) {
        model = theModel;
        view = theView;
        listener = new BreakoutMouseListener();
        view.getPanel().addMouseListener(listener);
        view.getPanel().addMouseMotionListener(listener);
    }

    /**
     * Initialises a game
     */
    public void init() {
        createAndShowBricks();
        createAndShowPaddle();
        createAndShowBall();
    }

    /**
     * Runs the game
     */
    public void play() {
        time = new Timer(15, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.moveBall(view.getPanel().getSize().width, view.getPanel().getSize().height);
                Brick collidingObject = model.checkForCollision();
                if (collidingObject != null) {
                    BrickDrawer bd = collidingObject.getDrawer();
                    view.removeBrickDrawer(bd);
                    model.remove(collidingObject);
                }
            }
        });
        time.start();
    }

    /**
     * Creates the bricks and adds them to the world
     */
    public void createAndShowBricks() {
        int startX = (view.getPanel().getSize().width)
                - ((Breakout.NBRICKS_PER_ROW * Brick.BRICK_WIDTH)
                + (Breakout.NBRICKS_PER_ROW * Brick.BRICK_SEP)) - (Brick.BRICK_SEP);
        int currentX = startX;
        int brickStartY = Breakout.BRICK_Y_OFFSET;
        Color color = Color.RED;

        for (int i = 0; i < Breakout.NBRICK_ROWS; i++) {
            for (int j = 0; j < Breakout.NBRICKS_PER_ROW; j++) {
                Brick b = new Brick(currentX, brickStartY, color);
                BrickDrawer bd = new BrickDrawer(b);
                b.setDrawer(bd);
                view.addBrickDrawer(bd);
                model.addBrick(b);
                currentX += (Brick.BRICK_WIDTH + Brick.BRICK_SEP);
            }
            currentX = startX;
            brickStartY += (Brick.BRICK_HEIGHT + Brick.BRICK_SEP);
            color = setColorByRow(i);
        }
    }

    /**
     * Sets the colour of a row of bricks
     *
     * @param rowIndex the index of the row
     * @return the colour
     */
    public Color setColorByRow(int rowIndex) {
        Color color = Color.RED;
        if (rowIndex < 1) {
            color = Color.RED;
        } else if (rowIndex < 3) {
            color = Color.ORANGE;
        } else if (rowIndex < 5) {
            color = Color.YELLOW;
        } else if (rowIndex < 7) {
            color = Color.GREEN;
        } else if (rowIndex < 9) {
            color = Color.CYAN;
        }
        return color;
    }

    /**
     * Creates the paddle and adds it to the world
     */
    public void createAndShowPaddle() {
        Color c = Color.BLACK;
        Paddle p = new Paddle(c);
        PaddleDrawer pd = new PaddleDrawer(p);
        view.addPaddleDrawer(pd);
        model.setPaddle(p);
    }

    /**
     * Moves the paddle
     *
     * @param x the x coordinate to move the paddle to
     */
    public void movePaddle(int x) {
        model.movePaddle(x);
    }

    /**
     * Creates the ball and adds it to the world
     */
    public void createAndShowBall() {
        int ballStartX = ((view.getPanel().getSize().width / 2) - (Ball.BALL_RADIUS / 2));
        int ballStartY = ((view.getPanel().getSize().height / 2) - (Ball.BALL_RADIUS / 2));
        ball = new Ball(ballStartX, ballStartY);
        BallDrawer bd = new BallDrawer(ball);
        view.addBallDrawer(bd);
        model.setBall(ball);
    }

    /**
     * This class handles mouse events from the user
     */
    class BreakoutMouseListener extends MouseAdapter {

        /**
         * Reference to the outer controller class
         */
        BreakoutController c = BreakoutController.this;
        /**
         * Instance variable
         */
        private boolean mousePressed = false;

        public boolean isMousePressed() {
            return this.mousePressed;
        }

        public void setMousePressed(boolean pressed) {
            mousePressed = pressed;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == 1) {
                if (model.selectPaddle(e.getX(), e.getY())) {
                    setMousePressed(true);
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            mousePressed = false;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (mousePressed) {
                int x = e.getX();
                if (x >= view.getPanel().getSize().width - Paddle.PADDLE_WIDTH) {
                    x = view.getPanel().getSize().width - Paddle.PADDLE_WIDTH;
                }
                if (x <= 0) {
                    x = 0;
                }
                c.movePaddle(x);
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }

    }

}
