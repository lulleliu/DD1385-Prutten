package Labb2;

import java.util.*;
class Text15 {
    public static void main(String[] u) {
        Scanner scan = new Scanner(System.in);
        Boardgame thegame = new FifteenModel();                 // Model object is created
        System.out.println("\nWelcome to tictactoe\n");
        while (true) {
            // Print the current board
            for (int i=0; i<4; i++) {
                for (int j=0; j<4; j++)
                    System.out.print("  " + thegame.getStatus(i,j)); // getStatus
                System.out.println();
            }

            System.out.println();
            int i = scan.nextInt();  // get an int number from terminal window
            int j = scan.nextInt();
            thegame.move(j,i);	                             // move
            System.out.println(thegame.getMessage());	     // getMessage
        }
    }
}