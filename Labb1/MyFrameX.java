import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrameX extends JFrame implements ActionListener{
    ArrayList<MyButtonX> buttonArray = new ArrayList<MyButtonX>();

    public MyFrameX(String[] buttonInputString){
        super("Lucas, Filip");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        int nButtons = Integer.parseInt(buttonInputString[0]);

        if (buttonInputString.length == 1) {
            for (int i = 0; i < nButtons; i++) {
                MyButtonX tempButton = new MyButtonX("toggle", "TOGGLE");
                tempButton.addActionListener(this);
                buttonArray.add(tempButton);
                panel.add(tempButton);
            }
        }

        else {
            for (int i = 1; i < nButtons*2; i+=2) {
                String state1 = buttonInputString[i];
                String state2 = buttonInputString[i+1];

                MyButtonX tempButton = new MyButtonX(state1, state2);
                tempButton.addActionListener(this);
                buttonArray.add(tempButton);
                panel.add(tempButton);
                
            }
        }

        this.add(panel);
    }

    public void actionPerformed(ActionEvent e){
        int indexButton = buttonArray.indexOf(e.getSource());
        for (int i=0; i < buttonArray.size(); i++) {
            if (i != indexButton) {
                buttonArray.get(i).toggleState();
            }
        }
    }

    public static void main(String[] args){
        MyFrameX frame = new MyFrameX(args);
        frame.setDefaultCloseOperation(MyFrameX.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);

}

}
