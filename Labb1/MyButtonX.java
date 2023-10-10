import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyButtonX extends JButton {
    public boolean toggled;
    public String state1;
    public String state2;

    public MyButtonX(String text1, String text2){
        // 4. Button is constructed according to its super class (JButton)
        super(text1);

        state1 = text1;
        state2 = text2;

        this.setBackground(Color.BLUE);
        // EarX newEar = new EarX(this);
        
    }

    public void toggleState() {
        // 7. When button is pressed its apperance is changed accordingly.
        if (!this.toggled) {
             this.setText(state2);
             this.setBackground(Color.GREEN);
             toggled = true;
        }

        else {
            this.setText(state1);
            this.setBackground(Color.BLUE);
            toggled = false;
        }
       
    }

}