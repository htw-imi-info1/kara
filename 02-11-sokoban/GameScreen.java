import greenfoot.*;
import java.util.HashMap;
import java.util.List;
import java.awt.Color;
import java.awt.Font;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is the world for the Kara Sokoban game:
 * <p>
 * This class manages the following:
 * <ul>
 * <li>all information about the world and pixel sizes
 * <li>references to the icons that are used
 * <li>the Fonts
 * <li>all the screen states
 * <li>all the levels
 * <li>the current level and number of moves
 * <li>the highscore
 * <ul>
 * 
 * @author Marco Jakob (majakob@gmx.ch)
 * @version 1.3 (2012-07-04)
 */
public class GameScreen extends World
{   
    // the screen settings
    public static final int WIDTH_IN_CELLS = 21;
    public static final int HEIGHT_IN_CELLS = 18;
    public static final int CELL_SIZE = 28;
    public static final int WIDTH_IN_PIXELS = WIDTH_IN_CELLS * CELL_SIZE;
    public static final int HEIGHT_IN_PIXELS = HEIGHT_IN_CELLS * CELL_SIZE;
    
    // fonts and colors
    public static final String FONT_NAME = "Tahoma";
    public static final Font FONT_S = new Font(FONT_NAME, Font.PLAIN, 12);
    public static final Font FONT_S_BOLD = new Font(FONT_NAME, Font.BOLD, 12);
    public static final Font FONT_M = new Font(FONT_NAME, Font.PLAIN, 17);
    public static final Font FONT_L = new Font(FONT_NAME, Font.PLAIN, 20);
    public static final Font FONT_XL = new Font(FONT_NAME, Font.PLAIN, 30);
    public static final Font FONT_XL_BOLD = new Font(FONT_NAME, Font.BOLD, 30);
    public static final Font FONT_XXL = new Font(FONT_NAME, Font.PLAIN, 50);

    // all actor icons (this is a trick to get the default image that was chosen for actors)
    public static final GreenfootImage ICON_LEAF = (new Leaf()).getImage();
    public static final GreenfootImage ICON_MUSHROOM = (new Mushroom()).getImage();
    public static final GreenfootImage ICON_MUSHROOM_ON_TARGET = findOnTargetImage(ICON_MUSHROOM, "_on_target");
    public static final GreenfootImage ICON_TREE = (new Tree()).getImage();
    public static final GreenfootImage ICON_KARA = (new Kara()).getImage();
    public static final GreenfootImage ICON_MY_KARA = (new MyKara()).getImage();
    
    // all general icons
    public static final GreenfootImage ICON_START = new GreenfootImage("newmooon_start.png");
    public static final GreenfootImage ICON_OK = new GreenfootImage("newmooon_ok.png");
    public static final GreenfootImage ICON_ARROW_RIGHT = new GreenfootImage("newmooon_arrow_right.png");
    public static final GreenfootImage ICON_ARROW_LEFT = new GreenfootImage("newmooon_arrow_left.png");
    public static final GreenfootImage ICON_LOCKED = new GreenfootImage("newmooon_locked.png");
    public static final GreenfootImage ICON_HOME = new GreenfootImage("newmooon_home.png");
    public static final GreenfootImage ICON_RELOAD = new GreenfootImage("newmooon_reload.png");
    public static final GreenfootImage ICON_FLAG = new GreenfootImage("fatcow_flag.png");
    public static final GreenfootImage ICON_TROPHY = new GreenfootImage("impressions_trophy.png");
    public static final GreenfootImage ICON_HIGHSCORE = new GreenfootImage("icon_highscore.png");
    public static final GreenfootImage ICON_GOLD = new GreenfootImage("fatcow_star_gold.png");
    public static final GreenfootImage ICON_SILVER = new GreenfootImage("fatcow_star_silver.png");
    public static final GreenfootImage ICON_BRONZE = new GreenfootImage("fatcow_star_bronze.png");

    // the screen states
    private ScreenState startState;
    private ScreenState enterNameState;
    private ScreenState levelSplashState;
    private ScreenState gameState;
    private ScreenState levelCompleteState;;
    private ScreenState gameCompleteState;
    private ScreenState highscoreState;

    private ScreenState state;

    private GreenfootImage defaultBackground;

    private Level[] allLevels;
    private HighscoreManager highscoreManager;
    private int currentLevelNumber;
    private int numberOfMoves;
    private boolean levelComplete;

