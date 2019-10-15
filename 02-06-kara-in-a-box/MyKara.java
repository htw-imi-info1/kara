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
    boolean done = false;
    boolean headingRight = true;
    int counter = 0;
    public void act() 
    {
        if (done) return; // don't stop Kiri
        walkLine();
        if(doneWithLastLine()){
            done = true;
            System.out.println("Kara counted "+counter + " leaves.");}
        else{
            if (headingRight)
                turn();
            else
                secondTurn();
        }

    }

    public void walkLine(){
        while(!treeFront()) moveAndCount();}

    public void turn(){
        turnRight();moveAndCount();turnRight();
        headingRight = false;
    }

    public void secondTurn(){
        turnLeft();moveAndCount();turnLeft();
        headingRight = true;
    }

    public void moveAndCount(){
        move();
        if (onLeaf()) counter ++;
    }

    public boolean doneWithLastLine(){
        return (headingRight && treeRight()) ||
        (!headingRight && treeLeft());}

}
