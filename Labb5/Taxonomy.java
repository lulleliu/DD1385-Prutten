import javax.swing.*;
import javax.swing.tree.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Taxonomy extends TreeFrame {

    static String directory=".";

    // Overrides method in TreeFrame
    void initTree() {
		root = new DefaultMutableTreeNode(directory);
		treeModel = new DefaultTreeModel( root );
		tree = new JTree( treeModel );
		buildTree();
    }

    // New method
    private void buildTree() {
		File f=new File(directory);
		String[] list = f.list(); 
		for (int i=0; i<list.length; i++ )
			buildTree(new File(f,list[ i ]), root); 
    }

    // New method
    private void buildTree( File f, DefaultMutableTreeNode parent) {  
		DefaultMutableTreeNode child = 
			new DefaultMutableTreeNode( f.toString() );
		parent.add(child);
		if ( f.isDirectory() ) {
			String list[] = f.list();
			for ( int i = 0; i < list.length; i++ )
			buildTree( new File(f,list[i]), child);            
		}        
    }  

    // Overrides method in TreeFrame
    void showDetails(TreePath p){
		if ( p == null )
			return;
		File f = new File( p.getLastPathComponent().toString() );
		JOptionPane.showMessageDialog( this, f.getPath() + 
						"\n   " + 
						getAttributes( f ) );
    }

    // New method
    private String getAttributes( File f ) {
		String t = "";
		if ( f.isDirectory() )
			t += "Directory";
		else
			t += "Nondirectory file";
		t += "\n   ";
		if ( !f.canRead() )
			t += "not ";
		t += "Readable\n   ";
		if ( !f.canWrite() )
			t += "not ";
		t += "Writeable\n  ";
		if ( !f.isDirectory() )
			t += "Size in bytes: " + f.length() + "\n   ";
		else {
			t += "Contains files: \n     ";
			String[ ] contents = f.list();
			for ( int i = 0; i < contents.length; i++ )
			t += contents[ i ] + ", ";
			t += "\n";
		} 
		return t;
    }

    public static void main(String[] args) {

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

			sc.close();




		} catch(Exception e){
			System.out.println("Whoops! Something went wrong with parsing the file");
		}


		if(args.length>0) directory=args[0];
		new DirTree2();

		
    }

}
