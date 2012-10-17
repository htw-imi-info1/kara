import greenfoot.*;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * This is the superclass for all Karas containing the basic Kara methods. 
 * Programs should only be written in subclasses (e.g. MyKara).<p>
 * 
 * <i>Diese Klasse ist die Oberklasse fuer alle Karas und enthaelt die Grundfunktionen von Kara. 
 * Programme sollten nur in den Unterklassen wie MyKara geschrieben werden.</i>
 * 
 * @author Marco Jakob (majakob@gmx.ch)
 * @version 1.3 (2012-07-04)
 */
public class Kara extends Actor 
{
    private static final int DIRECTION_RIGHT = 0;
    private static final int DIRECTION_DOWN = 90;
    private static final int DIRECTION_LEFT = 180;
    private static final int DIRECTION_UP = 270; 

    /**
     * Kara makes a step in the current direction <br>
     * <i>Kara macht einen Schritt in die aktuelle Richtung</i>.
     */         
    public void move() 
    {
        // Check for a tree
        if (treeFront())
        {
            showWarning("Kara can't move because of a tree!", 
                "Kara kann sich nicht bewegen wegen einem Baum!");
            return;
        }

        // Check for a mushroom
        Mushroom mushroomFront = (Mushroom) getObjectInFront(getRotation(), 1, Mushroom.class);
        if (mushroomFront != null) 
        {
            // Check if the mushroom could be pushed to the next field
            if (getObjectInFront(getRotation(), 2, Tree.class) == null && 
            getObjectInFront(getRotation(), 2, Mushroom.class) == null)
            {
                // Push the mushroom
                moveActor(mushroomFront, getRotation());
                // Check if the mushroom is now on a leaf
                mushroomFront.updateImage();
            }
            else 
            {
                // Could not push the mushroom
                showWarning("Kara can't move because he can't push the mushroom!", 
                    "Kara kann sich nicht bewegen, da er den Pilz nicht schieben kann!");
                return;
            }
        }

        // Kara can move
        moveActor(this, getRotation());
        // No delay since we use keyboard input
        // Greenfoot.delay(1);
    }
    
    /**
     * Gets the most recently pressed key <br>
     * <i>Ermittelt die zuletzt gedrueckte Taste</i>. <p>
     * 
     * Possible Keys are "up", "down", "left", "right", "a", "b", "1", ".", etc.
     * 
     * @return the most recently pressed key as String or an empty String if none was pressed.
     */
    public String getKey()
    {
        if (!getGameScreen().isLevelComplete()) 
        {
            String key = Greenfoot.getKey();
            if (key == null)
            {
                return "";
            }
            else
            {
                return key;
            }
        }
        else
        {
            return "";
        }
    }

    /**
     * Kara turns so that he looks to the right <br>
     * <i>Kara dreht sich so, dass er nach rechts schaut</i>.
     */         
    public void setDirectionRight() 
    {
        setRotation(DIRECTION_RIGHT);
    }

    /**
     * Kara turns so that he looks down <br>
     * <i>Kara dreht sich so, dass er nach unten schaut</i>.
     */         
    public void setDirectionDown() 
    {
        setRotation(DIRECTION_DOWN);
    }

    /**
     * Kara turns so that he looks to the left <br>
     * <i>Kara dreht sich so, dass er nach links schaut</i>.
     */    
    public void setDirectionLeft() 
    {
        setRotation(DIRECTION_LEFT);
    }

    /**
     * Kara turns so that he looks up <br>
     * <i>Kara dreht sich so, dass er nach oben schaut</i>.
     */       
    public void setDirectionUp() 
    {
        setRotation(DIRECTION_UP);
    }

    /**
     * Kara checks if there is a tree in front of him <br>
     * <i>Kara schaut nach, ob sich ein Baum vor ihm befindet</i>.
     * 
     * @return true if there is a tree in front of Kara, false otherwise
     */     
    public boolean treeFront() 
    {
        return getObjectInFront(getRotation(), 1, Tree.class) != null;
    }
    
