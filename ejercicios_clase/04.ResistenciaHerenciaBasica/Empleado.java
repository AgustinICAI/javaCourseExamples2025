import java.util.Random;
class Empleado{
  String nombre;
  String nif;
  double retribucionBase;
  int NUM_PAGAS=14;
  int numEmpleado;
  static int INCREMENTAL_EMPLEADO=0;
  
  Empleado(String nombre, String nif, double retribucionBase){
    this.nombre = nombre;
    this.nif = nif;
    Random r = new Random();
    numEmpleado = INCREMENTAL_EMPLEADO;
    INCREMENTAL_EMPLEADO += 1;
    this.retribucionBase = retribucionBase;
  }

  String pagarNomimaMes(){
    return retribucionBase / NUM_PAGAS;
  }
  



}