package examen2024.ui;

import examen2024.domain.Juego;
import examen2024.ui.JPelotaVeloz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;

public class JFondo extends JPanel {
    public static final int FPS = 30;
    HashSet<Integer> teclasPulsadas;
    Juego juego;
    public JFondo(){
        super();
        this.juego = new Juego(this);
        /**CODIGO A INTRODUCIR AQUÍ*/

        this.setPreferredSize(new Dimension(JPelotaVeloz.GAME_WIDTH, JPelotaVeloz.GAME_HEIGHT) );


        juego.start();

        JFondo.addKeyListener(new KeyAdapter{
          new Key
        });
        this.requestFocus();


        /*****/
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        juego.paint(g);
    }


}
