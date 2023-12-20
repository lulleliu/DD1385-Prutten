import javax.swing.*;
import javax.swing.tree.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

class PreparationTree extends JFrame implements ActionListener {
    JCheckBox box;
    JTree tree;
    // DefaultMutableTreeNode root;
	TaxonomyNode root;
    DefaultTreeModel treeModel;
    JPanel controls;
    static final String closeString = " Close ";
    static final String showString = " Show Details ";

    PreparationTree(ArrayList<String> data) {
		Container c = getContentPane();

		// initTree() should create root, treeModel and tree.
		initTree(data);

		tree.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (box.isSelected())
				showDetails(tree.getPathForLocation(e.getX(), 
									e.getY()));
			}
			});
			
		controls = new JPanel();
		box = new JCheckBox(showString);
		initGUI();
		
		c.add(controls, BorderLayout.NORTH);
		c.add(tree, BorderLayout.CENTER);   
		setVisible(true);
    } 

    public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals(closeString))
			dispose();
    }

    void initGUI() {
		tree.setFont(new Font("Dialog", Font.BOLD, 12));
		controls.add(box);
		addButton(closeString);
		controls.setBackground(Color.lightGray);
		controls.setLayout(new FlowLayout());    
		setSize(400, 400);
    }
 
    void addButton(String n) {
		JButton b = new JButton(n);
		b.setFont(new Font("Dialog", Font.BOLD, 12));
		b.addActionListener(this);
		controls.add(b);
    }

	private void buildTree(TaxonomyNode parent, ArrayList<String> parts){
		if (parts.size() < 3) {
            return;
        }

        String level = parts.get(0);
        String name = parts.get(1);
        String info = String.join(" ", parts.subList(2, parts.size()));

        TaxonomyNode child = new TaxonomyNode(level, name, info);
        parent.add(child);

        if (parts.size() > 3) {
            buildTree(child, new ArrayList<>(parts.subList(3, parts.size())));
        }
	}

    // ***** Override method initTree in your subclass
    // ***** create root, treeModel and tree in the new initTree
    void initTree(ArrayList<String> data){

		root = new TaxonomyNode("Liv", "Liv", "");

		for (String line : data) {
            buildTree(root, new ArrayList<>(Arrays.asList(line.trim().split(" "))));
        }

        treeModel = new DefaultTreeModel(root);
        tree = new JTree(treeModel);

		/*
		ArrayList<String> parts = new ArrayList<>(Arrays.asList(data.get(0).trim().split(" ")));
		if (parts.size() == 1){
			return root;
		}

		data.remove(0);

		String level = parts.get(0);
		String name = parts.get(1);
		String info = "";

		for (int i = 2; i < parts.size(); i++) {
			if (i == 2){
				info = info + parts.get(i);
			}

			else {
				info = info + " " + parts.get(i);
			}
		}

		root = new TaxonomyNode(level, name, info);
		TaxonomyNode child = initTree(data);
		root.add(child);

		if (data.isEmpty()){
			treeModel = new DefaultTreeModel(root);
			tree = new JTree(treeModel);
		}

		
		
			
		/* 
		root = new TaxonomyNode("he");
		DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("Växter");
		DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("Djur");
		DefaultMutableTreeNode child3 = new DefaultMutableTreeNode("Svampar");
		root.add(child1);
		root.add(child2);
		root.add(child3);
		treeModel = new DefaultTreeModel(root);
		tree = new JTree(treeModel);
		*/
    }

    // ***** showDetails can also be overridden in a subclass *****
    void showDetails(TreePath path){
		if (path == null)
			return;
		String info = path.getLastPathComponent().toString();
		JOptionPane.showMessageDialog(this, info);
    }

    public static void main(String[] u) {

		try {
			Scanner sc = new Scanner(new File("Liv.txt"));

			ArrayList<String> cleaned = new ArrayList<>();

			while (sc.hasNext()){
				
				String nextLine = sc.nextLine();
				// System.out.println("Line read: " + nextLine);


				ArrayList<String> parts = new ArrayList<>(Arrays.asList(nextLine.split(" ")));
				String cleaned_line = "";

				for (String part: parts){
					String trimmed_part = part.trim();
					String firstChar = String.valueOf(trimmed_part.charAt(0));


					if (firstChar.equals("<")){
						String cleaned_part = trimmed_part.substring(1, trimmed_part.length());
						// System.out.println("< found, adding remaining part of token: " + cleaned_part);
						cleaned_line = cleaned_line + " " + cleaned_part;
					}

					else if (trimmed_part.length() >= 5 && trimmed_part.substring(0, 5).equals("namn=")){
						// System.out.println("'namn=' found, adding remaining part of token: " + trimmed_part.substring(6, (trimmed_part.length()-2)));
						cleaned_line = cleaned_line + " " + trimmed_part.substring(6, (trimmed_part.length()-2));
					}

					else {
						cleaned_line = cleaned_line + " " + trimmed_part;
					}
				}

				// System.out.println("Cleaned line: " + cleaned_line);
				cleaned.add(cleaned_line);
			}
			// System.out.println(cleaned);
			sc.close();

			new PreparationTree(cleaned);




		} catch(FileNotFoundException e){
			System.out.println("Whoops! Something went wrong");
		}

		
    }
}
