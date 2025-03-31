import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import javax.imageio.ImageIO;

public class JPollo extends Sprite {
  private static final double SUBIDA = 150;
  boolean espacioPulsado = false;
  long lastEspacioPulsado = 0;
  static int WIDTH = 100;
  static int HEIGHT = 100;
  BufferedImage imagePollo;
  private double angulo = 0;
  private static final double velocidadRotacion = 250;
  private static final double velocidadCaida = 600;

  public JPollo() {
    super(80, 400, 0, velocidadCaida);

    try {
      BufferedImage imageOriginal = ImageIO.read(new File("flappy.png"));

      Image image = imageOriginal.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);

      imagePollo = Util.convertirAImagenBuffered(image, WIDTH, HEIGHT);
    } catch (IOException e) {
      System.out.println("No se pudo cargar la imagen");
    }
  }

  public void paint(Graphics g) {
    g.setColor(Color.RED);
    BufferedImage imagePolloRotada = Util.rotarImagen(imagePollo, angulo);
    g.drawImage(imagePolloRotada, (int) x, (int) y, null);
  }

  @Override
  public void move(HashSet<Integer> keys) {
    if (keys.contains(KeyEvent.VK_SPACE) && !espacioPulsado) {
      this.y -= JPollo.SUBIDA;
      if (this.y < 0)
        this.y = 0;
      espacioPulsado = true;
      angulo = 0;
      lastEspacioPulsado = System.currentTimeMillis();

    } else if (!keys.contains(KeyEvent.VK_SPACE)) {
      espacioPulsado = false;
    }

    this.y += this.vy / HiloJuego.FPS;
    if (this.y > JFlappy.GAME_HEIGHT - HEIGHT)
      this.y = JFlappy.GAME_HEIGHT - HEIGHT;

    long msCayendo = System.currentTimeMillis() - lastEspacioPulsado;

    angulo += velocidadRotacion / HiloJuego.FPS;
    if(angulo > 90){
      angulo = 90;
    }

  }

  public Rectangle getRect() {
    return new Rectangle((int) x, (int) y, WIDTH, HEIGHT);
  }

}
