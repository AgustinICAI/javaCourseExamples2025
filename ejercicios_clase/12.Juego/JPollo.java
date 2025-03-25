import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import javax.imageio.ImageIO;

public class JPollo extends Sprite {
  boolean espacioPulsado = false;
  long lastEspacioPulsado = 0;
  static int WIDTH = 100;
  static int HEIGHT = 50;
  BufferedImage imagePollo;
  BufferedImage imagePolloRotada;

  public JPollo() {
    super(30, 400, 0, 300);

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
    g.drawImage(imagePolloRotada, (int) x, (int) y, null);
  }

  @Override
  public void move(HashSet<Integer> keys) {
    if (keys.contains(KeyEvent.VK_SPACE) && !espacioPulsado) {
      this.y -= 100;
      if (this.y < 0)
        this.y = 0;
      espacioPulsado = true;
      lastEspacioPulsado = System.currentTimeMillis();

    } else if (!keys.contains(KeyEvent.VK_SPACE)) {
      espacioPulsado = false;
    }

    this.y += this.vy / HiloJuego.FPS;
    if (this.y > JFlappy.GAME_HEIGHT - HEIGHT)
      this.y = JFlappy.GAME_HEIGHT - HEIGHT;

    long msCayendo = System.currentTimeMillis() - lastEspacioPulsado;

    if (msCayendo > 1000) {
      imagePolloRotada = Util.rotarImagen(imagePollo, Math.toRadians(90));
    }
  }

}
