package Labb2;

public class RunMock {
    public static void main(String[] args) {
        MockObject mockGame = new MockObject();
        new ViewControl(mockGame, 2, "Mock Game");
    }
}