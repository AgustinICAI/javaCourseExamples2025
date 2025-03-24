import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Image;
import java.awt.Dimension;
import java.awt.Graphics;

public class JFondo extends JPanel {
  Image fondo;
  private JFlappy jFlappy;

  public JFondo(JFlappy jFlappy) {
    super();
    this.jFlappy = jFlappy;
    fondo = loadFondo();
      }
    
      private Image loadFondo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadFondo'");
      }
    
      public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(fondo, 0, 0, this);
    jFlappy.getPollo().paint(g);
  }

}
