import java.util.Random;
import java.util.Scanner;

public class Dijkstra {

    public static void main(String[] args){

        System.out.println ("/////////////////////////////DIJKSTRA /////////////////////////////////////////");

        Scanner scanner = new Scanner (System.in);
        Random random = new Random (  );
        int[][] matrix = new int[5][5];


        int[] distance = new int[5];
        int[] visited = new int[5];

        int[] predD = new int[5];   ///// get the actual path

        int min , NextNode = 0;     /// min is minimum value to the node
            // nextNode to kolejny wierzcholek na jaki sie natrafimy

//////////////////////////////////////////////////////
        //// This part can be ignored /////////////
        for(int i = 0 ; i < 5 ; i++){
            int  h = random.nextInt ( 5 );
            int  v = random.nextInt ( 5 );
            for(int j = 0 ;  j < 5 ; j++){
                matrix[i][j] = random.nextInt ( 20 )+1;
                matrix[h][v] = 999;
            }
        }
        ////////////// igonring finished //////////
        ///////////////////////////////////////////////////////////
        ///////////////////// SKANOWANIE macierzy ///////////////////////
        /// To musi byc macierz sasiedztwa oznaczona tak jak macierz sasiedztwa oznacza sie //////////////////
        //////////////// Ten sam wierzcholek jest oznaczony jako 0 a na outpucie 999 zeby miec duza wartosc /////
          ///// to jest potrzebne do poronwania /////////////////////
        for(int i = 0 ; i < 5 ; i++){

            for(int j = 0 ;  j < 5 ; j++){
                System.out.println ("element " + "[" + i + "][" + j + "] = " );
                matrix[i][j] = scanner.nextInt ();

                if(matrix[i][j] == 0) matrix[i][j] = 999;      /////// diagonalia oznaczona duza wartoscia jakby nieskonczonosc

            }
        }

        /////////////////// TU JEST SAM ALGORYTM //////////////////////////////////////////
        for(int i = 0 ; i < 5 ; i++){

            visited[i] = 0;          ///// zeruje wektor odwiedzonych wierzcholkow //////////////////   0 nie_odwiedzony 1 odwiedzony
            predD[i] = 0;              // oraz aktualnych sciezek
            for(int j = 0 ;  j < 5 ; j++){
                System.out.print (matrix[i][j]);
                System.out.print ("\t");    // wypiisanie macierzy

            }
            System.out.println ();
        }

        distance = matrix[0];   // set the first row to the distance area
        // pierwszy wektor macierzy ustawiam jako wektor dystansow (na poczatek no bo wiem na poczatku jakie mama dystanse do
        // sasiadow a gdzie nie mam dostepu)
        distance[0] = 0;   // simple no distance beetween the source // dystanse do zrodla jest 0 logiczne
        visited[0] = 1;  // source was visited  logiczne

        // code must be executed ass many times there is rows

        for(int i = 0 ; i < 5 ; i++){

            min = 999;    /////     wartosc minimalna na poczatku ustawiana na nieskonczonosc

            for(int j = 0 ; j <5 ; j++){
                if(min > distance[j] && visited[j] != 1){   /// spraw
                    min = distance[j];    ///// tutaj musze znalezc najmniejsza wartosc w kazdym wektorze (wierszu)
                    NextNode = j; // nna tym wierzcholku skjonczylem ten ma najmiejszy dystans narazie
                    // i teraz mamy zamiar odwiedzic ten wierzcholek
                }
            }
            visited[NextNode] = 1;  /// wiec teraz oznaczam ten wierzcholek jako odwiedzony

            // algithm start
            for(int c = 0 ; c < 5 ; c++){
            //// wykonywane jesli tylko nie odwiedzilismy jescze tego wierzcholka
                if(visited[c] != 1) {  // was not visited yet

                    if(min + matrix[NextNode][c] < distance[c]) { // porownanie dystansow osiagnietych do tej pory
                //// jesli znaleziono nowa wartosc mniejsza to od tej pory to nasz dystans do wierzcholka
                        distance[c] = min + matrix[NextNode][c];
                        predD[c] = NextNode;  //// a wierzcholek jest dodany do sciezki
                    }
                }
            }

        }
        /////////////DISTANCE AREA /////////////////////////////////

        /////// Ta petla to dystanse do kolejnych wierrzcholkow
        for(int i = 0 ; i < 5 ; i++){
            System.out.print ("|" + distance[i] );
        }
        System.out.print("|");

        // printing path

        /////// Ta petla pokazuje przez jakie wierzcholki trzeba przejsc by dojsc kolejno do ( 0  1  2  3 i 4) - tego wierzcholka
        for(int i = 0 ; i < 5 ; i++){
            int j;
            System.out.println ("Path = " + i);
            j = i;

            do{
                j = predD[j];   /// printuje sciezke chopdzac po wektorze z kolejny mi wierzcholkami
                System.out.println (" <- " + j);
            }while (j != 0);
        }
    }
}
