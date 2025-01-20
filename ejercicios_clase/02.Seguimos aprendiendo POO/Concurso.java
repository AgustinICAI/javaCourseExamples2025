class Concurso{
  Concursante[] concursantes;
  Pareja[] parejas;
  String edicion;
  int posLibrePareja;
  int posLibreConcursante;
  int NUMCONCURSANTES = 26;
  int NUMPAREJAS = 5;

  Concurso(String edicion){
    this.edicion = edicion;
    this.posLibrePareja = 0;
    this.posLibreConcursante = 0;
    //Inicialización arrays
    concursantes = new Concursante[NUMCONCURSANTES];
    parejas = new Pareja[NUMPAREJAS];
  }

  Concurso(String edicion, Concursante[] concursantes, Pareja[] parejas){
    this.edicion = edicion;
    this.parejas = parejas;
    this.concursantes = concursantes;
  }

  boolean addPareja(Pareja pareja){
    if(posLibrePareja < NUMPAREJAS){
      parejas[posLibrePareja] = pareja;
      posLibrePareja = posLibrePareja + 1;
      //addConcursante(pareja.getChico());
      //addConcursante(pareja.getChica());

      Concursante[] cs = pareja.getConcursantes();
      addConcursantes(cs);

      return true;
    }
    else return false;
  }

  boolean addConcursante(Concursante concursante){
    if(posLibreConcursante < NUMCONCURSANTES){
      concursantes[posLibreConcursante] = concursante;
      posLibreConcursante += 1;
      return true;
    }
    else return false;
  }

  boolean addConcursantes(Concursante[] concursantes){
    boolean insertados = true;
    for(int i = 0; i < concursantes.length; i++){
      boolean insertado = addConcursante(concursantes[i]);
      if(insertado == false)
        insertados = false;
    }
    return false;
  }

//Ejemplo add con bucle while y for
  void addParejaConBucle(Pareja pareja){
    int posLibrePareja = 0;
    
    while(parejas[posLibrePareja] != null)
      posLibrePareja = posLibrePareja + 1;
    parejas[posLibrePareja] = pareja;

    boolean insertado = false;
    for(int i = 0; i < parejas.length && !insertado ; i = i + 1){
      if(parejas[i] == null && insertado == false){
        parejas[i] = pareja;
        insertado = true;
      }
    }
  }


  





}