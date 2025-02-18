class Pareja implements Comparable{
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
  int getTiempoRelacion(){
    return tiempoRelacion;
  }
  Concursante getChico(){
    return chico;
  }
  Concursante getChica(){
    return chica;
  }

  Concursante[] getConcursantes(){
    Concursante[] cs = new Concursante[2];
    cs[0] = getChica();
    cs[1] = getChico();
    return cs;

  }

  public String toString(){
    return "[CHICO -> " + chico.toString() + 
           "\nCHICA -> " + chica.toString() + 
           "\nTIEMPO RELACION -> " + tiempoRelacion+ "]";
  }

  public boolean equals(Object o){
    if(o instanceof Pareja){
      Pareja p = (Pareja)o;
      return this.getChico().equals(p.getChico()) &&
             this.getChica().equals(p.getChica());
    }
    else return false;
  }
  public int hashCode(){
    return this.getChica().hashCode() + this.getChico().hashCode();
  }
  public int compareTo(Object o){
    if(o instanceof Pareja){
      Pareja p = (Pareja)o;
      if(tiempoRelacion > p.getTiempoRelacion())
        return 1;
      else if (tiempoRelacion < p.getTiempoRelacion())
        return -1;
      else
        return chica.compareTo(p.getChica());
    }
    else return -1;

  }
}