import greenfoot.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A Level contains information about the positions of the actors on the game screen.
 * <p>
 * The levels can be read from a text file which must have the following structure:
 * <p>
 * Each level must start with the Word 'Level:' and the corresponding level-number.
 * This is followed by a line starting with 'Password:' and the password. <br>
 * <p>
 * After the level number and the password, the actor positions are described with the 
 * following signs:
 * <ul>
 * <li>Kara: @
 * <li>Tree: #
 * <li>Leaf: .
 * <li>Mushroom: $
 * <li>Mushroom on Leaf: *
 * <li>Kara on Leaf: +
 * <li>Empty Field: Space
 * </ul>
 * <p>
 * A line starting with a Semicolon (;) is a comment and is ignored by the parser.
 * 
 * @author Marco Jakob (majakob@gmx.ch)
 * @version 1.3 (2012-07-04)
 */
public class Level  
{
    public static final int MAX_LEVELS = 105; // Limit because of ServerHighscore

    public static final char UNDEFINED = '?';
    public static final char EMPTY = ' ';
    public static final char KARA = '@';
    public static final char TREE = '#';
    public static final char LEAF = '.';
    public static final char MUSHROOM = '$';
    public static final char MUSHROOM_LEAF = '*'; // Mushroom on a leaf
    public static final char KARA_LEAF = '+'; // Kara on a leaf
    
    private int levelNumber = -1;
    private String levelPassword = "";
    private char[][] actorPositions;  

    /**
     * Constructor for a Level.
     */
    public Level(int levelNumber)
    {
        this.levelNumber = levelNumber;

        actorPositions = new char[GameScreen.HEIGHT_IN_CELLS][GameScreen.WIDTH_IN_CELLS];
        for (char[] row : actorPositions)
        {
            Arrays.fill(row, EMPTY);
        }
    }

    /**
     * Returns the level number.
     */
    public int getLevelNumber()
    {
        return levelNumber;
    }

    /**
     * Returns the level password.
     */
    public String getLevelPassword()
    {
        return levelPassword;
    }

    /**
     * Returns the actor type as character (see class description).
     */
    public char getActorTypeAt(int x, int y)
    {
        if (y > actorPositions.length || y < 0 || x > actorPositions[y].length || x < 0)
        {
            return UNDEFINED;
        }
        return actorPositions[y][x];
    }

    /**
     * Returns an image representation of this level with all the actors.
     */
    public GreenfootImage toImage()
    {
        GreenfootImage img = new GreenfootImage(GameScreen.WIDTH_IN_PIXELS, GameScreen.HEIGHT_IN_PIXELS);

        for (int x = 0; x < GameScreen.WIDTH_IN_CELLS; x++)
        {
            for (int y = 0; y < GameScreen.HEIGHT_IN_CELLS; y++)
            {
                switch(this.getActorTypeAt(x, y))
                {
                    case Level.KARA: 
                    img.drawImage(GameScreen.ICON_MY_KARA, x * GameScreen.CELL_SIZE + 10, y * GameScreen.CELL_SIZE); 
                    break;

                    case Level.TREE: 
                    img.drawImage(GameScreen.ICON_TREE, x * GameScreen.CELL_SIZE + 10, y * GameScreen.CELL_SIZE); 
                    break;

                    case Level.LEAF: 
                    img.drawImage(GameScreen.ICON_LEAF, x * GameScreen.CELL_SIZE + 10, y * GameScreen.CELL_SIZE); 
                    break;

                    case Level.MUSHROOM: 
                    img.drawImage(GameScreen.ICON_MUSHROOM, x * GameScreen.CELL_SIZE + 10, y * GameScreen.CELL_SIZE); 
                    break;

                    case Level.MUSHROOM_LEAF: 
                    img.drawImage(GameScreen.ICON_LEAF, x * GameScreen.CELL_SIZE + 10, y * GameScreen.CELL_SIZE); 
                    img.drawImage(GameScreen.ICON_MUSHROOM_ON_TARGET, x * GameScreen.CELL_SIZE + 10, y * GameScreen.CELL_SIZE); 
                    break;

                    case Level.KARA_LEAF: 
                    img.drawImage(GameScreen.ICON_LEAF, x * GameScreen.CELL_SIZE + 10, y * GameScreen.CELL_SIZE); 
                    img.drawImage(GameScreen.ICON_MY_KARA, x * GameScreen.CELL_SIZE + 10, y * GameScreen.CELL_SIZE); 
                    break;
                }
            }
        }

        return img;
    }

