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
    int z = 0;
    boolean ichLaufGradNachLinks = false;
    public void zaehlen(){
    z = z +1;}

    public void drehen(){
        if (ichLaufGradNachLinks) {
            turnLeft();
            move();
            turnLeft();
        } else{
            turnRight();
            move();
            turnRight();
        }	
ichLaufGradNachLinks = !ichLaufGradNachLinks;
    }
    /**
     * In the 'act()' method you can write your program for Kara <br>
     * <i>In der Methode 'act()' koennen die Befehle fuer Kara programmiert werden</i>
     */
    public void act() 
    {
        zaehlen();
        if (treeFront()){
            drehen();
        } else {
            move();
        }  
    }

}
