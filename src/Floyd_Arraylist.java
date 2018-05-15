import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Floyd_Arraylist {


    ArrayList<ArrayList<Integer>> P;
    ArrayList<ArrayList<Integer>> M;
    int hopCount;
    int costOfRoute;
    ArrayList<Integer> hops;
    // ustawiam macierz sciezek jak na filmie
    public void startPath(ArrayList<ArrayList<Integer>> M){
        Integer N = M.size ();
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


        M = new ArrayList<ArrayList<Integer>> ( N );

        ArrayList<Integer> zero = new ArrayList<Integer> ( N );
        ArrayList<Integer> first = new ArrayList<Integer> ( N );
        ArrayList<Integer> second = new ArrayList<Integer> ( N );
        ArrayList<Integer> third = new ArrayList<Integer> ( N );
        ArrayList<Integer> fourth = new ArrayList<Integer> ( N );
        ArrayList<Integer> fifth = new ArrayList<Integer> ( N );
        ArrayList<Integer> sixth = new ArrayList<Integer> ( N );
        ArrayList<Integer> seventh = new ArrayList<Integer> ( N );



        zero.add(0);
        zero.add(1);
        zero.add(4);
        zero.add(999);
        zero.add(999);
        zero.add(999);
        zero.add(999);
        zero.add(999);

        first.add ( 1 );
        first.add ( 0 );
        first.add ( 2 );
        first.add ( 5 );
        first.add ( 999 );
        first.add ( 999 );
        first.add ( 2 );
        first.add ( 7 );

        second.add ( 4 );
        second.add ( 2 );
        second.add ( 0 );
        second.add ( 999 );
        second.add ( 999 );
        second.add ( 999 );
        second.add ( 3 );
        second.add ( 999 );

        third.add ( 999 );
        third.add ( 5 );
        third.add ( 999 );
        third.add ( 0 );
        third.add ( 2 );
        third.add ( 999 );
        third.add ( 3 );
        third.add ( 999 );

        fourth.add ( 999 );
        fourth.add ( 999 );
        fourth.add ( 999 );
        fourth.add ( 2 );
        fourth.add ( 0 );
        fourth.add ( 4 );
        fourth.add ( 999 );
        fourth.add ( 999 );

        fifth.add ( 999 );
        fifth.add ( 999 );
        fifth.add ( 999 );
        fifth.add ( 999 );
        fifth.add ( 4 );
        fifth.add ( 0 );
        fifth.add ( 999 );
        fifth.add ( 2 );

        sixth.add ( 999 );
        sixth.add ( 2 );
        sixth.add ( 3 );
        sixth.add ( 3 );
        sixth.add ( 999 );
        sixth.add ( 999 );
        sixth.add ( 0 );
        sixth.add ( 5 );

        seventh.add ( 999 );
        seventh.add ( 7 );
        seventh.add ( 999 );
        seventh.add ( 999 );
        seventh.add ( 999 );
        seventh.add ( 2 );
        seventh.add ( 5 );
        seventh.add ( 0 );

        M.add ( zero );
        M.add ( first );
        M.add ( second );
        M.add ( third );
        M.add ( fourth );
        M.add ( fifth );
        M.add ( sixth );
        M.add ( seventh );
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


    public void choose_the_shortest( ArrayList<Integer> v , ArrayList<ArrayList<Integer>> M){

        ArrayList<OurMap> ways = new ArrayList<>(); // potrzebuje stworzyć bo chce duplikaty i dodawanie po koleji
        Integer lengthOfRoute = 0;
        Integer hopsOfRoute = 0;
        String lengthName;
        //System.out.println(P);
        for(int i = 0; i< v.size(); i++){
            for (int j = 0;j< v.size(); j++){
                if(j != i ){
                    for (int k = 0;k< v.size();k++){
                        if(k != j && k!= i) {
                            for (int r = 0; r < v.size(); r++) {
                                if(r != i && r!= j && r != k) {
                                    for (int l = 0; l < v.size(); l++) {
                                        if(l != i && l != j && l != k && l != r) {
                                            hopsOfRoute = hopCounter(0,v.get(i)) + hopCounter(v.get(i),v.get(j)) + hopCounter(v.get(j),v.get(k)) + hopCounter(v.get(k),v.get(r)) + hopCounter(v.get(r),v.get(l)) + hopCounter(v.get(l),0);
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
        for(OurMap o : ways) {
            if (shortestWay.getKey() > o.getKey()) {
                shortestWay = o;
            }
            //shortestWay.printMap();
            // o.printMap();}
        }
        shortestWay.printMap();
    }
    public String converter(int val, int xLength){
        int x = val % xLength;
        int y = val / xLength;
        String temp = "(" + x + "," + y + ")";
        return temp;
    }
    public void choose_the_shortest(int xLength, ArrayList<Integer> v , ArrayList<ArrayList<Integer>> M){

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
                                            //hopsOfRoute = hopCounter(0,v.get(i)) + hopCounter(v.get(i),v.get(j)) + hopCounter(v.get(j),v.get(k)) + hopCounter(v.get(k),v.get(r)) + hopCounter(v.get(r),v.get(l)) + hopCounter(v.get(l),0);
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
        for(OurMap o : ways) {
            if (shortestWay.getKey() > o.getKey()) {
                shortestWay = o;
            }
            //shortestWay.printMap();
            // o.printMap();}
        }
        shortestWay.printMap();
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

    public Integer printpaths(Integer src , Integer dest){

        System.out.println ();
        System.out.println ("Path from " + src + " to " + dest + " : ");
        Integer obecny_cel = P.get ( src ).get ( dest );
        Integer hop = 0;
        if(src != dest) {
            System.out.print ( src + " ==> " + obecny_cel );
            hop++;


            for (int i = 0; i < P.size (); i++) {
                for (int j = 0; j < P.size (); j++) {

                    if (obecny_cel != dest) {
                        do {
                            hop++;
                            obecny_cel = P.get ( obecny_cel ).get ( dest );
                            System.out.print ( " ==> " + obecny_cel );

                        } while (obecny_cel != dest);
                    } else {
                        break;
                    }

                }
            }
        }else{
            System.out.print ( src + " ==> " + dest );

        }
        System.out.println ();
        System.out.print ("Ilosc hopow : " + hop);
        return hop;
    }




    public int hopCounter(Integer src , Integer dest){
        Integer obecny_cel = P.get ( src ).get ( dest );
        Integer hop = 0;
        if(src != dest) {
            hop++;
            for (int i = 0; i < P.size (); i++) {
                for (int j = 0; j < P.size (); j++) {

                    if (obecny_cel != dest) {
                        do {
                            hop++;
                            obecny_cel = P.get(obecny_cel).get(dest);
                        } while (obecny_cel != dest);
                    } else {
                        break;
                    }
                }
            }
        }
        return hop;
    }

    public static void main(String[] args){   // poszczegolne wywolania
        Floyd_Arraylist floyd_arraylist = new Floyd_Arraylist ();
        System.out.println ();
        System.out.println ("Adjacencies Matrix");
        floyd_arraylist.alloc ( 8 );
        floyd_arraylist.print ( floyd_arraylist.M);
        System.out.println ();
        System.out.println ("Shortest Path Matrix");

        floyd_arraylist.startPath ( floyd_arraylist.M );
        floyd_arraylist.print ( floyd_arraylist.floyd ( floyd_arraylist.M ) );



        System.out.println ("Path Matrix");
        floyd_arraylist.print ( floyd_arraylist.P );
        floyd_arraylist.printpaths (  1 , 7);
        //floyd_arraylist.choose_the_shortest ( new ArrayList<Integer> (  ) ,floyd_arraylist.M );
        //   System.out.println (floyd_arraylist.count_path ( 0 , 5 ));

        // System.out.println (floyd_arraylist.count_path ( 5,2 ));
        //System.out.println (floyd_arraylist.count_path ( 5,2 ));
        System.out.println ();


    }
}
