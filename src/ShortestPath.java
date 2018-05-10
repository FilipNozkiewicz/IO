import java.util.*;
import java.lang.*;
import java.io.*;

public class ShortestPath {

    static final int V = 9; //statyczna ilosc wierzcholkow

    int minDistance(int dist[], Boolean sptSet[]) { // tablica najmniejsxych dystansow i bool czy wierzchoilek jest juz na liscie spt

        int min = Integer.MAX_VALUE, min_index = -1; //??
        // robie petle przez wszystkie wierzcholki bez wzgledu gdzie zaczynam
        // gdzie v to numer vierzcholka
        for (int v = 0; v < V; v++) {
            if (sptSet[v] == false && dist[v] <= min) // jelsi nie ma go jeszze na liscie i dsyatans okazl sie mniejszy od obecznego
            // to robie jakies przestawienia i operacje
            {
                // ustawiam minimalny dystans na znaleziony
                min = dist[v];
                min_index = v;  // usatwioenie indeksu wierzcholaka
            }
        }
        return min_index;  // zwracam numer wierzcholka
    }

    void printSolution(int dist[], int n)
    {
        // tylko wypisanie macierzy
        System.out.println ("Vertex Dist fom Source");
        for(int i = 0 ; i < V ; i++) // wypisanie wszystkich
        {
            System.out.println (i + " ===> " + dist[i]); // i to vierzcholek  i dystans do niego
        }
    }
    // alghorith using adjacency matrix representation
    void dijkstra(int graph[][] , int src)
    {
        int dist[] = new int[V]; // wyjsciowa tablca gdzie dist[i] przetrzymuje najrotszy dystans ze zrodla do wierzcholka
        Boolean sptSet[] = new Boolean[V]; // nowa tablica na sprawdzane odwiedzenia

        for (int i = 0 ; i < V ; i++){

            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;

        }

        dist[src] = 0;
        // inicjalizacja wszystkich wierzcholkow jako infinity i tablicy odwiedzonych jako false
        for (int i = 0; i < V ; i++){

            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;
        // find shortest path for all vertices

        for (int i = 0 ; i < V ; i++)
        {

            int u = minDistance ( dist , sptSet ); // walinij petle po dystansach i znjadz ten wierzcholek do ktorego dystans jaes t eraz najmniejszy

            sptSet[u] = true; // oznacz vierzcholek ze juz go przeerobiles

            for(int v = 0;  v < V ; v++)
            {
                // jesli vierzcholek nie  jest w stpSet to go zupdatuj
                // ale jesli jescze nie jestem na zrodle oraz jesli distanas nie jest nieskonczony
                 // czy tam nieosiagalny  i jelsi jescze dystans do tego wierzcholka + nowa krawedz bedzie mniejszy niz
                /// dotychczasowy dystans
                if(!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]){
                    dist[v] = dist[u] + graph[u][v]; // tera zupdejtuj dystans
                }
            }


        }
        System.out.println ("Source is " + src);
        printSolution ( dist , V ); // wypisz odleglosci

    }
    public static void main (String[] args)
    {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 4);
    }

}