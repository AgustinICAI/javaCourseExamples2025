public class HiloJuego extends Thread {
  JFlappy jFlappy;
  static final int FPS = 60;

  JPollo pollo;


  public HiloJuego(JFlappy jFlappy) {
    this.jFlappy = jFlappy;
    this.pollo = new JPollo();

  }

  public void run() {
    while (true) {
      try {

        pollo.move(jFlappy.getKeys());
        
        jFlappy.getFondo().repaint();
        Thread.sleep(1000 / FPS);
      } catch (InterruptedException e) {
        System.out.println("Error en el hilo");
      }
    }
  }

  public JPollo getPollo() {
    return pollo;
  }

}
