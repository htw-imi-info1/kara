import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyKaraAct here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyKaraAct extends Kara
{
    int counter = 0;
    /**
     * Act - do whatever the MyKaraAct wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(treeFront()){
            countLeaf();
            System.out.println("Zahl der Blätter: " + counter);
            Greenfoot.stop();            
        }
        else{
            countLeaf();
            move();           
        }

    } 

    private void countLeaf(){
        if(onLeaf()){
            counter = counter + 1;
        }

    } 
}
