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

    public Component getComponent(Integer componentIndex){

        throw new UnsupportedOperationException();
    }

    public String toString(){

        throw new UnsupportedOperationException();
    }

    public Integer getWeight(){

        throw new UnsupportedOperationException();
    }

}