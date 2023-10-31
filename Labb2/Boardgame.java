package Labb2;

public interface Boardgame {
    public boolean move(int x, int y);
    public String getStatus(int x, int y);
    public String getMessage();
}