    /**
     * Constructor for World.
     */
    public GameScreen() 
    {
        // Create a new world with the specified cells
        super(WIDTH_IN_CELLS, HEIGHT_IN_CELLS, CELL_SIZE);

        setPaintOrder(Label.class, Kara.class, Tree.class, Mushroom.class, Leaf.class);
        Greenfoot.setSpeed(50);

        // Save the originial background image for later
        defaultBackground = getBackground();

        // Read all the levels from the level file
        this.allLevels = Level.parseLevelsFromFile(MyKara.LEVEL_FILE);

        // init the screen states
        startState = new StartState(this);
        enterNameState = new EnterNameState(this);
        levelSplashState = new LevelSplashState(this);
        gameState = new GameState(this);
        levelCompleteState = new LevelCompleteState(this);
        gameCompleteState = new GameCompleteState(this);
        highscoreState = new HighscoreState(this);

        // init the level number and number of moves
        currentLevelNumber = 1;
        numberOfMoves = 0;
        
        // init the highscore manager
        if (MyKara.HIGHSCORE_ENABLED)
        {
            // First tries to use the FileHighscore, if not possible, the ServerHighscore is used.
            if (FileHighscore.isAvailable())
            {
                highscoreManager = new FileHighscore();
            }
            else if (ServerHighscore.isAvailable())
            {
                highscoreManager = new ServerHighscore();
            } 
        }
        
        // skip the start menu if in developer mode
        if (MyKara.DEVELOPER_MODE)
        {
            setState(gameState);
        }
        else
        {
            setState(startState);
        }
    }
    
    /**
     * This method is called by the Greenfoot system when the execution has started.
     */
    public void started()
    {
        // Init the highscore
        if (highscoreManager != null)
        {
            highscoreManager.initHighscores();
        }
    }
    
    /**
     * Sets and initializes the specified screen state.
     * Before the new screen is initialized, all objects in the world are removed.
     * 
     * @param   state the new state of the screen
     */
    protected void setState(ScreenState state)
    {
        setState(state, true);
    }

    /**
     * Sets and initializes the specified screen state.
     * 
     * @param   state the new state of the screen
     * @param   clearWorld if true, all objects in the world are removed before the new state
     *          is initialized.
     */
    protected void setState(ScreenState state, boolean clearWorld)
    {
        if (clearWorld)
        {
            // Remove all objects in the world
            removeObjects(getObjects(null));
        }
        this.state = state;
        state.initScreen();
    }

    /**
     * Returns the start screen state.
     */
    protected ScreenState getStartState()
    {
        return startState;
    }

    /**
     * Returns the enter name screen state.
     */
    protected ScreenState getEnterNameState()
    {
        return enterNameState;
    }

    /**
     * Returns the level splash screen state.
     */
    protected ScreenState getLevelSplashState()
    {
        return levelSplashState;
    }

    /**
     * Returns the game screen state.
     */
    protected ScreenState getGameState()
    {
        return gameState;
    }   

    /**
     * Returns the level complete screen state.
     */
    protected ScreenState getLevelCompleteState()
    {
        return levelCompleteState;
    }   

    /**
     * Returns the game complete screen state.
     */
    protected ScreenState getGameCompleteState()
    {
        return gameCompleteState;
    }   

    /**
     * Returns the highscore screen state.
     */
    protected ScreenState getHighscoreState()
    {
        return highscoreState;
    }   

    /**
     * Shows the default background image that was chosen for this Class.
     */
    protected void showDefaultBackground()
    {
        setBackground(defaultBackground);
    }

    /**
     * Returns all the levels.
     */
    protected Level[] getAllLevels()
    {
        return allLevels;
    }

    /**
     * Returns the total number of levels.
     */
    protected int getNumberOfLevels()
    {
        return allLevels.length;
    }

    /**
     * Sets the level number for the current level.
     */
    protected void setCurrentLevelNumber(int currentLevelNumber)
    {
        this.currentLevelNumber = currentLevelNumber;
    }

    /**
     * Returns the level number for the current level.
     */
    protected int getCurrentLevelNumber()
    {
        return currentLevelNumber;
    }

    /**
     * Returns the current level.
     */
    protected Level getCurrentLevel()
    {
        if (currentLevelNumber > 0 && currentLevelNumber - 1 < allLevels.length)
        {
            return allLevels[currentLevelNumber - 1];
        }
        return null;
    }

    /**
     * Returns the level with the specified number.
     */
    protected Level getLevel(int levelNumber)
    {
        if (levelNumber > 0 && levelNumber - 1 < allLevels.length)
        {
            return allLevels[levelNumber - 1];
        }
        return null;
    }
    
