import java.util.ArrayList;

public class Leaf extends Component{
    private String item;
    private Integer weight;

    public Leaf(String item, Integer weight){
        this.item = item;
        this.weight = weight;
    }

    public String toString(){
        return this.item;
    }

    public Integer getWeight(){
        return this.weight;
    }

    @Override
    public ArrayList<Component> getComponents() {
        return null;
    }
}

