import java.util.ArrayList;

public abstract class Component {
    
    String item;
    Integer weight;
    
    public void add(Component newComponent){

        throw new UnsupportedOperationException();
    }

    public void remove(Component newComponent){

        throw new UnsupportedOperationException();
    }

    public abstract ArrayList<Component> getComponents();

    public String toString(){

        throw new UnsupportedOperationException();
    }

    public Integer getWeight(){

        throw new UnsupportedOperationException();
    }

}