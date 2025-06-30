package examen.clasesSuministradas;

import examen.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class ProductRetriever {
    private static Map<String, Producto> productos = new HashMap<>();

    static {
        // Producto simple: Bebida de COLA Clásica lata 33 cl
        productos.put("111", new ProductoSimple("111", "Bebida de COLA Clásica lata 33 cl", 139, new ImageIcon("resources/111.png")));

        // Producto compuesto: Bebida de COLA Clásica pack 12 latas 33 cl (12 x 139)
        ProductoCompuesto packCola = new ProductoCompuesto("112", "Bebida de COLA Clásica pack 12 latas 33 cl", new ImageIcon("resources/112.png"));
        packCola.addComponente(productos.get("111"), 12);
        productos.put("112", packCola);

        // Producto simple: Bebida Espirituosa Añeja Dominicano 700ml
        productos.put("113", new ProductoSimple("113", "Bebida Espirituosa Añeja Dominicano 700ml", 1440, new ImageIcon("resources/113.png")));

        // Producto compuesto: PACK fin de examenes (1 packCola + 1 espirituosa)
        ProductoCompuesto packExamen = new ProductoCompuesto("114", "PACK fin de examenes", new ImageIcon("resources/114.png"));
        packExamen.addComponente(packCola, 1);
        packExamen.addComponente(productos.get("113"), 1);
        productos.put("114", packExamen);
    }

    public static Producto getInfo(String ean) throws Exception {
        if (productos.containsKey(ean)) {
            return productos.get(ean);
        } else {
            throw new Exception("Producto no encontrado para EAN: " + ean);
        }
    }
}