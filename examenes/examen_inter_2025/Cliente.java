import java.util.List;
import java.util.ArrayList;
import java.lang.Comparable;

class Cliente implements Comparable{
    private String nombre;
    private String apellido;
    private String dni;
    private List<Cuenta> cuentas;

    public Cliente(String nombre, String apellido, String dni) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuentas = new ArrayList<>();
    }
    
    @Override
    public int compareTo(Object o) {
        Cliente otro = (Cliente) o;
        if(this.calculaSaldo() == otro.calculaSaldo())
            return this.dni.compareTo(otro.dni);
        return Double.compare(this.calculaSaldo(), otro.calculaSaldo());
    }

    public Cliente( String dni){
        this.dni = dni;
    }

    public Cuenta abrirCuenta(double saldo) {
        Cuenta c = new Cuenta(saldo);
        cuentas.add(c);
        return c;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", saldo=" + String.format("%.2f EUR",calculaSaldo()) +
                ", saldoReal=" + String.format("%.2f EUR",calculaSaldoReal()) +
                '}';
    }



    public List<Cuenta> getCuentas() {
      return cuentas;
    }

    // ES NECESARIO IMPLEMENTAR LOS MÉTODOS y OTROS MÉTODOS QUE SE CONSIDEREN NECESARIOS
    public double calculaSaldo() {
        double saldo = 0;
        for (Cuenta c : cuentas) {
            saldo += c.getSaldo();
        }
        return saldo;
    }
    double calculaSaldoReal(){
        double saldo = 0;
        for (Cuenta c : cuentas) {
            saldo += c.getSaldoReal();
        }
        return saldo;
    }


}
