import com.sun.org.apache.xpath.internal.operations.String;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException  { // nie działał tu bo jakiś error
       Read read = new Read();
       read.readFunction("data.txt");
       for(int i = 0 ; i  < read.ar.size (); i ++){
           System.out.print(read.ar.get ( i ));
       }
       System.out.println ();
       System.out.println(read.ar.size ());

       MapGenerator mapGenerator = new MapGenerator();
       mapGenerator.generate();
   }
}
