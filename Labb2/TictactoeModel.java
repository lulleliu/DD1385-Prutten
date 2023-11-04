package Labb2;

public class TictactoeModel implements Boardgame {
    private String currentMessage = "Player X's Turn";
    private String[][] board = new String[3][3];
    private int roundsCount = 1;
    private String Player = "X";

    TictactoeModel(){
        InitializeBoard();
    }
    private void InitializeBoard(){
        for (int i=0; 1<3; i++){
            for (int j=0; j<3; j++){
                board[i][j] = " ";
            }
        }

        }

    public boolean move(int x, int y){
        //Kollar om det är utplaceringsfas eller flyttfas
        if (roundsCount <= 6){
        //Kollar så att den valda rutan är tom
            if (board[x][y] != " "){
                currentMessage = "Not an avaiable move, pick an empty tile";
                return false;
            }

            setPlayer();
            currentMessage = "Player " + Player + "'s turn";
            if (roundsCount%2==0){
                //kollar om det är spelare 2s tur
                board[x][y] = "O";

            }else{
                //Annars är det spelare 1s tur
                board[x][y] = "X";
            }
            //Lägger till denna rundan på counten 
            roundsCount+=1;
            return true;
            }
        return false;
    }

    private void setPlayer(){
        if (Player == "X"){
            Player = "O";
        }else Player = "X";
    }
    //En del av interfacet boardgame returnerar statusen av en position i arrayen
    public String getStatus(int x, int y){
        return board[x][y];
    
    }
    //En del av interfacet boardgame, returnerar meddelandet
    public String getMessage(){
        return currentMessage;
    }}

