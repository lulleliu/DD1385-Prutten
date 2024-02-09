import java.lang.Math;
import java.util.Random;

public class Particle {
    private double y;
    private double x; 
    private boolean moving;

    
    public Particle(){
    //slumpade koordinater
        moving = true;
    }
    
    public Particle(float x, float y){
    //angivna koordinater
        this.x = x;
        this.y = y;
        moving = true;
    }

    public void move(){
    //metod för att flytta partiklar slumpmässigt enligt
        Random r = new Random();
        double randomValue = 0 + (2) * r.nextDouble() * Math.PI;
        this.x = x + randomValue;
        this.y = y + randomValue;
    } 
}