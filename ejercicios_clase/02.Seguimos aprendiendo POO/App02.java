class App02 {
  public static void main (String[] argv){

    // Creación de los objetos Concursante
    Concursante kevin = new Concursante("Kevin", 178, 75, true, "masculino");
    Concursante jesus = new Concursante("Jesús", 180, 78, true, "masculino");
    Concursante david = new Concursante("David", 176, 80, true, "masculino");
    Concursante agus = new Concursante("Agus", 182, 77, true, "masculino");
    Concursante guille = new Concursante("Guille", 179, 74, true, "masculino");
    Concursante fran = new Concursante("Fran", 183, 82, true, "masculino");
    Concursante gerard = new Concursante("Gerard", 181, 79, true, "masculino");
    Concursante borja = new Concursante("Borja", 177, 76, true, "masculino");

    Concursante claudia = new Concursante("Claudia Sánchez", 165, 55, true, "femenino");
    Concursante nataly = new Concursante("Nataly Núñez", 168, 58, true, "femenino");
    Concursante erika = new Concursante("Érika Portillo Herrera", 163, 53, true, "femenino");
    Concursante mayeli = new Concursante("Mayeli Díaz", 166, 56, true, "femenino");
    Concursante paula = new Concursante("Paula Cámara", 167, 57, true, "femenino");
    Concursante paloma = new Concursante("Paloma Suárez", 164, 54, true, "femenino");
    Concursante raquel = new Concursante("Raquel Castro", 170, 60, true, "femenino");
    Concursante sofia = new Concursante("Sofía Lu Lee", 162, 52, true, "femenino");

    // Almacenamiento en un array
    Concursante[] solteros = {
        kevin, jesus, david, agus, guille, fran, gerard, borja,
        claudia, nataly, erika, mayeli, paula, paloma, raquel, sofia
    };
    



  }


}