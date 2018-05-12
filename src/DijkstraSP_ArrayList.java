

import java.util. *;
import java.lang. *;
import java.io. *;

public class DijkstraSP_ArrayList {


    int V = 9;
    ArrayList<ArrayList<Integer>> Matrix_Distance;
    ArrayList<Integer> Distance;
    public void create(){
        Matrix_Distance = new ArrayList<ArrayList<Integer>> (  );
    }

    Integer minDistance(ArrayList<Integer> dist, ArrayList<Boolean> stpSet) {

        //  dist = new ArrayList<Integer> ( V );
        //stpSet = new ArrayList<Boolean> ( V );
        Integer min = Integer.MAX_VALUE;
        Integer min_index = -1;

        for (int v = 0; v < V; v++) {
            if (stpSet.get ( v ) == false && dist.get ( v ) <= min) {

                min = dist.get ( v );
                min_index = v;
            }
        }
        return min_index;
    }
    public DijkstraSP_ArrayList(Integer V){
        this.V = V;
    }
    public DijkstraSP_ArrayList(){

    }
    void printSolution(ArrayList<Integer> dist, Integer n) {

        System.out.println ( "Vertex   Distance from Source" );
        for (int i = 0; i < dist.size (); i++) {

            System.out.println ( i + "===>" + dist.get ( i ) );
        }
    }
    void dijkstra(ArrayList<ArrayList<Integer>> graph , Integer src){


        ArrayList<Integer> dist = new ArrayList<Integer> ( V );
        ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>> ( V );
        ArrayList<Boolean> stpSet = new ArrayList<Boolean> ( V );
        ArrayList<Integer> ancestor = new ArrayList<> ( V );

        for (int i = 0 ; i < V ; i++){

            dist.add (  Integer.MAX_VALUE );
            stpSet.add (  false );
            path.add ( new ArrayList<Integer> (  ) );
            ancestor.add ( src );

        }
     //   ancestor.set ( src , src );

        dist.set ( src , 0 );

        for(int i = 0 ; i < V  ; i++){  // optymalzacja - 1

            Integer u = minDistance ( dist , stpSet); // znajduje wierzcholek o najmnieszej sciezce do niego
            stpSet.set ( u , true ); // odwiedzono

            for (int  v = 0 ;  v < V  ; v++){

                if(!stpSet.get ( v ) && graph.get ( u ).get ( v ) != 0
                        && dist.get ( u ) != Integer.MAX_VALUE &&
                        dist.get ( u ) + graph.get ( u ).get ( v ) < dist.get ( v )){
                    dist.set ( v , dist.get ( u ) + graph.get ( u ).get ( v ) );
                    ancestor.set ( v , u );
                }
            }
        }

        printSolution ( dist , V );

        System.out.println ();
       // Collections.reverse ( ancestor );
        for (int i = 0 ; i < V ;  i++) {
            if (i != src){
                int j;
            System.out.println ( "Path = " + i );
            j = i;
            int hop = 0;
            do {
                j = ancestor.get ( j );
                System.out.print ( "==>" + j );
                hop++;

            } while (j != src);
            System.out.println ();
            System.out.print ( "Ilosc hopow " + hop );
            System.out.println ();
            hop = 0;
            }
            else{
                System.out.println ( "Path = " + i );

                System.out.print ( "Ilosc hopow " + 0 );
                System.out.println ();
            }
        }
    }
    ArrayList<ArrayList<Integer>> Hop_Matrix;
    ArrayList<ArrayList<String>> Path_Matrix;
    ArrayList<Integer> Hop_list;
    ArrayList<String> Path_list;

