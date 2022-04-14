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
        mirrorLine();
        if (treeFront()){
            Greenfoot.stop();
        } else {
            move();
        }
    }  

    public void mirrorLine(){
        int column = 1;
        boolean thereIsAnotherColumn = true;
        while (thereIsAnotherColumn){
             thereIsAnotherColumn = mirrorLeaf(column);
             column++;
        }
    }

    public boolean mirrorLeaf(int column){
        turnLeft();
        move(column);
        boolean thereIsAnotherColumn = !treeFront();
        if(onLeaf()){
            putLeaf(column);
        } else {
            turnAround();
            move(column);
            turnLeft();
        }
        return thereIsAnotherColumn;
    }

    public void putLeaf(int column){
        turnAround();
        move(2*column);putLeaf();
        turnAround();
        move(column);
        turnRight();

    }

    public void turnAround(){turnRight();turnRight();}

}
