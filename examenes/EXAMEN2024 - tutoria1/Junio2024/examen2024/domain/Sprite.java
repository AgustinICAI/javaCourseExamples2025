package examen2024.domain;

import examen2024.ui.JFondo;

import java.awt.*;

public abstract class Sprite {
    double x;
    double y;
    double velocidadX, velocidadY;

    public Sprite(double x, double y, double velocidadX, double velocidadY){
        this.x = x;
        this.y = y;
        this.velocidadX = velocidadX;
        this.velocidadY = velocidadY;
    }
    public Sprite(){}

    public abstract void pintar(Graphics g);
    public abstract Rectangle getShape();

    public double getVelocidad(){
        return Math.hypot(velocidadX, velocidadY);
    }

    public abstract void updatePosicion();

    public abstract void reset();
}
