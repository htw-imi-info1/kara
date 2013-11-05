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
     * precondition: Kara sits on a leaf.
     * postcondition: Kara sits on another leaf, possibly in front of a tree.
     */
    public void act() 
    {
        removeLeaf();
        moveToNextLeafOrStop();
    }      

    /**
     * precondition: Kara sits on a spot where she just has removed a leaf.
     * postcondition: Kara sits on the next leaf on the trail.
     */
    public void moveToNextLeafOrStop(){
        if(treeFront())
            Greenfoot.stop();
        else
            moveToNextLeaf();
    }

    /**
     * Idea in Class: Write the method in a way that they can be chained - e.g. always
     * look on the spot to the left with these pre/postconditions:
     * precondition: Kara sits on a spot and the next leaf cannot be behind her.
     * (because she was just there and picked it up or was there and hadn't found one)
     * postcondition: Kara sits on the next Leaf.
     */
    public void moveToNextLeaf(){
        
    }

}
