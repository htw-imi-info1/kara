import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FasterKara here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FasterKara extends Kara
{
    int counter = 0;
    boolean isGoingRight = true;
    /**
     * Act - do whatever the FasterKara wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        countLine();
        boolean done = goBackAndDown();
        if (done) {
            System.out.println("Blätter: "+counter);
            Greenfoot.stop();
        }

    }    

    public boolean goBackAndDown(){
        if (isGoingRight){
            turnRight();
            if (treeFront()) return true;
            move();
            turnRight();
            isGoingRight = false;
        }
        else {
            turnLeft();
            if (treeFront()) return true;
            move();
            turnLeft();
            isGoingRight = true;
        }
        return false;
    }

    public void countLine() 
    {

        while(!treeFront()){
            countLeaf();
            move();           
        }
        countLeaf();

    } 

    private void countLeaf(){
        if(onLeaf()){
            counter = counter + 1;
        }

    } 
}
