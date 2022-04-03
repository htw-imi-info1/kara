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
    int counter = 0;
    boolean walkingToTheRight = true;
    public void act() 
    {
        if (onLeaf()) counter++;
        if (treeFront()){
            turnOrStop();
        } else {
            move();
        }  
    }
    public void turn(){
    if (walkingToTheRight){
            turnRight();
        } else {
            turnLeft();
        }
    }
    public void turnOrStop(){
        turn();
        if (treeFront()){
            Greenfoot.stop();
        }else {
            move();
            turn();
        }
        walkingToTheRight = !walkingToTheRight;
    }

}
