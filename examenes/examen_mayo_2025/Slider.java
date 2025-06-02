import java.awt.*;

public class Slider extends Sprite {
    // Atributos estáticos para las propiedades iniciales
    public static final int INITIAL_X = 250;
    public static final int INITIAL_Y = 380;
    public static final int WIDTH = 100;
    public static final int HEIGHT = 10;

    public Slider() {
        super(INITIAL_X, INITIAL_Y, WIDTH, HEIGHT);
        this.speedX = 0; // Velocidad inicial del slider (puede cambiar dinámicamente)
    }

    @Override
    public void move(double deltaTime) {
        // El slider no se mueve automáticamente, solo responde a las teclas
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE); // Color del slider
        g.fillRect(x, y, width, height); // Dibujar el slider como un rectángulo
    }

    public void moveLeft(double distance) {
        x = Math.max(0, x - (int) distance); // Mover a la izquierda y asegurar que no salga del borde
    }

    public void moveRight(double distance) {
        x = Math.min(Game.panelWidth - width, x + (int) distance); // Mover a la derecha y asegurar que no salga del borde
    }
}