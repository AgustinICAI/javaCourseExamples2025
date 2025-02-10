
//La clase Animal es abstracta y no se puede modificar
abstract class Animal {
    String nombre  
    
    
    Animal(String nombre) {
        this.nombre = nombre
    }
    
    void hacerSonido();
    
    void moverse() {
        System.out.print("El animal se está moviendo");
    }
}


class Perro extends Animal {
    
    Perro(String nombre) {
        super() 
    }
    
    void sonido() { 
        System.out.println("El perro ladra")
    }
    
    String moverse() {
        super.moverse()
        System.out.println("meneando la cola");
    }

    void mostrarNombre() {
        return "El nombre del perro es: " + nombre;
    }
    
public class Main {
    public static void main(String[] args) {
        Animal miPerro1 = new Animal("Bobby") 
        Perro miPerro2 = new Perro("Firulais") 
        miPerro1.hacerSonido();
        miPerro2.moverse();
}

/**SALIDA DEL PROGRAMA****************
> javac Perro.java && java Perro
El perro ladra
El animal se está moviendo meneando la cola

**** */