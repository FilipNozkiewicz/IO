// A Java program for Floyd Warshall All Pairs Shortest
// Path algorithm.
import java.util.*;
import java.lang.*;
import java.io.*;


class AllPairShortestPath
{
    final static int INF = 99999, V = 9;

    void floydWarshall(int graph[][])
    {
        int dist[][] = new int[V][V];
        int i, j, k;
        int pred[][] = new int[V][V];

        for(int v1 = 0 ; v1  < graph.length ; v1++){
            for(int v2 = 0 ; v2 < graph.length ; v2++){

                if(v1 != v2){
                    if(graph[v1][v2] != INF){   // jestem na krawedzi
                    //    dist[v1][v2] = graph[v1][v2];
                        pred[v1][v2] = v1;

                    }
                }
            }
        }

        /* Initialize the solution matrix same as input graph matrix.
           Or we can say the initial values of shortest distances
           are based on shortest paths considering no intermediate
           vertex. */
        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++){
               dist[i][j] = graph[i][j];
            //    pred[i][j] = 999;
        }


        /* Add all vertices one by one to the set of intermediate
           vertices.
          ---> Before start of a iteration, we have shortest
               distances between all pairs of vertices such that
               the shortest distances consider only the vertices in
               set {0, 1, 2, .. k-1} as intermediate vertices.
          ----> After the end of a iteration, vertex no. k is added
                to the set of intermediate vertices and the set
                becomes {0, 1, 2, .. k} */
        for (k = 0; k < V; k++)
        {
            // Pick all vertices as source one by one
            for (i = 0; i < V; i++)
            {
                // Pick all vertices as destination for the
                // above picked source
                for (j = 0; j < V; j++)
                {
                    // If vertex k is on the shortest path from
                    // i to j, then update the value of dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        pred[i][j] = pred[k][j];
                    }
                }
            }
        }

        // Print the shortest distance matrix
        printSolution(dist);
        System.out.println ("Path Matrix");
        printSolution ( pred );
    }

    void printSolution(int dist[][])
    {
        System.out.println("Following matrix shows the shortest "+
                "distances between every pair of vertices");
        for (int i=0; i<V; ++i)
        {
            for (int j=0; j<V; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }

    // Driver program to test above function
    public static void main (String[] args)
    {
        /* Let us create the following weighted graph
           10
        (0)------->(3)
        |         /|\
        5 |          |
        |          | 1
        \|/         |
        (1)------->(2)
           3           */
      /*  int graph[][] = { {0,   5,  INF, 10},
                        {5, 0,   3, INF},
                        {INF, 3, 0,   1},
                        {10, INF, 1, 0}
        };*/
      int graph[][] = {
              {0,4,INF,INF,INF,INF,INF,8,INF}, // 0
              {4,0,8,INF,INF,INF,INF,11,INF}, // 1
              {INF,8,0,7,INF,4,INF,INF,2}, //2
              {INF,INF,7,0,9,14,INF,INF,INF}, // 3
              {INF,INF,INF,9,0,10,INF,INF,INF}, // 4
              {INF,INF,4,14,10,0,2,INF,INF}, // 5
              {INF,INF,INF,INF,INF,2,0,1,6}, // 6
              {8,11,INF,INF,INF,INF,1,0,7}, // 7
              {INF,INF,2,INF,INF,INF,6,7,0} // 8
      };
        AllPairShortestPath a = new AllPairShortestPath();

        // Print the solution
        a.floydWarshall(graph);
    }
}