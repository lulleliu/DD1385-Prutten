import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyButtonB extends JButton implements ActionListener {
    public boolean toggled;

    public MyButtonB(String text1){
        // 4. Button is constructed according to its super class (JButton)
        super(text1);
        this.setBackground(Color.BLUE);
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        //6. When the button is pressed, toggleState() is called. GO TO "MyButton.java" för step 7.
        this.toggleState();
    }

    public void toggleState() {
        // 7. When button is pressed its apperance is changed accordingly.
        if (!this.toggled) {
             this.setText("TOGGLE");
             this.setBackground(Color.GREEN);
             toggled = true;
        }

        else {
            this.setText("toggle");
            this.setBackground(Color.BLUE);
            toggled = false;
        }
       
    }
}