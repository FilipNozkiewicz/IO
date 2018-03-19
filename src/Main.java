import java.io.IOException;

public class Main {



   public static void main(String[] args) throws IOException {
       Read read = new Read();
       read.read1("data.txt");
       for(int i = 0 ; i  < read.ar.size (); i ++){
           System.out.print(read.ar.get ( i ));
       }
       System.out.println ();
       System.out.println (read.check.size ());
       //System.out.println(read.);
       System.out.println (read.max);

       String s = "111111111111111111111111111111111111111";
       System.out.println (s.length ());
      
       MapGenerator mapGenerator = new MapGenerator();
       mapGenerator.generate();
   }
}
