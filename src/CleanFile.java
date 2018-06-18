import java.io.FileNotFoundException;
import java.io.PrintWriter;


// To jest klasa ktora czysci wybrany plik tekstowy (kasuje jego zawartosc poprzez nadpisywanie pustym stringiem)
public class CleanFile {

    public static void clean(String file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();
    }////
}
