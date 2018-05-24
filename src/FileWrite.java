import java.io.*;
import java.sql.Timestamp;

public class FileWrite{

    public static void main(String[] args) throws Exception {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(timestamp);

    }

    public static void writefile(String string , String file) {
        File fl = new File(file);

        try {
            FileWriter writer = new FileWriter(fl, true);
            BufferedWriter buffer = new BufferedWriter(writer);
            PrintWriter printWriter = new PrintWriter(buffer);

            printWriter.print(string);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}