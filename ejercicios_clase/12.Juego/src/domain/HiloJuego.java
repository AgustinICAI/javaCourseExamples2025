package domain;
import ui.JFlappy;

import java.util.ArrayList;

public class HiloJuego extends Thread {
  JFlappy jFlappy;
  static final int FPS = 60;
  
  JPollo pollo;
  ArrayList<Tuberia> tuberias = new ArrayList<Tuberia>();

  public HiloJuego(JFlappy jFlappy) {
    this.jFlappy = jFlappy;
    this.pollo = new JPollo();
  }

  public ArrayList<Tuberia> getTuberias() {
    return tuberias;
  }

  public void run() {
    long msInicio = System.currentTimeMillis();
    while (jFlappy.getEstadoJuego() == JFlappy.EstadoJuego.ARRANCADO) {
      try {
        generarYContarTuberias(msInicio);
        move();
        hayColision();

        jFlappy.getFondo().repaint();
        Thread.sleep(1000 / FPS);
      } catch (InterruptedException e) {
        System.out.println("Error en el hilo");
      }
    }
  }

  int avanceAnterior = 0;
  int tuberiaPasadas = 0;

  public int getTuberiaPasadas() {
    return tuberiaPasadas;
  }
  private void generarYContarTuberias(long msInicio) {
    long msDesdeInicio = System.currentTimeMillis() - msInicio;
    int avance = (int) (msDesdeInicio % 2000);

    if (avance < avanceAnterior) {
      Tuberia tuberia = new Tuberia();
      tuberias.add(tuberia);
      tuberiaPasadas += 1;
    }
    avanceAnterior = avance;
  }

  private void hayColision() {
/*
    tuberias.forEach(t -> {
      if(t.getRectInferior().intersects(pollo.getRect())) {
        System.out.println("Colision Inferior");
      }
      if(t.getRectSuperior().intersects(pollo.getRect())) {
        System.out.println("Colision Superior");
      }
    });*/

    if(tuberias.stream()
    .filter(t -> t.getRectInferior().intersects(pollo.getRect())
                 || t.getRectSuperior().intersects(pollo.getRect()))
    .count() > 0) {
      System.out.println("Colision");
      jFlappy.setEstadoJuego(JFlappy.EstadoJuego.PERDIDO);
    }
  }

  private void move() {
    pollo.move(jFlappy.getKeys());
    for(Tuberia tuberia : tuberias) {
      tuberia.move(jFlappy.getKeys());
    }
  }

  public JPollo getPollo() {
    return pollo;
  }

}
