import java.io.IOException;

public class Main {



   public static void main(String[] args) throws IOException {
       Read read = new Read();
       read.read1("data.txt");
       for(int i = 0 ; i  < read.ar.size (); i ++){
           System.out.print(read.ar.get ( i ));
       }
       System.out.println ();
       System.out.println(read.ar.size ());
   }
}
