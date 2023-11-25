package Uppgift2.Human;

class Woman extends Human{
    String name;

    public Woman(String name){
        this.name = name;
    }
    public String toString() {
        return "jag är en kvinna och heter " + name;
    }
}