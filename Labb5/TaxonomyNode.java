import javax.swing.*;
import javax.swing.tree.*;
import java.io.*;        

class TaxonomyNode extends DefaultMutableTreeNode{
    public String info;
    public String level;

    TaxonomyNode(String level, String name, String info){
        super(level);
        this.info = info;
        this.level = level;

    }

}