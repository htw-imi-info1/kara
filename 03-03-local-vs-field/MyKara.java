import greenfoot.*;

public class MyKara extends Kara
{
    int fieldCounter = 0;
    public void act() 
    {
       int localCounter = 0;
       move();
       fieldCounter ++;
       localCounter ++;
       if (treeFront()){
           Greenfoot.stop();
        }
    }  
}
