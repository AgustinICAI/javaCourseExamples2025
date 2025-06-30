package examen;

import javax.swing.*;
import java.util.*;

public class ProductoCompuesto extends Producto {
    private Map<Producto, Integer> componentes = new LinkedHashMap<>();

    public ProductoCompuesto(String ean, String descripcion, ImageIcon imagen) {
        super(ean, descripcion, 0, imagen);
    }

    public void addComponente(Producto producto, int cantidad) {
        componentes.put(producto, cantidad);
    }

    @Override
    public int getCalorias() {
        int total = 0;
        for (Map.Entry<Producto, Integer> entry : componentes.entrySet()) {
            total += entry.getKey().getCalorias() * entry.getValue();
        }
        return total;
    }

    public Map<Producto, Integer> getComponentes() {
        return componentes;
    }
}