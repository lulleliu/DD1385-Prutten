import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;

class RPSSkel extends JFrame implements ActionListener{
    Gameboard myboard, computersboard;
    int counter = 0; // To count ONE ... TWO  and on THREE you play
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    JButton closebutton;

    RPSSkel() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		closebutton = new JButton("Close");

		myboard = new Gameboard("Myself", this); // Must be changed
		computersboard = new Gameboard("Computer");

		JPanel boards = new JPanel();
		boards.setLayout(new GridLayout(1,2));

		boards.add(myboard);
		boards.add(computersboard);

		add(boards, BorderLayout.CENTER);
		add(closebutton, BorderLayout.SOUTH);

		setSize(350, 650);
		setVisible(true);
    }
	
	public void actionPerformed(ActionEvent e) {
        // This method will be called when a button on the player's board is clicked

        
		if (counter == 0){
			system.out.println("ETT..");
			counter++;
		}
		else if (counter == 1){
			system.out.println("TVÅ..");
			counter++;
		}

		else {
			System.out.println("Du valde " + );
			counter = 0; 
			String command = e.getActionCommand(); // Get the text from the button
		}

        // Handle the button click based on the command
        // You can add your game logic here, for example, compare player's choice with computer's choice
        // ...

        // Update the UI based on the game result
        playerBoard.setUpper("You chose: " + command);
        // Update other UI components as needed
        // ...

        // Example: Mark the player's choice on the player's board
        playerBoard.markPlayed(command);
    }

    public static void main (String[] u) {
		RPSSkel skel = new RPSSkel();
		skel.actionPerformed()
		// Här sker Sockethantering
    }
}
