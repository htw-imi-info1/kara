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
        addObject(tree, 7, 1);
        Tree tree2 = new Tree();
        addObject(tree2, 6, 1);
        Tree tree3 = new Tree();
        addObject(tree3, 5, 1);
        Tree tree4 = new Tree();
        addObject(tree4, 4, 1);
        Tree tree5 = new Tree();
        addObject(tree5, 7, 2);
        Tree tree6 = new Tree();
        addObject(tree6, 7, 3);
        Tree tree7 = new Tree();
        addObject(tree7, 7, 4);
        Tree tree8 = new Tree();
        addObject(tree8, 6, 5);
        Tree tree9 = new Tree();
        addObject(tree9, 5, 5);
        Tree tree10 = new Tree();
        addObject(tree10, 4, 6);
        Tree tree11 = new Tree();
        addObject(tree11, 4, 7);
        Tree tree12 = new Tree();
        addObject(tree12, 3, 7);
        Tree tree13 = new Tree();
        addObject(tree13, 2, 7);
        Tree tree14 = new Tree();
        addObject(tree14, 1, 6);
        Tree tree15 = new Tree();
        addObject(tree15, 2, 5);
        Tree tree16 = new Tree();
        addObject(tree16, 1, 4);
        Tree tree17 = new Tree();
        addObject(tree17, 2, 3);
        Tree tree18 = new Tree();
        addObject(tree18, 3, 2);
        Leaf leaf = new Leaf();
        addObject(leaf, 2, 4);
        Leaf leaf2 = new Leaf();
        addObject(leaf2, 3, 4);
        Leaf leaf3 = new Leaf();
        addObject(leaf3, 3, 3);
        Leaf leaf4 = new Leaf();
        addObject(leaf4, 4, 3);
        Leaf leaf5 = new Leaf();
        addObject(leaf5, 4, 2);
        Leaf leaf6 = new Leaf();
        addObject(leaf6, 5, 2);
        Leaf leaf7 = new Leaf();
        addObject(leaf7, 6, 2);
        Leaf leaf8 = new Leaf();
        addObject(leaf8, 6, 3);
        Leaf leaf9 = new Leaf();
        addObject(leaf9, 5, 3);
        Leaf leaf10 = new Leaf();
        addObject(leaf10, 6, 4);
        Leaf leaf11 = new Leaf();
        addObject(leaf11, 5, 4);
        Leaf leaf12 = new Leaf();
        addObject(leaf12, 4, 4);
        Leaf leaf13 = new Leaf();
        addObject(leaf13, 4, 5);
        Leaf leaf14 = new Leaf();
        addObject(leaf14, 3, 5);
        Leaf leaf15 = new Leaf();
        addObject(leaf15, 3, 6);
        Leaf leaf16 = new Leaf();
        addObject(leaf16, 2, 6);
        MyKara mykara = new MyKara();
        addObject(mykara, 0, 4);
        mykara.turnLeft();
    }
}
