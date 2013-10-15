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
    private static final int WORLD_WIDTH = 9;  // Number of horizontal cells
    private static final int WORLD_HEIGHT = 9;  // Number of vertical cells

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
        addObject(tree, 0, 0);
        Tree tree2 = new Tree();
        addObject(tree2, 1, 0);
        Tree tree3 = new Tree();
        addObject(tree3, 2, 0);
        Tree tree4 = new Tree();
        addObject(tree4, 3, 0);
        Tree tree5 = new Tree();
        addObject(tree5, 4, 0);
        Tree tree6 = new Tree();
        addObject(tree6, 5, 0);
        Tree tree7 = new Tree();
        addObject(tree7, 6, 0);
        Tree tree8 = new Tree();
        addObject(tree8, 7, 0);
        Tree tree9 = new Tree();
        addObject(tree9, 8, 0);
        Tree tree10 = new Tree();
        addObject(tree10, 8, 1);
        Tree tree11 = new Tree();
        addObject(tree11, 8, 2);
        Tree tree12 = new Tree();
        addObject(tree12, 8, 3);
        Tree tree13 = new Tree();
        addObject(tree13, 8, 4);
        Tree tree14 = new Tree();
        addObject(tree14, 8, 5);
        Tree tree15 = new Tree();
        addObject(tree15, 8, 6);
        Tree tree16 = new Tree();
        addObject(tree16, 8, 7);
        Tree tree17 = new Tree();
        addObject(tree17, 8, 8);
        Tree tree18 = new Tree();
        addObject(tree18, 7, 8);
        Tree tree19 = new Tree();
        addObject(tree19, 6, 8);
        Tree tree20 = new Tree();
        addObject(tree20, 5, 8);
        Tree tree21 = new Tree();
        addObject(tree21, 4, 8);
        Tree tree22 = new Tree();
        addObject(tree22, 3, 8);
        Tree tree23 = new Tree();
        addObject(tree23, 2, 8);
        Tree tree24 = new Tree();
        addObject(tree24, 1, 8);
        Tree tree25 = new Tree();
        addObject(tree25, 0, 8);
        Tree tree26 = new Tree();
        addObject(tree26, 0, 7);
        Tree tree27 = new Tree();
        addObject(tree27, 0, 6);
        Tree tree28 = new Tree();
        addObject(tree28, 0, 5);
        Tree tree29 = new Tree();
        addObject(tree29, 0, 4);
        Tree tree30 = new Tree();
        addObject(tree30, 0, 3);
        Tree tree31 = new Tree();
        addObject(tree31, 0, 2);
        Tree tree32 = new Tree();
        addObject(tree32, 0, 1);
        Leaf leaf = new Leaf();
        addObject(leaf, 5, 3);
        Leaf leaf2 = new Leaf();
        addObject(leaf2, 4, 4);
        Leaf leaf3 = new Leaf();
        addObject(leaf3, 2, 3);
        Leaf leaf4 = new Leaf();
        addObject(leaf4, 4, 1);
        Leaf leaf5 = new Leaf();
        addObject(leaf5, 5, 1);
        Leaf leaf6 = new Leaf();
        addObject(leaf6, 7, 6);
        Leaf leaf7 = new Leaf();
        addObject(leaf7, 2, 7);
        Leaf leaf8 = new Leaf();
        addObject(leaf8, 2, 7);
        Leaf leaf9 = new Leaf();
        addObject(leaf9, 3, 6);
        Leaf leaf10 = new Leaf();
        addObject(leaf10, 5, 7);
        Leaf leaf11 = new Leaf();
        addObject(leaf11, 6, 5);
        Leaf leaf12 = new Leaf();
        addObject(leaf12, 7, 2);
        Leaf leaf13 = new Leaf();
        addObject(leaf13, 4, 3);
        Leaf leaf14 = new Leaf();
        addObject(leaf14, 4, 3);
        Leaf leaf15 = new Leaf();
        addObject(leaf15, 4, 2);
        Leaf leaf16 = new Leaf();
        addObject(leaf16, 4, 2);
        Leaf leaf17 = new Leaf();
        addObject(leaf17, 2, 2);
        Leaf leaf18 = new Leaf();
        addObject(leaf18, 3, 5);
        Leaf leaf19 = new Leaf();
        addObject(leaf19, 2, 4);
        Leaf leaf20 = new Leaf();
        addObject(leaf20, 7, 4);
        Leaf leaf21 = new Leaf();
        addObject(leaf21, 5, 6);
        Leaf leaf22 = new Leaf();
        addObject(leaf22, 5, 6);
        Leaf leaf23 = new Leaf();
        addObject(leaf23, 5, 5);
         MyKara mykara = new MyKara();
        addObject(mykara, 1, 1);
       
      
    }
}
