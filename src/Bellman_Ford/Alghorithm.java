package Bellman_Ford;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alghorithm {

    public List<Vertex> vertexList;
    public List<Edge> edgeList;

    public Alghorithm(List<Vertex> vertexList, List<Edge> edgeList) {
        this.vertexList = vertexList;
        this.edgeList = edgeList;
    }

    public void shortestpath(Vertex sourceVertex , Vertex targetVertex){  // using sorce and target gonna find the shorthest path
      //  int[][] tab = {{2,3},{4,1}};
        sourceVertex.setMinDistance ( 0 );

        for(int i = 0 ; i  < this.vertexList.size () - 1 ; i++){

            for(Edge edge : this.edgeList){

                if(edge.getStartVertex ().getMinDistance () == Double.MAX_VALUE) continue;
                // jeslli odleglosc od zrodla (minimalna czyli mamy niskonczonosc to pomijam iteracje)

                Vertex v = edge.getStartVertex ();  // ide do nowej krawedzi i biore wartosc poczatkowa (z pocz krawedzi)
                Vertex u = edge.getTargetVertex (); // wartosc z konca krawedzi

                double newDistance = v.getMinDistance () + edge.getWeight ();

                // nowy dystance odleglosc od zrodla + wartosc krawedzi

                if(newDistance < u.getMinDistance () ){ // jesli ten dystanss jest mniejszy od poprzedniego
                    u.setMinDistance ( newDistance );
                    u.setPreviousVertex ( v );
                }

            }
        }


        /// check for  a negative cycle ///////////////////////
        for(Edge edge : this.edgeList){

            if(edge.getStartVertex ().getMinDistance () != Double.MAX_VALUE){
                System.out.println ("cykl ujemny");
            }
        }


    }
    private boolean hasCycle(Edge edge){
        return (edge.getStartVertex ().getMinDistance () + edge.getWeight ()) < edge.getTargetVertex ().getMinDistance ();
        //no jesli minimalny dytstans + wartosc krawedzi mniejszzy od min odleglosci do konca krawedzi to cos jest nie tak
        /// to znaczy ze sa zapetlenie kore trzeba wywalic
        /// chociaz w naszym przypadku to sie nie powinno zdarzyc ale lepiej sie zabezpieczyc
        // no bo jesli znajdziemy wszystko i sie pojaiw kolejn e to jest cykl ujemny
        ///// if this is true return true
    }

    public List<Vertex> printPath(Vertex target){

        List<Vertex> path = new ArrayList<> (  );

        for(Vertex v = target ;  v != null ; v = v.getPreviousVertex ()){   // repeat as long that is gonna be parentvertex
            path.add ( v );
        }
        Collections.reverse ( path ); // reverse a path

        return path;
    }
}
