import java.util.ArrayList;

public class DepthFirstIterator implements Iterator{

    private ArrayList<Component> componentsTree = new ArrayList<Component>();

    public DepthFirstIterator(Component component){
        componentsTree.add(component);
        buildTree(component.getComponents());
        
    }

    // Resväska, Necessär, Bag with stuff, pokemonkort...

    public void buildTree(ArrayList<Component> components){
        for (Component component : components) {
            componentsTree.add(component);
            if (component.getComponents() != null){
                buildTree(component.getComponents());
            }
            
        }
    }

    @Override
    public Component next() {
        if (hasNext()){
            Component nexComponent = componentsTree.get(0);
            componentsTree.remove(0);

            return nexComponent;
        }
        return null;
        
        
    }

    @Override
    public boolean hasNext() {
        return !componentsTree.isEmpty();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
    
}

