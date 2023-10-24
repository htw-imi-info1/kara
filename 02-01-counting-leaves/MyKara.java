<<<<<<< Updated upstream
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
    int counter = 0;
 
    /**
     * In the 'act()' method you can write your program for Kara <br>
     * <i>In der Methode 'act()' koennen die Befehle fuer Kara programmiert werden</i>
     */
    public void act() 
    {
       

    } 

    
}
=======
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
    int counter = 0;

    /**
     * In the 'act()' method you can write your program for Kara <br>
     * <i>In der Methode 'act()' koennen die Befehle fuer Kara programmiert werden</i>
     */
    public void act() 
    {

        move();
        if(onLeaf()){
            counter = counter +1;
        } 
        if (treeFront()) 
            Greenfoot.stop();

    } 

    public int countLeaves(){
        int count = 0;
        while(!treeFront()){

            move();
            if(onLeaf()){
                count = count +1;
            }
        }
        return count;
    }
}
>>>>>>> Stashed changes
