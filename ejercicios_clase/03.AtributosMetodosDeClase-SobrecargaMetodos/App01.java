class App01 {
    
  static Concurso concurso;

  public static void main (String[] argv){
    //Concurso concurso = init();
    init();
    System.out.println(concurso);
    concurso.simularSemana();
    System.out.println(concurso);

  }

  static void init(){
    Concursante[] solteros = new Concursante[16];
    // Creación y asignación de los objetos en cada posición del array
    solteros[0] = new Concursante("Kevin", 178, 75, true, "masculino");
    solteros[1] = new Concursante("Jesús", 180, 78, true, "masculino");
    solteros[2] = new Concursante("David", 176, 80, true, "masculino");
    solteros[3] = new Concursante("Agus", 182, 77, true, "masculino");
    solteros[4] = new Concursante("Guille", 179, 74, true, "masculino");
    solteros[5] = new Concursante("Fran", 183, 82, true, "masculino");
    solteros[6] = new Concursante("Gerard", 181, 79, true, "masculino");
    solteros[7] = new Concursante("Borja", 177, 76, true, "masculino");
    solteros[8] = new Concursante("Claudia Sánchez", 165, 55, true, "femenino");
    solteros[9] = new Concursante("Nataly Núñez", 168, 58, true, "femenino");
    solteros[10] = new Concursante("Érika Portillo Herrera", 163, 53, true, "femenino");
    solteros[11] = new Concursante("Mayeli Díaz", 166, 56, true, "femenino");
    solteros[12] = new Concursante("Paula Cámara", 167, 57, true, "femenino");
    solteros[13] = new Concursante("Paloma Suárez", 164, 54, true, "femenino");
    solteros[14] = new Concursante("Raquel Castro", 170, 60, true, "femenino");
    solteros[15] = new Concursante("Sofía Lu Lee", 162, 52, true, "femenino");
        
    // Declaración del array de parejas
    Pareja[] parejas = new Pareja[5];

    // Creación y asignación de cada pareja en el array
    Concursante c1 = new Concursante("Eros", 180, 78, false, "Masculino");
    Concursante c2 = new Concursante("Bayan", 165, 55, false, "Femenino");
    parejas[0] = new Pareja(c1, c2, 4);

    parejas[1] = new Pareja(
        new Concursante("Gerard", 181, 79, false, "Masculino"),
        new Concursante("Alba", 167, 57, false, "Femenino"),
        1
    );

    parejas[2] = new Pareja(
        new Concursante("Montoya", 183, 82, false, "Masculino"),
        new Concursante("Anita", 168, 58, false, "Femenino"),
        1
    );

    parejas[3] = new Pareja(
        new Concursante("Joel", 175, 70, false, "Masculino"),
        new Concursante("Andrea", 170, 60, false, "Femenino"),
        3
    );

    parejas[4] = new Pareja(
        new Concursante("Fran", 178, 76, false, "Masculino"),
        new Concursante("Ana", 166, 56, false, "Femenino"),
        1
    );

    concurso = new Concurso("2025",solteros, parejas);

  }


}