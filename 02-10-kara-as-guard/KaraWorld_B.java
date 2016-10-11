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
        Tree tree = new Tree();
        addObject(tree, 1, 1);
        Tree tree2 = new Tree();
        addObject(tree2, 2, 1);
        Tree tree3 = new Tree();
        addObject(tree3, 3, 1);
        Tree tree4 = new Tree();
        addObject(tree4, 4, 1);
        Tree tree5 = new Tree();
        addObject(tree5, 5, 1);
        Tree tree6 = new Tree();
        addObject(tree6, 6, 1);
        Tree tree7 = new Tree();
        addObject(tree7, 7, 1);
        Tree tree8 = new Tree();
        addObject(tree8, 7, 2);
        Tree tree9 = new Tree();
        addObject(tree9, 7, 3);
        Tree tree10 = new Tree();
        addObject(tree10, 7, 4);
        Tree tree11 = new Tree();
        addObject(tree11, 7, 5);
        Tree tree12 = new Tree();
        addObject(tree12, 7, 6);
        Tree tree13 = new Tree();
        addObject(tree13, 7, 7);
        Tree tree14 = new Tree();
        addObject(tree14, 6, 7);
        Tree tree15 = new Tree();
        addObject(tree15, 5, 7);
        Tree tree16 = new Tree();
        addObject(tree16, 5, 6);
        Tree tree17 = new Tree();
        addObject(tree17, 5, 5);
        Tree tree18 = new Tree();
        addObject(tree18, 5, 4);
        Tree tree19 = new Tree();
        addObject(tree19, 5, 3);
        Tree tree20 = new Tree();
        addObject(tree20, 4, 3);
        Tree tree21 = new Tree();
        addObject(tree21, 3, 3);
        Tree tree22 = new Tree();
        addObject(tree22, 3, 4);
        Tree tree23 = new Tree();
        addObject(tree23, 3, 5);
        Tree tree24 = new Tree();
        addObject(tree24, 3, 6);
        Tree tree25 = new Tree();
        addObject(tree25, 3, 7);
        Tree tree26 = new Tree();
        addObject(tree26, 2, 7);
        Tree tree27 = new Tree();
        addObject(tree27, 1, 7);
        Tree tree28 = new Tree();
        addObject(tree28, 1, 6);
        Tree tree29 = new Tree();
        addObject(tree29, 1, 5);
        Tree tree30 = new Tree();
        addObject(tree30, 1, 4);
        Tree tree31 = new Tree();
        addObject(tree31, 1, 3);
        Tree tree32 = new Tree();
        addObject(tree32, 1, 2);
        Leaf leaf = new Leaf();
        addObject(leaf, 2, 6);
        Leaf leaf2 = new Leaf();
        addObject(leaf2, 2, 5);
        Leaf leaf3 = new Leaf();
        addObject(leaf3, 2, 4);
        Leaf leaf5 = new Leaf();
        addObject(leaf5, 2, 3);
        Leaf leaf6 = new Leaf();
        addObject(leaf6, 2, 2);
        Leaf leaf7 = new Leaf();
        addObject(leaf7, 3, 2);
        Leaf leaf8 = new Leaf();
        addObject(leaf8, 4, 2);
        Leaf leaf9 = new Leaf();
        addObject(leaf9, 5, 2);
        Leaf leaf10 = new Leaf();
        addObject(leaf10, 6, 2);
        Leaf leaf11 = new Leaf();
        addObject(leaf11, 6, 3);
        Leaf leaf12 = new Leaf();
        addObject(leaf12, 6, 4);
        Leaf leaf13 = new Leaf();
        addObject(leaf13, 6, 5);
        Leaf leaf14 = new Leaf();
        addObject(leaf14, 6, 6);
        MyKara mykara = new MyKara();
        addObject(mykara, 3, 8);
        mykara.turnLeft();
        mykara.turnLeft();
    }
}
