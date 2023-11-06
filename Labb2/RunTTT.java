package Labb2;

public class RunTTT {
    public static void main(String[] args) {
        TictactoeModel tictactoe = new TictactoeModel();
        new ViewControl(tictactoe, 3, "Tictactoe");
    }
}
