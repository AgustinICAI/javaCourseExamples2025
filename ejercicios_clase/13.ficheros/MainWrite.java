import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainWrite {
  public static void main(String[] args) {
    // Escribir en un fichero
    try {
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("fichero.txt"))));
      pw.println("Hola");
      pw.println("Adios");
      pw.println("Hasta luego");
      pw.println("Hasta la vista");
      pw.println("Hasta la proxima");
      pw.println("Hasta la vista, baby");

      pw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
