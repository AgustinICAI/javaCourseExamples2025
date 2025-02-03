class Presentador extends PersonajePublico{
  double conocimientoIngles;

  Presentador(String nombre, String nif, double retribucionBase, String afinidadPolitica, double conocimientoIngles){
    super(nombre, nif, retribucionBase, afinidadPolitica);
    this.conocimientoIngles = conocimientoIngles;
  }

  
}