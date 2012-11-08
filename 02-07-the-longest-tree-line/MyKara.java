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

    }  

    public int findMaxRow(){

        boolean done = false;

        while(!done){
            while (!treeFront() && !onLeaf()) move();
            if (treeFront()){
                int nextLine =  countNextLine();
                if (nextLine > longestLine)
                    longestLine = nextLine;
            }
            else{
                System.out.println("The longest line is: "+longestLine);
                done = true;           
            }
        }

        return longestLine;
    }

    public int countNextLine(){
        int lineCounter = 0;
        turnLeft();
        while (treeRight()) {
            move();
            lineCounter++;
        }
        turnRight();move();move();turnRight();
        move(lineCounter);
        turnLeft();

        return lineCounter;

    }
}
