package Bellman2;

import java.util.*;

public class Algorithm {
int wtf = 2;
    final int infinity = 999;
    List<Vertex> vlist;
    List<Integer> distance;
    List<Integer> predecessors;
    List<Edge> elist;
    Map<Integer , ArrayList<Integer>> mapa;

    public ArrayList<ArrayList<Integer>> mapowanie;



    public void getVectors(ArrayList<ArrayList<Integer>> matrix) {



        mapa = new HashMap<> (matrix.size ());
        vlist = new ArrayList<> ( matrix.size () );
        for (int i = 0; i < matrix.size (); i++) {
            vlist.add ( new Vertex ( i ) );
        }
        elist = new ArrayList<> ();
        for (int i = 0; i < matrix.size () - 1; i++) {
            for (int j = i; j < matrix.get ( 0 ).size (); j++) {
                if (i != j) {
                    if (matrix.get ( i ).get ( j ) != 0) {
                        elist.add ( new Edge ( vlist.get ( i ) , vlist.get ( j ) , matrix.get ( i ).get ( j ) ) );
                        elist.add ( new Edge ( vlist.get ( j ) , vlist.get ( i ) , matrix.get ( i ).get ( j ) ) );
                    }

                }
            }
        }
    }
    public void printVertex(){
        for(Vertex v : vlist){
            System.out.print ("|" + v.id);
        }
        System.out.print ("|");
        System.out.println ();
    }
    public void printEdges(){
        for(Edge e : elist){
            System.out.println ("From " +e.start.id+"--->" + e.finish.id +" value: " + e.value);
        }
    }
    public void shorthestpath(Vertex source , Vertex target){
        source.minDistance = 0;
        ArrayList<Integer> lista = new ArrayList<Integer> (  );
        for(int i = 0 ; i < vlist.size () - 1 ; i++){

            for(Edge edge : elist){
                if(edge.start.minDistance == Double.MAX_VALUE) continue;

                Vertex u = edge.start;
                Vertex v = edge.finish;

                Double newDistance = v.minDistance + edge.value;

                if(newDistance < u.minDistance ){ // jesli ten dystanss jest mniejszy od poprzedniego
                    u.minDistance = newDistance;
                    u.previousVertex = v;
                    System.out.println (v.id);

                }
            }
        }
     /*   for(Vertex v = target ;  v != null ; v = v.previousVertex){   // repeat as long that is gonna be parentvertex
            lista.add ( v.id );

        }
        Collections.reverse ( lista );

        mapa.put ( target.id , lista );*/
    }
    public void sh(List<Vertex> vertices, List<Edge> edges , Vertex source){
        distance = new ArrayList<Integer> (  );
        predecessors = new ArrayList<Integer> (  );
        mapa = new HashMap<Integer, ArrayList<Integer>> (  );
        for(Vertex v : vertices){
            distance.add ( infinity );
            predecessors.add ( null );
            v.distance = infinity;
            mapa.put ( v.id , new ArrayList<Integer> (  ) );
        }
        distance.set ( source.id , 0 );

        ArrayList<Integer> path = new ArrayList<Integer> (  );
        for(int i = 0 ; i < vertices.size () - 1 ; i++){
            for(Edge edge : edges){
                if(distance.get ( edge.start.id ) + edge.value < distance.get ( edge.finish.id )){
                    distance.set(edge.finish.id , distance.get ( edge.start.id )+edge.value);
                    predecessors.set(edge.finish.id , edge.start.id);
                   // predecessors.add ( edge.start.id );

                }
            }

        }
    }
    public void print_pred(){
        for(Integer x : predecessors){
            System.out.print ("----->" + x);
        }
        System.out.println ();
    }
    public void print_dist(){
        for(Integer x : distance){
            System.out.print ("----->" + x);
        }
        System.out.println ();
    }


    public void print(){
        for (Map.Entry<Integer , ArrayList<Integer>> entry : mapa.entrySet())
        {
            ArrayList<Integer> ar = entry.getValue ();

            for(Integer x : ar){
                System.out.print ("----->" + x );
            }
            System.out.println ();
        }
    }
}
