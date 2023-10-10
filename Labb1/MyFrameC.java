import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrameC extends JFrame{

    public MyFrameC(String name){
        // 2. Construct the frame object according to its super class (JFrame).
        super(name);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // 3. Creates a new button object and adds it. GO TO "MyButton.java" for step 4.
        MyButtonC button = new MyButtonC("toggle");
        MyButtonC button2 = new MyButtonC("toggle");

        panel.add(button);
        panel.add(button2);

        this.add(panel);
        // 5. The button is added to the frame and an actionListener is added to the button
    }

    public static void main(String[] args){
        // 1. Börjar med att skapa en ny MyFrame objekt
        MyFrameC frame = new MyFrameC("Lucas, Filip");
        frame.setDefaultCloseOperation(MyFrameC.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);

}

}