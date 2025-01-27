import java.util.Random;

class Relacion{
  Concursante concursante;
  String tipoRelacion;

  Relacion(Concursante concursante, String tipoRelacion){
    this.concursante = concursante;
    this.tipoRelacion = tipoRelacion;
  }

  public String toString(){
    return concursante.getNombre() + "->"+ tipoRelacion;
  }

  static String generateRelacionAleatoria(){
    Random r = new Random();
    int probabilidad = r.nextInt(3);
    if(probabilidad == 0)
      return "beso";
    else if(probabilidad == 1)
      return "beso apasionado";
    else
      return "coito";
  }


}