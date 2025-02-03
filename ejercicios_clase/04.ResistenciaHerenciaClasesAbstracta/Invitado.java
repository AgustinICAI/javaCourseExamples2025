class Invitado extends PersonajePublico{
  String trabajo;

  Invitado(String nombre, String nif, double retribucionBase, String afinidadPolitica, String trabajo){
    super(nombre, nif, retribucionBase, afinidadPolitica);
    this.trabajo = trabajo;
  }

  String recibirRecompensa(){
    return "Haber tenido una buena audiencia";
  }

  
}