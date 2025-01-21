import java.util.Random;

class AppEjemplo{
  public static void main(String argv[]){
    Util util = new Util();
    util.wait(1);
    System.out.println("HOLA");  
    util.wait(1);
    System.out.println("ADIOS");

    Random r = new Random();
    System.out.println(r.nextInt(100));
    System.out.println(r.nextInt(100));
    System.out.println(r.nextInt(100));
    System.out.println(r.nextInt(100));

  }


}