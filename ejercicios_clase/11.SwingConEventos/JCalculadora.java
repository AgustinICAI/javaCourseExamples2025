import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class JCalculadora extends JFrame implements ActionListener, KeyListener, WindowListener {
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
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(this);
    }
    void initComponents(){
        // Aquí se inicializan los componentes de la ventana
        txtPantalla = new JTextField();
        Font fontCalculadora = new Font(Font.SANS_SERIF, Font.BOLD, 30);
        txtPantalla.setFont(fontCalculadora);
        txtPantalla.setHorizontalAlignment(JTextField.RIGHT);
        txtPantalla.addKeyListener(this);
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
            calculaResultado();
        }
        else{
            if(literal.equals("X"))
                literal = "*";
            txtPantalla.setText(txtPantalla.getText()+literal);
        }
        txtPantalla.requestFocus();
    }

    
    void calculaResultado(){
        DecimalFormat df = new DecimalFormat("0.##");

        txtPantalla.setText(df.format(evaluarExpresion(txtPantalla.getText())));
    }

    public static double evaluarExpresion(String expresion) {
        Expression e = new ExpressionBuilder(expresion).build();
        return e.evaluate();
    }
    @Override
    public void keyTyped(KeyEvent e) {
        if("0987654321+*/-".indexOf(e.getKeyChar()) == -1){
            e.consume();
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            calculaResultado();
        }
    }
    @Override
    public void windowOpened(WindowEvent e) {

    }
    @Override
    public void windowClosing(WindowEvent e) {
        //Libera recursos de la ventana y cierra la aplicación
        this.dispose();
        System.exit(0);
    }
    @Override
    public void windowClosed(WindowEvent e) {

    }
    @Override
    public void windowIconified(WindowEvent e) {
    }
    @Override
    public void windowDeiconified(WindowEvent e) {
    }
    @Override
    public void windowActivated(WindowEvent e) {
    }
    @Override
    public void windowDeactivated(WindowEvent e) {
}


    
  
}
