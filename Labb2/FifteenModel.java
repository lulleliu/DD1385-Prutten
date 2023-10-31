package Labb2;

import java.util.ArrayList;

class FifteenModel implements Boardgame {
    private String[][] board = new String[4][4];
    public int[] coordsEmpty = new int[2];
    
    //Constructor
    public FifteenModel(){
        ArrayList<String> pieceArray = new ArrayList<String>();
        pieceArray.add("");
        for (Integer i = 0; i < 15; i++){
            pieceArray.add(String.valueOf(i+1));
        }
         
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++){
                int randomposition =  (int)Math.floor(Math.random() * (pieceArray.size() - 1 - 0 + 1) + 0);
                if (pieceArray.get(randomposition).equals("")){
                    coordsEmpty[0] = i;
                    coordsEmpty[1] = j;
                }
                board[i][j] = pieceArray.get(randomposition);
                pieceArray.remove(randomposition);
            }
            
        }

    }

    @Override
    public boolean move(int x, int y) {
        
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }


    public String getStatus(int x, int y) {
        return String.valueOf(board[x][y]);
    }

    @Override
    public String getMessage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMessage'");
    }
    
}