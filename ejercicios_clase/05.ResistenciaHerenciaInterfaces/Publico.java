class Publico implements Entrevistable{
  String nombre;
  Publico (String nombre){
    this.nombre = nombre;
  }

  public String darJuego(){
    return "soy un super personaje del publico";
  }
  public String bailar(String cancion){
    return "no se bailar pero bailo esta cancion " + cancion; 
  }
  

}