import java.sql.Array;
import java.util.ArrayList;

public class Testowa {

    public ArrayList<ArrayList<Integer>> matrix;

    public ArrayList<ArrayList<Integer>> alokuj(){
        matrix = new ArrayList<ArrayList<Integer>> (  );

        ArrayList<Integer> zero = new ArrayList<Integer> ( 5 );
        ArrayList<Integer> first = new ArrayList<Integer> ( 5 );
        ArrayList<Integer> second = new ArrayList<Integer> ( 5 );
        ArrayList<Integer> third = new ArrayList<Integer> ( 5 );
        ArrayList<Integer> fourth = new ArrayList<Integer> ( 5 );

       zero.add ( 0 );
       zero.add ( 10 );
       zero.add ( 0 );
       zero.add ( 30 );
       zero.add ( 100 );

       first.add ( 10 );
       first.add ( 0 );
       first.add ( 50 );
       first.add ( 0 );
       first.add ( 0 );

       second.add ( 0 );
       second.add ( 50 );
       second.add ( 0 );
       second.add ( 20 );
       second.add ( 10 );

       third.add ( 30 );
       third.add ( 0 );
       third.add ( 20 );
       third.add ( 0 );
       third.add ( 60 );

       fourth.add ( 100 );
       fourth.add ( 0 );
       fourth.add ( 10 );
       fourth.add ( 60 );
       fourth.add ( 0 );

      matrix.add (0, zero);
      matrix.add (1, first);
      matrix.add ( 2,second);
      matrix.add (3,third);
      matrix.add (4,fourth);

      return matrix;
    }
    public static void main(String[] args){

        Testowa testowa = new Testowa ();
        testowa.alokuj ();

       Dijkstra_Proper dijkstra_proper = new Dijkstra_Proper ();

       for(ArrayList<Integer> x: testowa.alokuj ()){
           for(Integer  y : x){
               System.out.print (y + "\t");
           }
           System.out.println ();
       }

       dijkstra_proper.dijkstra ( testowa.alokuj () );


       dijkstra_proper.print_distance ();

        dijkstra_proper.print_path ();

  /*  ArrayList<ArrayList<Integer>> ar = new ArrayList<ArrayList<Integer>> ( 2 );
        ArrayList<Integer> zero = new ArrayList<Integer> ( 2 );
        ArrayList<Integer> first = new ArrayList<Integer> ( 2 );

        zero.add ( 2 );
        zero.add ( 2 );

        first.add ( 2 );
        first.add ( 2 );

        ar.add ( zero );
        ar.add ( first );

        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 2 ; j++){
                if(ar.get ( i ).get ( j ) == 2){
                    ar.get ( i ).set ( j , 33 );
                }
            }
        }


        for(ArrayList<Integer> x: ar){
            for(Integer  y : x){
                System.out.print (y + "\t");
            }
            System.out.println ();
        }*/

    }


}
