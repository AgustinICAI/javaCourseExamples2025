public class App{
  public static void main(String argv[]){
    /*
    int a = 65 → Integer → float →char → String → devolver el primer carácter en
    mayúsculas como char → int → byte*/
    int a = 65; 
    Integer a1 = a; //Integer a1 = new Integer(a); ###AUTOBOXING
    float f = a1;  //a1.floatValue();
    char c = (char) f;
    //Opción 1: a partir del wrapper
    Character c1 = c;
    String s1 = c1.toString();
    //Opción 2: pasando a un array de char
    char[] cs = {c};
    String s2 = new String(cs); 
    //Opción 3: usando valueOf
    String s3 = String.valueOf(c);
    
    //Opción 1
    char c2 = s1.toUpperCase().charAt(0);
    //Opción 2
    char c3 = Character.toUpperCase(s1.charAt(0));

    int i = c3;

    byte b = (byte) i;
    System.out.println(b);


  }

}