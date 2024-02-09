import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Model{
    private Timer timer;
    private int frequency; //frequency of the timer in milliseconds


    public Model(){
        //något fint
    }

    public ArrayList<Particle> compute_positions(ArrayList<Particle> old_positions){
        
        // Räknar alla positioner
        return old_positions; // Vill egentligen returnera new_positions
    }

    public static void start(){
        //starta timern 
        Timer timer = new Timer();
        timer.schedule(new TimerTask(){
            public void run(){
                //körs out.println("testar timern")e frekvens
                System.out.println("YO!");
            }
        }, 0,2000);
    
    }
    
    public void stop(){
        //stoppa timern
    }

    public void slideChanger(){
        //ändra sliderns value osv
    }

}