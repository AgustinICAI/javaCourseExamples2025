import java.util.Collection;
import java.util.ArrayList;
import java.util.LinkedList;

public class App{

  public static void main(String argv[]){
    Collection<Concursante> concursantes = new ArrayList<>();
    //LinkedList<Concursante> concursantes = new LinkedList<>();

    Concursante c1 = new Concursante("Montoya", 183, 82, false, "Masculino");
    Concursante c2 = new Concursante("Anita", 168, 58, false, "Femenino");
        
    concursantes.add(c1);
    concursantes.add(c2);
    concursantes.remove(new Concursante("Montoya"));

    //Concursante c3 = concursantes.pop();

    for(Concursante c : concursantes)
      System.out.println(c);



  }




}