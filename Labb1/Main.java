import javax.swing.JButton;

public class Main {

        public static void main(String[] args){
            MyFrame frame = new MyFrame("Lucas, Filip");
            frame.setDefaultCloseOperation(MyFrame.EXIT_ON_CLOSE);
            frame.setSize(500,500);
            MyButton button = new MyButton("Press");
            frame.getContentPane().add(button);
            frame.setVisible(true);
            button.addActionListener();
    }
}
