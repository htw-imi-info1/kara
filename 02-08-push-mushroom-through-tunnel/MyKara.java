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
    // this could be determined during the program
    // I leave that as an exercise -
    int widthOfField = 6; 

    /**
     * In the 'act()' method you can write your program for Kara <br>
     * <i>In der Methode 'act()' koennen die Befehle fuer Kara programmiert werden</i>
     */
    public void act() 
    {
        tunnelEingangFinden();
        int zeile = pilzFinden();
        pilzVorTunneleingangSchieben(zeile);
        pilzAufDasKleeBlattStossen();
        Greenfoot.stop();
    } 

    /**
     * Ausgangspunkt: Kara steht am Startpunkt
     * Endpunkt: Kara steht links vom Tunnel und guckt nach rechts
     */
    public void tunnelEingangFinden(){
        moveTillTree();
        turnRight();
        while(treeLeft()){
            move();
        }
        turnLeft();
    }

    /**
     * Ausgangspunkt: Kara steht rechts vom Tunnel und guckt nach rechts
     * Endpunkt: Kara hat den Pilz schon nach ganz rechts geschoben,
     *            Kara steht rechts neben dem Pilz und guckt nach links
     * Rückgabe: 1, 2: pilz steht unterhalb des Tunnels in der 1. oder 2. 
     * Reihe
     * 1,2   : Pilz steht oberhalb des Tunnels
     * (dieser Wert wird gebraucht um den Pilz einfacher in die richtige
     * Reihe zu schieben)
     * @returns int zeile - row in which Mushroom and Kara are positioned
     */
    public int pilzFinden(){
        moveTillTree(); 
        turnRight();
        int zeile = sucheUnten();
        if (zeile != 0){
            return (-1)*zeile;
        }
        else {
            return sucheOben();
        }

    }

    /**
     * sucht den Pilz in der unteren Hälfte.
     * gibt die Zeile zurück, wenn der Pilz gefunden
     * wurde; 0 wenn er nicht gefunden wurde 
     * Ausgangspunkt: Kara steht rechts in der Mitte und guckt 
     * nach unten rechts.
     * Endpunkt: 
     *   1-2: Kara steht rechts vom Pilz und guckt nach rechts. 
     *   Die Zahl ist die Zeilennummer = Anzahl der Schritte, die 
     *   der Pilz nach oben geschoben werden muss
     *   0: Kara steht in der Mitte und guckt nach oben.
     */
    public int sucheUnten(){
        return sucheUntenOderOben(true);
    }

    /**
     * wie sucheUnten nur andersrum :)
     */
    public int sucheOben(){   
        return sucheUntenOderOben(false);
    }

    /**
     * sucheOben und sucheUnten sind bis auf zwei punkte gleich
     * 
     */
    public int sucheUntenOderOben(boolean unten){
        int zeile = 0;
        while (!treeFront()){
            zeile = zeile +1;
            //move to beginning of row
            move();
            if (unten) turnRight(); else turnLeft();
            // searchRow
            int counter = 0;
            while(!mushroomFront() && !treeFront()){
                counter = counter + 1;
                move();
            }
            // jetzt steht Kara vor einem Baum oder vorm Pilz
            if (mushroomFront()) {
                // pilz nach rechts schieben - das ist hier einfacher,
                // weil bekannt ist wie weit dass noch ist
                multiMove(widthOfField-counter-2); 
                return zeile; // dann ist der pilz gefunden
            }
            // pilz nicht gefunden, nächste Zeile
            wenden(); //wenden
            moveTillTree(); // zurücklaufen
            if (unten) turnRight(); else turnLeft(); // wieder nach unten/oben gucken
        }   
        wenden();

        move(zeile); // multi-move
        return 0;       
    }

    /**
     * Ausgangspunkt: Kara steht rechts vom Pilz und guckt nach links
     * Endpunkt: Pilz steht rechts vom Tunnel, Kara rechts davon und 
     * guckt nach links.
     * @param zeile: siehe rückgabe von pilzFinden
     * @
     */
    public void pilzVorTunneleingangSchieben(int zeile){
        if (zeile < 0) { // wir sind unten, unter Pilz stellen
            turnLeft();move();turnRight();move();turnRight();
        }else { // wir sind oben, über Pilz stellen
            turnRight();move();turnLeft();move();turnLeft();
        }
        multiMove(Math.abs(zeile));
        if (zeile < 0){
            turnRight();move();turnLeft();move();turnLeft();
        }
        else 
        {
            turnLeft();move();turnRight();move();turnRight();
        }
    }

    /**
     * Ausgangspunkt: Pilz steht rechts vom Tunnel, Kara rechts davon und 
     * guckt nach links.
     * Endpunkt: Pilz ist auf dem Kleeblatt.
     */
    public void pilzAufDasKleeBlattStossen(){
        multiMove(12);
        turnRight();move();turnLeft();move();turnLeft();
        multiMove(3);
    }

    /**
     * because we need while(!treeFront()){move();}
     * so often...
     */
    public void moveTillTree(){
        while(!treeFront()){
            move();
        }
    }

    public void wenden(){
        turnRight();turnRight();
    }

    public void multiMove(int n){
        int i = 0;
        while (i<n){
            i = i + 1;
            move();
        }
    }
}
