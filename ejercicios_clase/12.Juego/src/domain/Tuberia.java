package domain;

import ui.JFlappy;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.HashSet;

public class Tuberia extends Sprite {
  private static final int WIDTH = 100;
  private static final double VELOCIDAD = 300;
  private static final int ANCHO_TUBERIA = 400;
  

  public Tuberia() {
    super(JFlappy.GAME_WIDTH, Math.random() * (JFlappy.GAME_HEIGHT-ANCHO_TUBERIA) + ANCHO_TUBERIA, VELOCIDAD, 0);
}

  public Rectangle getRectInferior() {
    return new Rectangle((int) x, (int) y, WIDTH, JFlappy.GAME_HEIGHT - (int) y);
  }
  public Rectangle getRectSuperior() {
    return new Rectangle((int) x, 0, WIDTH, (int) y - ANCHO_TUBERIA);
  }

  public void paint(Graphics g) {
        g.setColor(java.awt.Color.GREEN);
        g.fillRect( getRectInferior().x, getRectInferior().y, getRectInferior().width, getRectInferior().height);
        g.fillRect( getRectSuperior().x, getRectSuperior().y, getRectSuperior().width, getRectSuperior().height);
    }

  @Override
  public void move(HashSet<Integer> keys) {
    this.x -= this.vx / HiloJuego.FPS;
  }

}
