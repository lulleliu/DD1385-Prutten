import java.util.ArrayList;
import java.util.Iterator;

public class Composite extends Component implements Iterable<Component> {
    
    public ArrayList<Component> components = new ArrayList<Component>();
    private ArrayList<Component> componentsTree = new ArrayList<Component>();
    
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

    public ArrayList<Component> getComponents(){
        return this.components;
    }

    public Integer getWeight(){
        Integer totalWeight = weight;
        for (Component item : components){
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    public String toString(){
        //String contains = item;
        return this.item;
        
        /* 
        for (Component item : components){
            contains += "\n" + item;
        }
        
        return contains;
        */
    }

    public void buildTree(ArrayList<Component> components){

        for (Component component : components) {
            componentsTree.add(component);
            if (component.getComponents() != null){
                buildTree(component.getComponents());
            }
            
        }
    }


    @Override
    public Iterator<Component> iterator() {
        componentsTree.clear();
        componentsTree.add(this);
        buildTree(this.getComponents());
        return componentsTree.iterator();
    }
}