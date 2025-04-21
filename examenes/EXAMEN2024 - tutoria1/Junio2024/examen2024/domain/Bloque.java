package examen2024.domain;

import java.awt.Rectangle;
import java.awt.Graphics;
import examen2024.ui.*;


public class Bloque extends Sprite{
  static int WIDTH = 60;
  static int HEIGHT = 30;
  static int VELOCIDAD = 40;
  
  enum Orientacion {VERTICAL, HORIZONTAL};

  Orientacion orientacion;

  public Bloque(){
    this.x = Math.random()*JPelotaVeloz.GAME_WIDTH;
    this.y = Math.random()*JPelotaVeloz.GAME_HEIGHT;

    //RESUELTO USANDO UN ENUM, PERO SERÍA MEJOR HABER USADO HERENCIA, AUNQUE ESTO TAMBIÉN ES UN 10
    if(Math.random() > 0.5 ){
        orientacion = Orientacion.HORIZONTAL;
        this.velocidadX = VELOCIDAD;
        this.velocidadY = 0;  
    }
    else{
        orientacion = Orientacion.VERTICAL;
        this.velocidadX = 0;
        this.velocidadY = VELOCIDAD;
    }
  }


  public void updatePosicion(){
    if(orientacion == Orientacion.HORIZONTAL){
      x += velocidadX / JFondo.FPS;
      if(x >= JPelotaVeloz.GAME_WIDTH || x < 0)
        velocidadX = -velocidadX;
    }
    else{
      y += velocidadY / JFondo.FPS;
      if(y >= JPelotaVeloz.GAME_HEIGHT || y < 0)
        velocidadY = -velocidadY;
    }
  }

  public void reset(){

  }


  public void pintar(Graphics g){
    g.setColor(java.awt.Color.GRAY);
    if(orientacion == Orientacion.HORIZONTAL)
      g.fillRect((int)x,(int)y,WIDTH,HEIGHT);
    else
      g.fillRect((int)x,(int)y,HEIGHT,WIDTH);
  }

  public Rectangle getShape(){
    if(orientacion == Orientacion.HORIZONTAL)
      return new Rectangle((int)x,(int)y,WIDTH,HEIGHT);
    else
      return new Rectangle((int)x,(int)y,HEIGHT,WIDTH);
  }

}