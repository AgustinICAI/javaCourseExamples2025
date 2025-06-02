import java.awt.*;

public class Ball extends Sprite {
    // Atributos estáticos para las propiedades iniciales
    public static final int INITIAL_X = 300;
    public static final int INITIAL_Y = 200;
    public static final int DIAMETER = 20;
    public static final int INITIAL_SPEED_X = 200; // Velocidad inicial en px/s
    public static final int INITIAL_SPEED_Y = 200; // Velocidad inicial en px/s

    public Ball() {
        super(INITIAL_X, INITIAL_Y, DIAMETER, DIAMETER);
        this.speedX = INITIAL_SPEED_X;
        this.speedY = INITIAL_SPEED_Y;
    }

    @Override
    public void move(double deltaTime) {
        x += speedX * deltaTime; // Actualizar posición en función de deltaTime
        y += speedY * deltaTime; // Actualizar posición en función de deltaTime

        // Rebote contra las paredes laterales
        if (x <= 0) {
            x = 0; // Asegurar que la pelota no quede fuera del borde izquierdo
            speedX = -speedX;
        } else if (x + width >= Game.panelWidth) {
            x = Game.panelWidth - width; // Asegurar que la pelota no quede fuera del borde derecho
            speedX = -speedX;
        }

        // Rebote contra el techo
        if (y <= 0) {
            y = 0; // Asegurar que la pelota no quede fuera del borde superior
            speedY = -speedY;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED); // Color de la pelota
        g.fillOval(x, y, width, height); // Dibujar la pelota como un óvalo
    }

    public void increaseSpeed(double increment) {
        speedX += (speedX > 0) ? increment : -increment;
        speedY += (speedY > 0) ? increment : -increment;
    }

    public void reset() {
        x = INITIAL_X;
        y = INITIAL_Y;
        speedX = INITIAL_SPEED_X;
        speedY = INITIAL_SPEED_Y;
    }

    public void reverseY() {
        speedY = -speedY; // Invertir la dirección vertical
    }
}