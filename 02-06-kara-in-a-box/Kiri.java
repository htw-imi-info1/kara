import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kiri here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kiri extends Kara
{
    /**
     * Act - do whatever the Kiri wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int counter = 0;
    public void act() 
    {
        walkAndCount();
        turn();
        walkBack();
        if (treeLeft()){
            Greenfoot.stop();
            System.out.println("Kiri counted "+counter + " leaves.");
        }
        else
            nextLine();
    }    

    public void walkAndCount(){
        while(!treeFront())
            moveAndCount();}

    public void turn(){
        turnRight();
        turnRight();
    }

    public void walkBack(){
        while(!treeFront())
            move();}

    public void nextLine(){
        turnLeft();
        moveAndCount();
        turnLeft();
    }
      public void moveAndCount(){
        move();
        if (onLeaf()) counter ++;
    }
}
