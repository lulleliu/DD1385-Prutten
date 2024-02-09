import javax.swing.*;
import java.awt.*;

public class View extends JFrame{
    private JFrame frame;
    private JPanel Control;

    public View(){
        frame = new JFrame("Simulation");
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(new BorderLayout());

        ControlPanel controlpanel = new ControlPanel();
        frame.add(controlpanel, BorderLayout.SOUTH);
    
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Model model = new Model();
        new View();
    }
    
    
}