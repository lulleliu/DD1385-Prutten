import test.*;
import javax.swing.*;
import javax.swing.tree.*;

import test.TaxonomyNode;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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

			if (line.size() < 3) {
				if (!parent.getTheLevel().equals(line.get(0).substring(line.get(0).indexOf("/")+1, line.get(0).indexOf(">")))) {
					data.remove(0);
				}
			} else {
				String level = line.get(0);
				String name = line.get(1);
				String info = line.get(2);

				TaxonomyNode child = new TaxonomyNode(level, name, info);
				parent.add(child);
				data.remove(0);
				
				line = new ArrayList<>(Arrays.asList(data.get(0).trim().split("::")));
				while (line.size() >= 3 || !child.getTheLevel().equals(line.get(0).substring(line.get(0).indexOf("/")+1, line.get(0).indexOf(">")))) {
					buildTree(child, data);
					try {
						line = new ArrayList<>(Arrays.asList(data.get(0).trim().split("::")));
					} catch (IndexOutOfBoundsException e) {
						System.out.println("ERROR! Unmatching tags");
						return;
					}
					
				}
				data.remove(0);
		}
		

	}

	public static ArrayList<String> read_file(String filename) throws Exception{

		// Räknare som håller koll på öppning och stängnings taggar

		Integer start_count = 0;
		Integer end_count = 0;

		try {
				Scanner sc = new Scanner(new File(filename));

				ArrayList<String> cleaned = new ArrayList<>();

				while (sc.hasNext()){
					
					String nextLine = sc.nextLine();

					String cleaned_line = "";

					if (!nextLine.contains("/")){			// Om inte stängningstagg så läser vi in alla delar av raden
						start_count++;
						String level = nextLine.substring(nextLine.indexOf("<")+1, nextLine.indexOf(" namn"));
						String name = nextLine.substring(nextLine.indexOf("namn=") +6, nextLine.indexOf(">")-1);
						String info = nextLine.substring(nextLine.indexOf(">") +2, nextLine.length());

						// Bygger den processade strängen med utfunna delanra
						cleaned_line = cleaned_line + level;
						cleaned_line = cleaned_line + "::" + name;
						cleaned_line = cleaned_line + "::" + info.strip();
						cleaned.add(cleaned_line);		// Lägger till processad sträng till vår lista
					}

					else {		// Om stängningstagg
						end_count++;
						cleaned_line = nextLine.substring(nextLine.indexOf("/"), nextLine.length());
						cleaned.add(cleaned_line);
					}

				}

				sc.close();

				if (start_count==end_count){		// Kollar om inläsning av taggar matchar
					return cleaned;
				} else {
					throw new Exception("Unmatching opening and closing tags!");
				}
				
		}
		catch (FileNotFoundException e){
			System.out.println("Whoops! No such file: " + filename);
			return null;
		}
}

    // ***** Override method initTree in your subclass
    // ***** create root, treeModel and tree in the new initTree
    void initTree(ArrayList<String> data){

		/*
		ArrayList<String> first_line = new ArrayList<>(Arrays.asList(data.get(0).trim().split("::")));
		String level = first_line.get(0);
        String name = first_line.get(1);
        String info = String.join(" ", first_line.subList(2, first_line.size()));

		root = new TaxonomyNode(level, name, info);
		 */

		// Skapar roten
		root = new TaxonomyNode("Allt", "Allt", "Allt");

		// Bygger träd ur roten. Datan är en lista med strängar. Varje sträng är en processad linje från inläst dokument.
		buildTree(root, data);
		

        treeModel = new DefaultTreeModel(root);
        tree = new JTree(treeModel);

    }

    // ***** showDetails can also be overridden in a subclass *****
    void showDetails(TreePath path){
		if (path == null)
			return;
		TaxonomyNode node = (TaxonomyNode) path.getLastPathComponent();		// Tar fram noden som klickats på
		JOptionPane.showMessageDialog(this, node.getTheInfo());		// Skriver informationen tillhörande noden till rutan
    }

    public static void main(String[] u) throws Exception {
		
		try {		// Testar om egeninmatad filnamn existerar
			String filename = u[0];
			ArrayList<String> cleaned = read_file(filename); 	// I sådanna fall läser vi filen
			new PreparationTree(cleaned);		// Bygger träd med inlästa filen
			
		} catch(ArrayIndexOutOfBoundsException e){
			ArrayList<String> cleaned = read_file("Liv.txt");		// Om inmatning ej existerar så läser vi in "Liv.txt" hårdkodat
			new PreparationTree(cleaned);
		}
		
    }
}
