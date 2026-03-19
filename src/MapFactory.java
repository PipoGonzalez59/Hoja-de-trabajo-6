import java.util.*;

public class MapFactory {

    public static Map<String, String> crearMap(int opcion) {
        if (opcion == 1) {
            return new HashMap<>();
        } else if (opcion == 2) {
            return new TreeMap<>();
        } else if (opcion == 3) {
            return new LinkedHashMap<>();
        } else {
            System.out.println("Opción inválida, usando HashMap por defecto.");
            return new HashMap<>();
        }
    }
}