import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ear implements ActionListener{
    MyButtonC button_ear;
    
    public Ear(MyButtonC button){
        button_ear = button;
        button_ear.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        button_ear.toggleState();
    }

}
