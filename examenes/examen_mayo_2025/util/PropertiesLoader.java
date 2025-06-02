package util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class PropertiesLoader {

    public static HashMap<String, String> loadProperties(String filePath, String typeProperties) {
        HashMap<String, String> properties = new HashMap<>();
        boolean isInSection = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                // Detectar el inicio de una sección
                if (line.startsWith("[") && line.endsWith("]")) {
                    String section = line.substring(1, line.length() - 1).trim();
                    isInSection = section.equalsIgnoreCase(typeProperties);
                    continue;
                }

                // Ignorar líneas fuera de la sección deseada
                if (!isInSection || line.isEmpty() || line.startsWith("//")) {
                    continue;
                }

                // Dividir la línea en clave y valor
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    properties.put(key, value);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de propiedades: " + e.getMessage());
        }

        return properties;
    }
}
