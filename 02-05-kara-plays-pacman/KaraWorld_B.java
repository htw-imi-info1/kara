import greenfoot.*;

/**
 * This class creates a world for Kara. It contains settings for height and 
 * width of the world and initializes the Actors.
 * 
 * @author Marco Jakob (majakob@gmx.ch)
 * @version 1.3 (2012-07-04)
 */
public class KaraWorld_B extends World 
{   
    private static final int WORLD_WIDTH = 9;  // Number of horizontal cells
    private static final int WORLD_HEIGHT = 9;  // Number of vertical cells

    private static final int CELL_SIZE = 28; // Size of one cell

    /**
     * Creates a world for Kara.
     */
    public KaraWorld_B() 
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
        Tree tree4 = new Tree();
        addObject(tree4, 0, 6);
        Tree tree5 = new Tree();
        addObject(tree5, 0, 7);
        Tree tree6 = new Tree();
        addObject(tree6, 0, 8);
        Leaf leaf30 = new Leaf();
        addObject(leaf30, 1, 7);
        Leaf leaf31 = new Leaf();
        addObject(leaf31, 2, 7);
        Leaf leaf32 = new Leaf();
        addObject(leaf32, 2, 8);
        Leaf leaf33 = new Leaf();
        addObject(leaf33, 3, 8);
        Leaf leaf34 = new Leaf();
        addObject(leaf34, 4, 8);
        Leaf leaf35 = new Leaf();
        addObject(leaf35, 5, 8);
        Leaf leaf36 = new Leaf();
        addObject(leaf36, 6, 8);
        Leaf leaf37 = new Leaf();
        addObject(leaf37, 6, 7);
        Leaf leaf38 = new Leaf();
        addObject(leaf38, 7, 7);
        Leaf leaf39 = new Leaf();
        addObject(leaf39, 7, 6);
        Leaf leaf40 = new Leaf();
        addObject(leaf40, 7, 5);
        Leaf leaf41 = new Leaf();
        addObject(leaf41, 7, 4);
        Leaf leaf42 = new Leaf();
        addObject(leaf42, 7, 3);
        Leaf leaf43 = new Leaf();
        addObject(leaf43, 7, 2);
        Leaf leaf44 = new Leaf();
        addObject(leaf44, 6, 2);
        Leaf leaf45 = new Leaf();
        addObject(leaf45, 5, 2);
        Leaf leaf46 = new Leaf();
        addObject(leaf46, 5, 3);
        Leaf leaf47 = new Leaf();
        addObject(leaf47, 5, 4);
        Leaf leaf48 = new Leaf();
        addObject(leaf48, 5, 5);
        Leaf leaf49 = new Leaf();
        addObject(leaf49, 4, 5);
        Leaf leaf50 = new Leaf();
        addObject(leaf50, 3, 5);
        Leaf leaf51 = new Leaf();
        addObject(leaf51, 2, 5);
        Leaf leaf52 = new Leaf();
        addObject(leaf52, 1, 5);
        Leaf leaf53 = new Leaf();
        addObject(leaf53, 1, 4);
        Leaf leaf54 = new Leaf();
        addObject(leaf54, 1, 3);
        Leaf leaf55 = new Leaf();
        addObject(leaf55, 2, 3);
        Leaf leaf56 = new Leaf();
        addObject(leaf56, 3, 3);
        Leaf leaf57 = new Leaf();
        addObject(leaf57, 3, 2);
        Leaf leaf58 = new Leaf();
        addObject(leaf58, 3, 1);
        Leaf leaf59 = new Leaf();
        addObject(leaf59, 2, 1);
    
        MyKara mykara2 = new MyKara();
        addObject(mykara2, 2, 1);
    }
}
