package breakout;

/**
 * Main class which instantiates the game
 *
 * @author ChrisBerryman
 */
public class BreakoutMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Breakout b = new Breakout();
        b.init();
        b.play();
    }

}
