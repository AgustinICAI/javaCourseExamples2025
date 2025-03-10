
public class TarjetaDebito extends Tarjeta{

    public TarjetaDebito(String numeroTarjeta, String fechaVencimiento, Cuenta cuenta) {
        super(numeroTarjeta, fechaVencimiento, cuenta);
    }

    @Override
    public Movimiento pagarConTarjeta(double pago) {
        if(pago > getCuenta().getSaldo())
            return null;
        getCuenta().retirar(pago);
        return super.pagarConTarjeta(pago);
    }

}
