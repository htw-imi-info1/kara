import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BetterReadableKara here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BetterReadableKara extends Kara
{
    /**
     * Act - do whatever the BetterReadableKara wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * Walks in a square and drops a leaf in every corner
     */
    public void act() 
    {
        int counter = 1;
        while(counter <= 4){     
            counter = counter + 1;
            walkEdgeAndMarkCorner();

        }
    }  

    public void walkEdgeAndMarkCorner(){
        move(5);
        putLeaf();
        turnRight();
    }
}
