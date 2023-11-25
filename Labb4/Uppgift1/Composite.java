package Uppgift1;
import java.util.ArrayList;

public class Composite extends Component {
    
    ArrayList<Component> components = new ArrayList<Component>();
    
    public Composite(String item, int weight){
        this.item = item;
        this.weight = weight;
    }
    
    public void add(Component newComponent){
        components.add(newComponent);
    }

    public void remove(Component newComponent){
        components.remove(newComponent);
    }

    public Integer getWeight(){
        Integer totalWeight = weight;
        for (Component item : components){
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    public String toString(){
        String contains = item;
        
        for (Component item : components){
            contains += "\n" + item;
        }
        
        return contains;
    }
}