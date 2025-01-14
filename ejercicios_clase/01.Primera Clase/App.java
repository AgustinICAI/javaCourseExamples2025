class App {
  public static void main (String[] argv){
    System.out.println("Hola mundo");
    System.out.println("Estoy jugando a la isla de las tentaciones");

    Concursante c1 = new Concursante("Pepe",170,60,false,"masculino");
    Concursante c2 = new Concursante("Maria",160,55,true,"femenino");
    Concursante c3 = new Concursante("Juan",175,80,true,"masculino");
    Concursante c4 = new Concursante("Juana",180,70,false,"femenino");
    Concursante c5 = c1;
    //System.out.println(c1.getNombre());
    //System.out.println("altura: " + c1.getAltura() + ", peso: " + c1.getPeso());

    System.out.println(c1.toString());
    System.out.println(c2.toString());
    System.out.println(c3.toString());
    System.out.println(c4.toString());

    Pareja p1 = new Pareja(c1, c4, 10);
    System.out.println(p1.toString());

  }


}