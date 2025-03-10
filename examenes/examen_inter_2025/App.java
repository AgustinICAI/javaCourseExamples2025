/*METED LOS IMPORTS QUE SE CONSIDEREIS*/

import java.util.Collection;
import java.util.TreeSet;

public class App {
    static Collection<Cliente> clientes = new TreeSet<>(); /* MODIFICAR LINEA A CONSIDERAR POR EL ALUMNO */
    public static void main(String[] args) {
        init();
        simulacionMovimientos();

        System.out.println("Buscando información cliente .... " + buscaCliente("87654321B"));
        System.out.println("Mostrando clientes ordenados por saldo en cuenta");
        imprimirOrdenadosPorSaldoEnCuenta();
    }
    
    //IMPLEMENTAR LOS DOS MÉTODOS PARA DAR RESPUESTA A LOS REQUERIMIENTOS DEL main
    static Cliente buscaCliente(String dni) {
        for (Cliente c : clientes)
            if (c.getDni().equals(dni))
                return c;
        return null;
    }
    static void imprimirOrdenadosPorSaldoEnCuenta() {
        for (Cliente c : clientes)
            System.out.println(c);
    }

    public static void init()
    {
        Cliente c1 = new Cliente("Juan", "Pérez", "12345678A");
        Cliente c2 = new Cliente("Ana", "Gómez", "87654321B");
        Cliente c3 = new Cliente("Carlos", "Rodríguez", "C0034324C");
        
        Cuenta c11 = c1.abrirCuenta(10000);
        c11.agregarTarjetaCredito(3000);
        c11.agregarTarjetaDebito();

        Cuenta c21 = c2.abrirCuenta(5000);
        c21.agregarTarjetaCredito(4000);
        c21.agregarTarjetaCredito(3000);
        c2.abrirCuenta(4000).agregarTarjetaDebito();

        c3.abrirCuenta(10000).agregarTarjetaDebito();

        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);

    }
    public static void simulacionMovimientos(){
        for (Cliente c : clientes)
            for (Cuenta cuenta : c.getCuentas())
                for (Tarjeta t : cuenta.getTarjetas()){
                    t.pagarConTarjeta(Math.random()*1000);
                    t.retirarEfectivo(Math.random()*1000);
                }
    }

}
