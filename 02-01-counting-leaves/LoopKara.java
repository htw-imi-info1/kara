import greenfoot.*;

/**
 * Write a description of class LoopKara here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoopKara extends Kara
{
    /**
     * Act - do whatever the LoopKara wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int leafCounter = 0;
        while(!treeFront()){
            move();
            if(onLeaf()){
                leafCounter++;
            }
        }
        System.out.println(leafCounter);

    }    
}
