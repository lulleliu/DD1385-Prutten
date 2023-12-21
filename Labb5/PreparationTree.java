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

	private void buildTree(TaxonomyNode parent, ArrayList<String> data){
		while (!data.isEmpty()) {
			String line = data.get(0).trim();
	
			if (line.startsWith("<") && line.endsWith(">")) {
				// It's a tag
				String[] parts = line.substring(1, line.length() - 1).split(" ", 2);
				String level = parts[0];
				String content = parts.length > 1 ? parts[1] : "";
	
				TaxonomyNode child = new TaxonomyNode(level, "", content);
				parent.add(child);
				System.out.println(parent.toString() + Integer.toString(parent.getChildCount()));
	
				data.remove(0);
	
				// Recursively build tree for child nodes
				buildTree(child, data);
			} else if (line.startsWith("</")) {
				// It's a closing tag, return to the upper level
				data.remove(0);
				return;
			} else {
				// It's not a tag, move to the next line
				data.remove(0);
			}
		}
		/*
		while (!data.isEmpty()) {
			ArrayList<String> line = new ArrayList<>(Arrays.asList(data.get(0).trim().split(" ")));
	
			if (line.size() < 3) {
				if (parent.getTheLevel().equals(line.get(0).substring(line.get(0).indexOf("/")+1, line.get(0).indexOf(">")))) {
					data.remove(0);
				} else {
					return;
				}
			} else {
				String level = line.get(0);
				String name = line.get(1);
				String info = String.join(" ", line.subList(2, line.size()));
	
				TaxonomyNode child = new TaxonomyNode(level, name, info);
				parent.add(child);
				System.out.println(parent.toString() + Integer.toString(parent.getChildCount()));
	
				data.remove(0);
				buildTree(child, data);
			}
		}
		*/
		/* 
		ArrayList<String> line = new ArrayList<>(Arrays.asList(data.get(0).trim().split(" ")));

		if (line.size()<3){
			if (parent.getTheLevel().equals(line.get(0).substring(line.get(0).indexOf("/")+1, line.get(0).indexOf(">"))) && data.isEmpty()){
				System.out.println("Balle");
				return;
			} 
			else{
				System.out.println("Removing " + data.get(0));

				data.remove(0);
				if(data.isEmpty()){
					System.out.println("Empty 1");
					return;
				}
				buildTree(parent, data);

			}
		}
		

		/* 
		if (line.size() < 3) {
			if (data.isEmpty()){
				return;
			}
			
			else {
				data.remove(0);
				buildTree(parent, data);
			}
        }
		*/
		/* 
		if (line.size() == 1) {
			if (line.get(0).equals(parent.getTheLevel())) {
				if (!data.isEmpty()) {
				  TaxonomyNode p = (TaxonomyNode) parent.getParent();

				  data.remove(0);
				  buildTree(p, data);
				}
				return;
			}
			else{
				System.out.println("error");
			}
		}
		*/
		/* 
        String level = line.get(0);
        String name = line.get(1);
        String info = String.join(" ", line.subList(2, line.size()));

        TaxonomyNode child = new TaxonomyNode(level, name, info);
        parent.add(child);
		System.out.println(parent.toString() + Integer.toString(parent.getChildCount()));

        if (line.size() > 3) {
			data.remove(0);

			if(data.isEmpty()){
				System.out.println("Empty 2");
				return;
			}

            buildTree(child, data);
        }
		*/

	}

    // ***** Override method initTree in your subclass
    // ***** create root, treeModel and tree in the new initTree
    void initTree(ArrayList<String> data){

		ArrayList<String> first_line = new ArrayList<>(Arrays.asList(data.get(0).trim().split(" ")));
		String level = first_line.get(0);
        String name = first_line.get(1);
        String info = String.join(" ", first_line.subList(2, first_line.size()));
		root = new TaxonomyNode(level, name, info);

		data.remove(0);
		buildTree(root, data);
		/*
		for (String line : data) {
            buildTree(root, new ArrayList<>(Arrays.asList(line.trim().split(" "))));
        }
		*/

        treeModel = new DefaultTreeModel(root);
        tree = new JTree(treeModel);

		/*
		ArrayList<String> data = new ArrayList<>(Arrays.asList(data.get(0).trim().split(" ")));
		if (data.size() == 1){
			return root;
		}

		data.remove(0);

		String level = data.get(0);
		String name = data.get(1);
		String info = "";

		for (int i = 2; i < data.size(); i++) {
			if (i == 2){
				info = info + data.get(i);
			}

			else {
				info = info + " " + data.get(i);
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


				ArrayList<String> data = new ArrayList<>(Arrays.asList(nextLine.split(" ")));
				String cleaned_line = "";

				for (String part: data){
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
