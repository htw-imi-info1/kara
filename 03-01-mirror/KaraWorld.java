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

    
        Kara kara = new MyKara();
        addObject(kara, 12, 24);
        kara.turnLeft();

        Leaf leaf = new Leaf();
        addObject(leaf, 3, 7);
        Leaf leaf2 = new Leaf();
        addObject(leaf2, 2, 7);
        Leaf leaf3 = new Leaf();
        addObject(leaf3, 1, 7);
        Leaf leaf4 = new Leaf();
        addObject(leaf4, 2, 6);
        Leaf leaf5 = new Leaf();
        addObject(leaf5, 3, 6);
        Leaf leaf6 = new Leaf();
        addObject(leaf6, 3, 5);
        Leaf leaf7 = new Leaf();
        addObject(leaf7, 3, 4);
        Leaf leaf8 = new Leaf();
        addObject(leaf8, 1, 4);
        Tree tree32 = new Tree();
        addObject(tree32, 0, 8);
        Tree tree33 = new Tree();
        addObject(tree33, 0, 7);
        Tree tree34 = new Tree();
        addObject(tree34, 0, 6);
        Tree tree35 = new Tree();
        addObject(tree35, 0, 5);
        Tree tree36 = new Tree();
        addObject(tree36, 0, 4);
        Tree tree37 = new Tree();
        addObject(tree37, 0, 3);
        Tree tree38 = new Tree();
        addObject(tree38, 0, 2);
        Tree tree39 = new Tree();
        addObject(tree39, 0, 1);
        Tree tree40 = new Tree();
        addObject(tree40, 4, 0);
        Leaf leaf67 = new Leaf();
        addObject(leaf67, 2, 2);
        Leaf leaf68 = new Leaf();
        addObject(leaf68, 1, 1);
        Leaf leaf69 = new Leaf();
        addObject(leaf69, 3, 1);
        Leaf leaf70 = new Leaf();
        addObject(leaf70, 3, 3);
        Leaf leaf71 = new Leaf();
        addObject(leaf71, 1, 3);
        Leaf leaf72 = new Leaf();
        addObject(leaf72, 2, 8);
        kara.setLocation(4, 8);
    }
}
