public class KeyPressed {
    boolean upPressed;
    boolean downPressed;
    boolean rightPressed;
    boolean leftPressed;
    boolean shootPresed;

    /**
     * can access globally
     */
    private static final KeyPressed INSTANCE = new KeyPressed();

    private KeyPressed(){
        this.upPressed = false;
        this.downPressed = false;
        this.rightPressed = false;
        this.leftPressed = false;
        this.shootPresed = false;
    }

    public static KeyPressed getInstance(){
        /**
         * static have no 'this'
         */
        return INSTANCE;
    }
}
