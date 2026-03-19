import java.io.*;
import java.util.*;

public class Inventario {

    private Map<String, String> inventario;

    public Inventario(Map<String, String> inventario) {
        this.inventario = inventario;
    }

    public void cargarArchivo(String nombreArchivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");

                String categoria = partes[0].trim();
                String producto = partes[1].trim();

                inventario.put(producto, categoria);
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error al leer el archivo.");
        }
    }

    public Map<String, String> getInventario() {
        return inventario;
    }
}