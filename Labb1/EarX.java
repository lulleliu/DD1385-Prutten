import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EarX implements ActionListener{
    MyButtonX button_ear;
    
    public EarX(MyButtonX button){
        button_ear = button;
        button_ear.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        button_ear.toggleState();
    }

}
