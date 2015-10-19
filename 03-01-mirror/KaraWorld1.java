import greenfoot.*;

/**
 * This class creates a world for Kara. It contains settings for height and 
 * width of the world and initializes the Actors.
 * 
 * @author Marco Jakob (majakob@gmx.ch)
 * @version 1.3 (2012-07-04)
 */
public class KaraWorld1 extends World 
{   
    private static final int WORLD_WIDTH = 25;  // Number of horizontal cells
    private static final int WORLD_HEIGHT = 25;  // Number of vertical cells

    private static final int CELL_SIZE = 28; // Size of one cell

    /**
     * Creates a world for Kara.
     */
    public KaraWorld1() 
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

        Kara copykara = new MyKara();
        addObject(copykara, 12, 0);
  
        copykara.setLocation(12, 24);
        copykara.turnLeft();
        Leaf leaf = new Leaf();
        addObject(leaf, 11, 23);
        Leaf leaf2 = new Leaf();
        addObject(leaf2, 10, 23);
        Leaf leaf3 = new Leaf();
        addObject(leaf3, 9, 23);
        Leaf leaf4 = new Leaf();
        addObject(leaf4, 8, 23);
        Leaf leaf5 = new Leaf();
        addObject(leaf5, 7, 23);
        Leaf leaf6 = new Leaf();
        addObject(leaf6, 6, 23);
        Leaf leaf7 = new Leaf();
        addObject(leaf7, 5, 23);
        Leaf leaf8 = new Leaf();
        addObject(leaf8, 11, 22);
        Leaf leaf9 = new Leaf();
        addObject(leaf9, 11, 22);
        Leaf leaf10 = new Leaf();
        addObject(leaf10, 11, 21);
        Leaf leaf11 = new Leaf();
        addObject(leaf11, 10, 21);
        Leaf leaf12 = new Leaf();
        addObject(leaf12, 9, 21);
        Leaf leaf13 = new Leaf();
        addObject(leaf13, 8, 21);
        Leaf leaf14 = new Leaf();
        addObject(leaf14, 11, 20);
        Leaf leaf15 = new Leaf();
        addObject(leaf15, 11, 19);
        Leaf leaf16 = new Leaf();
        addObject(leaf16, 10, 20);
        Leaf leaf17 = new Leaf();
        addObject(leaf17, 2, 5);
        Leaf leaf18 = new Leaf();
        addObject(leaf18, 2, 6);
        Leaf leaf19 = new Leaf();
        addObject(leaf19, 2, 7);
        Leaf leaf20 = new Leaf();
        addObject(leaf20, 2, 8);
        Leaf leaf21 = new Leaf();
        addObject(leaf21, 2, 9);
        Leaf leaf22 = new Leaf();
        addObject(leaf22, 2, 10);
        Leaf leaf23 = new Leaf();
        addObject(leaf23, 2, 11);
        Leaf leaf24 = new Leaf();
        addObject(leaf24, 2, 12);
        Leaf leaf25 = new Leaf();
        addObject(leaf25, 2, 13);
        Leaf leaf26 = new Leaf();
        addObject(leaf26, 3, 13);
        Leaf leaf27 = new Leaf();
        addObject(leaf27, 4, 13);
        Leaf leaf28 = new Leaf();
        addObject(leaf28, 5, 12);
        Leaf leaf29 = new Leaf();
        addObject(leaf29, 6, 12);
        Leaf leaf30 = new Leaf();
        addObject(leaf30, 6, 11);
        Leaf leaf31 = new Leaf();
        addObject(leaf31, 6, 10);
        Leaf leaf32 = new Leaf();
        addObject(leaf32, 5, 9);
        Leaf leaf33 = new Leaf();
        addObject(leaf33, 4, 9);
        Leaf leaf34 = new Leaf();
        addObject(leaf34, 3, 9);
        Leaf leaf35 = new Leaf();
        addObject(leaf35, 6, 8);
        Leaf leaf36 = new Leaf();
        addObject(leaf36, 6, 7);
        Leaf leaf37 = new Leaf();
        addObject(leaf37, 6, 6);
        Leaf leaf38 = new Leaf();
        addObject(leaf38, 5, 6);
        Leaf leaf39 = new Leaf();
        addObject(leaf39, 4, 5);
        Leaf leaf40 = new Leaf();
        addObject(leaf40, 3, 5);
        Leaf leaf41 = new Leaf();
        addObject(leaf41, 5, 5);
        Leaf leaf42 = new Leaf();
        addObject(leaf42, 5, 6);
        removeObject(leaf38);
        Leaf leaf43 = new Leaf();
        addObject(leaf43, 5, 13);
        removeObject(leaf28);
        Leaf leaf44 = new Leaf();
        addObject(leaf44, 11, 18);
        Leaf leaf45 = new Leaf();
        addObject(leaf45, 10, 18);
        Leaf leaf46 = new Leaf();
        addObject(leaf46, 9, 18);
        Leaf leaf47 = new Leaf();
        addObject(leaf47, 4, 18);
        Leaf leaf48 = new Leaf();
        addObject(leaf48, 4, 18);
        Leaf leaf49 = new Leaf();
        addObject(leaf49, 4, 21);
        Leaf leaf50 = new Leaf();
        addObject(leaf50, 4, 21);
        Leaf leaf51 = new Leaf();
        addObject(leaf51, 5, 20);
        Leaf leaf52 = new Leaf();
        addObject(leaf52, 5, 18);
        Leaf leaf53 = new Leaf();
        addObject(leaf53, 5, 19);
        Leaf leaf54 = new Leaf();
        addObject(leaf54, 6, 16);
        Leaf leaf55 = new Leaf();
        addObject(leaf55, 6, 16);
        Leaf leaf56 = new Leaf();
        addObject(leaf56, 8, 16);
        Leaf leaf57 = new Leaf();
        addObject(leaf57, 7, 16);
        Leaf leaf58 = new Leaf();
        addObject(leaf58, 7, 16);
        Leaf leaf59 = new Leaf();
        addObject(leaf59, 2, 17);
        Leaf leaf60 = new Leaf();
        addObject(leaf60, 4, 16);
        Leaf leaf61 = new Leaf();
        addObject(leaf61, 8, 3);
        Leaf leaf62 = new Leaf();
        addObject(leaf62, 7, 2);
        Leaf leaf63 = new Leaf();
        addObject(leaf63, 6, 1);
        Leaf leaf64 = new Leaf();
        addObject(leaf64, 9, 2);
        Leaf leaf65 = new Leaf();
        addObject(leaf65, 10, 1);
        Leaf leaf66 = new Leaf();
        addObject(leaf66, 11, 0);
        Tree tree = new Tree();
        addObject(tree, 12, 0);
        removeObject(tree);
        Tree tree2 = new Tree();
        addObject(tree2, 0, 24);
        Tree tree3 = new Tree();
        addObject(tree3, 0, 23);
        Tree tree4 = new Tree();
        addObject(tree4, 0, 22);
        Tree tree5 = new Tree();
        addObject(tree5, 0, 21);
        Tree tree6 = new Tree();
        addObject(tree6, 0, 20);
        Tree tree7 = new Tree();
        addObject(tree7, 0, 18);
        Tree tree8 = new Tree();
        addObject(tree8, 0, 19);
        Tree tree9 = new Tree();
        addObject(tree9, 0, 17);
        Tree tree10 = new Tree();
        addObject(tree10, 0, 16);
        Tree tree11 = new Tree();
        addObject(tree11, 0, 15);
        Tree tree12 = new Tree();
        addObject(tree12, 0, 14);
        Tree tree13 = new Tree();
        addObject(tree13, 0, 13);
        Tree tree14 = new Tree();
        addObject(tree14, 0, 12);
        Tree tree15 = new Tree();
        addObject(tree15, 0, 11);
        Tree tree16 = new Tree();
        addObject(tree16, 0, 10);
        Tree tree17 = new Tree();
        addObject(tree17, 0, 9);
        Tree tree18 = new Tree();
        addObject(tree18, 0, 8);
        Tree tree19 = new Tree();
        addObject(tree19, 0, 7);
        Tree tree20 = new Tree();
        addObject(tree20, 0, 6);
        Tree tree21 = new Tree();
        addObject(tree21, 0, 5);
        Tree tree22 = new Tree();
        addObject(tree22, 0, 4);
        Tree tree23 = new Tree();
        addObject(tree23, 0, 3);
        Tree tree24 = new Tree();
        addObject(tree24, 0, 2);
        Tree tree25 = new Tree();
        addObject(tree25, 0, 1);
        Tree tree26 = new Tree();
        addObject(tree26, 0, 0);
        Tree tree27 = new Tree();
        addObject(tree27, 1, 0);
        Tree tree28 = new Tree();
        addObject(tree28, 2, 0);
        Tree tree29 = new Tree();
        addObject(tree29, 3, 0);
        Tree tree30 = new Tree();
        addObject(tree30, 4, 0);
        removeObject(tree30);
        removeObject(tree29);
        removeObject(tree28);
        removeObject(tree27);
        Tree tree31 = new Tree();
        addObject(tree31, 12, 0);
        removeObject(leaf66);
    }
}
