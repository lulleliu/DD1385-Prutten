// package test;
import javax.swing.tree.*;

public class TaxonomyNode extends DefaultMutableTreeNode{
    public String info;
    public String level;
    public String name;

    public TaxonomyNode(String level, String name, String info){
        super(name);
        this.info = info;
        this.level = level;
        this.name = name;

    }

    public String getTheLevel(){
        return this.level;
    }

    public String getTheInfo(){
        return this.info;
    }

    public String getTheName(){
        return this.name;
    }

}