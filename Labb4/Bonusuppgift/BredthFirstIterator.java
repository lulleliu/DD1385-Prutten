import java.util.ArrayList;

public class BredthFirstIterator implements Iterator {

    private ArrayList<Component> componentsTree = new ArrayList<Component>();

    public BredthFirstIterator(Component component){
        componentsTree.add(component);
        
    }

    @Override
    public Component next() {
        if (hasNext()){
            Component nextComponent = componentsTree.get(0);
            componentsTree.remove(0);
            if (nextComponent.getComponents() == null){
                return nextComponent;
            }

           for (Component i : nextComponent.getComponents()) {
                componentsTree.add(i);
            }

            return nextComponent;
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
