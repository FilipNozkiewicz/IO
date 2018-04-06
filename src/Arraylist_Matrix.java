import java.util.ArrayList;
import java.util.Random;

// to jest przyklad uzycia arraylist do macierzy
// uwazam ze to jest lepszy sposob bo maja one o wiele wiecej mozliwosci
// do edycji i ogolnie do dostepnosci elemntow niz zwykle tabice

public class Arraylist_Matrix {

    public static ArrayList<ArrayList<Integer>>  ar = new ArrayList<ArrayList<Integer>> (  );

    // zasada jest taka ze tworze arrayliste arraylist i daje jej jakis typ zmiennej

    public  static  Random r  = new Random (  );



    public static void matrix(int a , int b){

        // macierz tworze normalnie w petli
        for(int i = 0 ; i < a ; i++ ){
            ar.add ( i , new ArrayList<Integer>() );  // waze jest zeby za kazda iteracja dodac nowa arayliste
            for(int j = 0 ; j < b ; j++ ){

                ar.get ( i ).add ( j , r.nextInt ( 10 ) );
                // nastepnie do elementow dodanej arraylisty dodajemy kolejne elementy
            }
        }
    }
    public static void ch(){
        for(ArrayList<Integer> x  : ar){  // dla kazeej arrraylisty w obiekcie ar
            for(int y : x){   // dla kazdego elementu tej arraylisty z poprzedniej petli
                // wypisanie za pomoaca petli for each bardzie wygodne tez zalecane :) :) :)
                y = 2;

            }

        }
    }
    public static void print(){
        for(ArrayList<Integer> x  : ar){  // dla kazeej arrraylisty w obiekcie ar
            for(int y : x){   // dla kazdego elementu tej arraylisty z poprzedniej petli
                // wypisanie za pomoaca petli for each bardzie wygodne tez zalecane :) :) :)

                System.out.print(y);
                System.out.print('\t');
            }
            System.out.println ();   // po kazdym wypisaniu wiersza nowa linia
        }
    }

    public static void main(String[] args){

        Arraylist_Matrix t = new Arraylist_Matrix ();
        t.matrix ( 5,5 );
        t.ch();
        t.print ();
        // przyklad pobrania elementu macierzy(2,3);
        System.out.println (t.ar.get ( 2 ).get ( 3 ));

    }
}
