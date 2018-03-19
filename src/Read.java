import com.sun.jdi.event.MethodExitEvent;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Read {


        ArrayList<ArrayList<Integer>> bufer = new ArrayList<ArrayList<Integer>>(  );
    public int max;
    public int k;
    public  ArrayList<Integer> check = new ArrayList<Integer> (  );
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
                boolean mustbreak = false;
                 max = 0;
                int it = 0;
                 k = 0;

                while ((c = reader.read()) != -1) {  // czytaj do konca pliku

                    Character character = (char)c;
                    // Do something with your character
                    if(mustbreak) break;

                    k++;

                    ar.add ( character );
                    it++;
                    if((Character.isDigit ( character ) == false) && (character != 10) && (character != 13)){
                        System.out.println("Cosik nie tak w okumenciku");
                        ar.clear ();
                        break;
                    }

                    if(character == 10 ){
                        check.add ( k );
                        if(check.size () > 1) {
                            for (int i = 1; i < check.size (); i++) {
                                if (check.get ( i ) != check.get ( i - 1 )){
                                    System.out.println ("niewlasciwy wymiar");
                                    ar.clear ();
                                    mustbreak = true;
                                    break;

                                }

                            }
                        }

                        max = k -2;
                        k = 0;

                    }
                    if(check.size () > max){
                        System.out.println ("Niezgodny wymia");
                        ar.clear ();
                        mustbreak=true;
                        break;
                    }

                }
                if(check.size () < max){ System.out.println("niewlasciwy wymiar"); ar.clear (); }
                if(max > 50) {ar.clear (); System.out.println("maksymalnie 50 wierszu macierzy");}

            } catch (FileNotFoundException e) {
                System.out.println ("Nie ma takiego pliku");
            }

        }
}
