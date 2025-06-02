import javax.swing.*;

public class JPongSolitario {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong Solitario");
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}