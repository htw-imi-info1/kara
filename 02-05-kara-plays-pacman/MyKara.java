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
    public void act() 
    {
        if (leafRight()){
            // go there and take it
        } else if (leafFront()){
            // go there and take it
        } else if (leafLeft()){
            // go there and take it
        }
    }   

    public boolean leafRight(){
        boolean foundLeaf = false;
        turnRight();
        move();
        if (onLeaf())
            foundLeaf = true;
        turnLeft();turnLeft();
        move();
        turnRight();
        return foundLeaf;
    }

    public boolean leafFront(){
        return false;
    }

    public boolean leafLeft(){
        boolean foundLeaf = false;
        turnLeft();
        move();
        if (onLeaf()){
            foundLeaf = true;
        } else {
            turnLeft();turnLeft();
            move();
            turnLeft();
        }
         return foundLeaf;
    }
}
