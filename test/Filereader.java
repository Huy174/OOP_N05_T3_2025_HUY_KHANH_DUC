
    import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {
    public static void main(String[] args) {
        File f = new File("final/src/test.txt");
        // Sử dụng try-with-resources để tự động đóng FileInputStream
        try (FileInputStream fis = new FileInputStream(f)) {
            int c;
            while ((c = fis.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

