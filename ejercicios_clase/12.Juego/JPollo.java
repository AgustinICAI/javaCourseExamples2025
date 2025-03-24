import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.HashSet;

public class JPollo extends Sprite {
  public JPollo() {
    super(30, 400, 0, 300);
  } 
  
  public void paint(Graphics g) {
    g.setColor(Color.RED);
    g.fillOval((int)x,(int) y, 50,50);
  }

  @Override
  public void move(HashSet<Integer> keys) {
    if (keys.contains(KeyEvent.VK_SPACE))
      this.y -= 100;
    
    this.y += this.vy/HiloJuego.FPS;
  }

}
