import java.awt.Color;

import javax.swing.JButton;

public class MyButton extends JButton {
    public boolean toggled;
    public Color BLUE;

    public MyButton(String text1){
        super(text1);
        this.setBackground(BLUE);
    }

    public void toggleState(String text1,String text2) {

        if (!this.toggled) {
             this.setText(text2);
             this.setBackground(Color.GREEN);
             toggled = true;
        }

        else {
            this.setText(text1);
            this.setBackground(Color.BLUE);
            toggled = false;
        }
       
    }
}