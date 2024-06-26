package co.com.hyunseda.market.infra;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Utilidades varias utilizadas por otras clases
 *
 * @author Libardo
 */
/**
 * @brief Clase de utilidades con métodos útiles.
 */
public class Utilities {

    /**
     * @brief Cargar una propiedad de config.properties.
     * @param key Llave de la propiedad.
     * @return Valor de la propiedad.
     */
    public static String loadProperty(String key) {
        Properties prop = new Properties();
        InputStream is;

        try {
            is = new FileInputStream("./config.properties");
            prop.load(is);
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo");
        }

        return prop.getProperty(key);
    }

    /**
     * @brief Verificar si un String contiene sólo dígitos.
     * @param str Cadena a verificar.
     * @return true si contiene sólo dígitos, false en caso contrario.
     */
    public static boolean isNumeric(String str) {

        boolean resultado;

        try {
            Integer.parseInt(str);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

    /**
     * @brief Cargar una imagen a partir de la URL.
     * @param name URL de la imagen.
     * @return Un icono de la imagen.
     */
    public static ImageIcon loadImageFromCloud(String name) {

        String imageUrl = name;

        try {
            URL url = new URL(imageUrl);
            ImageIcon icon = new ImageIcon(ImageIO.read(url));
            return icon;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
