package Labb2;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// import Labb2.FifteenModel;

// lämpliga import-satser här
class ViewControl extends JFrame implements ActionListener {

    private Boardgame game;
    private int size;
    private Square[][] board;        // Square är subklass till JButton
    private JTextField mess = new JTextField();  // JLabel funkar också

    ViewControl (Boardgame gm, int n, String gameName){  // OK med fler parametrar om ni vill!
        this.game = gm;
        this.size = n;

        board = new Square[size][size];

        JFrame gameFrame = new JFrame(gameName);
        gameFrame.setVisible(true);

        // Skapar paneler
        JPanel mainPanel = new JPanel();
        JPanel slotsPanel = new JPanel();
        JPanel messagePanel = new JPanel();

        // Ändrar layouten så det blir av matrisform
        mainPanel.setLayout(new BorderLayout());
        slotsPanel.setLayout(new GridLayout(size, size));

        messagePanel.add(mess);

        // Lägger till panelerna i framen
        mainPanel.add(slotsPanel, BorderLayout.CENTER);
        mainPanel.add(messagePanel, BorderLayout.PAGE_END);
        gameFrame.add(mainPanel);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(500,500);
        
    }

    public static void main(String[] args) {
        //FifteenModel testboard = new FifteenModel();
        ViewControl test = new ViewControl(null, 4, "TEST");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}