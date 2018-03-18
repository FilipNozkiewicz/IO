import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Read {

        ArrayList<ArrayList<Integer>> bufer = new ArrayList<ArrayList<Integer>>(  );

        public StringBuilder s;
       public ArrayList<Character> ar = new ArrayList<Character> (  );
        public void read1(String text) throws IOException {

            BufferedReader reader = null;
            try {
                reader = new BufferedReader (
                        new InputStreamReader (
                                new FileInputStream ( text )
                                 ) );
                int c;

                int it = 0;
                while ((c = reader.read()) != -1) {  // czytaj do konca pliku

                    Character character = (char)c;
                    // Do something with your character
                    ar.add ( character );
                    
                }

            } catch (FileNotFoundException e) {
                System.out.println ("Nie ma takiego pliku");
            }

        }
}
