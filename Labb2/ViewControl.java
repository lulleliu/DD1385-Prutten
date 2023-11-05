package Labb2;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        
        //Adds the squares
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Vi vill skapa en ruta med information i, dvs rutans status.
                Square square = new Square(gm.getStatus(i, j));
                square.setCoordinates(i,j);
                square.addActionListener(this);
                board[i][j] = square;

                slotsPanel.add(square);
            }
            
        }    
        messagePanel.add(mess);

        // Lägger till panelerna i framen
        mainPanel.add(slotsPanel, BorderLayout.CENTER);
        mainPanel.add(messagePanel, BorderLayout.PAGE_END);
        gameFrame.add(mainPanel);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(500,500);
        
    }

    public static void main(String[] args) {
        FifteenModel testboard = new FifteenModel();
        ViewControl test = new ViewControl(testboard, 4, "TEST");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Square clickedSquare = (Square) e.getSource();

        game.move(clickedSquare.getX(), clickedSquare.getY());
        String message = game.getMessage();
        mess.setText(message);
        updateBoard();
        


    }

    public void updateBoard(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j].setText(game.getStatus(i, j));
            }
        }
    }
}