import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;

class RPSSkel extends JFrame implements ActionListener{
    Gameboard myboard, computersboard;
    Integer counter = 0; // To count ONE ... TWO  and on THREE you play
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    JButton closebutton;

    RPSSkel() {
		
		try {
            // localhost är alias för IP-adress för den lokala datorn d.v.s. den datorn 
            // du kör detta program (vilket i detta fall är samma dator som serverprogrammet körs på)
            Socket socket = new Socket("localhost",4713);
            Scanner scanner = new Scanner(System.in);

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            System.out.println("Enter your name: ");
           	String name = scanner.nextLine();
            out.println(name);
            out.flush();

            System.out.println(in.readLine());

			setDefaultCloseOperation(EXIT_ON_CLOSE);
			//closebutton = new JButton("Close");
			createCloseBttn();

			myboard = new Gameboard(name, this); // Must be changed
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
		
		catch (IOException e){
			System.out.println("Ingen Anslutning");
		}

		
	
	}


	private void createCloseBttn(){
		closebutton = new JButton("Close");
		ActionListener closebuttonlistener = (new ActionListener() {
			public void actionPerformed(ActionEvent e){
				out.println("");
				out.flush();
				System.exit(0);
			}	
		});
		closebutton.addActionListener(closebuttonlistener);
	}



	private void updateBoard(String playerPick, String computerPick){
		if (counter == 1){
			myboard.setLower("Ett...");
			computersboard.setLower("Ett..");
			myboard.setUpper("RPS");
			computersboard.setUpper("RPS");
			//myboard.setUpper(playerPick);
			//computersboard.setUpper(computerPick);

			myboard.resetColor();
			computersboard.resetColor();

			}

		if (counter == 2){
			myboard.setLower("Två...");
			computersboard.setLower("Två..");
		
			//myboard.setUpper(playerPick);
			//computersboard.setUpper(computerPick);

			}

		if (counter == 3){
			counter = 0;

			myboard.resetColor();
			computersboard.resetColor();

			myboard.markPlayed(playerPick);
			computersboard.markPlayed(computerPick);
			
			myboard.setLower(playerPick);
			computersboard.setLower(computerPick);

			myboard.setUpper(playerPick);
			computersboard.setUpper(computerPick);

			result(playerPick, computerPick);
			
			// Object clicked = e.getSource();

			}
		
	}

	private void result(String playerPick, String computerPick){
		if (playerPick.equals(computerPick)){
			myboard.setLower("DRAW");
			computersboard.setLower("DRAW");
		} 
		
		else if
			(playerPick.equals("SAX") && computerPick.equals("PASE") ||
			playerPick.equals("PASE") && computerPick.equals("STEN") ||
			playerPick.equals("STEN") && computerPick.equals("SAX")){
			myboard.setLower("WIN");
			computersboard.setLower("LOSE");
			myboard.wins();
		}

		else {
			myboard.setLower("LOSE");
			computersboard.setLower("WIN");
			computersboard.wins();
		}
		
	}

	public void actionPerformed(ActionEvent e) {
        // This method will be called when a button on the player's board is clicked
		counter++;
		String playerPick = e.getActionCommand();
		System.out.println(playerPick);
		String computerPick;
		try {
			out.println(playerPick);
			out.flush();

			computerPick = in.readLine();
			updateBoard(playerPick, computerPick);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		


        // Handle the button click based on the command
        // You can add your game logic here, for example, compare player's choice with computer's choice
        // ...

        // Update the UI based on the game result
        //playerBoard.setUpper("You chose: " + command);
        // Update other UI components as needed
        // ...

        // Example: Mark the player's choice on the player's board
        //playerBoard.markPlayed(command);
    }

    public static void main (String[] u) {
		new RPSSkel();
		// Här sker Sockethantering
    }
}


