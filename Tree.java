import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Tree implements menu {

    @Override
    public void message(){
        System.out.println("Has seleccionado Tree()");
    }

    @Override
    public void sort(){
        // Leer el archivo de inventario y crear la colección de productos
        File file = new File("products.txt");
        try (Scanner scanner = new Scanner(file)) {
            Map<String, List<String>> inventario = new TreeMap<>();
            
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
                        System.out.print("\nIngrese su opción: "); 
                        String cat = input.nextLine();
                        mostrarCategoria(inventario, cat);
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
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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

    public static void mostrarCategoria(Map<String, List<String>> inventario, String categoria) {
        if (!inventario.containsKey(categoria)) {
            System.out.println("La categoría " + categoria + " no existe en el inventario.");
            return;
        }
    
        System.out.println("Productos en la categoría " + categoria + ":");
        for (String producto : inventario.get(categoria)) {
            System.out.println(producto.toString());
        }
    }

    public static void mostrarDatosColeccion(Map<String, List<String>> inventario) {
        for (String categoria : inventario.keySet()) {
            System.out.println("Productos en la categoría " + categoria + ":");
            for (String producto : inventario.get(categoria)) {
                System.out.println(producto.toString());
            }
        }
    }

    public static void mostrarDatosColeccionOrdenada(Map<String, List<String>> inventario) {
        TreeMap<String, List<String>> inventarioOrdenado = new TreeMap<>(inventario);
        mostrarDatosColeccion(inventarioOrdenado);
    }

    public static void mostrarInventario(Map<String, List<String>> inventario) {
        System.out.println("Inventario completo:");
        mostrarDatosColeccion(inventario);
    }

    public static void mostrarCategoriasOrdenadas(Map<String, List<String>> inventario) {
        TreeMap<String, List<String>> inventarioOrdenado = new TreeMap<>(inventario);
        System.out.println("Categorías en orden alfabético:");
        for (String categoria : inventarioOrdenado.keySet()) {
            System.out.println(categoria);
        }
    } 
    

    
    

    
    
}
