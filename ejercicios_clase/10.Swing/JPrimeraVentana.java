import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

public class JPrimeraVentana extends JFrame{
    public static void main(String[] args) {
        JPrimeraVentana jpv = new JPrimeraVentana();
    }


    public JPrimeraVentana(){
        super("Mi primera ventana");
        initComponents();
        this.setSize(800,800);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void initComponents(){
        // Aquí se inicializan los componentes de la ventana
        //JButton btnCentro = new JButton("CENTRO");
        JPanel pnlCentro = new JPanel();
        pnlCentro.add(new JButton("Botón 1"));
        pnlCentro.add(new JButton("Botón 2"));
        pnlCentro.add(new JButton("Botón 3"));
        pnlCentro.add(new JButton("Botón 4"));
        
        JButton btnNorte = new JButton("NORTE");
        JButton btnSur = new JButton("SUR");
        JButton btnEste = new JButton("ESTE");
        JButton btnOeste = new JButton("OESTE");

        this.add(btnNorte, BorderLayout.NORTH);
        this.add(btnSur, BorderLayout.SOUTH);
        this.add(btnEste, BorderLayout.EAST);   
        this.add(btnOeste, BorderLayout.WEST);
        this.add(pnlCentro/*, BorderLayout.CENTER*/);

    }


}