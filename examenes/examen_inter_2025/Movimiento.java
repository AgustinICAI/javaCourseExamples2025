public class Movimiento {
  private String fecha;
  private double importe;

  public Movimiento(double importe) {
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm");
    fecha = sdf.format(new java.util.Date());
    this.importe = importe;
  }

  public String toString() {
    return "Movimiento{" +
            "fecha='" + fecha + '\'' +
            ", importe=" + importe +
            '}';
  }

  public double getImporte() {
    return importe;
  }
  
}
