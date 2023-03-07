import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static void main(String[] args) {
        String fileName = "products.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                String category = parts[0].trim();
                String product = parts[1].trim();
                System.out.println("Categoria: " + category + "  Producto: " + product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

