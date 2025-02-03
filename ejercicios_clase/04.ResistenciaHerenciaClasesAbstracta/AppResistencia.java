class AppResistencia{

  public static void main(String argv[]){
    Presentador broncano = new Presentador("David Broncano", "3423x",2000000, "izquierda", 0.4 );

    //Empleado e1 = new Empleado("Pepe","4323",40000);
    Productor productor = new Productor("Ricardo Castella","4323",2000000);

    Empleado[] empleados = new Empleado[10];
    empleados[0] = broncano;
    empleados[1] = productor;
    empleados[2] = new Invitado("Cristiano Ronaldo", "xxx", 100000000, "no definida", "futbolista");

    for(Empleado e : empleados){
      if(e!=null){
        System.out.println(e);
        System.out.println(e.pagarNomimaMes() );
        System.out.println(e.recibirRecompensa());

        if( e instanceof Productor){
          /*Productor p = (Productor)e;  
          System.out.println(p.hacerEntrevistaLaboral());
          */
          System.out.println(((Productor)e).hacerEntrevistaLaboral());
          System.out.println(e.pagarNomimaMes());
        }

      }
    }


  }

}