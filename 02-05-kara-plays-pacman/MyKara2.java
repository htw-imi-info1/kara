import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyKara2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyKara2 extends Kara
{
    /**
     * Act - do whatever the MyKara2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(onLeaf()){
            removeLeaf();
        }
        else{
            if (leafLeft()){
                turnLeft();
                move();
            } else if (leafRight()){
                turnRight();
                move();} 
            else { 
                move();
            }
        }
        // Add your action code here.
    }    

    public boolean leafLeft(){
        if(treeLeft()) {
            return false;
        }
        turnLeft();
        tryToMove();
        boolean result = false;
        if(onLeaf()){
            result = true;
        }
        moveBack();
        turnRight();
        return result;
    }

    public boolean leafRight(){
        if(treeRight()) {
            return false;
        }
        turnRight();
        tryToMove();
        boolean result = false;
        if(onLeaf()){
            result = true;
        }
        moveBack();
        turnLeft();
        return result;
    }

    public void tryToMove(){
        if(!treeFront()){
            move();
        }
    }

    public void moveBack(){
        turnRight();
        turnRight();
        move();
        turnRight();
        turnRight();

    }

}
