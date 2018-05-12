import java.util. *;
import java.lang. *;
import java.io. *;

public class DijkstraSP_ArrayList {

    int V = 9;

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

        dijkstraSP_arrayList.dijkstra ( dijkstraSP_arrayList.alokuj () , 3 );

    }
}