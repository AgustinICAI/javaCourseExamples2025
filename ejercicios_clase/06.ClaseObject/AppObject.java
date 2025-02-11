class AppObject{

  public static void main (String argv[]){

    Publico i1 = new Publico("Pepe");
    Publico i2 = new Publico("Pepe");

    System.out.println(i1==i2);
    System.out.println(i1.equals(i2));

    System.out.println(i1);
    System.out.println(i2);

    System.out.println(i1.hashCode());
    System.out.println(i2.hashCode());

    int i3 = 5;
    int i4 = 5;
    System.out.println(i3==i4);

    boolean b1;

    byte b2 = -5;



  }
}