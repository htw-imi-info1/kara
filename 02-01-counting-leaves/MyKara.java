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
       int localCounter = 0;
       if (onLeaf()){
           counter = counter +1;
           localCounter = localCounter + 1;
        }
        move();
        System.out.println("localCounter: "+localCounter);
          System.out.println("counter: "+counter);

    } 

    
}
