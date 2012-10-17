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
        addObject(tree9, 7, 1);
        Tree tree10 = new Tree();
        addObject(tree10, 7, 2);
        Tree tree11 = new Tree();
        addObject(tree11, 7, 3);
        Tree tree12 = new Tree();
        addObject(tree12, 7, 5);
        Tree tree13 = new Tree();
        addObject(tree13, 7, 6);
        Tree tree14 = new Tree();
        addObject(tree14, 7, 7);
        Tree tree15 = new Tree();
        addObject(tree15, 7, 8);
        Tree tree16 = new Tree();
        addObject(tree16, 6, 8);
        Tree tree17 = new Tree();
        addObject(tree17, 5, 8);
        Tree tree18 = new Tree();
        addObject(tree18, 4, 8);
        Tree tree19 = new Tree();
        addObject(tree19, 3, 8);
        Tree tree20 = new Tree();
        addObject(tree20, 2, 8);
        Tree tree21 = new Tree();
        addObject(tree21, 1, 8);
        Tree tree22 = new Tree();
        addObject(tree22, 0, 8);
        Tree tree23 = new Tree();
        addObject(tree23, 0, 7);
        Tree tree24 = new Tree();
        addObject(tree24, 0, 6);
        Tree tree25 = new Tree();
        addObject(tree25, 0, 5);
        Tree tree26 = new Tree();
        addObject(tree26, 0, 4);
        Tree tree27 = new Tree();
        addObject(tree27, 0, 3);
        Tree tree28 = new Tree();
        addObject(tree28, 0, 2);
        Tree tree29 = new Tree();
        addObject(tree29, 0, 1);
        Tree tree30 = new Tree();
        addObject(tree30, 8, 5);
        Tree tree31 = new Tree();
        addObject(tree31, 9, 5);
        Tree tree32 = new Tree();
        addObject(tree32, 10, 5);
        Tree tree33 = new Tree();
        addObject(tree33, 11, 5);
        Tree tree34 = new Tree();
        addObject(tree34, 19, 0);
        Tree tree35 = new Tree();
        addObject(tree35, 18, 0);
        Tree tree36 = new Tree();
        addObject(tree36, 17, 0);
        Tree tree37 = new Tree();
        addObject(tree37, 16, 0);
        Tree tree38 = new Tree();
        addObject(tree38, 15, 0);
        Tree tree39 = new Tree();
        addObject(tree39, 14, 0);
        Tree tree40 = new Tree();
        addObject(tree40, 13, 0);
        Tree tree41 = new Tree();
        addObject(tree41, 12, 0);
        Tree tree42 = new Tree();
        addObject(tree42, 12, 1);
        Tree tree43 = new Tree();
        addObject(tree43, 12, 2);
        Tree tree44 = new Tree();
        addObject(tree44, 12, 3);
        Tree tree45 = new Tree();
        addObject(tree45, 11, 3);
        Tree tree46 = new Tree();
        addObject(tree46, 10, 3);
        Tree tree47 = new Tree();
        addObject(tree47, 9, 3);
        Tree tree48 = new Tree();
        addObject(tree48, 8, 3);
        Tree tree49 = new Tree();
        addObject(tree49, 12, 5);
        Tree tree50 = new Tree();
        addObject(tree50, 12, 6);
        Tree tree51 = new Tree();
        addObject(tree51, 12, 7);
        Tree tree52 = new Tree();
        addObject(tree52, 12, 8);
        Tree tree53 = new Tree();
        addObject(tree53, 13, 8);
        Tree tree54 = new Tree();
        addObject(tree54, 14, 8);
        Tree tree55 = new Tree();
        addObject(tree55, 15, 8);
        Tree tree56 = new Tree();
        addObject(tree56, 16, 8);
        Tree tree57 = new Tree();
        addObject(tree57, 17, 8);
        Tree tree58 = new Tree();
        addObject(tree58, 18, 8);
        Tree tree59 = new Tree();
        addObject(tree59, 19, 8);
        Tree tree60 = new Tree();
        addObject(tree60, 19, 7);
        Tree tree61 = new Tree();
        addObject(tree61, 19, 6);
        Tree tree62 = new Tree();
        addObject(tree62, 19, 5);
        Tree tree63 = new Tree();
        addObject(tree63, 19, 4);
        Tree tree64 = new Tree();
        addObject(tree64, 19, 3);
        Tree tree65 = new Tree();
        addObject(tree65, 19, 2);
        Tree tree66 = new Tree();
        addObject(tree66, 19, 1);
        Mushroom mushroom = new Mushroom();
        addObject(mushroom, 15, 6);
        MyKara mykara = new MyKara();
        addObject(mykara, 1, 1);
        Leaf leaf = new Leaf();
        addObject(leaf, 1, 7);
    }
}
