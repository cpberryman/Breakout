package breakout;

/**
 * This class initialises the components of the game
 *
 * @author ChrisBerryman
 */
public class Breakout {

    /**
     * Width and height of application window in pixels. On some platforms *
     * these may NOT actually be the dimensions of the graphics canvas.
     */
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;
    /**
     * Dimensions of game board. On some platforms these may NOT actually be the
     * dimensions of the graphics canvas.
     */
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;
    /**
     * Number of rows of bricks
     */
    public static final int NBRICK_ROWS = 10;
    /**
     * Number of bricks per row
     */
    public static final int NBRICKS_PER_ROW = 10;
    /**
     * Offset of the top brick row from the top
     */
    public static final int BRICK_Y_OFFSET = 70;

    /**
     * Instance variables
     */
    private final BreakoutModel model;
    private final BreakoutView view;
    private final BreakoutController controller;

    /**
     * Constructs a breakout instance and initialises model, view and controller
     */
    public Breakout() {
        model = new BreakoutModel();
        view = new BreakoutView(WIDTH, HEIGHT, model);
        controller = new BreakoutController(model, view);
    }

    /**
     * Initialises the game
     */
    public void init() {
        controller.init();
    }

    /**
     * Plays the game
     */
    public void play() {
        controller.play();
    }

}
