
//La clase Animal es abstracta y no se puede modificar
abstract class Animal {
    String nombre  ;
    
    
    Animal(String nombre) {
        this.nombre = nombre;
    }
    
    abstract void hacerSonido();
    
    void moverse() {
        System.out.print("El animal se está moviendo");
    }
}