    public ArrayList<Integer> Dijkstra_With_Return(ArrayList<ArrayList<Integer>> graph , Integer src){
        ArrayList<Integer> dist = new ArrayList<Integer> ( V );
        ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>> ( V );
        ArrayList<Boolean> stpSet = new ArrayList<Boolean> ( V );
        ArrayList<Integer> ancestor = new ArrayList<> ( V );
        Hop_list = new ArrayList<Integer> (  );
        Path_list = new ArrayList<String> (  );

        for (int i = 0 ; i < V ; i++){

            dist.add (  Integer.MAX_VALUE );
            stpSet.add (  false );
            path.add ( new ArrayList<Integer> (  ) );
            ancestor.add ( src );
            Path_list.add ( "" );
        }
        //   ancestor.set ( src , src );

        dist.set ( src , 0 );

        for(int i = 0 ; i < V  ; i++){  // optymalzacja - 1

            Integer u = minDistance ( dist , stpSet); // znajduje wierzcholek o najmnieszej sciezce do niego
            stpSet.set ( u , true ); // odwiedzono

            for (int  v = 0 ;  v < V  ; v++){

                if(!stpSet.get ( v ) && graph.get ( u ).get ( v ) != 0
                        && dist.get ( u ) != Integer.MAX_VALUE &&
                        dist.get ( u ) + graph.get ( u ).get ( v ) < dist.get ( v )){
                    dist.set ( v , dist.get ( u ) + graph.get ( u ).get ( v ) );
                    ancestor.set ( v , u );
                }
            }
        }
        for (Integer i = 0 ; i < V ;  i++) {
            if (i != src){
                Integer j;

                j = i;
                int hop = 0;
                do {
                    StringBuilder x = new StringBuilder();

                    j = ancestor.get ( j );
                    x.append ( " ===> " + j.toString () );
                    x.append(Path_list.get ( i ));
                   Path_list.set ( i , x.toString ());
                //    String x = "==>" + j.toString ();
              //      String y = Path_list.get ( i );
              //      StringBuilder xy = new StringBuilder (  );
              //      xy.append ( x ).append ( y );
              //      Path_list.set ( i , xy.toString () );
                    hop++;

                } while (j != src);
                Hop_list.add ( hop );
                hop = 0;
            }
            else{

                Hop_list.add ( 0 );
            }
        }
        return dist;

    }
    ArrayList<ArrayList<Integer>>  Fulfill_Distance_Matrix(ArrayList<ArrayList<Integer>> graph){
        Matrix_Distance = new ArrayList<ArrayList<Integer>> (  );
        Hop_Matrix = new ArrayList<ArrayList<Integer>> (  );
        Path_Matrix = new ArrayList<ArrayList<String>> (  );
        for(int i = 0 ; i < V ; i++){
          Distance = Dijkstra_With_Return ( graph , i );
          Matrix_Distance.add ( Distance );
          Hop_Matrix.add ( Hop_list );
          Path_Matrix.add ( Path_list );
        }
        return Matrix_Distance;
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
    public void print_paths (ArrayList<ArrayList<String>> M){   // tylko sposob wypisywania

        System.out.println ("\n\t");
        System.out.print ("\t");
        for(int i =0 ; i< M.size () ; i++ ){
            System.out.print (i + "|\t" +"\t\t\t");
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
    public void choose_the_shortest( ArrayList<Integer> v , ArrayList<ArrayList<Integer>> M){

        ArrayList<OurMap> ways = new ArrayList<>(); // potrzebuje stworzyć bo chce duplikaty i dodawanie po koleji
        Integer lengthOfRoute = 0;
        Integer hopsOfRoute = 0;
        String lengthName;

        Fulfill_Distance_Matrix ( M );
        System.out.println(Hop_Matrix);
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
                                            lengthName = "0 -> " + String.valueOf(v.get(i)) + " -> " + String.valueOf(v.get(j)) + " -> " + String.valueOf(v.get(k)) + " -> " + String.valueOf(v.get(r)) + " -> " + String.valueOf(v.get(l)) + " -> 0";
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

    ArrayList<ArrayList<Integer>> alokuj(){

        ArrayList<ArrayList<Integer>> M  = new ArrayList<ArrayList<Integer>> ( V );
        ArrayList<Integer> zero = new ArrayList<> ( 9 );
        ArrayList<Integer> one = new ArrayList<> ( 9 );
        ArrayList<Integer> two = new ArrayList<> ( 9 );
        ArrayList<Integer> three = new ArrayList<> ( 9 );
        ArrayList<Integer> four = new ArrayList<> ( 9 );
        ArrayList<Integer> five = new ArrayList<> ( 9 );
        ArrayList<Integer> six = new ArrayList<> ( 9 );
        ArrayList<Integer> seven = new ArrayList<> ( 9 );
        ArrayList<Integer> eight = new ArrayList<> ( 9 );


        zero.add ( 0 );
        zero.add ( 4 );
        zero.add ( 0 );
        zero.add ( 0 );
        zero.add ( 0 );
        zero.add ( 0 );
        zero.add ( 0 );
        zero.add ( 8 );
        zero.add ( 0 );

        one.add ( 4 );
        one.add ( 0 );
        one.add ( 8 );
        one.add ( 0 );
        one.add ( 0 );
        one.add ( 0 );
        one.add ( 0 );
        one.add ( 11 );
        one.add ( 0 );

        two.add ( 0 );
        two.add ( 8 );
        two.add ( 0 );
        two.add ( 7 );
        two.add ( 0 );
        two.add ( 4 );
        two.add ( 0 );
        two.add ( 0 );
        two.add ( 2 );

        three.add ( 0 );
        three.add ( 0 );
        three.add ( 7 );
        three.add ( 0 );
        three.add ( 9 );
        three.add ( 14 );
        three.add ( 0 );
        three.add ( 0 );
        three.add ( 0 );

        four.add ( 0 );
        four.add ( 0 );
        four.add ( 0 );
        four.add ( 9 );
        four.add ( 0 );
        four.add ( 10 );
        four.add ( 0 );
        four.add ( 0 );
        four.add ( 0 );

        five.add ( 0 );
        five.add ( 0 );
        five.add ( 4 );
        five.add ( 14 );
        five.add ( 10);
        five.add ( 0 );
        five.add ( 2 );
        five.add ( 0 );
        five.add ( 0 );

        six.add ( 0 );
        six.add ( 0 );
        six.add ( 0 );
        six.add ( 0 );
        six.add ( 0 );
        six.add ( 2 );
        six.add ( 0 );
        six.add ( 1 );
        six.add ( 6 );

        seven.add ( 8 );
        seven.add ( 11 );
        seven.add ( 0 );
        seven.add ( 0 );
        seven.add ( 0 );
        seven.add ( 0 );
        seven.add ( 1 );
        seven.add ( 0 );
        seven.add ( 7 );

        eight.add ( 0 );
        eight.add ( 0 );
        eight.add ( 2 );
        eight.add ( 0 );
        eight.add ( 0 );
        eight.add ( 0 );
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
    public static void main(String[] args){

        DijkstraSP_ArrayList dijkstraSP_arrayList = new DijkstraSP_ArrayList ();
        System.out.println ();
        System.out.println ("---------------------------------Distance Matrix-----------------------------------------------------------------------------------");
        dijkstraSP_arrayList.print ( dijkstraSP_arrayList.Fulfill_Distance_Matrix ( dijkstraSP_arrayList.alokuj () ) );
        System.out.println ();
        System.out.println ("--------------------------------------Hop Matrix-----------------------------------------------------------------------------------");
        dijkstraSP_arrayList.print ( dijkstraSP_arrayList.Hop_Matrix );
        System.out.println ();
        System.out.println ("-------------------------------------Path Matrix-----------------------------------------------------------------------------------");
        dijkstraSP_arrayList.print_paths ( dijkstraSP_arrayList.Path_Matrix );
    }
}