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

		ArrayList<String> line = new ArrayList<>(Arrays.asList(data.get(0).trim().split("::")));
		System.out.println(line);
		if (line.size() < 3) {
			if (!parent.getTheLevel().equals(line.get(0).substring(line.get(0).indexOf("/")+1, line.get(0).indexOf(">")))) {
				data.remove(0);
			}
		} else {
			String level = line.get(0);
			String name = line.get(1);
			//String info = String.join(" ", line.subList(2, line.size()));
			String info = line.get(2);
			System.out.println(info);
			//System.out.println(level + " " + name + " " + info);

			TaxonomyNode child = new TaxonomyNode(level, name, info);
			parent.add(child);
			data.remove(0);
			
			line = new ArrayList<>(Arrays.asList(data.get(0).trim().split("::")));
			while (line.size() >= 3 || !child.getTheLevel().equals(line.get(0).substring(line.get(0).indexOf("/")+1, line.get(0).indexOf(">")))) {
				buildTree(child, data);
				line = new ArrayList<>(Arrays.asList(data.get(0).trim().split("::")));
			}
			data.remove(0);
		}

	}

    // ***** Override method initTree in your subclass
    // ***** create root, treeModel and tree in the new initTree
    void initTree(ArrayList<String> data){

		ArrayList<String> first_line = new ArrayList<>(Arrays.asList(data.get(0).trim().split(" ")));
		String level = first_line.get(0);
        String name = first_line.get(1);
        String info = String.join(" ", first_line.subList(2, first_line.size()));
		root = new TaxonomyNode(level, name, info);

		// data.remove(0);
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
				System.out.println("Line read: " + nextLine);


				// ArrayList<String> data = new ArrayList<>(Arrays.asList(nextLine.split(" ")));
				String cleaned_line = "";

				if (!nextLine.contains("/")){
					String level = nextLine.substring(nextLine.indexOf("<")+1, nextLine.indexOf(" namn"));
					String name = nextLine.substring(nextLine.indexOf("namn=") +6, nextLine.indexOf(">")-1);
					String info = nextLine.substring(nextLine.indexOf(">") +2, nextLine.length());

					cleaned_line = cleaned_line + level;
					cleaned_line = cleaned_line + "::" + name;
					cleaned_line = cleaned_line + "::" + info.strip();
					System.out.println(cleaned_line);
					cleaned.add(cleaned_line);
				}

				else {
					cleaned_line = nextLine.substring(nextLine.indexOf("/"), nextLine.length());
					System.out.println(cleaned_line);
					cleaned.add(cleaned_line);
				}

			}
			System.out.println(cleaned);
				/*

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
				// System.out.println(cleaned_line);
			}
			*/
			
			// System.out.println(cleaned);
			sc.close();

			new PreparationTree(cleaned);




		} catch(FileNotFoundException e){
			System.out.println("Whoops! Something went wrong");
		}

		
    }
}
