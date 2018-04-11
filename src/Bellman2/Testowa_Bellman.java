package Bellman2;

import java.util.ArrayList;

public class Testowa_Bellman {

    public ArrayList<ArrayList<Integer>> matrix;

    public ArrayList<ArrayList<Integer>> alokuj() {

        matrix = new ArrayList<ArrayList<Integer>> ();

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

        matrix.add ( 0, zero );
        matrix.add ( 1, first );
        matrix.add ( 2, second );
        matrix.add ( 3, third );
        matrix.add ( 4, fourth );

        return matrix;
    }

    public static void main(String[] args) {

        Testowa_Bellman bellman = new Testowa_Bellman ();
     //   bellman.alokuj ();


        for (ArrayList<Integer> x : bellman.alokuj ()) {
            for (Integer y : x) {
                System.out.print ( y + "\t" );
            }
            System.out.println ();
        }
        Algorithm algorithm = new Algorithm ();
        algorithm.getVectors ( bellman.alokuj () );

        algorithm.printVertex ();
        algorithm.printEdges ();

      //  algorithm.shorthestpath ( algorithm.vlist.get ( 0 ) , algorithm.vlist.get ( 1 ) );
    //    algorithm.shorthestpath ( algorithm.vlist.get ( 0 ) , algorithm.vlist.get ( 2 ) );
     //   algorithm.shorthestpath ( algorithm.vlist.get ( 0 ) , algorithm.vlist.get ( 3 ) );
       // algorithm.shorthestpath ( algorithm.vlist.get ( 0 ) , algorithm.vlist.get ( 4 ) );

        algorithm.sh ( algorithm.vlist , algorithm.elist , algorithm.vlist.get ( 0 ) );
        algorithm.print_pred ();
        algorithm.print_dist ();
        algorithm.print ();





    }
}
