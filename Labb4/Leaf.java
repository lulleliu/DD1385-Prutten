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
}

