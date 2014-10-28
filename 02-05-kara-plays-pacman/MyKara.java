import greenfoot.*;

/**
 * MyKara is a subclass of Kara. Therefore, it inherits all methods of Kara: <p>
 * 
 * <i>MyKara ist eine Unterklasse von Kara. Sie erbt damit alle Methoden der Klasse Kara:</i> <p>
 * 
 * Actions:     move(), turnLeft(), turnRight(), putLeaf(), removeLeaf() <b>
 * Sensors:     onLeaf(), treeFront(), treeLeft(), treeRight(), mushroomFront()
 */
public class MyKara extends Kara
{
    /**
     * In the 'act()' method you can write your program for Kara <br>
     * <i>In der Methode 'act()' koennen die Befehle fuer Kara programmiert werden</i>
     */
    public void turn(){
        turnLeft();
        turnLeft();

    }

    public boolean leafFront(){
        move();
        boolean leafFound = onLeaf();
        turn();
        move();
        turn();
        return leafFound;
    }

    public boolean leafLeft(){
        turnLeft();
        move();
        boolean leafFound = onLeaf();
        turn();
        move();
        turnLeft();
        return leafFound;
    }

    public void act() 
    {
        if (onLeaf()) {
            removeLeaf();
        }

        if (leafFront()){
            move();
        } else {
            if (leafLeft()){
                turnLeft();
                move();
            }
            else {
                turnRight();
                move();
            }
        }
        if (treeFront()) {
            Greenfoot.stop();
        }
    }      
}
