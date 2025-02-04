class AppResistencia{

  public static void main(String argv[]){

    Empleado cr7 = new Invitado("Cristiano Ronaldo", "xxx", 100000000, "no definida", "futbolista");
    Publico pepe = new Publico("Pepe");

    Entrevistable[] entrevistados = {(Invitado)cr7, pepe};
    
    for(Entrevistable e : entrevistados){
      System.out.println(e.bailar("Esa Diva"));
    }

    Object[] entrevistados2 = {(Invitado)cr7, pepe};

    for(Object o : entrevistados2){
      if(o instanceof Entrevistable){
        Entrevistable e = (Entrevistable)o;
        System.out.println(e.bailar("Esa Diva"));
      }
    }
      
  }

}