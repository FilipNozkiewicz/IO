

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class Floyyd {

    ArrayList<ArrayList<Integer>> Distance_Matrix;
    ArrayList<ArrayList<Integer>> Path_Matrix;
    public ArrayList<Integer> Hop_list;
    public ArrayList<String> Path_list;
    final int INF = 9999;

    public void floyd(ArrayList<ArrayList<Integer>> M){

        //    Hop_Matrix = new ArrayList<ArrayList<Integer>> (  );
        ArrayList<ArrayList<Integer>> dist = M;
        ArrayList<ArrayList<Integer>> pred = new ArrayList<ArrayList<Integer>> (  );

        for(int i = 0 ; i < M.size () ; i++) {

            ArrayList<Integer> xd = new ArrayList<Integer> (  );
            ArrayList<Integer> xd2 = new ArrayList<Integer> (  );
            for (int j = 0; j < M.size (); j++) {
                xd.add ( null );



            }
            pred.add ( xd );
            //    Hop_Matrix.add ( xd );
        }

        for(int i = 0 ; i < M.size () ; i++){
            for(int j = 0 ; j < M.size () ; j++){
                if(i != j){
                    if(M.get ( i ).get ( j ) != INF){
                        pred.get ( i ).set ( j , i );
                    }
                }
            }
        }
        for(int k = 0 ; k < M.size () ; k++){
            for(int i = 0 ; i < M.size ()  ; i++){
                for(int j = 0 ; j < M.size () ; j++){

                    if(dist.get ( i ).get ( k ) + dist.get ( k ).get ( j ) < dist.get ( i ).get ( j )){
                        dist.get ( i ).set ( j , dist.get ( i ).get ( k ) + dist.get ( k ).get ( j ) );
                        pred.get ( i ).set ( j , pred.get ( k ).get ( j ) );
                    }
                }
            }
        }

        //   System.out.println ("Disytance");
        //   print ( dist );
        //   System.out.println ("Paths");
        //    print (pred);
        Distance_Matrix = dist;
        Path_Matrix = pred;

    }
    public void print(ArrayList<ArrayList<Integer>> M){   // tylko sposob wypisywania

        System.out.println ("\n\t");
        System.out.print ("\t");
        for(int i =0 ; i< M.size () ; i++ ){
            System.out.print (i + "|\t");
        }
        System.out.println ();
        for(int i = 0 ; i < 23 ; i ++) {
            System.out.print ("-");
        }
        System.out.println ();
        for(int i = 0 ; i  < M.size () ; i++){
            System.out.print (i + "|\t");
            for(int j = 0 ; j < M.size () ; j++){
                if(i == j) {
                    System.out.print ( "-" );
                }
                else {
                    System.out.print ( M.get ( i ).get ( j ) );
                }
                System.out.print("\t");


            }
            System.out.println ("\n");
        }
        System.out.println ("\n");
    }
    public ArrayList<ArrayList<Integer>> alokuj() {

        ArrayList<ArrayList<Integer>> M = new ArrayList<ArrayList<Integer>> ();

        ArrayList<Integer> zero = new ArrayList<Integer> ();
        ArrayList<Integer> one = new ArrayList<Integer> ();
        ArrayList<Integer> two = new ArrayList<Integer> ();
        ArrayList<Integer> three = new ArrayList<Integer> ();
        ArrayList<Integer> four = new ArrayList<Integer> ();
        ArrayList<Integer> five = new ArrayList<Integer> ();
        ArrayList<Integer> six = new ArrayList<Integer> ();
        ArrayList<Integer> seven = new ArrayList<Integer> ();
        ArrayList<Integer> eight = new ArrayList<Integer> ();


        zero.add ( 0 );
        zero.add ( 4 );
        zero.add ( INF );
        zero.add ( INF );
        zero.add ( INF );
        zero.add ( INF );
        zero.add ( INF );
        zero.add ( 8 );
        zero.add ( INF );

        one.add ( 4 );
        one.add ( 0 );
        one.add ( 8 );
        one.add ( INF );
        one.add ( INF );
        one.add ( INF );
        one.add ( INF );
        one.add ( 11 );
        one.add ( INF );

        two.add ( INF );
        two.add ( 8 );
        two.add ( 0 );
        two.add ( 7 );
        two.add ( INF );
        two.add ( 4 );
        two.add ( INF );
        two.add ( INF );
        two.add ( 2 );

        three.add ( INF );
        three.add ( INF );
        three.add ( 7 );
        three.add ( 0 );
        three.add ( 9 );
        three.add ( 14 );
        three.add ( INF );
        three.add ( INF );
        three.add ( INF );

        four.add ( INF );
        four.add ( INF );
        four.add ( INF );
        four.add ( 9 );
        four.add ( 0 );
        four.add ( 10 );
        four.add ( INF );
        four.add ( INF );
        four.add ( INF );

        five.add ( INF );
        five.add ( INF );
        five.add ( 4 );
        five.add ( 14 );
        five.add ( 10);
        five.add ( 0 );
        five.add ( 2 );
        five.add ( INF );
        five.add ( INF );

        six.add ( INF );
        six.add ( INF );
        six.add ( INF );
        six.add ( INF );
        six.add ( INF );
        six.add ( 2 );
        six.add ( 0 );
        six.add ( 1 );
        six.add ( 6 );

        seven.add ( 8 );
        seven.add ( 11 );
        seven.add ( INF );
        seven.add ( INF );
        seven.add ( INF );
        seven.add ( INF );
        seven.add ( 1 );
        seven.add ( 0 );
        seven.add ( 7 );

        eight.add ( INF );
        eight.add ( INF );
        eight.add ( 2 );
        eight.add ( INF );
        eight.add ( INF );
        eight.add ( INF );
        eight.add ( 6 );
        eight.add ( 7 );
        eight.add ( 0 );

        M.add ( zero );
        M.add ( one );
        M.add ( two );
        M.add ( three );
        M.add ( four );
        M.add ( five );
        M.add ( six );
        M.add ( seven );
        M.add ( eight );

        return M;
    }
    void printuj(ArrayList<ArrayList<String>> M){
        for(Integer i = 0 ; i < M.size () ; i++ ){
            for(Integer j = 0 ; j < M.get ( i ).size () ; j ++){
                System.out.print (M.get ( i ).get ( j ) + "\t");
            }
            System.out.println ();
        }
    }
    ArrayList<ArrayList<Integer>> Hop_Matrix;
    ArrayList<ArrayList<String>> String_Path_Matrix;

    public void count_paths(){

      //  Hop_Matrix = new ArrayList<ArrayList<Integer>> (  );
        String_Path_Matrix = new ArrayList<ArrayList<String>> (  );
        Integer V = Path_Matrix.size ();

        for(int k =0 ; k <  Path_Matrix.size()  ; k++){

            Path_list = new ArrayList<String> (  );
            for(int w = 0 ; w < Path_Matrix.size () ; w++){
                Path_list.add ( "" );
            }
            for(int i = 0 ;  i < Path_Matrix.size () ; i++){

                int src = k;
                if(i != src){
                    Integer j = i;
                    int hop = 0;
                    do{

                        StringBuilder x = new StringBuilder ();

                        j = Path_Matrix.get ( k ).get ( j );
                        x.append ( " ===> " + j.toString () );
                        x.append ( Path_list.get ( i ) );
                        Path_list.set ( i, x.toString () );
                    }while (j != src);
            //        Hop_list.add ( hop );
                    hop = 0;
                } else {

                  //  Hop_list.add ( 0 );
                }
            }

      //      Hop_Matrix.add ( Hop_list );
            String_Path_Matrix.add ( Path_list );

        }
    }
    public void counthop(){

        Hop_Matrix = new ArrayList<ArrayList<Integer>> (  );
        for(int k = 0 ;  k < Path_Matrix.size () ; k++){ // for each vertex
            Hop_list = new ArrayList<Integer> (  );
            int src = k;
            for(int i = 0 ;  i < Path_Matrix.size () ; i++){

                if(i != src){
                    Integer j = i;
                    int hop = 0;
                    do{

                        j = Path_Matrix.get ( k ).get ( j );
                    hop += 1;
                    }while (j != src);
                    Hop_list.add ( hop );
                    hop = 0;
                } else {

                    Hop_list.add ( 0 );
                }
            }

            Hop_Matrix.add ( Hop_list );

            }

        }


    public void count_paths2(){
        Hop_Matrix = new ArrayList<ArrayList<Integer>> (  );
        String_Path_Matrix = new ArrayList<ArrayList<String>> (  );

        Integer V = Distance_Matrix.size ();

        for(int k = 0 ; k < Distance_Matrix.size () ; k++) {
            Hop_list = new ArrayList<Integer> (  );
            Integer src = k;
            Path_list = new ArrayList<String> (  );
            for(int w = 0 ; w < Path_Matrix.size () ; w++){
                Path_list.add ( "" );
            }


            for (Integer i = 0; i < V; i++) {

                //   Path_list = new ArrayList<String> (  );
                //    for(int t = 0 ; t < Distance_Matrix.size () ; t++){
                //        Path_list.add ( "" );
                //     }
                if (i != src) {
                    Integer j;

                    j = i;
                    int hop = 0;
                    do {
                        StringBuilder x = new StringBuilder ();

                        j = Path_Matrix.get ( k ).get ( j );
                        x.append ( " ===> " + j.toString () );
                        x.append ( Path_list.get ( i ) );
                        Path_list.set ( i, x.toString () );
                        //    String x = "==>" + j.toString ();
                        //      String y = Path_list.get ( i );
                        //      StringBuilder xy = new StringBuilder (  );
                        //      xy.append ( x ).append ( y );
                        //      Path_list.set ( i , xy.toString () );
                        hop++;

                    } while (j != src);
                    Hop_list.add ( hop );
                    hop = 0;
                } else {

                    Hop_list.add ( 0 );
                }
            }
            Hop_Matrix.add ( Hop_list );
            String_Path_Matrix.add ( Path_list );
        }
    }
    public void print_paths (ArrayList<ArrayList<String>> M) throws FileNotFoundException {   // tylko sposob wypisywania
        ArrayList<ArrayList<Integer>> wartosci = new ArrayList<ArrayList<Integer>> (  );
        ArrayList<ArrayList<Integer>> wartosci2 = new ArrayList<ArrayList<Integer>> (  );
        ArrayList<Integer> wiersz;
        ArrayList<Integer> maxymalne = new ArrayList<Integer> (  );
        System.out.println ("\n\t");
        System.out.print ("\t");
        for(Integer i = 0 ; i < M.size () ; i++){
            wiersz = new ArrayList<Integer> (  );
            for(Integer j = 0 ; j < M.size () ; j++){
                wiersz.add ( M.get ( i ).get ( j ).length () );
            }
            wartosci.add ( wiersz );
            wartosci2.add ( wiersz );
        }
        for(Integer i = 0 ; i < M.size () ; i++) {

            for (Integer j = 0; j < M.size (); j++) {
                wartosci2.get ( i  ).set ( j , wartosci.get(j).get ( i ) );
            }
        }
        for(Integer i = 0 ; i < M.size () ; i++) {
            maxymalne.add ( Collections.max ( wartosci2.get ( i ) ) );
        }
        ArrayList<String> odstep = new ArrayList<String > (  );
        String spacja = " ";
        try {
            CleanFile.clean ( "trasy3.txt" );
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        }

        for(Integer i =0 ; i< M.size () ; i++ ){

            //   System.out.print (i + (String.join("", Collections.nCopies(maxymalne.get ( i ), " "))));
            //    System.out.print("\t");
            FileWrite.writefile ( i.toString () + String.join("", Collections.nCopies(maxymalne.get ( i ), " ")) + "\t" , "trasy3.txt" );


        }
        //  System.out.println ();
        FileWrite.writefile ( "\n"  , "trasy3.txt");
        for(int i = 0 ; i < 23 ; i ++) {
            //     System.out.print ("-");
            FileWrite.writefile ( "-" , "trasy3.txt" );
        }
        //    System.out.println ();
        FileWrite.writefile ( "\n"  , "trasy3.txt");

        for(Integer i = 0 ; i  < M.size () ; i++){
            //   System.out.print (i + "|\t");
            FileWrite.writefile ( i.toString () + "|\t" , "trasy3.txt" );
            for(int j = 0 ; j < M.size () ; j++){
                if(i == j) {
                    //      System.out.print ( "-" );
                    FileWrite.writefile ( "-"  , "trasy3.txt");
                }
                else {
                    //       System.out.print ( M.get ( i ).get ( j ) );
                    FileWrite.writefile ( M.get ( i ).get ( j ).toString ()  , "trasy3.txt");
                }
                //   System.out.print(String.join("", Collections.nCopies(maxymalne.get ( j ) - M.get ( i ).get ( j ).length () + 2, " ")));
                FileWrite.writefile ( String.join("", Collections.nCopies(maxymalne.get ( j ) - M.get ( i ).get ( j ).length () + 2, " ")) , "trasy3.txt");

            }
            //   System.out.println ("\n");
            FileWrite.writefile ( "\n"  , "trasy3.txt");

        }
        //   System.out.println ("\n");
        FileWrite.writefile ( "\n"  , "trasy3.txt");
    }
    public String converter(int val, int xLength){
        int x = val % xLength;
        int y = val / xLength;
        String temp = "(" + x + "," + y + ")";
        return temp;
    }
    public void choose_the_shortest(int xLength, ArrayList<Integer> v , ArrayList<ArrayList<Integer>> M ){

        ArrayList<OurMap> ways = new ArrayList<>(); // potrzebuje stworzyć bo chce duplikaty i dodawanie po koleji
        Integer lengthOfRoute = 0;
        Integer hopsOfRoute = 0;
        String lengthName;


        for(int i = 0; i< v.size(); i++){
            for (int j = 0;j< v.size(); j++){
                if(j != i ){
                    for (int k = 0;k< v.size();k++){
                        if(k != j && k!= i) {
                            for (int r = 0; r < v.size(); r++) {
                                if(r != i && r!= j && r != k) {
                                    for (int l = 0; l < v.size(); l++) {
                                        if(l != i && l != j && l != k && l != r) {
                                            hopsOfRoute = Hop_Matrix.get(0).get(v.get(i)) + Hop_Matrix.get(v.get(i)).get(v.get(j)) + Hop_Matrix.get(v.get(j)).get(v.get(k)) + Hop_Matrix.get(v.get(k)).get(v.get(r)) + Hop_Matrix.get(v.get(r)).get(v.get(l)) + Hop_Matrix.get(v.get(l)).get(0) ;
                                            lengthOfRoute = M.get(0).get(v.get(i)) + M.get(v.get(i)).get(v.get(j)) + M.get(v.get(j)).get(v.get(k)) + M.get(v.get(k)).get(v.get(r)) + M.get(v.get(r)).get(v.get(l)) + M.get(v.get(l)).get(0);
                                            lengthName = "0 -> " + converter(v.get(i),xLength) + " -> " + converter(v.get(j),xLength) + " -> " + converter(v.get(k),xLength) + " -> " + converter(v.get(r),xLength) + " -> " + converter(v.get(l),xLength) + " -> 0";
                                            ways.add(new OurMap(lengthOfRoute, hopsOfRoute, lengthName));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        OurMap shortestWay = ways.get(0);
        for(OurMap o : ways){
            if(shortestWay.getKey() > o.getKey()){
                shortestWay = o;
            }
            //shortestWay.printMap();
            //o.printMap();
        }
        shortestWay.printMap();



    }

    public ArrayList<ArrayList<Integer>> conv_to_inf(ArrayList<ArrayList<Integer>> M) {

        for(Integer i = 0 ; i < M.size () ; i++){
            for (Integer j = 0 ; j < M.size () ; j++){
                if(i != j){
                    if(M.get ( i ).get ( j ) == 0){
                        M.get ( i ).set ( j , INF );
                    }
                }
            }
        }

        return M;
    }

    public static void main(String[] args) throws FileNotFoundException {

        Floyyd floyyd = new Floyyd ();
        floyyd.floyd ( floyyd.alokuj () );
        System.out.println ("Distance");
        floyyd.print ( floyyd.Distance_Matrix );
        System.out.println ("Path");
        floyyd.print ( floyyd.Path_Matrix );
        floyyd.count_paths ();
        System.out.println ("Hop");
        floyyd.print ( floyyd.Hop_Matrix );
        //floyyd.printuj ( floyyd.Hop_Matrix );
        System.out.println ("Path Matrix");
        floyyd.printuj ( floyyd.String_Path_Matrix );
        floyyd.print_paths ( floyyd.String_Path_Matrix );

    }
}
