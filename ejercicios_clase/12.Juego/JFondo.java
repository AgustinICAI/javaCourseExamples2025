import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class JFondo extends JPanel {
  Image fondo;
  private JFlappy jFlappy;

  public JFondo(JFlappy jFlappy) {
    super();
    this.jFlappy = jFlappy;
    loadFondo();
  }


  private void loadFondo() {
    try {
      BufferedImage fondoOriginal = ImageIO.read(new File("fondo.png"));
      
      fondo = fondoOriginal.getScaledInstance(JFlappy.GAME_WIDTH,JFlappy.GAME_HEIGHT, Image.SCALE_SMOOTH);
      
      this.setPreferredSize(new Dimension(JFlappy.GAME_WIDTH, JFlappy.GAME_HEIGHT));
      
    } catch (IOException e) {
      System.out.println("No se pudo cargar la imagen");
    }
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(fondo, 0, 0, this);
    jFlappy.getPollo().paint(g);
  }

}
