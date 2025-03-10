import java.util.Collection;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

public class App{

  public static void main(String argv[]){

    Concursante c1 = new Concursante("Montoya", 183, 82, false, "Masculino");
    Concursante c2 = new Concursante("Anita", 168, 58, false, "Femenino");
    Concursante c3 = new Concursante("Pepe", 183, 82, false, "Masculino");
    Concursante c4 = new Concursante("Pepa", 168, 58, false, "Femenino");

    Map<Concursante,Concursante> parejas = new HashMap<>();
    parejas.put(c1,c2);
    parejas.put(c3,c4);
    System.out.println("Usando EntrySet");
    for(Map.Entry<Concursante,Concursante> pareja : parejas.entrySet())
      System.out.println(pareja.getKey() + " " + pareja.getValue());
    
    System.out.println("Usando KeySet");
    for(Concursante c : parejas.keySet())
      System.out.println(c + " " + parejas.get(c));

    System.out.println("Usando forEach con lambda");
    parejas.forEach((k,v) -> System.out.println(k + " " + v));
    

    HashMap<Concursante,ArrayList<Concursante>> relaciones = new HashMap<>();

    relaciones.put(c1,new ArrayList<Concursante>());
    relaciones.put(c2,new ArrayList<Concursante>());
    relaciones.put(c3,new ArrayList<Concursante>());
    relaciones.put(c4,new ArrayList<Concursante>());

    relaciones.get(c1).add(c2);
    relaciones.get(c1).add(c3);
    relaciones.get(c1).add(c4);

    relaciones.get(c2).add(c1);
    relaciones.get(c3).add(c1);
    relaciones.get(c4).add(c1);

    System.out.println("Usando Map con EntrySet dentro");
    relaciones.forEach((c,relacionados) -> {
      System.out.println(c + " esta relacionado con:");
      relacionados.forEach(relacionado -> System.out.println(relacionado));
    });






  }




}