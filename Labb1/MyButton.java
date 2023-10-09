import java.awt.Color;

import javax.swing.JButton;

public class MyButton extends JButton {
    public boolean toggled;

    public MyButton(String text1){
        // 4. Button is constructed according to its super class (JButton)
        super(text1);
        this.setBackground(Color.BLUE);
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