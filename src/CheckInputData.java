import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CheckInputData {


    public ArrayList<ArrayList<Integer>> buffer;
    public ArrayList<ArrayList<Integer>> horizontal;
    public ArrayList<ArrayList<Integer>> vertical;

    public ArrayList<ArrayList<Integer>> getHorizontal() {
        return horizontal;
    }

    public ArrayList<ArrayList<Integer>> getVertical() {
        return vertical;
    }
    public void read(String text) throws IOException {
        int c;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader (
                    new InputStreamReader (
                            new FileInputStream ( text )
                    ) );
        }catch (IOException e){
            System.out.println ("there is no such a file");
        }
        buffer = new ArrayList<ArrayList<Integer>> (  );
        buffer.add ( new ArrayList<Integer> (  ) );
        int iter = 0;
        int poczekajka = 999; // poczekajka ustawia nam ostatni znka na nowo linie (dalem jaks artosc co nie waliduje)
        while ((c = reader.read()) != -1) {
            if( c == 13){
              //  int[] checking = new int[2];
            //    checking[0] = c;
                poczekajka = c;   // poczekajka ustawia nam ostatni znka na nowo linie
              //  buffer.add ( new ArrayList<Integer> (  ) );
                iter++;
            }
            if((c >= 48 && c <= 57)  && poczekajka == 13  ){ // jesli dane to liczba od 0-9 ii ostatni znak to nowa linia
                // to dodaj koleny wiersz do macierzy
                buffer.add ( new ArrayList<Integer> (  ) );
                poczekajka = 999;
            }
            if(c >= 48 && c <= 57  ){
                // jesli dane sa poprawne czyli liczba od 0 do 9 to dodaj elemnt do macierzy
                // ale trzeba przeprowadzic konwersje zmiennych
                Character cc = ((char)c); // zrzutowac z ascii
                String ss = cc.toString ();  // dac do stringa
                Integer input = Integer.parseInt ( ss ); // i dopiero an koncu konwersja do inta
                buffer.get ( iter ).add ( input );
            }
            if(((c != 10) && (c != 13)) && ((c < 48) || (c > 57)) ){ // jesli dane wejsciowe sa zle
                System.out.println ("Not Valid input data"); // to prerwanie petli bo nie da sie tego zrobic
                buffer = null;
                break;
            }
        }
    }
    public void print(){
        try {
            for (ArrayList<Integer> ar : buffer) {
                for (Integer x : ar) {
                    System.out.print ( x );
                }
                System.out.println ();
            }
        }catch (Exception e){
            System.out.println ("We can not read a data");
        }

    }
    public void separate(){   // odzielenie horryzontalnych i vertykalnych
        horizontal = new ArrayList<ArrayList<Integer>> (  );
        vertical = new ArrayList<ArrayList<Integer>> (  );
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> tempWithZero;
        try {
            for (int i = 0; i < buffer.size () ; i++){
                if((i % 2) == 0){
                    tempWithZero = buffer.get ( i );
                    tempWithZero.remove(tempWithZero.size() - 1);
                    tempWithZero.add(0);
                    horizontal.add ( tempWithZero );
                }else{
                    vertical.add ( buffer.get ( i ));
                }
            }
            for(int i = 0; i < buffer.get(1).size() ; i++)
                temp.add(0);
            if(vertical.size() < horizontal.size()){
                vertical.add(temp);
            }else {
                horizontal.add(temp);
            }
        }catch (Exception e){
            System.out.println ("Something goes wrong , check if everything is correct");
        }
    }
    // tylko wypisania
    public void print_hor(){
        for(ArrayList<Integer> ar : horizontal){
            for (Integer x : ar){
                System.out.print (x);
            }
            System.out.println ();
        }
    }

    public void print_ver(){
        for(ArrayList<Integer> ar : vertical){
            for (Integer x : ar){
                System.out.print (x);
            }
            System.out.println ();
        }
    }
    public static void main(String[] args) throws IOException {
        // SPRAWDZENIE POPRAWnOSCI
        CheckInputData check_input_data = new CheckInputData();
        check_input_data.read ( "DataInputGroupWT1115_MAP.txt" );
        check_input_data.print ();
        check_input_data.separate ();
        System.out.println ("VERICALLY: ");
        check_input_data.print_ver ();
        System.out.println ("HORRIZONALLY");
        check_input_data.print_hor ();



       // check_input_data.separate ();

      //  check_input_data.print_ver ();

       // check_input_data.print_hor ();
    }
}
