class Publico implements Entrevistable{
  String nombre;
  Publico (String nombre){
    this.nombre = nombre;
  }
  String getNombre(){
    return nombre;
  }
  public String darJuego(){
    return "soy un super personaje del publico";
  }
  public String bailar(String cancion){
    return "no se bailar pero bailo esta cancion " + cancion; 
  }

  @Override
  public boolean equals(Object o){
    if(o instanceof Publico){
      Publico p1 = (Publico)o;
      return this.nombre.equals(p1.getNombre());
    }
    else return false;
  }

  @Override
  public int hashCode(){
      return nombre.hashCode();
  }  

  public String toString(){
    return "Personaje publico " + this.getNombre();
  }
  

}