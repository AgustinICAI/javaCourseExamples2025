
public class TarjetaCredito extends Tarjeta {
  double limite;
  double deuda;

  public TarjetaCredito(String numeroTarjeta, String fechaVencimiento, Cuenta cuenta, double limite) {
    super(numeroTarjeta, fechaVencimiento, cuenta);
    this.limite = limite;
    this.deuda = 0;
  }
  public void liquidarFinDeMes(){
    getCuenta().retirar(deuda);
    deuda = 0;
  }
  
  public double getDeuda() {
    return deuda;
  }
  @Override
  public Movimiento pagarConTarjeta(double pago) {
    
    if(pago > limite - deuda)
      return null;
    deuda += pago;
    return super.pagarConTarjeta(pago);
  }




}
