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
    private static final int WORLD_WIDTH = 13;  // Number of horizontal cells
    private static final int WORLD_HEIGHT = 3;  // Number of vertical cells

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
        addObject(mykara, 1, 5);
        mykara.setLocation(0, 1);


        Tree tree = new Tree();
        addObject(tree, 1, 1);
        Tree tree2 = new Tree();
        addObject(tree2, 3, 1);
        Tree tree3 = new Tree();
        addObject(tree3, 5, 1);
        Tree tree4 = new Tree();
        addObject(tree4, 7, 1);
        
        Leaf leaf = new Leaf();
        addObject(leaf, 5, 0);
        leaf.setLocation(8, 1);
    }
}
