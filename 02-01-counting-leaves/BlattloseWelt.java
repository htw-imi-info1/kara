import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlattloseWelt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlattloseWelt extends World
{

    /**
     * Constructor for objects of class BlattloseWelt.
     * 
     */
    public BlattloseWelt()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        MyKara mykara2 = new MyKara();
        addObject(mykara2, 98, 215);
        Tree tree2 = new Tree();
        addObject(tree2, 466, 209);
    }
}
