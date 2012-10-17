import greenfoot.*;

/**
 * This class creates a world for Kara. It contains settings for height and 
 * width of the world and initializes the Actors.
 * 
 * @author Marco Jakob (majakob@gmx.ch)
 * @version 1.3 (2012-07-04)
 */
public class KaraWorld extends World 
{   
    private static final int WORLD_WIDTH = 20;  // Number of horizontal cells
    private static final int WORLD_HEIGHT = 1;  // Number of vertical cells

    private static final int CELL_SIZE = 28; // Size of one cell

    /**
     * Creates a world for Kara.
     */
    public KaraWorld() 
    {
        // Create the new world
        super(WORLD_WIDTH, WORLD_HEIGHT, CELL_SIZE);

        setPaintOrder(Kara.class, Tree.class, Mushroom.class, Leaf.class);
        Greenfoot.setSpeed(20);

        // Initialize actors
        prepare();
    }

    /**
     * Prepare the world, i.e. create all initial actors.
     * 
     * Hint:
     * First create and position all Actors with the mouse in the world.
     * Then right-click on the world and choose 'Save the World'. This will
     * automatically generate the content of this method.
     */
    private void prepare() 
    {
        MyKara mykara = new MyKara();
        addObject(mykara, 0, 0);
        Tree tree = new Tree();
        addObject(tree, 19, 0);
        Leaf leaf = new Leaf();
        addObject(leaf, 3, 0);
        Leaf leaf2 = new Leaf();
        addObject(leaf2, 6, 0);
        Leaf leaf3 = new Leaf();
        addObject(leaf3, 7, 0);
        Leaf leaf4 = new Leaf();
        addObject(leaf4, 10, 0);
        Leaf leaf5 = new Leaf();
        addObject(leaf5, 12, 0);
        Leaf leaf6 = new Leaf();
        addObject(leaf6, 14, 0);
        Leaf leaf7 = new Leaf();
        addObject(leaf7, 18, 0);
    }
}
