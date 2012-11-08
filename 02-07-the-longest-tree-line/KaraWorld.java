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
    private static final int WORLD_HEIGHT = 10;  // Number of vertical cells

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
        Tree tree = new Tree();
        addObject(tree, 2, 9);
        Tree tree2 = new Tree();
        addObject(tree2, 2, 8);
        Tree tree3 = new Tree();
        addObject(tree3, 2, 7);
        Tree tree4 = new Tree();
        addObject(tree4, 2, 6);
        Tree tree5 = new Tree();
        addObject(tree5, 2, 5);
        Tree tree6 = new Tree();
        addObject(tree6, 2, 4);
        Tree tree7 = new Tree();
        addObject(tree7, 4, 9);
        Tree tree8 = new Tree();
        addObject(tree8, 4, 8);
        Tree tree9 = new Tree();
        addObject(tree9, 4, 7);
        Tree tree10 = new Tree();
        addObject(tree10, 4, 6);
        Tree tree11 = new Tree();
        addObject(tree11, 7, 9);
        Tree tree12 = new Tree();
        addObject(tree12, 7, 8);
        Tree tree13 = new Tree();
        addObject(tree13, 7, 7);
        Tree tree14 = new Tree();
        addObject(tree14, 7, 6);
        Tree tree15 = new Tree();
        addObject(tree15, 7, 5);
        Tree tree16 = new Tree();
        addObject(tree16, 7, 4);
        Tree tree17 = new Tree();
        addObject(tree17, 7, 3);
        Tree tree18 = new Tree();
        addObject(tree18, 7, 2);
        Tree tree19 = new Tree();
        addObject(tree19, 7, 1);
        Tree tree20 = new Tree();
        addObject(tree20, 11, 9);
        Tree tree21 = new Tree();
        addObject(tree21, 11, 8);
        Tree tree22 = new Tree();
        addObject(tree22, 11, 7);
        Tree tree23 = new Tree();
        addObject(tree23, 13, 9);
        Tree tree24 = new Tree();
        addObject(tree24, 17, 9);
        Tree tree25 = new Tree();
        addObject(tree25, 17, 8);
        Tree tree26 = new Tree();
        addObject(tree26, 17, 7);
        Tree tree27 = new Tree();
        addObject(tree27, 17, 6);
        Tree tree28 = new Tree();
        addObject(tree28, 17, 5);
        Tree tree29 = new Tree();
        addObject(tree29, 17, 4);
        Tree tree30 = new Tree();
        addObject(tree30, 17, 3);
        
        MyKara mykara = new MyKara();
        addObject(mykara, 0, 9);
        
        Leaf leaf = new Leaf();
        addObject(leaf, 19, 9);
    }
}
