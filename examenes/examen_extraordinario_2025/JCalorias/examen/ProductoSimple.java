package examen;

import javax.swing.*;

public class ProductoSimple extends Producto {
    public ProductoSimple(String ean, String descripcion, int calorias, ImageIcon imagen) {
        super(ean, descripcion, calorias, imagen);
    }

    @Override
    public int getCalorias() {
        return calorias;
    }
}