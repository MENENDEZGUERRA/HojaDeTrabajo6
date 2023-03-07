import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Collections;

public class LinkedHash implements menu{
    
    @Override
    public void message(){
        System.out.println("Has seleccionado LinkedHash()");
    }

    @Override
    public void sort(){
        // Leer el archivo de inventario y crear la colección de productos
        File file = new File("products.txt");
        try (Scanner scanner = new Scanner(file)) {
            Map<String, List<String>> inventario = new LinkedHashMap<>();
            
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
                
                //Categoria 2
                if(choice == 2) {
                Scanner sc = new Scanner(System.in);
                System.out.print("\nEscriba la categoria a mostrar: ");
                String cat = sc.nextLine();
                }
                
                switch (choice) {
                    case 1:
                        agregarProducto(inventario);
                        break;
                    case 2:
                        mostrarCategoria(inventario, "Carnes"); //No te olvides de cambiar esto (me voy a olvidar probablemente)
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
        //Mostrar categoría
        public static void mostrarCategoria(Map<String, List<String>> inventario, String categoria) {
            if (inventario.containsKey(categoria)) {
                System.out.println("Productos en la categoría " + categoria + ":");
                for (String producto : inventario.get(categoria)) {
                    System.out.println("- " + producto);
                }
            } else {
                System.out.println("No hay productos en la categoría " + categoria);
            }
        }
        //Mostrar datos en colección
        public static void mostrarDatosColeccion(Map<String, List<String>> inventario) {
            System.out.println("Inventario:");
            for (Map.Entry<String, List<String>> entry : inventario.entrySet()) {
                String categoria = entry.getKey();
                List<String> productos = entry.getValue();
                System.out.println(categoria + ":");
                for (String producto : productos) {
                    System.out.println("- " + producto);
                }
            }
        }
        //Mostrar datos en colección ordenada
        public static void mostrarDatosColeccionOrdenada(Map<String, List<String>> inventario) {
            System.out.println("Inventario ordenado:");
            Map<String, List<String>> inventarioOrdenado = new LinkedHashMap<>();
            List<String> categoriasOrdenadas = new ArrayList<>(inventario.keySet());
            Collections.sort(categoriasOrdenadas);
            for (String categoria : categoriasOrdenadas) {
                inventarioOrdenado.put(categoria, inventario.get(categoria));
            }
            mostrarDatosColeccion(inventarioOrdenado);
        }
        //Mostrar inventario
        public static void mostrarInventario(Map<String, List<String>> inventario) {
            System.out.println("Inventario:");
            for (String categoria : inventario.keySet()) {
                System.out.println(categoria + ":");
                for (String producto : inventario.get(categoria)) {
                    System.out.println("- " + producto);
                }
            }
        }
        //Mostrar categoría ordenada
        public static void mostrarCategoriasOrdenadas(Map<String, List<String>> inventario) {
            System.out.println("Categorías ordenadas:");
            List<String> categoriasOrdenadas = new ArrayList<>(inventario.keySet());
            Collections.sort(categoriasOrdenadas);
            for (String categoria : categoriasOrdenadas) {
                System.out.println("- " + categoria);
            }
        }
        
        
        
}
