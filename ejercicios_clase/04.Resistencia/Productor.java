class Productor extends Empleado{
  String[] objetivos;

  Productor(String nombre, String nif, double retribucionBase){
    super(nombre, nif, retribucionBase);
    objetivos = new String [10];
  }
  
}