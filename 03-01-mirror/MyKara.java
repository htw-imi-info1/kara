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
     * pre-condition: Kara sits in the middle of the next line to mirror.
     * post-condition: line is mirrored, 
     *                 Kara sits in the middle of the next line to be mirrored
    */
    public void act() 
    {
        mirrorLine();
        if(treeFront()) 
          Greenfoot.stop();
        else
          move();
    }  
    /**
     * pre-condition: Kara sits in the middle of the line to mirror.
     * post-condition: Kara sits in the middle of the line to mirror,
     *                 line is mirrored.
     */
    public void mirrorLine(){
        int column = 1;
        turnLeft();
        while(mirrorLeaf(column++));
        turnRight();
    }
    /**
     * pre-cond.: kara sits in middle of line facing left
     * post-cond: kara sits in middle of line facing left,
     * 
     */
    public boolean mirrorLeaf(int column){
        boolean foundTree = false;
    
        move(column);
        foundTree = treeFront();
        if(onLeaf()){
            turnLeft();turnLeft();
            move(column*2);
            putLeaf();
            turnRight();turnRight();
            move(column);
        }
        else{
            turnLeft();turnLeft();
            move(column);
            turnLeft();turnLeft();    
        }
        return !foundTree;
    }
    
}