    /**
     * Kara checks if there is a tree on his left side <br>
     * <i>Kara schaut nach, ob sich ein Baum links von ihm befindet</i>.
     * 
     * @return true if Kara has a tree on his left, false otherwise
     */         
    public boolean treeLeft() 
    {
        return getObjectInFront(modulo(getRotation() -  90, 360), 1, Tree.class) != null;
    }

    /**
     * Kara checks if there is a tree on his right side <br>
     * <i>Kara schaut nach, ob sich ein Baum rechts von ihm befindet</i>.
     * 
     * @return true if Kara has a tree on his right, false otherwise
     */         
    public boolean treeRight() 
    {
        return getObjectInFront(modulo(getRotation() +  90, 360), 1, Tree.class) != null;
    }

    /**
     * Kara checks if there is a mushroom in front of him <br>
     * <i>Kara schaut nach, ob er einen Pilz vor sich hat</i>.
     * 
     * @return true if a mushroom is in front of a Kara, false otherwise
     */         
    public boolean mushroomFront() 
    {
        return getObjectInFront(getRotation(), 1, Mushroom.class) != null;
    }

    /**
     * Kara checks if he can push a mushroom <br>
     * <i>Kara schaut nach, ob er einen Pilz stossen kann</i>.
     * 
     * @return true if Kara can push a mushroom, false otherwise 
     */
    public boolean canPushMushroom()
    {
        // first check if there actually is a mushroom in front of Kara
        if (mushroomFront())
        {
            // check if the mushroom can be pushed
            if (getObjectInFront(getRotation(), 2, Tree.class) == null && getObjectInFront(getRotation(), 2, Mushroom.class) == null)
            {
                return true;
            }
        }
        else 
        {
            showWarning("Should check if Kara can push a mushroom but there is no mushroom in front of Kara!", 
                    "Soll testen, ob Kara einen Pilz stossen kann. Kara steht aber gar nicht vor einem Pilz!");
        }

        return false;
    }

    /**
     * Sets the number of moves the player has made <br>
     * <i>Setzt die Anzahl Bewegungen, die der Spieler gemacht hat</i>.
     */
    public void setNumberOfMoves(int moves)
    {
        getGameScreen().setNumberOfMoves(moves);
    }

    /**
     * Checks if the level is complete (all mushrooms on a leaf) <br>
     * <i>Prueft, ob der Level fertig ist (alle Pilze stehen auf einem Blatt)</i>.
     * 
     * @return true if the level is complete, false otherwise
     */
    public boolean testLevelComplete()
    {
        List<Mushroom> mushrooms = getGameScreen().getObjects(Mushroom.class);

        // Test all mushrooms if they are on a leaf
        for (Mushroom m : mushrooms)
        {
            if (getGameScreen().getObjectsAt(m.getX(), m.getY(), Leaf.class).size() == 0)
            {
                // Mushroom is not on a leaf
                return false;
            }
        }

        // All mushrooms are on a leaf
        return true;
    }

    /**
     * Marks the current level as complete <br>
     * <i>Markiert den aktuellen Level als fertig</i>.
     */
    public void levelComplete()
    {
        getGameScreen().setLevelComplete(true);
    }
    
    /**
     * Adds the entry to the highscore list <br>
     * <i>Fuegt einen Eintrag in die Highscoreliste ein</i>.
     */
    public void addHighscoreEntry(int moves)
    {
        if (!getGameScreen().isHighscoreReadOnly())
        {
            Highscore h = getGameScreen().getHighscoreForCurrentLevel();
            if (h == null)
            {
                showWarning("Highscore is not available!",
                        "Die Highscore ist nicht verfuegbar!");
            }
            
            int place = h.addHighscoreEntry(getGameScreen().getPlayerName(), moves);
            if (place == -1)
            {
                // entry is not in the highscore
                showWarning("The highscore entry is not in the top 3. You can't add it!", 
                        "Der Eintrag in die Highscore ist nicht in den Top 3. Er kann nicht hinzugefuegt werden!");
                return;
            }
            else
            {
                getGameScreen().setHighscore(h);
            }
        }
    }
    
