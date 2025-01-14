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
    /*this.peso = peso;
    this.soltero = soltero;*/
  }

  String getIsla(){
    if( soltero == true && sexo.equals("masculino") ||
        soltero == false && sexo.equals("femenino") ){
      return "Villa Playa";
    }
    else{
      return "Villa Montaña";
    }
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
  void setPeso(int _peso){
    peso = _peso;
  }
  void setSoltero(boolean soltero){
    this.soltero = soltero;
  }

  public String toString(){
    return "nombre: " + getNombre() +
           ", altura: " + getAltura() +
           ", peso: " + getPeso() +
           ", soltero: " + isSoltero() +
           ", sexo: " + sexo + 
           ", isla: " + getIsla();
  }


}