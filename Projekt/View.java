import javax.swing.*;
import java.awt.*;

public class View extends JFrame{
    private JFrame frame;
    private JButton start;
    private JButton stop;
    private JSlider slider;

    public View(){
        frame = new JFrame("Simulation");
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(new BorderLayout());


        JPanel controlpanel = new JPanel();
        start = new JButton("Start");
        stop = new JButton("Stop");

        slider = new JSlider(0, 100);
        slider.setValue(50);
        


        controlpanel.add(stop);
        controlpanel.add(start);
        controlpanel.add(slider);
        frame.add(controlpanel, BorderLayout.SOUTH);

        frame.setVisible(true);

        
    }

    public static void main(String[] args) {
        new View();
    }
    
    
}