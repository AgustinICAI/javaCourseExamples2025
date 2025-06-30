package examen;

import javax.swing.*;

public abstract class Producto {
    protected String ean;
    protected String descripcion;
    protected int calorias;
    protected ImageIcon imagen;

    public Producto(String ean, String descripcion, int calorias, ImageIcon imagen) {
        this.ean = ean;
        this.descripcion = descripcion;
        this.calorias = calorias;
        this.imagen = imagen;
    }

    public String getEan() { return ean; }
    public String getDescripcion() { return descripcion; }
    public ImageIcon getImagen() { return imagen; }

    public abstract int getCalorias();

    @Override
    public String toString() {
        return descripcion + " (" + ean + ") - " + getCalorias() + " cal";
    }
}