class PersonajePublico extends Empleado{
  String tipoTraje;
  String afinidadPolitica;

  PersonajePublico(String nombre, String nif, double retribucionBase, String afinidadPolitica){
    super(nombre, nif, retribucionBase);
    this.afinidadPolitica = afinidadPolitica;
  }
  void setTraje (String tipoTraje){
    this.tipoTraje = tipoTraje;
  }

  
}