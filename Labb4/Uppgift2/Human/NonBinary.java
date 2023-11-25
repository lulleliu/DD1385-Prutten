package Uppgift2.Human;

class NonBinary extends Human{
    String name;
    public NonBinary(String name){
        this.name = name;

    }
    public String toString(){
        return "jag är ickebinär och heter " + name;
    }
}