import javax.swing.tree.*;

public class TaxonomyNode extends DefaultMutableTreeNode{
    public String info;
    public String level;

    TaxonomyNode(String level, String name, String info){
        super(name);
        this.info = info;
        this.level = level;

    }

    public String getTheLevel(){
        return this.level;
    }

    public String getTheInfo(){
        return this.info;
    }


}