    /**
     * Returns if the number of moves would be in the top 3 of the highscore list <br>
     * <i>Ermittelt, ob die Anzahl Bewegungen fuer die Top 3 in der Highscore reichen wuerden</i>.
     */
    public boolean isHighscoreTop3(int moves)
    {
        Highscore h = getGameScreen().getHighscoreForCurrentLevel();
        if (h == null)
        {
            return false;
        }
        return h.isHighscoreTop3(moves);
    }

    /*-------------------- privat methods -----------------------*/

    /**
     * Returns the game screen.
     */
    private GameScreen getGameScreen()
    {
        return (GameScreen) getWorld();
    }

    /**
     * Finds an object in the specified direction. 
     * 
     * @param direction the direction in which to look for the object
     * @param steps number of cells to look ahead (1 means the next field, etc.)
     * @param clazz the (actor) class to look for
     * @return the object that was found or null if none was found
     */
    private Object getObjectInFront(int direction, int steps, Class clazz) 
    {
        int x = getX();
        int y = getY();

        // Change x und y depending on the direction
        switch (direction)
        {
            case DIRECTION_RIGHT:
            x = modulo((x + steps), getWorld().getWidth());
            break;

            case DIRECTION_DOWN:
            y = modulo((y + steps), getWorld().getHeight());
            break;

            case DIRECTION_LEFT:
            x = modulo((x - steps), getWorld().getWidth());
            break;

            case DIRECTION_UP:
            y = modulo((y - steps), getWorld().getHeight());
            break;

            default: // Not a valid direction
            return null;
        }

        List objects = getWorld().getObjectsAt(x, y, clazz);

        if (objects != null && objects.size() > 0)
        {
            return objects.get(0);
        }
        else 
        {
            return null;
        }
    }

    /**
     * Moves the actor one step in the specified direction.
     * 
     * @param actor the actor to be moved
     * @param direction the direction to move
     */
    private void moveActor(Actor actor, int direction) 
    {
        switch(direction)
        {
            case DIRECTION_RIGHT:
            actor.setLocation(modulo((actor.getX() + 1), getWorld().getWidth()), actor.getY());
            break;

            case DIRECTION_DOWN:
            actor.setLocation(actor.getX(), modulo((actor.getY() + 1), getWorld().getHeight()));
            break;

            case DIRECTION_LEFT:
            actor.setLocation(modulo((actor.getX() - 1), getWorld().getWidth()), actor.getY());
            break;

            case DIRECTION_UP:
            actor.setLocation(actor.getX(), modulo((actor.getY() - 1), getWorld().getHeight()));
            break;
            
            default: // Not a valid direction
            break;
        }
    }

    /**
     * A special modulo operation that never returns a negative number. This is 
     * necessary to always stay inside the grid of the world. <p>
     * The Java modulo operation would return -1 for something like -1%10, but we
     * would need 9. <p>
     * Note: Depending on the programming language, the modulo operation for negative
     * numbers is defined differently.
     * 
     * @param a the first operand
     * @param b the second operand
     * @return the result of the modulo operation, always positive
     */
    private int modulo(int a, int b) 
    {
        return (a % b + b) % b;
    }

    /**
     * Shows a popup with a warning message containing both the english
     * or german message.
     */
    private void showWarning(String englishMessage, String germanMessage) {
        String message = "<html>" + englishMessage + "<p><i>" + germanMessage + "</i></html>";
        
        Object[] options = {"OK", "Exit Program"}; 
        int choice = JOptionPane.showOptionDialog(null, message, "Warning", JOptionPane.DEFAULT_OPTION, 
                JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        
        if (choice == 1) {
            // Emergency stop. Greenfoot should restart after this.
            System.exit(0);
        }
        else 
        {
            // Stop. This will still finish the act()-method.
            Greenfoot.stop();
            // Repaint, otherwise the world might keep displaying a dialog in some cases
            getWorld().repaint();
        }
    }
}
