

import java.util.ArrayList;

class Graph{

    Integer V , E ;    // deklaracjavierzcholkow i edgy
    ArrayList<Edge> edge_list;

    public Graph(ArrayList<ArrayList<Integer>> M){

        edge_list = new ArrayList<Edge> (  );
        this.V = M.size ();
        this.E = 0;
        for(Integer i = 0 ; i < M.size () ; i++){
            for(Integer j = 0 ; j < M.size (); j++ ){

                if(i != j ){
                    if(M.get ( i ).get ( j ) != Integer.MAX_VALUE  ){
                        Edge edge = new Edge (i , j , M.get ( i ).get ( j ));
                        edge_list.add ( edge );
                        this.E ++;
                    }
                }
            }
        }
    }


}
class Edge{
    Integer src , dest , weight;
    Edge(Integer src , Integer dest ,Integer weight){
       this.src = src;
       this.dest = dest;
       this.weight = weight;
    }
}

public class Bellman_Arraylist {

    public ArrayList<Integer> ancestors;
    public ArrayList<Integer> distances;
    public void BellmanFord(ArrayList<ArrayList<Integer>> M , Integer src){


        Graph graph = new Graph ( M );
        Integer V = graph.V;
        Integer E = graph.E;
         //System.out.println (V);
        //System.out.println (E);
        for(Integer i = 0 ; i < E  ; i++){
            System.out.println (graph.edge_list.get ( i ).src + "==>" + graph.edge_list.get ( i ).dest + " waga " + graph.edge_list.get ( i ).weight );
        }


        ArrayList<Integer> dist = new ArrayList<Integer> (  );
        ArrayList<Integer> pred = new ArrayList<Integer> (  );

        for(Integer i = 0 ; i < V ; i ++){
            dist.add ( Integer.MAX_VALUE );
            pred.add ( Integer.MAX_VALUE );

        }
        dist.set ( src , 0 );
        for(Integer i = 0 ; i < V ; i++){
            for(Integer j = 0 ;  j < E; j++){
              //  System.out.println (graph.edge_list.get ( E  ).src + "==>" +graph.edge_list.get ( E  ).dest);
                Integer u = graph.edge_list.get ( j ).src;
                Integer v = graph.edge_list.get ( j ).dest;
                Integer weight = graph.edge_list.get ( j ).weight;

                if((dist.get ( u ) != Integer.MAX_VALUE) && (dist.get ( u ) + weight < dist.get ( v ))){
                    dist.set ( v , dist.get ( u ) + weight );
                    pred.set ( v , u );
                }
            }
        }
        ancestors = pred;
        distances = dist;
        ///////////////////////// CYKLE UJEMNE //////////////////////////////
        for(Integer i = 0 ; i < E ; i++ ){
            Integer u = graph.edge_list.get ( i ).src;
            Integer v = graph.edge_list.get ( i ).dest;
            Integer weight = graph.edge_list.get ( i ).weight;

            if(dist.get ( u ) != Integer.MAX_VALUE && dist.get ( u ) + weight < dist.get ( v )){
                System.out.println ("Negative cycles detected");
            }

        }

    }

    public ArrayList<ArrayList<Integer>> infinity(ArrayList<ArrayList<Integer>> M){

        for(int i = 0 ; i < M.size () ; i++){
            for(int j = 0 ; j < M.size () ; j++){
                if((i != j) && M.get ( i ).get ( j ) == 0){
                    M.get ( i ).set ( j , Integer.MAX_VALUE );
                }
            }
        }

        return M;
    }

    ArrayList<ArrayList<Integer>>  aloc_main_matrix(ArrayList<ArrayList<Integer>> M){

        ArrayList<ArrayList<Integer>> Matrix = new ArrayList<ArrayList<Integer>> (  );
        for(Integer i = 0 ; i  < M.size () ; i++){

            BellmanFord ( M , i);
            Matrix.add ( distances );

        }

        return Matrix;

    }
    ArrayList<ArrayList<Integer>>  aloc_patch_matrix(ArrayList<ArrayList<Integer>> M){

        ArrayList<ArrayList<Integer>> Matrix = new ArrayList<ArrayList<Integer>> (  );
        for(Integer i = 0 ; i  < M.size () ; i++){

            BellmanFord ( M , i);
            Matrix.add ( ancestors );

        }

        return Matrix;

    }
    public void print(ArrayList<ArrayList<Integer>> M){
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


}
