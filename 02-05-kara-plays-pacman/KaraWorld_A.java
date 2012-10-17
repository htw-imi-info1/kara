import greenfoot.*;

/**
 * This class creates a world for Kara. It contains settings for height and 
 * width of the world and initializes the Actors.
 * 
 * @author Marco Jakob (majakob@gmx.ch)
 * @version 1.3 (2012-07-04)
 */
public class KaraWorld_A extends World 
{   
    private static final int WORLD_WIDTH = 9;  // Number of horizontal cells
    private static final int WORLD_HEIGHT = 9;  // Number of vertical cells

    private static final int CELL_SIZE = 28; // Size of one cell

    /**
     * Creates a world for Kara.
     */
    public KaraWorld_A() 
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
        Tree tree = new Tree();
        addObject(tree, 0, 0);
        Tree tree2 = new Tree();
        addObject(tree2, 0, 1);
        Tree tree3 = new Tree();
        addObject(tree3, 0, 2);
        Leaf leaf = new Leaf();
        addObject(leaf, 1, 1);
        Leaf leaf2 = new Leaf();
        addObject(leaf2, 2, 1);
        Leaf leaf3 = new Leaf();
        addObject(leaf3, 3, 1);
        Leaf leaf4 = new Leaf();
        addObject(leaf4, 4, 1);
        Leaf leaf5 = new Leaf();
        addObject(leaf5, 5, 1);
        Leaf leaf6 = new Leaf();
        addObject(leaf6, 6, 1);
        Leaf leaf7 = new Leaf();
        addObject(leaf7, 7, 1);
        Leaf leaf8 = new Leaf();
        addObject(leaf8, 7, 2);
        Leaf leaf9 = new Leaf();
        addObject(leaf9, 7, 3);
        Leaf leaf10 = new Leaf();
        addObject(leaf10, 7, 4);
        Leaf leaf11 = new Leaf();
        addObject(leaf11, 7, 5);
        Leaf leaf12 = new Leaf();
        addObject(leaf12, 7, 6);
        Leaf leaf13 = new Leaf();
        addObject(leaf13, 6, 6);
        Leaf leaf14 = new Leaf();
        addObject(leaf14, 5, 6);
        Leaf leaf15 = new Leaf();
        addObject(leaf15, 5, 5);
        Leaf leaf16 = new Leaf();
        addObject(leaf16, 5, 4);
        Leaf leaf17 = new Leaf();
        addObject(leaf17, 5, 3);
        Leaf leaf18 = new Leaf();
        addObject(leaf18, 4, 3);
        Leaf leaf19 = new Leaf();
        addObject(leaf19, 3, 3);
        Leaf leaf20 = new Leaf();
        addObject(leaf20, 2, 3);
        Leaf leaf21 = new Leaf();
        addObject(leaf21, 1, 3);
        Leaf leaf22 = new Leaf();
        addObject(leaf22, 1, 4);
        Leaf leaf23 = new Leaf();
        addObject(leaf23, 1, 5);
        Leaf leaf24 = new Leaf();
        addObject(leaf24, 2, 5);
        Leaf leaf25 = new Leaf();
        addObject(leaf25, 3, 5);
        Leaf leaf26 = new Leaf();
        addObject(leaf26, 3, 6);
        Leaf leaf27 = new Leaf();
        addObject(leaf27, 3, 7);
        Leaf leaf28 = new Leaf();
        addObject(leaf28, 2, 7);
        Leaf leaf29 = new Leaf();
        addObject(leaf29, 1, 7);
        MyKara mykara = new MyKara();
        addObject(mykara, 1, 7);
    }
}
