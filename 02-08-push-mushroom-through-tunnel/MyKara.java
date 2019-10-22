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
        findMushRoom();
        pushMushRoomOnLeaf();

    }  

    public void findMushRoom(){
        findTunnelEntrance();
        walkThroughTunnel();
        findMushRoomOnRightSide();
        moveToPushPosition();
    }

    public void pushMushRoomOnLeaf(){
        pushMushRoomThroughTunnel();
    }

    public void pushMushRoomThroughTunnel(){}

    public void  findTunnelEntrance(){
        while(!treeFront())move();
        turnRight();
        while(treeLeft())move();
        turnLeft();
    };

    public boolean inTunnel(){
        return treeLeft() && treeRight();
    }

    public void    walkThroughTunnel(){
        move();
        while(inTunnel()) move();
    };
    
    int row = 0;
    public void findMushRoomOnRightSide(){
        walkToRightHand();
        // look in upper half
        turnLeft();
        boolean mushRoomFound = false;
        while (!mushRoomFound... not on top){
        move();
        row = row+1;
        turnLeft();
        while(!mushroomFront() && !treeFront()) move();
        if (treeFront()) walkBack();
        else { mushRoomFound = true; 
            goInPositionToPush();
        
        }
        
        
        
    };
    public void walkToRightHand(){
        // put logic to take care of mushroom in the middle here
    while (!treeFront())move();}

    public void    moveToPushPosition(){};
}
