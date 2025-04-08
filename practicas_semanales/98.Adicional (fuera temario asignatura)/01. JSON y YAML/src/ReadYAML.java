import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.*;

public class ReadYAML {
    public static void main(String argv[])
    {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("./resources/user.yaml"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Configurar el Constructor para la clase User
        Constructor constructor = new Constructor(User.class, new LoaderOptions());
        Yaml yaml = new Yaml(constructor);

        // Cargar el YAML en una instancia de User
        User user = yaml.load(inputStream);

        System.out.println(user);
    }
}
