import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import java.util.HashSet;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class JFlappy extends JFrame {
    
    public static int GAME_HEIGHT = 600;
    public static int GAME_WIDTH = 1200;

    public enum EstadoJuego {
        INICIO, ARRANCADO, PERDIDO
    }

    EstadoJuego estadoJuego = EstadoJuego.INICIO;

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
        estadoJuego = EstadoJuego.ARRANCADO;
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
            public void keyPressed(KeyEvent e) {
                keys.add(e.getKeyCode());
                if (e.getKeyCode() == KeyEvent.VK_SPACE && estadoJuego.equals("PERDIDO")) {
                    estadoJuego = EstadoJuego.ARRANCADO;
                    hilo = new HiloJuego(JFlappy.this);
                    hilo.start();
                }
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

    public ArrayList<Tuberia> getTuberias() {
        return hilo.getTuberias();
    }

    public String getTuberiasPasadas() {
        return String.valueOf(hilo.getTuberiaPasadas());
    }

    public EstadoJuego getEstadoJuego() {
        return estadoJuego;    
    }

    public void setEstadoJuego(EstadoJuego estado) {
        this.estadoJuego = estado;    
    }
}
