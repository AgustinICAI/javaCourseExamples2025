import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class JCalculadora extends JFrame implements ActionListener {
    public static void main(String[] args) {
        JCalculadora jpv = new JCalculadora();
    }
    
    HashMap<JButton, String> btnLiteral = new HashMap<JButton, String>();
    JTextField txtPantalla;

    public JCalculadora(){
        super("Calculadora");
        initComponents();
        this.setSize(800,800);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void initComponents(){
        // Aquí se inicializan los componentes de la ventana
        txtPantalla = new JTextField();
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
        for (String literal : botones) {
            JButton jButton = new JButton(literal);
            jButton.setFont(fontCalculadora);
            jButton.addActionListener(this);
            btnLiteral.put(jButton, literal);
            pnlBotones.add(jButton);
        }        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jBtnOrigen = (JButton)e.getSource();
        String literal = btnLiteral.get(jBtnOrigen);
        System.out.println(literal);
        if(literal.equals("<-")){
            String texto = txtPantalla.getText();
            if(texto.length()>0)
                txtPantalla.setText(texto.substring(0, texto.length()-1));
        }
        else if(literal.equals("=")){
            txtPantalla.setText(String.valueOf(evaluarExpresion(txtPantalla.getText())));
        }
        else{
            if(literal.equals("X"))
                literal = "*";
            txtPantalla.setText(txtPantalla.getText()+literal);
        }

    }

    public static double evaluarExpresion(String expresion) {
        Expression e = new ExpressionBuilder(expresion).build();
        return e.evaluate();
    }
  
}
