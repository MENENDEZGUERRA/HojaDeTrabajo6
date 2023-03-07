import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderV2 {
  public static void main(String[] args) {
    String filename = "products.txt"; // Nombre del archivo a leer
    ArrayList<String> productsArray = new ArrayList<>(); // ArrayList para almacenar el contenido del archivo

    try {
      BufferedReader br = new BufferedReader(new FileReader(filename));
      String line = br.readLine(); // Lee la primera línea del archivo

      while (line != null) {
        productsArray.add(line); // Agrega la línea actual al ArrayList
        line = br.readLine(); // Lee la siguiente línea del archivo
      }

      br.close(); // Cierra el archivo
    } catch (IOException e) {
      System.err.println("Error al leer el archivo: " + e);
    }

    // Imprime el contenido del ArrayList
    //for (String line : productsArray) {
    //  System.out.println(line);
    //}
  }
}

