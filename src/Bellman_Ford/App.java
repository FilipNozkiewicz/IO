package Bellman_Ford;

import java.util.ArrayList;
import java.util.List;

////////////////// FOR TEST ////////////////////////////////////
public class App {

    public static void main(String[] args){

        Vertex v1 = new Vertex ( "A" );
        Vertex v2 = new Vertex ( "B" );
        Vertex v3 = new Vertex ( "C" );
        Vertex v4 = new Vertex ( "D" );

        Edge e1 = new Edge (10 , v1 , v2  );
        Edge e2 = new Edge (100 , v1 , v4  );
        Edge e3 = new Edge (10 , v2 , v3  );
        Edge e4 = new Edge (10 , v4 , v4  );

        List<Vertex> vlist = new ArrayList<Vertex> (  );
        vlist.add ( v1 );
        vlist.add ( v2 );
        vlist.add ( v3 );
        vlist.add ( v4 );

        List<Edge> elist = new ArrayList<Edge> (  );

        elist.add ( e1 );
        elist.add ( e2 );
        elist.add ( e3 );
        elist.add ( e4 );

        Alghorithm alghorithm = new Alghorithm ( vlist , elist );

        List<Vertex> path = alghorithm.printPath ( v4 );
        System.out.println (path);


    }
}
