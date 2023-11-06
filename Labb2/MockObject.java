package Labb2;

public class MockObject implements Boardgame {

    private String[][] board = new String[2][2];
    public int[] coordsEmpty = new int[2];
    private String message = "amazing game";

    @Override
    public boolean move(int x, int y) {
        return true;
    }

    @Override
    public String getStatus(int x, int y) {
        return "AMZ";
    }

    @Override
    public String getMessage() {
        return message;
    }
    
}
