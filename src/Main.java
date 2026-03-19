import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione implementación:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");

        int opcion = sc.nextInt();
        sc.nextLine();

        Map<String, String> inventarioMap = MapFactory.crearMap(opcion);

        Inventario inventario = new Inventario(inventarioMap);
        inventario.cargarArchivo("ListadoProducto.txt");

        Map<String, String> inventarioData = inventario.getInventario();

        // colección del usuario
        Map<String, Integer> coleccionUsuario = new HashMap<>();

        int opcionMenu = 0;

        while (opcionMenu != 7) {

            System.out.println("\nMENU:");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar categoría de producto");
            System.out.println("3. Mostrar colección");
            System.out.println("4. Mostrar colección ordenada");
            System.out.println("5. Mostrar inventario");
            System.out.println("6. Mostrar inventario ordenado");
            System.out.println("7. Salir");

            opcionMenu = sc.nextInt();
            sc.nextLine();

            if (opcionMenu == 1) {
                System.out.println("Ingrese producto:");
                String producto = sc.nextLine();

                if (inventarioData.containsKey(producto)) {
                    coleccionUsuario.put(producto,
                        coleccionUsuario.getOrDefault(producto, 0) + 1);
                    System.out.println("Producto agregado.");
                } else {
                    System.out.println("Producto no existe.");
                }

            } else if (opcionMenu == 2) {
                System.out.println("Ingrese producto:");
                String producto = sc.nextLine();

                if (inventarioData.containsKey(producto)) {
                    System.out.println("Categoría: " + inventarioData.get(producto));
                } else {
                    System.out.println("Producto no encontrado.");
                }

            } else if (opcionMenu == 3) {
                for (String prod : coleccionUsuario.keySet()) {
                    System.out.println(prod + " | " +
                        inventarioData.get(prod) + " | Cantidad: " +
                        coleccionUsuario.get(prod));
                }

            } else if (opcionMenu == 4) {
                Map<String, Integer> ordenado = new TreeMap<>(coleccionUsuario);

                for (String prod : ordenado.keySet()) {
                    System.out.println(prod + " | " +
                        inventarioData.get(prod) + " | Cantidad: " +
                        ordenado.get(prod));
                }

            } else if (opcionMenu == 5) {
                for (String prod : inventarioData.keySet()) {
                    System.out.println(prod + " | " + inventarioData.get(prod));
                }

            } else if (opcionMenu == 6) {
                Map<String, String> ordenado = new TreeMap<>(inventarioData);

                for (String prod : ordenado.keySet()) {
                    System.out.println(prod + " | " + ordenado.get(prod));
                }
            }
        }

        sc.close();
    }
}
