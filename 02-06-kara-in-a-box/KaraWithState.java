import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KaraWithState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KaraWithState extends Kara
{
    public int counter = 0;
    /**
     * Act - do whatever the KaraWithState wants to do. This method is called whenever
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
        turnRight();
        turnRight();
        while (!treeFront()) move();
        turnLeft();
        if (treeFront()) return true;
        move();
        turnLeft();
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
