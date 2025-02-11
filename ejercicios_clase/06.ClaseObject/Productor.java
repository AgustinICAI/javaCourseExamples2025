class Productor extends Empleado implements Opinable{
  String[] objetivos;

  Productor(String nombre, String nif, double retribucionBase){
    super(nombre, nif, retribucionBase);
    objetivos = new String [10];
  }

  public String darOpinion(){
    return "Mi opinión tiene que ser moderada";
  }

  String pagarNomimaMes(){
    return "Pagada nómina mes en curso: " + String.format("%.2f",retribucionBase / NUM_PAGAS * Math.random());
  }
  
  String recibirRecompensa(){
    return "Cumplir los objetivos y que no me quiten nomina";
  }

  String hacerEntrevistaLaboral(){
    return "Haciendo entrevista laboral";
  }

}