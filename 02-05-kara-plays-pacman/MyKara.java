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
     * Start: Kara steht auf dem nächsten Blatt.
     * Step:  Blatt aufnehmen und zu nächstem Blatt gehen.
     */
    public void act() 
    {
        removeLeaf();
        if (treeFront()){
            Greenfoot.stop();
        } else {
            findNextLeaf();
        }      
    }  

    public void goBack(){
        turnRight();turnRight();
        move();
    }

    public void findNextLeaf(){
        // vorne gucken
        move();
        if (onLeaf()) return;
        goBack();
        // nach links laufen
        turnRight();
        move();
        if (onLeaf()) return;
        goBack();
        // nach rechts laufen
        move();
        if (onLeaf()) return;
        System.out.println("Kara couldn't find a leaf!");
        Greenfoot.stop(); 
    }
}
