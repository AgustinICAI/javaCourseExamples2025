package examen;

import examen.clasesSuministradas.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class JCaloriasApp extends JFrame {
    private GestorProductos gestor = new GestorProductos();
    private JPanel gridPanel = new JPanel(new GridLayout(4, 1, 10, 10)); // 4 filas, 1 columna

    public JCaloriasApp() {
        setTitle("JCalorias");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Botón para escanear en la parte superior (NORTH)
        JButton escanearBtn = new JButton("Escanear");
        escanearBtn.addActionListener(e -> escanearProducto());
        JPanel panelNorth = new JPanel();
        panelNorth.add(escanearBtn);
        add(panelNorth, BorderLayout.NORTH);

        // Panel central con los productos escaneados
        add(gridPanel, BorderLayout.CENTER);

        // Botón para imprimir en la parte inferior (SOUTH)
        JButton imprimirBtn = new JButton("Imprimir");
        imprimirBtn.addActionListener(e -> imprimirDetalle());
        JPanel panelSouth = new JPanel();
        panelSouth.add(imprimirBtn);
        add(panelSouth, BorderLayout.SOUTH);

        actualizarGrid();
    }

    private void escanearProducto() {
        try {
            BarScanner scanner = new BarScanner();
            String ean = scanner.read();
            Producto p = ProductRetriever.getInfo(ean);
            gestor.addProducto(p);
            actualizarGrid();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al escanear: " + ex.getMessage());
        }
    }

    private void imprimirDetalle() {
        JOptionPane.showMessageDialog(this, gestor.imprimirDetalle());
    }

    private void actualizarGrid() {
        gridPanel.removeAll();
        List<Producto> productos = gestor.getProductosEscaneados();
        int start = Math.max(0, productos.size() - 4);
        int pintados = 0;
        for (int i = start; i < productos.size(); i++) {
            Producto p = productos.get(i);
            ImageIcon icon = p.getImagen();
            String texto = p.getDescripcion() + " - " + p.getCalorias() + " cal";
            JLabel label = new JLabel(texto, icon, JLabel.LEFT);
            label.setIconTextGap(15);
            gridPanel.add(label);
            pintados++;
        }
        // Rellenar celdas vacías si hay menos de 4 productos
        for (int i = pintados; i < 4; i++) {
            gridPanel.add(new JLabel());
        }
        gridPanel.revalidate();
        gridPanel.repaint();
    }

    public static void main(String[] args) {
        JCaloriasApp app = new JCaloriasApp();
        app.setVisible(true);
    }
}