import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.util.HashSet;

import javax.swing.JFrame;

public class JFlappy extends JFrame {
    
    public static int GAME_HEIGHT = 600;
    public static int GAME_WIDTH = 1200;



    HashSet<Integer> keys = new HashSet<Integer>();
    public static void main(String[] args) {
        JFlappy jf = new JFlappy();
    }

    HiloJuego hilo;
    private JFondo fondo;

    public JFlappy() {
        super("Flappy Bird");
        initComponents();

        hilo = new HiloJuego(this);
        hilo.start();

        this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.requestFocus();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void initComponents() {
        fondo = new JFondo(this);
        this.add(fondo);
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                keys.add(e.getKeyCode());
            }

            public void keyReleased(java.awt.event.KeyEvent e) {
                keys.remove(e.getKeyCode());
            }
        });
    }

    JPollo getPollo() {
        return hilo.getPollo();
    }
    HashSet<Integer> getKeys() {
        return keys;
    }

    public Component getFondo() {
        return fondo;
    }
}
