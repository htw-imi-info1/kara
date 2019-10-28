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
    public void findTunnel(){
        while (!treeFront()) move();
        turnRight();
        while (treeLeft()) move();
        turnLeft();}

    public void walkThroughTunnel(){
        move();
        while(treeRight()) move();
    }
    public int currentColumn = 0;
    public void moveLeft(){
        currentColumn--;
        move();
    }

    public boolean searchLine(){

        turnLeft();moveUp();turnLeft();
        currentColumn = 5;
        while (!treeFront()){
            if(mushroomFront()) return true;
            moveLeft();
        }
        turnRight();turnRight();
        while (!treeFront()) move();
        return false;
    }
    public int currentLine = 0;
    public void moveDown(){currentLine--;move();}

    public void moveUp(){currentLine++;move();}

    public void findMushroom(){
        turnRight();
        while (!treeFront() && !mushroomFront()) moveDown();
        if (mushroomFront()){ 
            // mushroom is on line below
            currentLine--;
            goToLeftSide();
        }
        else{
            turnLeft();
            while (!treeFront()) move();

            while (!searchLine());}
    }

    public void pushMushroomToTunnelEntrance(){
        if (currentLine < 0) // we're in the lower half
        {
            goToLeftSide();
            pushMushroom(currentLine * (-1));        
            goToRightSide();
        }
        else{ 
            goToRightSide();
            pushMushroom(currentLine);
            goToLeftSide();
        }
        for (int i = currentColumn; i > 0; i--)move();
    }

    public void goToLeftSide(){
        turnLeft();move();turnRight();move();turnRight();}

    public void goToRightSide(){
        turnRight();move();turnLeft();move();turnLeft();
    };

    public void pushMushroom(int n){
        for(int i = 0; i< n;i++) move();
    }

    public void pushMushRoomOnLeaf(){
        pushMushroom(11);
        goToRightSide();
        pushMushroom(3);

    }

    public void act() 
    {   
        findTunnel();
        walkThroughTunnel();
        findMushroom();
        pushMushroomToTunnelEntrance();
        pushMushRoomOnLeaf();  
        Greenfoot.stop();
    }  
}
