import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MyFrameB extends JFrame{

    public MyFrameB(String name){
        // 2. Construct the frame object according to its super class (JFrame).
        super(name);

        // 3. Creates a new button object and adds it. GO TO "MyButton.java" for step 4.
        MyButtonB button = new MyButtonB("toggle");
        this.add(button);
        // 5. The button is added to the frame and an actionListener is added to the button

    }

    public static void main(String[] args){
        // 1. Börjar med att skapa en ny MyFrame objekt
        MyFrameB frame = new MyFrameB("Lucas, Filip");
        frame.setDefaultCloseOperation(MyFrameB.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);

}

}