package Labb2;

import java.util.ArrayList;

class FifteenModel implements Boardgame {
    private String[][] board = new String[4][4];
    public int[] coordsEmpty = new int[2];
    private String message;
    private String tempSlot;
    
    //Constructor
    public FifteenModel(){
        ArrayList<String> pieceArray = new ArrayList<String>();
        pieceArray.add("__");
        for (Integer i = 0; i < 15; i++){
            pieceArray.add(String.valueOf(i+1));
        }
         
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++){
                int randomposition =  (int)Math.floor(Math.random() * (pieceArray.size() - 1 - 0 + 1) + 0);
                if (pieceArray.get(randomposition).equals("__")){
                    coordsEmpty[0] = i;
                    coordsEmpty[1] = j;
                }
                board[i][j] = pieceArray.get(randomposition);
                pieceArray.remove(randomposition);
            } 
        }

    }


/* 
    @Override
    public boolean move(int x, int y) {
        int x1 = x-1;
        int x2 = x+1;
        int y1 = y-1;
        int y2 = y+1;

        System.out.println("coords:");
        System.out.println(coordsEmpty[0]);
        System.out.println(coordsEmpty[1]);

        tempSlot = board[x][y];
        //rutan ovanför
        if (y1 == coordsEmpty[1] && x == coordsEmpty[0]){
            System.out.println("possible move:");
            System.out.println(x);
            System.out.println(y1);
            message = "Valid move, since the slot aboe was empty. Good job!";
            coordsEmpty[1] = y;
            coordsEmpty[0] = x;

            System.out.println(board[x][y1]);
            board[x][y1] = board[x][y];
            board[x][y] = "__";

            return true;
        }

        //rutan nedan
        if (y2 == coordsEmpty[1] && x == coordsEmpty[0]){
            System.out.println("possible move:");
            System.out.println(x);
            System.out.println(y2);
            message = "Valid move, since the slot below was empty. Good job!";
            coordsEmpty[1] = y;
            coordsEmpty[0] = x;

            board[x][y2] = tempSlot;
            board[x][y] = "__";

            return true;
        }

        //rutan vänster
        if (y == coordsEmpty[1] && x1 == coordsEmpty[0]){
            System.out.println("possible move:");
            System.out.println(x1);
            System.out.println(y);
            message = "Valid move, since the slot to the left was empty. Good job!";
            coordsEmpty[1] = y;
            coordsEmpty[0] = x;

            board[x1][y] = tempSlot;
            board[x][y] = "__";

            return true;
        }

        //rutan höger
        if (y == coordsEmpty[1] && x2 == coordsEmpty[0]){
            System.out.println("possible move:");
            System.out.println(x2);
            System.out.println(y);
            message = "Valid move, since the slot to the right was empty. Good job!";
            coordsEmpty[1] = y;
            coordsEmpty[0] = x;

            board[x2][y] = tempSlot;
            board[x][y] = "__";

            return true;
        }
        
        //annars funkar det inte
        else {
            message = "Not a possible move. Move a number next to the empty slot";
            return false;
        }

        

    }

*/
public boolean move(int x, int y) {
    int emptyX = coordsEmpty[0];
    int emptyY = coordsEmpty[1];
    if ((Math.abs(emptyX - x) == 1 && emptyY == y) || (Math.abs(emptyY - y) == 1 && emptyX == x)) {
        // Check if the selected cell is adjacent to the empty cell

        // Swap the selected cell and the empty cell
        String tempSlot = board[y][x];
        board[y][x] = "__";
        board[emptyY][emptyX] = tempSlot;

        coordsEmpty[0] = x;
        coordsEmpty[1] = y;

        message = "Valid move, swapped cell with empty slot.";
        return true;
    } else {
        message = "Not a possible move. Move a number next to the empty slot.";
        return false;
    }
}
    public String getStatus(int x, int y) {
        if (board[x][y] == null){
            return " ";
        }
        return board[x][y];
    }

    @Override
    public String getMessage() {
        return message;
    }


    
}