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
    public int longestLine = 0;

    /**
     * In the 'act()' method you can write your program for Kara <br>
     * <i>In der Methode 'act()' koennen die Befehle fuer Kara programmiert werden</i>
     */
    public void act() 
    {
        if (treeFront()){
            countLine();
        } else {
            move();
        }  
        if (onLeaf()){
            Greenfoot.stop();
            System.out.println("The longest line was: "+longestLine);
        }
    }
    public void countLine(){
        int count = 0;
        turnLeft();
        while (treeRight()){
            count++;
            move();
        }
        // oben angekommen
        if (count > longestLine) longestLine = count;
        turnRight();move();move();turnRight();
        while (count > 0){
            move();
            count--;
        }
        turnLeft();
    }
}
