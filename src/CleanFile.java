import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CleanFile {

    public static void clean(String file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();
    }
}
