import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

public class AppSet{

  static Collection<Concursante> solteros;
  static Collection<Pareja> parejas;

  public static void main (String argv[]){

    init();
    //System.out.println(solteros);
    //System.out.println(parejas);
    for(Concursante s: solteros)
      System.out.println(s.getNombre());

    TreeSet<Concursante> tsSolteros = (TreeSet<Concursante>)solteros;
    for(Concursante s: tsSolteros.descendingSet())
      System.out.println(s.getNombre());
    
    System.out.println(tsSolteros.subSet(new Concursante("Fran"),new Concursante("Jesús")));
    

    for(Pareja p: parejas)
      System.out.println(p.getTiempoRelacion() + "---" + p.getChica().getNombre() + " -- " + p.getChico().getNombre());
  }

  static void init(){
    solteros = new TreeSet<>();
    
    // Creación y asignación de los objetos en cada posición del array
    solteros.add(new Concursante("Kevin", 178, 75, true, "masculino"));
    solteros.add(new Concursante("Jesús", 180, 78, true, "masculino"));
    solteros.add(new Concursante("David", 176, 80, true, "masculino"));
    solteros.add(new Concursante("Agus", 182, 77, true, "masculino"));
    solteros.add(new Concursante("Guille", 179, 74, true, "masculino"));
    solteros.add(new Concursante("Fran", 183, 82, true, "masculino"));
    solteros.add(new Concursante("Gerard", 181, 79, true, "masculino"));
    solteros.add(new Concursante("Borja", 177, 76, true, "masculino"));
    solteros.add(new Concursante("Claudia Sánchez", 165, 55, true, "femenino"));
    solteros.add(new Concursante("Nataly Núñez", 168, 58, true, "femenino"));
    solteros.add(new Concursante("Érika Portillo Herrera", 163, 53, true, "femenino"));
    solteros.add(new Concursante("Mayeli Díaz", 166, 56, true, "femenino"));
    solteros.add(new Concursante("Paula Cámara", 167, 57, true, "femenino"));
    solteros.add(new Concursante("Paloma Suárez", 164, 54, true, "femenino"));
    solteros.add(new Concursante("Raquel Castro", 170, 60, true, "femenino"));
    solteros.add(new Concursante("Sofía Lu Lee", 162, 52, true, "femenino"));
        
    parejas = new TreeSet<>();

    // Creación y asignación de cada pareja en el array
    Concursante c1 = new Concursante("Eros", 180, 78, false, "Masculino");
    Concursante c2 = new Concursante("Bayan", 165, 55, false, "Femenino");
    parejas.add(new Pareja(c1, c2, 4));

    parejas.add(new Pareja(
        new Concursante("Gerard", 181, 79, false, "Masculino"),
        new Concursante("Alba", 167, 57, false, "Femenino"),
        1
    ));
    parejas.add(new Pareja(
        new Concursante("Montoya", 183, 82, false, "Masculino"),
        new Concursante("Anita", 168, 58, false, "Femenino"),
        1
    ));
    parejas.add(new Pareja(
        new Concursante("Montoya", 183, 82, false, "Masculino"),
        new Concursante("Anita", 168, 58, false, "Femenino"),
        1
    ));

    parejas.add(new Pareja(
        new Concursante("Joel", 175, 70, false, "Masculino"),
        new Concursante("Andrea", 170, 60, false, "Femenino"),
        3
    ));

    parejas.add(new Pareja(
        new Concursante("Fran", 178, 76, false, "Masculino"),
        new Concursante("Ana", 166, 56, false, "Femenino"),
        1
    ));
  }

}