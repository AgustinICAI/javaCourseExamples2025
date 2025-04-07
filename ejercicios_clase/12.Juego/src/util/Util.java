package util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Util {

    public static BufferedImage rotarImagen(BufferedImage imagen, double angulo) {
        double rads = Math.toRadians(angulo); // Convertir el ángulo a radianes
        int ancho = imagen.getWidth();
        int alto = imagen.getHeight();

        // Crear una nueva imagen con el mismo tipo
        BufferedImage imagenRotada = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);

        // Crear un objeto Graphics2D
        Graphics2D g2d = imagenRotada.createGraphics();

        // Establecer una transformación para rotar la imagen en su centro
        AffineTransform transform = new AffineTransform();
        // 1. Trasladar el origen al centro de la imagen
        transform.translate(ancho / 2.0, alto / 2.0);
        // 2. Rotar la imagen alrededor de su centro
        transform.rotate(rads);
        // 3. Trasladar la imagen de vuelta para que su centro coincida
        transform.translate(-ancho / 2.0, -alto / 2.0);

        // Dibujar la imagen rotada aplicando la transformación
        g2d.setTransform(transform);
        g2d.drawImage(imagen, 0, 0, null);
        g2d.dispose();

        return imagenRotada;
    }

    public static BufferedImage convertirAImagenBuffered(Image imagen, int ancho, int alto) {
        // Crear un BufferedImage con el mismo tamaño y tipo
        BufferedImage bufferedImage = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);

        // Dibujar la imagen en el BufferedImage
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(imagen, 0, 0, ancho, alto, null);
        g2d.dispose();

        return bufferedImage;
    }
}