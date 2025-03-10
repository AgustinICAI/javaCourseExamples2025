import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public abstract class Tarjeta  /* MODIFICAR LINEA A CONSIDERAR POR EL ALUMNO */{
    private String numeroTarjeta;
    private String fechaVencimiento;
    private Cuenta cuenta;
    private Collection<Movimiento> movimientos;


    public Tarjeta(String numeroTarjeta, String fechaVencimiento, Cuenta cuenta) {
        this(numeroTarjeta);
        this.fechaVencimiento = fechaVencimiento;
        this.cuenta = cuenta;
        movimientos = new ArrayList<>();
    }
    public Tarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public static String generarNumeracionTarjeta(){
        Random r = new Random();
        String numero = "";
        for (int i = 0; i < 16; i++) 
            numero += r.nextInt(10);
        return numero;
    }

    public static String generarFechaVencimiento(){
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaVencimiento = fechaActual.plusYears(4);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
        return fechaVencimiento.format(formatter);
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Collection<Movimiento> getMovimientos() {
        return movimientos;
    }

    // ES NECESARIO IMPLEMENTAR LOS MÉTODOS y OTROS MÉTODOS QUE SE CONSIDEREN NECESARIOS
    public boolean retirarEfectivo(double importe) {
        if(importe > cuenta.getSaldo())
            return false;
        cuenta.retirar(importe);
        return true;
    }
    public Movimiento pagarConTarjeta(double pago){
        Movimiento m = new Movimiento(pago);
        getMovimientos().add(m);
        return m;
    }



}
