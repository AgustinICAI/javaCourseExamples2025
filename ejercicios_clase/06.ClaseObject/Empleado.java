abstract class Empleado{
  String nombre;
  String nif;
  double retribucionBase;
  int NUM_PAGAS=14;
  int numEmpleado;
  static int INCREMENTAL_EMPLEADO=0;
  
  Empleado(String nombre, String nif, double retribucionBase){
    this.nombre = nombre;
    this.nif = nif;
    numEmpleado = INCREMENTAL_EMPLEADO;
    INCREMENTAL_EMPLEADO += 1;
    this.retribucionBase = retribucionBase;
  }

  String pagarNomimaMes(){
    return "Pagada nómina mes en curso: " + String.format("%.2f",retribucionBase / NUM_PAGAS);
  }

  abstract String recibirRecompensa();
  
  public String toString(){
    return "nombre: " + nombre + ", num. Empleado: " + numEmpleado;
  }

}