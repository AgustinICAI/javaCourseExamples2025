import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

public class GamePanel extends JPanel implements KeyListener, Runnable {
    private static final int FPS = 60; // Configurable: Frames por segundo
    private Game game;
    private boolean moveLeft = false, moveRight = false; // Control de teclas presionadas

    public GamePanel() {
        setPreferredSize(new Dimension(600, 400));
        setBackground(Color.BLACK);
        game = new Game();
        addKeyListener(this);
        setFocusable(true);

        // Iniciar hilos
        new Thread(this).start(); // Hilo principal del juego
        new Thread(this::moveSlider).start(); // Hilo para mover el slider
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Establecer la posición del slider
        game.getSlider().y = getHeight() - 30;

        // Dibujar la paleta
        g.setColor(Color.WHITE);
        game.getSlider().draw(g);

        // Dibujar la pelota
        game.getBall().draw(g);

        // Dibujar la puntuación
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Tiempo: " + game.getScore() + " segundos", 10, 20);
        

        // Dibujar el Top 3 de puntuaciones
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Top 3 Puntuaciones:", getWidth() - 200, 20);
        Iterator<Integer> iterator = game.getTopScoresDescending();
        for (int i = 0; i < 3 && iterator.hasNext(); i++) {
            g.drawString((i + 1) + ". " + iterator.next() + " segundos", getWidth() - 200, 40 + i * 20);
        }

        // Mostrar mensaje de fin del juego si es necesario
        if (game.isGameOver() && !game.isFirstRun()) {
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.setColor(Color.RED);
            g.drawString("¡Juego terminado!", getWidth() / 2 - 100, getHeight() / 2 - 20);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Tiempo final: " + game.getScore() + " segundos", getWidth() / 2 - 80, getHeight() / 2 + 20);
            g.setFont(new Font("Arial", Font.PLAIN, 16));
            g.drawString("Presiona ESPACIO para reiniciar", getWidth() / 2 - 120, getHeight() / 2 + 50);
        }
    }

    @Override
    public void run() {
        long frameDuration = 1000 / FPS; // Duración de cada cuadro en milisegundos

        while (true) {
            game.updateGame(getWidth(), getHeight());
            repaint();

            // Pausar el hilo para mantener el FPS configurado
            try {
                Thread.sleep(frameDuration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void moveSlider() {
        long lastUpdateTime = System.currentTimeMillis(); // Tiempo de la última actualización

        while (true) {
            long currentTime = System.currentTimeMillis();
            double deltaTime = (currentTime - lastUpdateTime) / 1000.0; // Tiempo transcurrido en segundos
            lastUpdateTime = currentTime;

            if (moveLeft) {
                game.moveSliderLeft(getWidth(), deltaTime); // Mover el slider a la izquierda
            }
            if (moveRight) {
                game.moveSliderRight(getWidth(), deltaTime); // Mover el slider a la derecha
            }

            // Pausar el hilo para controlar la velocidad del movimiento del slider
            try {
                Thread.sleep(10); // Ajusta este valor si es necesario
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!game.isGameOver()) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                moveLeft = true;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                moveRight = true;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            game.resetGame(); // Reiniciar el juego al presionar Espacio
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moveLeft = false;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveRight = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}