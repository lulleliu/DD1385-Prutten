package Labb2;
import java.awt.Color;

import javax.swing.*;
//import javafx.util.Pair;


public class Square extends JButton {
    private int x; 
    private int y;
    private String value;
    
    Square(String text){
        super(text);
    }

    public void setCoordinates(int x, int y){
        this.x = x;
        this.y = y;

    }

    public void setValue(String val){
        value = val;
    }

    public int xGet(){
        return x;
    }

    public int yGet(){
        return y;
    }
    

}