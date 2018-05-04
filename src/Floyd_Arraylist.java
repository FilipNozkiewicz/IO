import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Floyd_Arraylist {


    ArrayList<ArrayList<Integer>> P;
    ArrayList<ArrayList<Integer>> M;
    // ustawiam macierz sciezek jak na filmie
    public void startPath(Integer N){
        P = new ArrayList<ArrayList<Integer>> ( N );

       for(int i = 0 ; i < N ;  i++){
           P.add ( new ArrayList<Integer> (  ) );
           for(int j = 0 ; j < N ; j++){
               P.get ( i ).add ( 0 );
           }
       }
       for(int i = 0 ; i < P.size () ; i++){
           for(int j  = 0; j < P.size() ; j++){
               if( i != j){
                   P.get ( i ).set ( j , j );
               }
           }
        }

    }
    // biore se przykladowa maciuerz do testow
    public void alloc(Integer N){

        P = new ArrayList<ArrayList<Integer>> ( N );
        M = new ArrayList<ArrayList<Integer>> ( N );

        ArrayList<Integer> zero = new ArrayList<Integer> ( N );
        ArrayList<Integer> first = new ArrayList<Integer> ( N );
        ArrayList<Integer> second = new ArrayList<Integer> ( N );
        ArrayList<Integer> third = new ArrayList<Integer> ( N );
        ArrayList<Integer> fourth = new ArrayList<Integer> ( N );

        zero.add ( 0 );
        zero.add ( 5 );
        zero.add ( 1 );
        zero.add ( 2 );
        //zero.add ( 100 );

        first.add ( 5 );
        first.add ( 0 );
        first.add ( 3 );
        first.add ( 999 );
        //first.add ( 0 );

        second.add ( 1 );
        second.add ( 3 );
        second.add ( 0 );
        second.add ( 4 );
        //second.add ( 10 );

        third.add ( 2 );
        third.add ( 999 );
        third.add ( 4 );
        third.add ( 0 );
        //third.add ( 60 );

        fourth.add ( 100 );
        fourth.add ( 0 );
        fourth.add ( 10 );
        fourth.add ( 60 );
        fourth.add ( 0 );

        M.add (0, zero);
        M.add (1, first);
        M.add ( 2,second);
        M.add (3,third);
        //M.add (4,fourth);


    }

    public ArrayList<ArrayList<Integer>> infinity(ArrayList<ArrayList<Integer>> M){

        for(int i = 0 ; i < M.size () ; i++){
            for(int j = 0 ; j < M.size () ; j++){
                if((i != j) && M.get ( i ).get ( j ) == 0){
                    M.get ( i ).set ( j , 999 );
                }
            }
        }

        return M;
    }
    //// MINIMALNA SCIEZKA ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void choose_the_shortest( Integer v1 , Integer v2 , Integer v3 , ArrayList<ArrayList<Integer>> M){

        ArrayList<Integer> kombinacje = new ArrayList<Integer> ( 6 );
        HashMap<Integer , String> mapa = new HashMap<Integer, String> (6  );

        try {
            Integer startvalue = M.get ( 0 ).get ( 0 );
            Integer v0_v1 = M.get(0).get ( v1 );
            Integer v0_v2 = M.get(0).get ( v2 ) ;
            Integer v0_v3 = M.get(0).get ( v3 ) ;
            Integer v1_v2 = M.get(v1).get ( v2 );
            Integer v1_v3 = M.get(v1).get ( v3 ) ;
            Integer v2_v3 = M.get(v2).get ( v3 );

            String mapa_kombinacji_1 = "(" + "0,0" + ")--->" + "(" + "0" + "," + v1.toString () + ")--->" + "(" + v1.toString () + "," + v2.toString () + ")--->" +
                    "(" + v2.toString () + "," + v3.toString () + ")--->" + "(" + v3.toString () + ",0) = "
                    + " 0-->"+ v1.toString () +"-->"+ v2.toString () + "-->"+v3.toString () + "-->0" ;
            String mapa_kombinacji_2 = "(" + "0,0" + ")--->" + "(" + "0" + "," + v1.toString () + ")--->" + "(" + v1.toString () + "," + v3.toString () + ")--->" +
                    "(" + v3.toString () + "," + v2.toString () + ")--->" + "(" + v2.toString () + ",0) = "
                    + " 0-->"+ v1.toString () +"-->"+ v3.toString () + "-->"+v2.toString ()  + "-->0" ;
            String mapa_kombinacji_3 = "(" + "0,0" + ")--->" + "(" + "0" + "," + v2.toString () + ")--->" + "(" + v2.toString () + "," + v1.toString () + ")--->" +
                    "(" + v1.toString () + "," + v3.toString () + ")--->" + "(" + v3.toString () + ",0) = "
                    + " 0-->"+ v2.toString () +"-->"+ v1.toString () + "-->"+v3.toString () + "-->0"  ;
            String mapa_kombinacji_4 = "(" + "0,0" + ")--->" + "(" + "0" + "," + v2.toString () + ")--->" + "(" + v2.toString () + "," + v3.toString () + ")--->" +
                    "(" + v3.toString () + "," + v1.toString () + ")--->" + "(" + v1.toString () + ",0) = "
                    + " 0-->"+ v2.toString () +"-->"+ v3.toString () + "-->"+v1.toString () + "-->0";
            String mapa_kombinacji_5 = "(" + "0,0" + ")--->" + "(" + "0" + "," + v3.toString () + ")--->" + "(" + v3.toString () + "," + v2.toString () + ")--->" +
                    "(" + v2.toString () + "," + v1.toString () + ")--->" + "(" + v1.toString () + ",0) = "
                    + " 0-->"+ v3.toString () +"-->"+ v2.toString () + "-->"+v1.toString () + "-->0" ;
            String mapa_kombinacji_6 = "(" + "0,0" + ")--->" + "(" + "0" + "," + v3.toString () + ")--->" + "(" + v3.toString () + "," + v1.toString () + ")--->" +
                    "(" + v1.toString () + "," + v2.toString () + ")--->" + "(" + v2.toString () + ",0) = "
                    + " 0-->"+ v3.toString () +"-->"+ v1.toString () + "-->"+v2.toString () + "-->0" ;

            Integer komb1 = v0_v1 + v1_v2 + v2_v3 + v0_v3;
            Integer komb2 = v0_v1 + v1_v3 + v2_v3 + v0_v2;
            Integer komb3 = v0_v2 + v1_v2 + v1_v3 + v0_v3;
            Integer komb4 = v0_v2 + v2_v3 + v1_v3 + v0_v1;
            Integer komb5 = v0_v3 + v2_v3 + v1_v2 + v0_v1;
            Integer komb6 = v0_v3 + v1_v3 + v1_v2 + v0_v2;


            mapa.put ( komb1 , mapa_kombinacji_1 );
            mapa.put ( komb2 , mapa_kombinacji_2 );
            mapa.put ( komb3 , mapa_kombinacji_3 );
            mapa.put ( komb4 , mapa_kombinacji_4 );
            mapa.put ( komb5 , mapa_kombinacji_5 );
            mapa.put ( komb6 , mapa_kombinacji_6 );

            Integer min = Collections.min ( mapa.keySet () );
            Object value = mapa.get ( min );
            System.out.println ();
            System.out.println ("Minimum Path");
            System.out.println ("Value " + min );
            System.out.println (value);



        }catch (IndexOutOfBoundsException e){
            System.out.println ("Index out of bound exception");
        }
    }
    public void choose_the_shortest( ArrayList<Integer> v , ArrayList<ArrayList<Integer>> M){
        Integer v1 = v.get(0) ;
        Integer v2 = v.get(1) ;
        Integer v3 = v.get(2);
        ArrayList<Integer> kombinacje = new ArrayList<Integer> ( 6 );
        HashMap<Integer , String> mapa = new HashMap<Integer, String> (6  );

        try {
            Integer startvalue = M.get ( 0 ).get ( 0 );
            Integer v0_v1 = M.get(0).get ( v1 );
            Integer v0_v2 = M.get(0).get ( v2 ) ;
            Integer v0_v3 = M.get(0).get ( v3 ) ;
            Integer v1_v2 = M.get(v1).get ( v2 );
            Integer v1_v3 = M.get(v1).get ( v3 ) ;
            Integer v2_v3 = M.get(v2).get ( v3 );

            String mapa_kombinacji_1 = "(" + "0,0" + ")--->" + "(" + "0" + "," + v1.toString () + ")--->" + "(" + v1.toString () + "," + v2.toString () + ")--->" +
                    "(" + v2.toString () + "," + v3.toString () + ")--->" + "(" + v3.toString () + ",0) = "
                    + " 0-->"+ v1.toString () +"-->"+ v2.toString () + "-->"+v3.toString () + "-->0" ;
            String mapa_kombinacji_2 = "(" + "0,0" + ")--->" + "(" + "0" + "," + v1.toString () + ")--->" + "(" + v1.toString () + "," + v3.toString () + ")--->" +
                    "(" + v3.toString () + "," + v2.toString () + ")--->" + "(" + v2.toString () + ",0) = "
                    + " 0-->"+ v1.toString () +"-->"+ v3.toString () + "-->"+v2.toString ()  + "-->0" ;
            String mapa_kombinacji_3 = "(" + "0,0" + ")--->" + "(" + "0" + "," + v2.toString () + ")--->" + "(" + v2.toString () + "," + v1.toString () + ")--->" +
                    "(" + v1.toString () + "," + v3.toString () + ")--->" + "(" + v3.toString () + ",0) = "
                    + " 0-->"+ v2.toString () +"-->"+ v1.toString () + "-->"+v3.toString () + "-->0"  ;
            String mapa_kombinacji_4 = "(" + "0,0" + ")--->" + "(" + "0" + "," + v2.toString () + ")--->" + "(" + v2.toString () + "," + v3.toString () + ")--->" +
                    "(" + v3.toString () + "," + v1.toString () + ")--->" + "(" + v1.toString () + ",0) = "
                    + " 0-->"+ v2.toString () +"-->"+ v3.toString () + "-->"+v1.toString () + "-->0";
            String mapa_kombinacji_5 = "(" + "0,0" + ")--->" + "(" + "0" + "," + v3.toString () + ")--->" + "(" + v3.toString () + "," + v2.toString () + ")--->" +
                    "(" + v2.toString () + "," + v1.toString () + ")--->" + "(" + v1.toString () + ",0) = "
                    + " 0-->"+ v3.toString () +"-->"+ v2.toString () + "-->"+v1.toString () + "-->0" ;
            String mapa_kombinacji_6 = "(" + "0,0" + ")--->" + "(" + "0" + "," + v3.toString () + ")--->" + "(" + v3.toString () + "," + v1.toString () + ")--->" +
                    "(" + v1.toString () + "," + v2.toString () + ")--->" + "(" + v2.toString () + ",0) = "
                    + " 0-->"+ v3.toString () +"-->"+ v1.toString () + "-->"+v2.toString () + "-->0" ;

            Integer komb1 = v0_v1 + v1_v2 + v2_v3 + v0_v3;
            Integer komb2 = v0_v1 + v1_v3 + v2_v3 + v0_v2;
            Integer komb3 = v0_v2 + v1_v2 + v1_v3 + v0_v3;
            Integer komb4 = v0_v2 + v2_v3 + v1_v3 + v0_v1;
            Integer komb5 = v0_v3 + v2_v3 + v1_v2 + v0_v1;
            Integer komb6 = v0_v3 + v1_v3 + v1_v2 + v0_v2;


            mapa.put ( komb1 , mapa_kombinacji_1 );
            mapa.put ( komb2 , mapa_kombinacji_2 );
            mapa.put ( komb3 , mapa_kombinacji_3 );
            mapa.put ( komb4 , mapa_kombinacji_4 );
            mapa.put ( komb5 , mapa_kombinacji_5 );
            mapa.put ( komb6 , mapa_kombinacji_6 );

            Integer min = Collections.min ( mapa.keySet () );
            Object value = mapa.get ( min );
            System.out.println ();
            System.out.println ("Minimum Path");
            System.out.println ("Value " + min );
            System.out.println (value);



        }catch (IndexOutOfBoundsException e){
            System.out.println ("Index out of bound exception");
        }
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
    public ArrayList<ArrayList<Integer>> floyd(ArrayList<ArrayList<Integer>> M){ // algorytm 3 petle

        for(int k = 0 ; k < M.size () ; k++){
            for (int i = 0 ; i < M.size () ; i++){
                for(int j = 0 ; j < M.size () ; j++){
                    if(M.get ( i ).get ( k ) + M.get ( k ).get ( j ) < M.get ( i ).get ( j )){ // pacze czy znaleziono dla danej iteracji mniejszy dystans
                        M.get ( i ).set ( j , M.get ( i ).get ( k ) + M.get ( k ).get ( j ) );
                        P.get ( i ).set ( j , k );     // jak tak to ustwiam go w macierzy M i macierzy sciezek P
                    }
                }
            }
        }

        return M;   // zwracam przetworzona macierz
    }

    public static void main(String[] args){   // poszczegolne wywolania
        Floyd_Arraylist floyd_arraylist = new Floyd_Arraylist ();
        System.out.println ();
        System.out.println ("Adjacencies Matrix");
        floyd_arraylist.alloc ( 4 );
        floyd_arraylist.print ( floyd_arraylist.M);
        System.out.println ();
        System.out.println ("Shortest Path Matrix");
        floyd_arraylist.startPath ( 4 );
        floyd_arraylist.print ( floyd_arraylist.floyd ( floyd_arraylist.M ) );
        System.out.println ("Path Matrix");
        floyd_arraylist.print ( floyd_arraylist.P );

    }
}