    /**
     * Returns the number of moves that were made.
     */
    protected int getNumberOfMoves()
    {
        return numberOfMoves;
    }

    /**
     * Sets the number of moves.
     */
    protected void setNumberOfMoves(int moves)
    {
        numberOfMoves = moves;
    }

    /**
     * Returns true if the current level is complete.
     */
    protected boolean isLevelComplete()
    {
        return levelComplete;
    }

    /**
     * Sets whether the current level is complete.
     */
    protected void setLevelComplete(boolean levelComplete)
    {
        this.levelComplete = levelComplete;
    }

    /**
     * Returns whether the game is complete, i.e. the last level is completed.
     * 
     * @return true if the game is complete
     */
    protected boolean isGameComplete()
    {
        return isLevelComplete() && getCurrentLevelNumber() >= getNumberOfLevels();
    }
    
    /**
     * Returns if the highscore is enabled and available.
     */
    protected boolean isHighscoreAvailable()
    {
        return highscoreManager != null;
    }
    
    /**
     * Returns if the highscore is enabled and available.
     */
    protected boolean isHighscoreReadOnly()
    {
        if (highscoreManager == null)
        {
            return true;
        }
        
        return highscoreManager.isReadOnly();
    }
    
    /**
     * Returns the name of the current player or empty String if none has been set.
     */
    protected String getPlayerName()
    {
        if (highscoreManager == null)
        {
            return "";
        }
        return highscoreManager.getCurrentPlayerName();
    }

    /**
     * Sets the name of the current player. (Will be ignored if ServerHighscore is
     * used since the username of UserInfo is used).
     */
    protected void setPlayerName(String playerName)
    {
        if (highscoreManager == null)
        {
            return;
        }
        highscoreManager.setCurrentPlayerName(playerName);
    }
    
    /**
     * Returns true if the name of the current player can be set.
     */
    protected boolean canSetPlayerName()
    {
        // Name of player can only be set if using the FileHighscore.
        return highscoreManager instanceof FileHighscore;
    }

    /**
     * Returns the Highscore for the current level.
     * May be null.
     */
    protected Highscore getHighscoreForCurrentLevel()
    {
        return getHighscoreForLevel(currentLevelNumber);
    }
    
    /**
     * Returns the Highscore for the specified level.
     */
    protected Highscore getHighscoreForLevel(int levelNumber)
    {
        if (highscoreManager == null)
        {
            return null;
        }
        return highscoreManager.getHighscoreForLevel(levelNumber);
    }

    /**
     * Sets the specified Highscore.
     */
    protected void setHighscore(Highscore highscore)
    {
        highscoreManager.setHighscore(highscore);
    }

    /**
     * Generates a level definition from all the actors currently in the world and prints it
     * to system out. 
     * <p>
     * Usage: Drag and Drop the Actors into the World, then call this method on the world to get 
     * the level as ASCII text. <br>
     * This level definition can then be copied into a level text file.
     */
    public void generateASCIILevel()
    {
        List<Actor> actors = getObjects(Actor.class);
        Level l = Level.createLevelFromActors(actors, 0, "XXXX");
        System.out.println(";-------------------------- START --------------------------");
        System.out.println(l.toString());
        System.out.println(";--------------------------- END ---------------------------\n");
    }

    /**
     * The act method is called by the greenfoot framework at each action step. 
     * The world's act method is called before the act method of any objects in 
     * the world. 
     * <p>
     * Delegates act to the current state.
     */
    public void act()
    {
        // Delegate to the current state
        state.act();
    }
    
    /**
     * Retrieves the filename of the default image and adds the on-target postfix to
     * the filename to load the on-target-image.
     * If the on target image cannot be found, the default image is returned.
     */
    private static GreenfootImage findOnTargetImage(GreenfootImage defaultImage, String onTargetPostfix)
    {
        // Since a GreenfootImage only has a toString method we must parse it to get the file name
        Pattern pattern = Pattern.compile("Image file name: (.+)(\\.+\\S{3,4})\\s+Image url");
        Matcher matcher = pattern.matcher(defaultImage.toString());

        if (matcher.find()) {
            String fileName = matcher.group(1) + onTargetPostfix + matcher.group(2);
            try
            {
                return new GreenfootImage(fileName);
            }
            catch (Exception e)
            {
                System.out.println("Could not find the file: " + fileName + " (the default file is used)");
                return defaultImage;
            }
        }
        else
        {
            // Could not find the on target image --> use default
            return defaultImage;
        }
    }
}
