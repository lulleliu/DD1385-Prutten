package Labb2;
import javax.swing.*;
//import javafx.util.Pair;


public class Square extends JButton {
    private int x; 
    private int y;
    private String value;
    
    /* 
    public Square(int x, int y){
        this.x = x;
        this.y = y;

    }

    */
    
    Square(){
        super();
    }

    public void setCoordinates(int x, int y){
        this.x = x;
        this.y = y;

    }

}