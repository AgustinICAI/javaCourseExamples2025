/*METED LOS IMPORTS QUE SE CONSIDEREIS*/
import java.util.List;
import java.util.ArrayList;

public class Cuenta {
    
    private double saldo;
    private List<Tarjeta> tarjetas;

    public Cuenta() {
        this(0);
    }
    public Cuenta(double saldoInicial)
    {
        this.saldo = saldoInicial;
        tarjetas = new ArrayList<>();
    }


    public void retirar(double monto) {
            saldo -= monto;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {

        return "Cuenta{" +
                "saldo=" + String.format("%.2f EUR",saldo) +
                '}';
    }

    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    // ES NECESARIO IMPLEMENTAR LOS MÉTODOS y OTROS MÉTODOS QUE SE CONSIDEREN NECESARIOS
    public void agregarTarjetaCredito(int saldo){
        tarjetas.add(new TarjetaCredito(
             Tarjeta.generarNumeracionTarjeta(),
             Tarjeta.generarFechaVencimiento(), this, saldo));

    }
    public void agregarTarjetaDebito() {
        tarjetas.add(new TarjetaDebito(
             Tarjeta.generarNumeracionTarjeta(),
             Tarjeta.generarFechaVencimiento(), this));
    }

    public double getSaldoReal(){
        double saldoReal = saldo;
        for (Tarjeta t : tarjetas)
            if(t instanceof TarjetaCredito)
                saldoReal -= ((TarjetaCredito) t).getDeuda();
        return saldoReal;

    }

}
