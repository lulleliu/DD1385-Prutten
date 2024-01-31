import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;


public class ControlPanel extends JPanel{
    private JButton startButton;
    private JButton stopButton;
    private JSlider slider;
    
    public ControlPanel(){
        super();

        //start = new JButton("Start");
        //stop = new JButton("Stop");

        createStopButton();
        createStartButton();
        createJSlider();
        //slider = new JSlider(0, 100);
        //slider.setValue(50);

        this.add(startButton);
        this.add(stopButton);
        this.add(slider);
    }

    private void createStopButton(){
		stopButton = new JButton("Stop");
		ActionListener closebuttonlistener = (new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//model.stop()
                System.out.println("STOP");
			}	
		});
		stopButton.addActionListener(closebuttonlistener);
	}
   
    private void createStartButton(){
        startButton = new JButton("Start");
        
        ActionListener startButtonlistener = (new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //model.start()
                System.out.println("Starting");
            }	
        });
    
        startButton.addActionListener(startButtonlistener);
    }

    private void createJSlider(){
		slider = new JSlider(1, 100);
        slider.setValue(50);
		ChangeListener slideListener = (new ChangeListener() {
			public void stateChanged(ChangeEvent e){
                System.out.println(slider.getValue());
			}	
		});
		slider.addChangeListener(slideListener);
	}
        
		

}