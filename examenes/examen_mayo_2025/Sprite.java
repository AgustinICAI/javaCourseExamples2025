import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Sprite {
    protected int x, y, width, height; // Posición y tamaño
    protected double speedX, speedY;   // Velocidad en px/s

    public Sprite(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speedX = 0; // Velocidad inicial en X
        this.speedY = 0; // Velocidad inicial en Y
    }

    // Métodos abstractos que deben implementar las subclases
    public abstract void draw(Graphics g);
    public abstract void move(double deltaTime);

    // Métodos para obtener y establecer la velocidad
    public double getSpeedX() {
        return speedX;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    // Métodos para obtener y establecer la posición
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // Método para obtener los límites del sprite (para colisiones)
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}