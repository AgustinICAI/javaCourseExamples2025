class Presentador extends PersonajePublico{
  String trabajo;

  Invitado(String nombre, String nif, double retribucionBase, String afinidadPolitica, String trabajo){
    super(nombre, nif, retribucionBase, afinidadPolitica);
    this.trabajo = trabajo;
  }

  
}