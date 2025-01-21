class Concursante{
  String nombre;
  int altura;
  int peso;
  boolean soltero;
  String sexo;
  
  Concursante(String nombre, int altura, int peso, boolean soltero,String sexo){
    this.nombre = nombre;
    this.altura = altura;
    this.sexo = sexo;
    setPeso(peso);
    setSoltero(soltero);
    }

  String getIsla(){
    if( soltero == true && sexo.equals("masculino") ||
        soltero == false && sexo.equals("femenino") )
      return "Villa Playa";
    else
      return "Villa Montaña";
    
  }

  String getNombre(){
    return nombre;
  }

  int getAltura(){
    return altura;
  }
  int getPeso(){
    return peso;
  }
  boolean isSoltero(){
    return soltero;
  }
  void setPeso(int peso){
    this.peso = peso;
  }
  void setSoltero(boolean soltero){
    this.soltero = soltero;
  }

  public String toString(){
    String estado = "En pareja";
    if(isSoltero())
      estado = "Soltero";

    return "nombre: " + getNombre() +
           ", altura: " + getAltura() +
           ", peso: " + getPeso() +
           ", estado: " + estado +
           ", sexo: " + sexo + 
           ", isla: " + getIsla();
  }


}