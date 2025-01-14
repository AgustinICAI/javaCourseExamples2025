class Pareja{
  Concursante chico;
  Concursante chica;
  int tiempoRelacion;//meses

  Pareja(Concursante chico, Concursante chica, int tiempoRelacion){
    this.chico = chico;
    this.chica = chica;
    this.tiempoRelacion = tiempoRelacion;
  }
  void setChico(Concursante chico){
    this.chico = chico;
  }
  void setChica(Concursante chica){
    this.chica = chica;
  }
  Concursante getChico(){
    return chico;
  }
  Concursante getChica(){
    return chica;
  }
  public String toString(){
    return "[CHICO -> " + chico.toString() + 
           "\nCHICA -> " + chica.toString() + 
           "\nTIEMPO RELACION -> " + tiempoRelacion+ "]";
  }



}