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

    public void act() 
    {
        if (onLeaf()){
            counter = counter +1;
        }
        if (treeFront()){

            Greenfoot.stop(); 
            System.out.println("counter: "+counter);
        }
        else {
            move();
        }

    } 

}
