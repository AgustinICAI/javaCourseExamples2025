package examen2024.domain;

import java.awt.Rectangle;
import java.awt.Graphics;


public class Pelota extends Sprite{

  static int SIZE = 30;
  static int X_INICIAL = 50;
  static int Y_INICIAL = 450;
  static int ACELERACION_X = 20;
  static int ACELERACION_Y = 20;
  static int DESACELERACION = 40;


  public Pelota(){
    super(X_INICIAL, Y_INICIAL, 0, 0);
  }

  public void updatePosicion(){
    x+= velocidadX;
    y+= velocidadY;
  }

  public void reset(){
    x = X_INICIAL;
    y = Y_INICIAL;
  }


  public void pintar(Graphics g){
    g.setColor(java.awt.Color.RED);
    g.fillOval((int)x,(int)y,SIZE,SIZE);

  }


  public Rectangle getShape(){
    return new Rectangle((int)x,(int)y,SIZE,SIZE);
  }


}