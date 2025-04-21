package examen2024.ui;


import examen2024.ui.JFondo;

import javax.swing.*;


public class JPelotaVeloz extends JFrame {

    public static final int GAME_WIDTH = 880;
    public static final int GAME_HEIGHT = 550;

    JPelotaVeloz(){
        super("JPelota");


        //Prop propiedades = Util.LeerFicheroPropiedades();

        JFondo fondo = new JFondo();
        this.add(fondo);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fondo.requestFocus();
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new JPelotaVeloz();
    }

    //EJEMPLO QUE NO ERA DE ESTE EXAMEN
    /*
    public HashMap<String,Integer> LeerFicheroPropiedades(){
        
        HashMap<String,Integer> hm = new HashMap<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(new File("Fichero.txt")));

            String linea;

            while( (linea = br.readLine()) != null ){
                
                if(linea.contains(" = ")){
                    String[] campos = linea.split("=");
                    hm.put(campos[0].trim(), Integer.parseInt(campos[1].trim()));
                }




            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return hm;

    }*/

}