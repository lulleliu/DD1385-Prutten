package Labb2;

public class RunFifteen {
    public static void main(String[] args) {
        FifteenModel fifteengame = new FifteenModel();
        ViewControl fifteengraphic = new ViewControl(fifteengame, 4, "Fifteen game");
    }
}
