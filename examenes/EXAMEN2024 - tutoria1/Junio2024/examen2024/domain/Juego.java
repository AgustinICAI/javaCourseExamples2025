package examen2024.domain;

import examen2024.domain.Bloque;
import examen2024.domain.Pelota;
import examen2024.ui.JPelotaVeloz;
import examen2024.ui.JFondo;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;



public class Juego extends Thread{

  enum Estado {RUNNING, WAITING, EXITING}

  Estado estado;

  long tsInicioEspera; 

  static int NUM_BLOQUES = 5;


  Pelota pelota;
  ArrayList<Bloque> bloques = new ArrayList<>();
  JFondo panelJuego;

  public Juego(JFondo panelJuego){
    pelota = new Pelota();
    for(int i = 0; i < NUM_BLOQUES; i++)
      bloques.add(new Bloque());
    
    this.panelJuego = panelJuego;

    estado = Estado.RUNNING;
  }


  public void paint(Graphics g){
    pelota.pintar(g);
    bloques.forEach(b -> b.pintar(g));
  }

  public void run(){
    while (estado != Estado.EXITING){
        System.out.println(estado);

      if(estado == Estado.RUNNING){
        pelota.updatePosicion();
        bloques.forEach(b -> b.updatePosicion());

        boolean pelotaOut = false;
        if(pelotaOut){
          estado = Estado.WAITING;
          tsInicioEspera = System.currentTimeMillis();
        }

      }else if (estado == Estado.WAITING){
        if( System.currentTimeMillis() - tsInicioEspera > 2000)
          estado = Estado.RUNNING;
      }

      panelJuego.repaint();

      try{
        Thread.sleep(1000 / JFondo.FPS);
      }

      catch (InterruptedException e){
        e.printStackTrace();
      }
    }
  }



}
