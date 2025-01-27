class Concursante{
  String nombre;
  int altura;
  int peso;
  boolean soltero;
  //Concursante pareja;POSIBLE MEJORA
  String sexo;
  Relacion[] relaciones;
  int numRelaciones;
  
  Concursante(String nombre, int altura, int peso, boolean soltero,String sexo){
    this.nombre = nombre;
    this.altura = altura;
    this.sexo = sexo;
    this.relaciones = new Relacion[10];
    numRelaciones = 0;
    setPeso(peso);
    setSoltero(soltero);
    }

  void anadirRelacion(Relacion r){
    this.relaciones[numRelaciones] = r;
    numRelaciones += 1;
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
  String getSexo(){
    return sexo;
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
    String cadRelaciones = "[";
    for (Relacion r : relaciones)
      if(r!=null)
        cadRelaciones += r +",";
    cadRelaciones += "]";

    return "nombre: " + getNombre() +
           ", altura: " + getAltura() +
           ", peso: " + getPeso() +
           ", estado: " + estado +
           ", sexo: " + sexo + 
           ", isla: " + getIsla() + 
           ", relaciones: " + cadRelaciones;
  }


}