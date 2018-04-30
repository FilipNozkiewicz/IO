import java.util.ArrayList;

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

        M.add (0, zero);
        M.add (1, first);
        M.add ( 2,second);
        M.add (3,third);
        M.add (4,fourth);


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
    public ArrayList<ArrayList<Integer>> Floyd(ArrayList<ArrayList<Integer>> M){ // algorytm 3 petle

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
        floyd_arraylist.alloc ( 5 );
        floyd_arraylist.print ( floyd_arraylist.M);
        System.out.println ();
        System.out.println ("Shortest Path Matrix");
        floyd_arraylist.startPath ( 5 );
        floyd_arraylist.print ( floyd_arraylist.Floyd ( floyd_arraylist.M ) );
        System.out.println ("Path Matrix");
        floyd_arraylist.print ( floyd_arraylist.P );

    }
}
