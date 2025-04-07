package domain;

import java.util.HashSet;

public abstract class Sprite {
  double x;
  double y;
  double vx;
  double vy;

  public Sprite(double x, double y, double vx, double vy) {
    this.x = x;
    this.y = y;
    this.vx = vx;
    this.vy = vy;
  }
  public abstract void move(HashSet<Integer> keys) ;
}
