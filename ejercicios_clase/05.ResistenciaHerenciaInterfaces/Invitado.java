class Invitado extends PersonajePublico implements Opinable, Entrevistable {
  String trabajo;

  Invitado(String nombre, String nif, double retribucionBase, String afinidadPolitica, String trabajo){
    super(nombre, nif, retribucionBase, afinidadPolitica);
    this.trabajo = trabajo;
  }

  public String darOpinion(){
    return "Estoy doy dando mi opinion";
  }

  public String darJuego(){
    return "estoy siendo un cachondo";
  }
  public String bailar(String cancion){
    return "Bailando la cancion " + cancion;
  }

  String recibirRecompensa(){
    return "Haber tenido una buena audiencia";
  }

  
}