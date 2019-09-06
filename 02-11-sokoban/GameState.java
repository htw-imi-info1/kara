import greenfoot.*;



/**
 * The game screen state.
 * 
 * @author Marco Jakob (majakob@gmx.ch)
 * @version 1.3 (2012-07-04)
 */
public class GameState extends ScreenState 
{
    private Label moveCounterLabel;
    private Button retryLevelButton;

    public GameState(GameScreen gameScreen)
    {
        super(gameScreen);
    }

    /**
     * Initializes the screen.
     */
    public void initScreen()
    {
        gameScreen.setLevelComplete(false);

        gameScreen.showDefaultBackground();
        gameScreen.setNumberOfMoves(0); // reset moves

        createInfoBar();

        Level level = gameScreen.getCurrentLevel();

        for (int x = 0; x < GameScreen.WIDTH_IN_CELLS; x++)
        {
            for (int y = 0; y < GameScreen.HEIGHT_IN_CELLS; y++)
            {
                switch(level.getActorTypeAt(x, y))
                {
                    case Level.KARA: gameScreen.addObject(new MyKara(), x, y); break;
                    case Level.TREE: gameScreen.addObject(new Tree(), x, y); break;
                    case Level.LEAF: gameScreen.addObject(new Leaf(), x, y); break;
                    case Level.MUSHROOM: gameScreen.addObject(new Mushroom(), x, y); break;
                    case Level.MUSHROOM_LEAF: gameScreen.addObject(new Mushroom(true), x, y); gameScreen.addObject(new Leaf(), x, y); break;
                    case Level.KARA_LEAF: gameScreen.addObject(new MyKara(), x, y); gameScreen.addObject(new Leaf(), x, y); break;
                }
            }
        }
    }

    /**
     * Creates the label for the level, the moves and the reset button.
     */
    private void createInfoBar()
    {
        Label levelLabel = new Label("Level: " + gameScreen.getCurrentLevelNumber(), 95, 18, GameScreen.FONT_S_BOLD);
        levelLabel.setBackgroundTransparency(180);
        gameScreen.addObject(levelLabel, GameScreen.WIDTH_IN_CELLS - 3, GameScreen.HEIGHT_IN_CELLS - 1);

        moveCounterLabel = new Label("Moves: 0", 95, 18, GameScreen.FONT_S_BOLD);
        moveCounterLabel.setBackgroundTransparency(180);
        updateMoveCounter();
        gameScreen.addObject(moveCounterLabel, GameScreen.WIDTH_IN_CELLS - 7, GameScreen.HEIGHT_IN_CELLS - 1);

        retryLevelButton = new Button("Retry Level", 95, 18, GameScreen.FONT_S_BOLD);
        retryLevelButton.setBackgroundColor(new Color(255, 205, 205));
        retryLevelButton.setBorderColor(Color.RED);
        retryLevelButton.setBackgroundTransparency(180);        
        gameScreen.addObject(retryLevelButton, GameScreen.WIDTH_IN_CELLS - 11 , GameScreen.HEIGHT_IN_CELLS - 1);
    }

    /**
     * The act method is called by the GameScreen to perform the action in the ScreenState.
     */
    public void act()
    {
        updateMoveCounter();

        if (retryLevelButton.wasClicked())
        {
            // go to level splash state            
            gameScreen.setState(gameScreen.getLevelSplashState());
        }

        if (gameScreen.isLevelComplete())
        {
            // show the level complete state without clearing the world
            gameScreen.removeObject(retryLevelButton);
            gameScreen.setState(gameScreen.getLevelCompleteState(), false);
        }
    }

    /**
     * Updates the move counter.
     */
    private void updateMoveCounter()
    {
        moveCounterLabel.setText("Moves: " + gameScreen.getNumberOfMoves());
    }
}
