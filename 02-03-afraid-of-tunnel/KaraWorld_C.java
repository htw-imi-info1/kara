import greenfoot.*;

/**
 * This class creates a world for Kara. It contains settings for height and 
 * width of the world and initializes the Actors.
 * 
 * @author Marco Jakob (majakob@gmx.ch)
 * @version 1.3 (2012-07-04)
 */
public class KaraWorld_C extends World 
{   
    private static final int WORLD_WIDTH = 9;  // Number of horizontal cells
    private static final int WORLD_HEIGHT = 3;  // Number of vertical cells

    private static final int CELL_SIZE = 28; // Size of one cell

    /**
     * Creates a world for Kara.
     */
    public KaraWorld_C() 
    {
        // Create the new world
        super(WORLD_WIDTH, WORLD_HEIGHT, CELL_SIZE);

        setPaintOrder(Kara.class, Tree.class, Mushroom.class, Leaf.class);
        Greenfoot.setSpeed(40);

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
        Tree tree12 = new Tree();
        addObject(tree12, 3, 0);
        Tree tree13 = new Tree();
        addObject(tree13, 4, 0);
        Tree tree14 = new Tree();
        addObject(tree14, 5, 0);
        Tree tree15 = new Tree();
        addObject(tree15, 6, 0);
        Tree tree16 = new Tree();
        addObject(tree16, 7, 0);
        Tree tree17 = new Tree();
        addObject(tree17, 8, 0);
        Tree tree18 = new Tree();
        addObject(tree18, 8, 2);
        Tree tree19 = new Tree();
        addObject(tree19, 7, 2);
        Tree tree20 = new Tree();
        addObject(tree20, 6, 2);
        Tree tree21 = new Tree();
        addObject(tree21, 5, 2);
        Tree tree22 = new Tree();
        addObject(tree22, 4, 2);
        Tree tree23 = new Tree();
        addObject(tree23, 3, 2);
        MyKara mykara = new MyKara();
        addObject(mykara, 3, 1);
    }
}
