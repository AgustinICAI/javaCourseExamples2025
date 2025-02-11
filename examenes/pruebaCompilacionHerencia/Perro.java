class Perro extends Animal {
    
    Perro(String nombre) {
        super(nombre) ;
    }
    @Override 
    void hacerSonido() { 
        System.out.println("El perro ladra");
    }
    
    void moverse() {
        super.moverse();
        System.out.println(" meneando la cola");
    }

    String mostrarNombre() {
        return "El nombre del perro es: " + nombre;
    }
    
    public static void main(String[] args) {
        Animal miPerro1 = new Perro("Bobby");
        Perro miPerro2 = new Perro("Firulais"); 
        miPerro1.hacerSonido();
        miPerro2.moverse();
    }
}

/**SALIDA DEL PROGRAMA****************
> javac Perro.java && java Perro
El perro ladra
El animal se está moviendo meneando la cola

**** */