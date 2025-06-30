package examen;

import java.util.*;

public class GestorProductos {
    private List<Producto> productosEscaneados = new ArrayList<>();

    public void addProducto(Producto p) {
        productosEscaneados.add(p);
    }

    public List<Producto> getProductosEscaneados() {
        return productosEscaneados;
    }

    public String imprimirDetalle() {
        StringBuilder sb = new StringBuilder();
        for (Producto p : productosEscaneados) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }
}