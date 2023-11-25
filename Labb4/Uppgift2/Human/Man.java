package Uppgift2.Human;

class Man extends Human{
    String name;

    public Man(String name){
        this.name = name;
    }
    public String toString(){
        return "jag är man och heter " + name;
    }
}
