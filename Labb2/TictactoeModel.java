package Labb2;

public class TictactoeModel implements Boardgame {
    private String currentMessage = "Player X's Turn";
    private String[][] board = new String[3][3];
    private int roundsCount = 1;
    private String player = "X";
    private int xmove;
    private int ymove;
    private Boolean moveselected = false;

    TictactoeModel(){
        InitializeBoard();
    }

    private void InitializeBoard(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                board[i][j] = " ";
            }
        }

        }
    
    private boolean placementPhase(int x, int y){
            if (board[x][y] != " "){
            currentMessage = "Not an avaiable move, pick an empty tile";
            return false;
            }

            setPlayer();
            currentMessage = "Player " + player + "'s turn";
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
    
    private boolean movePhase(int x, int y){
            if (!moveselected && (!board[x][y].equals(player) || board[x][y].equals(" "))){
                currentMessage = "Not an available move, pick an" + player +  " piece to move";
                return false;
            }

            // available move
            else if (!moveselected && board[x][y].equals(player)){
                currentMessage = "Pick an empty slot to move to";
                xmove = x;
                ymove = y;
                moveselected = true;
                return true;
            
            }

            if (moveselected == true){
                if (board[x][y].equals(" ")){
                    board[x][y] = board[xmove][ymove];
                    board[xmove][ymove] = " ";
                    setPlayer();
                    roundsCount++;
                    moveselected = false;
                    return true;      
                }                 
                else {
                    currentMessage = "välj en tom";
                    return false;
            }
        }
    return true;
    }  
    
    public boolean move(int x, int y){
        if (roundsCount <= 6){
            return placementPhase(x, y);
        }else{
            return movePhase(x, y);
        }
    }
        /* 
        //Kollar om det är utplaceringsfas eller flyttfas
        if (roundsCount <= 6){
        //Kollar så att den valda rutan är tom
            if (board[x][y] != " "){
                currentMessage = "Not an avaiable move, pick an empty tile";
                return false;
            }

            setPlayer();
            currentMessage = "Player " + player + "'s turn";
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
            }}

        // move phase
        else {
            if (!moveselected && (!board[x][y].equals(player) || board[x][y].equals(" "))){
                currentMessage = "Not an available move, pick an" + player +  " piece to move";
                return false;
            }

            // available move
            else if (!moveselected && board[x][y].equals(player)){
                currentMessage = "Pick an empty slot to move to";
                xmove = x;
                ymove = y;
                moveselected = true;
                return true;
            
            }

            if (moveselected == true){
                if (board[x][y].equals(" ")){
                    board[x][y] = board[xmove][ymove];
                    board[xmove][ymove] = " ";
                    setPlayer();
                    roundsCount++;
                    moveselected = false;
                    return true;      
                }                 
                else {
                    currentMessage = "välj en tom";
                    return false;
                } 
            }

            

        } 
    */
    
    private void setPlayer(){
        if (player.equals("X")){
            player = "O";
        }else player = "X";
    }
    
    //En del av interfacet boardgame returnerar statusen av en position i arrayen
    public String getStatus(int x, int y){
        return board[x][y];
    
    }
    //En del av interfacet boardgame, returnerar meddelandet
    public String getMessage(){
        return currentMessage;
    }
    }



