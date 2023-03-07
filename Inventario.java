import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Inventario {

    public static void main(String[] args) throws FileNotFoundException {
        
        // Leer el archivo de inventario y crear la colección de productos
        File file = new File("products.txt");
        Scanner scanner = new Scanner(file);
        Map<String, List<String>> inventario = new HashMap<>();
        
        while (scanner.hasNextLine()) {
            String[] linea = scanner.nextLine().split("\\|");
            String categoria = linea[0].trim();
            String producto = linea[1].trim();
            
            if (inventario.containsKey(categoria)) {
                inventario.get(categoria).add(producto);
            } else {
                List<String> listaProductos = new ArrayList<>();
                listaProductos.add(producto);
                inventario.put(categoria, listaProductos);
            }
        }
        scanner.close();
        
        // Menú de opciones
        Scanner input = new Scanner(System.in);
        int choice = 0;
        
        while (choice != 7) {
            System.out.println("\n\nMenú de opciones:");
            System.out.println("------------------");
            System.out.println("1. Agregar un producto a la colección del usuario");
            System.out.println("2. Mostrar la categoría del producto");
            System.out.println("3. Mostrar los datos del producto, categoría y la cantidad de cada artículo que el usuario tiene en su colección");
            System.out.println("4. Mostrar los datos del producto, categoría y la cantidad de cada artículo que el usuario tiene en su colección, ordenadas por tipo");
            System.out.println("5. Mostrar el producto y la categoría de todo el inventario");
            System.out.println("6. Mostrar el producto y la categoría existentes, ordenadas por tipo");
            System.out.println("7. Salir");
            System.out.print("\nIngrese su opción: ");
            choice = input.nextInt();
            
            switch (choice) {
                case 1:
                    agregarProducto(inventario);
                    break;
                case 2:
                    mostrarCategoria(inventario);
                    break;
                case 3:
                    mostrarDatosColeccion(inventario);
                    break;
                case 4:
                    mostrarDatosColeccionOrdenada(inventario);
                    break;
                case 5:
                    mostrarInventario(inventario);
                    break;
                case 6:
                    mostrarCategoriasOrdenadas(inventario);
                    break;
                case 7:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        }
        input.close();
    }
    
    // Método para agregar un producto a la colección del usuario
    public static void agregarProducto(Map<String, List<String>> inventario) {
        Scanner input = new Scanner(System.in);
        System.out.print("\nIngrese la categoría del producto que desea agregar: ");
        String categoria = input.nextLine();
        System.out.print("Ingrese el nombre del producto: ");
        String producto = input.nextLine();
        
        if (inventario.containsKey(categoria)) {
            inventario.get(categoria).add(producto);
            System.out.println("\nProducto agregado con éxito a la colección.");
        } else {
            System.out.println("\nError: la categoría ingresada no existe en el inventario.");
        }
    }

    // Método que muestra la categoría de un producto ingresado por el usuario
public static void mostrarCategoria(Map<String, List<String>> inventario) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el nombre del producto:");
    String producto = sc.nextLine();
    boolean encontrado = false;
    for (Map.Entry<String, List<String>> entry : inventario.entrySet()) {
        if (entry.getValue().contains(producto)) {
            System.out.println("La categoría del producto " + producto + " es: " + entry.getKey());
            encontrado = true;
            break;
        }
    }
    if (!encontrado) {
        System.out.println("El producto " + producto + " no se encuentra en el inventario.");
    }
}

// Método que muestra los datos del inventario, incluyendo la cantidad de cada artículo que el usuario tiene
public static void mostrarDatosColeccion(Map<String, List<String>> inventario) {
    System.out.println("Datos del inventario:");
    for (Map.Entry<String, List<String>> entry : inventario.entrySet()) {
        System.out.println("Categoría: " + entry.getKey());
        System.out.println("Productos: " + entry.getValue());
        System.out.println("Cantidad: " + entry.getValue().size());
    }
}

// Método que muestra los datos del inventario, ordenados por tipo de producto y con la cantidad de cada artículo que el usuario tiene
public static void mostrarDatosColeccionOrdenada(Map<String, List<String>> inventario) {
    System.out.println("Datos del inventario, ordenados por tipo de producto:");
    Map<String, List<String>> inventarioOrdenado = new HashMap<>(inventario);
    for (Map.Entry<String, List<String>> entry : inventarioOrdenado.entrySet()) {
        System.out.println("Categoría: " + entry.getKey());
        System.out.println("Productos: " + entry.getValue());
        System.out.println("Cantidad: " + entry.getValue().size());
    }
}

// Método que muestra el inventario completo, incluyendo el producto y la categoría
public static void mostrarInventario(Map<String, List<String>> inventario) {
    System.out.println("Inventario completo:");
    for (Map.Entry<String, List<String>> entry : inventario.entrySet()) {
        String categoria = entry.getKey();
        for (String producto : entry.getValue()) {
            System.out.println("Producto: " + producto + " | Categoría: " + categoria);
        }
    }
}

// Método que muestra el producto y la categoría de todo el inventario, ordenados por tipo de producto
public static void mostrarCategoriasOrdenadas(Map<String, List<String>> inventario) {
    System.out.println("Categorías de productos, ordenadas por tipo de producto:");
    Map<String, List<String>> inventarioOrdenado = new HashMap<>(inventario);
    for (Map.Entry<String, List<String>> entry : inventarioOrdenado.entrySet()) {
        System.out.println(entry.getKey());
        for (String producto : entry.getValue()) {
            System.out.println("\t" + producto);
        }
    }
}

}
