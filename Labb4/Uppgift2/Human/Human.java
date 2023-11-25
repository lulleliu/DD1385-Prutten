package Uppgift2.Human;

public abstract class Human {
    Human(){

    }
    public static Human create(String name, String pnr){
        //kollar vilken siffra som är på plats nummer 10 i personnumret
    int gender = Character.getNumericValue(pnr.charAt(10));
    
    if (gender == 0){
        //Om det är en 0a som 10e siffra är det en ickebinär person
        return new NonBinary(name);
    }
    else if (gender%2==0){
        //Om det är ett jämnt tal är det en man
        return new Man(name);
    }
    else{
        //Om det inte är en man eller en ickebinär person är det en kvinna
        return new Woman(name);
        }
    }
}

