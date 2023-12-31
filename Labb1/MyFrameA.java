import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MyFrameA extends JFrame implements ActionListener {
    MyButtonA button;

    public MyFrameA(String name){
        // 2. Construct the frame object according to its super class (JFrame).
        super(name);

        // 3. Creates a new button object and adds it. GO TO "MyButton.java" for step 4.
        button = new MyButtonA("toggle");
        this.add(button);
        button.addActionListener(this);
        // 5. The button is added to the frame and an actionListener is added to the button

    }

    public void actionPerformed(ActionEvent e){
        //6. When the button is pressed, toggleState() is called. GO TO "MyButton.java" för step 7.
        button.toggleState();
    }

    public static void main(String[] args){
        // 1. Börjar med att skapa en ny MyFrame objekt
        MyFrameA frame = new MyFrameA("Lucas, Filip");
        frame.setDefaultCloseOperation(MyFrameA.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);

}

}