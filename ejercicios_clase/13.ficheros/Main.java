import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {
  public static void main (String[] args) {
    try{
      BufferedReader br = new BufferedReader(new FileReader(new File ("fichero.txt")));

      String linea; 
      while ((linea = br.readLine()) != null) {
        System.out.println(linea);
      }
      br.close();
      
    } catch (FileNotFoundException e) {
      System.out.println("Error: NO ENCUENTRO EL FICHERO");
    } catch (IOException e) {
      e.printStackTrace();
    }

    




    // Extensiones de ficheros de texto famosas
    // .txt
    // .csv
    // .xml
    // .json
    // .html
    // .java
    // .yaml




  }
}