    /**
     * Returns a String representation of this level.
     */
    public String toString()
    {
        StringBuffer buf = new StringBuffer();
        buf.append("Level: " + levelNumber + "\n");
        buf.append("Password: " + levelPassword + "\n");
        for (int y = 0; y < actorPositions.length; y++)
        {
            buf.append(String.valueOf(actorPositions[y]));
            buf.append("\n");
        }
        return buf.toString();
    }

    /**
     * Returns true if the level actor positions are equal.
     */
    public boolean equals(Object o)
    {
        if (o == null || !(o instanceof Level))
        {
            return false;
        }
        Level other = (Level)o;

        if (this.getActorPositions().length != other.getActorPositions().length)
        {
            return false;
        }

        for (int i = 0; i < this.getActorPositions().length; i++)
        {
            if (! Arrays.equals(this.getActorPositions()[i], other.getActorPositions()[i]))
            {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns the actor positions.
     */
    private char[][] getActorPositions()
    {
        return actorPositions;
    }

    /**
     * Set the actor type at the specified position.
     */
    private void setActorTypeAt(int x, int y, char actorType)
    {
        actorPositions[y][x] = actorType;
    }

    /**
     * Set the level password.
     */
    private void setLevelPassword(String levelPassword)
    {
        this.levelPassword = levelPassword;
    }

    /**
     * Parses all the Levels from the specified Level File.
     * 
     * @return the levels as an array
     */
    public static Level[] parseLevelsFromFile(String levelFile)
    {
        List<Level> result = new ArrayList<Level>();

        try
        {
            BufferedReader input =  new BufferedReader(
                    new InputStreamReader(Level.class.getClassLoader().getResource(levelFile).openStream()));
            String line;
            Level currentLevel = null;
            int currentLevelY = 0;
            int currentLevelNumber = 1;

            try 
            {
                while ((line = input.readLine()) != null)
                {
                    if (!line.startsWith(";"))
                    {
                        if (line.startsWith("Level:"))
                        {
                            if (currentLevelNumber > MAX_LEVELS)
                            {
                                break; // stop while loop
                            }
                            currentLevel =  new Level(currentLevelNumber);
                            currentLevelY = 0;
                            currentLevelNumber++;
                            result.add(currentLevel);
                        }
                        else if (line.startsWith("Password:"))
                        {
                            currentLevel.setLevelPassword(line.substring("Password:".length()).trim());
                        }
                        else if (currentLevelY < GameScreen.HEIGHT_IN_CELLS)
                        {
                            if (line.matches("[@#.$\\s*+]+"))
                            {
                                char[] lineChars = line.toCharArray();
                                int length = Math.min(lineChars.length, GameScreen.WIDTH_IN_CELLS);
                                System.arraycopy(lineChars, 0, currentLevel.getActorPositions()[currentLevelY], 0, length);

                                currentLevelY++;
                            }
                        }
                    }
                }
            }
            finally {
                input.close();
            }
        }
        catch (Exception ex){
            System.out.println("ERROR: Could not load levels from file: " + levelFile);
            ex.printStackTrace();
        }

        return result.toArray(new Level[result.size()]);
    }

    /**
     * Creates a Level from all the actors in the list.
     * 
     * @return the level
     */
    public static Level createLevelFromActors(List<Actor> actors, int levelNumber, String password)
    {
        Level level = new Level(levelNumber);
        level.setLevelPassword(password);

        for (Actor actor : actors)
        {
            if (actor instanceof Kara)
            {
                if (level.getActorTypeAt(actor.getX(), actor.getY()) == LEAF)
                {
                    level.setActorTypeAt(actor.getX(), actor.getY(), KARA_LEAF);
                }
                else
                {
                    level.setActorTypeAt(actor.getX(), actor.getY(), KARA); 
                }
            } 
            else if (actor instanceof Tree)
            {
                level.setActorTypeAt(actor.getX(), actor.getY(), TREE); 
            } 
            else if (actor instanceof Leaf)
            {
                if (level.getActorTypeAt(actor.getX(), actor.getY()) == KARA)
                {
                    level.setActorTypeAt(actor.getX(), actor.getY(), KARA_LEAF);
                }
                else if (level.getActorTypeAt(actor.getX(), actor.getY()) == MUSHROOM)
                {
                    level.setActorTypeAt(actor.getX(), actor.getY(), MUSHROOM_LEAF); 
                } 
                else
                {
                    level.setActorTypeAt(actor.getX(), actor.getY(), LEAF); 
                }
            } 
            else if (actor instanceof Mushroom)
            {
                if (level.getActorTypeAt(actor.getX(), actor.getY()) == LEAF)
                {
                    level.setActorTypeAt(actor.getX(), actor.getY(), MUSHROOM_LEAF);
                }
                else
                {
                    level.setActorTypeAt(actor.getX(), actor.getY(), MUSHROOM); 
                }
            } 
        }

        return level;
    }
}
