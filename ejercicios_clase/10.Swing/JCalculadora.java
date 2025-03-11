import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JCalculadora extends JFrame{
    public static void main(String[] args) {
        JCalculadora jpv = new JCalculadora();
    }
    
    public JCalculadora(){
        super("Calculadora");
        initComponents();
        this.setSize(800,800);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void initComponents(){
        // Aquí se inicializan los componentes de la ventana
        JTextField txtPantalla = new JTextField();
        Font fontCalculadora = new Font(Font.SANS_SERIF, Font.BOLD, 30);
        txtPantalla.setFont(fontCalculadora);
        txtPantalla.setHorizontalAlignment(JTextField.RIGHT);
        this.add(txtPantalla, BorderLayout.NORTH);

        JPanel pnlBotones = new JPanel();
        pnlBotones.setLayout(new GridLayout(6,4));
        this.add(pnlBotones, BorderLayout.CENTER);

        String[] botones = {"%","CE","C","<-",
                            "1/x","x2","2rx","/",
                            "7","8","9","X",
                            "4","5","6","-",
                            "1","2","3","+",
                            "+-","0",".","="};
        for (String boton : botones) {
            JButton btn = new JButton(boton);
            btn.setFont(fontCalculadora);
            pnlBotones.add(btn);
        }        
    }
  
}
