import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyButtonC extends JButton {
    public boolean toggled;

    public MyButtonC(String text1){
        // 4. Button is constructed according to its super class (JButton)
        super(text1);
        this.setBackground(Color.BLUE);
        new Ear(this);
        
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