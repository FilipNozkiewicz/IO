import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;



class Graph{

    public  Integer INF = 9999;
    Integer V , E ;    // deklaracjavierzcholkow i edgy
    ArrayList<Edge> edge_list;

    public Graph(ArrayList<ArrayList<Integer>> M){

        edge_list = new ArrayList<Edge> (  );
        this.V = M.size ();
        this.E = 0;
        for(Integer i = 0 ; i < M.size () ; i++){
            for(Integer j = 0 ; j < M.size (); j++ ){

                if(i != j ){
                    if(M.get ( i ).get ( j ) != INF ){
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
    public  Integer INF = 9999;
    Integer src , dest , weight;
    Edge(Integer src , Integer dest ,Integer weight){
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class Bellman_Arraylist {

    public  Integer INF = 9999;
    public ArrayList<Integer> ancestors;
    public ArrayList<Integer> distances;
    public ArrayList<Integer> Hop_list;
    public ArrayList<String> Path_list;
    public void BellmanFord(ArrayList<ArrayList<Integer>> M , Integer src){


        Graph graph = new Graph ( M );
        Integer V = graph.V;
        Integer E = graph.E;
        Hop_list = new ArrayList<Integer> (  );
        Path_list = new ArrayList<String> (  );
        //System.out.println (V);
        //System.out.println (E);
        // for(Integer i = 0 ; i < E  ; i++){
        //      System.out.println (graph.edge_list.get ( i ).src + "==>" + graph.edge_list.get ( i ).dest + " waga " + graph.edge_list.get ( i ).weight );
        //    }


        ArrayList<Integer> dist = new ArrayList<Integer> (  );
        ArrayList<Integer> pred = new ArrayList<Integer> (  );

        for(Integer i = 0 ; i < V ; i ++){
            dist.add ( INF );
            pred.add ( INF );
           // pred.add ( 0 );
            Path_list.add ( "" );

        }

       pred.set ( src , src );
        dist.set ( src , 0 );
        for(Integer i = 0 ; i < V ; i++){
            for(Integer j = 0 ;  j < E; j++){
                //  System.out.println (graph.edge_list.get ( E  ).src + "==>" +graph.edge_list.get ( E  ).dest);
                Integer u = graph.edge_list.get ( j ).src;
                Integer v = graph.edge_list.get ( j ).dest;
                Integer weight = graph.edge_list.get ( j ).weight;

                if((dist.get ( u ) != INF) && (dist.get ( u ) + weight < dist.get ( v ))){
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

            if(dist.get ( u ) != INF && dist.get ( u ) + weight < dist.get ( v )){
                System.out.println ("Negative cycles detected");
            }

        }
        for (Integer i = 0 ; i < V ;  i++) {
            if (i != src){
                Integer j;

                j = i;
                int hop = 0;
                do {
                    StringBuilder x = new StringBuilder();

                    j = pred.get ( j );
                    x.append ( " ===> " + j.toString () );
                    x.append(Path_list.get ( i ));
                    Path_list.set ( i , x.toString ());
                    //    String x = "==>" + j.toString ();
                    //      String y = Path_list.get ( i );
                    //      StringBuilder xy = new StringBuilder (  );
                    //      xy.append ( x ).append ( y );
                    //      Path_list.set ( i , xy.toString () );
                    hop++;

                } while (j != src);
                Hop_list.add ( hop );
                hop = 0;
            }
            else{

                Hop_list.add ( 0 );
            }
        }

    }

    public ArrayList<ArrayList<Integer>> infinity(ArrayList<ArrayList<Integer>> M){

        for(int i = 0 ; i < M.size () ; i++){
            for(int j = 0 ; j < M.size () ; j++){
                if((i != j) && M.get ( i ).get ( j ) == 0){
                    M.get ( i ).set ( j , INF );
                }
            }
        }

        return M;
    }
    ArrayList<ArrayList<Integer>> Hop_Matrix;
    ArrayList<ArrayList<String>> Path_Matrix;
    ArrayList<ArrayList<Integer>>  aloc_main_matrix(ArrayList<ArrayList<Integer>> M){

        Hop_Matrix = new ArrayList<ArrayList<Integer>> (  );
        Path_Matrix = new ArrayList<ArrayList<String>> (  );
        ArrayList<ArrayList<Integer>> Matrix = new ArrayList<ArrayList<Integer>> (  );
        for(Integer i = 0 ; i  < M.size () ; i++){

            BellmanFord ( M , i);
            Matrix.add ( distances );
            Hop_Matrix.add ( Hop_list );
            Path_Matrix.add ( Path_list );

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

    ArrayList<ArrayList<Integer>> alokuj(){

        ArrayList<ArrayList<Integer>> M  = new ArrayList<ArrayList<Integer>> (  );
        ArrayList<Integer> zero = new ArrayList<> ( 9 );
        ArrayList<Integer> one = new ArrayList<> ( 9 );
        ArrayList<Integer> two = new ArrayList<> ( 9 );
        ArrayList<Integer> three = new ArrayList<> ( 9 );
        ArrayList<Integer> four = new ArrayList<> ( 9 );
        ArrayList<Integer> five = new ArrayList<> ( 9 );
        ArrayList<Integer> six = new ArrayList<> ( 9 );
        ArrayList<Integer> seven = new ArrayList<> ( 9 );
        ArrayList<Integer> eight = new ArrayList<> ( 9 );


        zero.add ( 0 );
        zero.add ( 4 );
        zero.add ( 0 );
        zero.add ( 0 );
        zero.add ( 0 );
        zero.add ( 0 );
        zero.add ( 0 );
        zero.add ( 8 );
        zero.add ( 0 );

        one.add ( 4 );
        one.add ( 0 );
        one.add ( 8 );
        one.add ( 0 );
        one.add ( 0 );
        one.add ( 0 );
        one.add ( 0 );
        one.add ( 11 );
        one.add ( 0 );

        two.add ( 0 );
        two.add ( 8 );
        two.add ( 0 );
        two.add ( 7 );
        two.add ( 0 );
        two.add ( 4 );
        two.add ( 0 );
        two.add ( 0 );
        two.add ( 2 );

        three.add ( 0 );
        three.add ( 0 );
        three.add ( 7 );
        three.add ( 0 );
        three.add ( 9 );
        three.add ( 14 );
        three.add ( 0 );
        three.add ( 0 );
        three.add ( 0 );

        four.add ( 0 );
        four.add ( 0 );
        four.add ( 0 );
        four.add ( 9 );
        four.add ( 0 );
        four.add ( 10 );
        four.add ( 0 );
        four.add ( 0 );
        four.add ( 0 );

        five.add ( 0 );
        five.add ( 0 );
        five.add ( 4 );
        five.add ( 14 );
        five.add ( 10);
        five.add ( 0 );
        five.add ( 2 );
        five.add ( 0 );
        five.add ( 0 );

        six.add ( 0 );
        six.add ( 0 );
        six.add ( 0 );
        six.add ( 0 );
        six.add ( 0 );
        six.add ( 2 );
        six.add ( 0 );
        six.add ( 1 );
        six.add ( 6 );

        seven.add ( 8 );
        seven.add ( 11 );
        seven.add ( 0 );
        seven.add ( 0 );
        seven.add ( 0 );
        seven.add ( 0 );
        seven.add ( 1 );
        seven.add ( 0 );
        seven.add ( 7 );

        eight.add ( 0 );
        eight.add ( 0 );
        eight.add ( 2 );
        eight.add ( 0 );
        eight.add ( 0 );
        eight.add ( 0 );
        eight.add ( 6 );
        eight.add ( 7 );
        eight.add ( 0 );

        M.add ( zero );
        M.add ( one );
        M.add ( two );
        M.add ( three );
        M.add ( four );
        M.add ( five );
        M.add ( six );
        M.add ( seven );
        M.add ( eight );

        return M;
    }
    public void print_paths (ArrayList<ArrayList<String>> M) throws FileNotFoundException {   // tylko sposob wypisywania
        ArrayList<ArrayList<Integer>> wartosci = new ArrayList<ArrayList<Integer>> (  );
        ArrayList<ArrayList<Integer>> wartosci2 = new ArrayList<ArrayList<Integer>> (  );
        ArrayList<Integer> wiersz;
        ArrayList<Integer> maxymalne = new ArrayList<Integer> (  );
        System.out.println ("\n\t");
        System.out.print ("\t");
        for(Integer i = 0 ; i < M.size () ; i++){
            wiersz = new ArrayList<Integer> (  );
            for(Integer j = 0 ; j < M.size () ; j++){
                wiersz.add ( M.get ( i ).get ( j ).length () );
            }
            wartosci.add ( wiersz );
            wartosci2.add ( wiersz );
        }
        for(Integer i = 0 ; i < M.size () ; i++) {

            for (Integer j = 0; j < M.size (); j++) {
                wartosci2.get ( i  ).set ( j , wartosci.get(j).get ( i ) );
            }
        }
        for(Integer i = 0 ; i < M.size () ; i++) {
            maxymalne.add ( Collections.max ( wartosci2.get ( i ) ) );
        }
        ArrayList<String> odstep = new ArrayList<String > (  );
        String spacja = " ";
        try {
            CleanFile.clean ( "trasy2.txt" );
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        }

        for(Integer i =0 ; i< M.size () ; i++ ){

       //     System.out.print (i + (String.join("", Collections.nCopies(maxymalne.get ( i ), " "))));
     //       System.out.print("\t");
            FileWrite.writefile ( i.toString () + String.join("", Collections.nCopies(maxymalne.get ( i ), " ")) + "\t" , "trasy2.txt" );


        }
    //    System.out.println ();
        FileWrite.writefile ( "\n"  , "trasy2.txt");
        for(int i = 0 ; i < 23 ; i ++) {
         //   System.out.print ("-");
            FileWrite.writefile ( "-" , "trasy2.txt" );
        }
   //     System.out.println ();
        FileWrite.writefile ( "\n"  , "trasy2.txt");

        for(Integer i = 0 ; i  < M.size () ; i++){
         //   System.out.print (i + "|\t");
            FileWrite.writefile ( i.toString () + "|\t" , "trasy2.txt" );
            for(int j = 0 ; j < M.size () ; j++){
                if(i == j) {
              //      System.out.print ( "-" );
                    FileWrite.writefile ( "-"  , "trasy2.txt");
                }
                else {
         //           System.out.print ( M.get ( i ).get ( j ) );
                    FileWrite.writefile ( M.get ( i ).get ( j ).toString ()  , "trasy2.txt");
                }
           //     System.out.print(String.join("", Collections.nCopies(maxymalne.get ( j ) - M.get ( i ).get ( j ).length () + 2, " ")));
                FileWrite.writefile ( String.join("", Collections.nCopies(maxymalne.get ( j ) - M.get ( i ).get ( j ).length () + 2, " ")) , "trasy2.txt");

            }
         //   System.out.println ("\n");
            FileWrite.writefile ( "\n"  , "trasy2.txt");

        }
   //     System.out.println ("\n");
        FileWrite.writefile ( "\n"  , "trasy2.txt");
    }
    public void choose_the_shortest( ArrayList<Integer> v , ArrayList<ArrayList<Integer>> M ){

        ArrayList<OurMap> ways = new ArrayList<>(); // potrzebuje stworzyć bo chce duplikaty i dodawanie po koleji
        Integer lengthOfRoute = 0;
        Integer hopsOfRoute = 0;
        String lengthName;

        // SetHops ( P );
        for(int i = 0; i< v.size(); i++){
            for (int j = 0;j< v.size(); j++){
                if(j != i ){
                    for (int k = 0;k< v.size();k++){
                        if(k != j && k!= i) {
                            for (int r = 0; r < v.size(); r++) {
                                if(r != i && r!= j && r != k) {
                                    for (int l = 0; l < v.size(); l++) {
                                        if(l != i && l != j && l != k && l != r) {
                                            hopsOfRoute = Hop_Matrix.get(0).get(v.get(i)) + Hop_Matrix.get(v.get(i)).get(v.get(j)) + Hop_Matrix.get(v.get(j)).get(v.get(k)) + Hop_Matrix.get(v.get(k)).get(v.get(r)) + Hop_Matrix.get(v.get(r)).get(v.get(l)) + Hop_Matrix.get(v.get(l)).get(0) ;
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
        for(OurMap o : ways){
            if(shortestWay.getKey() > o.getKey()){
                shortestWay = o;
            }
            //shortestWay.printMap();
            //o.printMap();
        }
        shortestWay.printMap();



    }
    public String converter(int val, int xLength){
        int x = val % xLength;
        int y = val / xLength;
        String temp = "(" + x + "," + y + ")";
        return temp;
    }
    Integer distance_sum = 0;
    Integer hop_sum = 0;
    String path_sum = "";
    public void choose_the_shortest(int xLength, ArrayList<Integer> v , ArrayList<ArrayList<Integer>> M ){

        ArrayList<OurMap> ways = new ArrayList<>(); // potrzebuje stworzyć bo chce duplikaty i dodawanie po koleji
        Integer lengthOfRoute = 0;
        Integer hopsOfRoute = 0;
        String lengthName;

        // SetHops ( P );
        for(int i = 0; i< v.size(); i++){
            for (int j = 0;j< v.size(); j++){
                if(j != i ){
                    for (int k = 0;k< v.size();k++){
                        if(k != j && k!= i) {
                            for (int r = 0; r < v.size(); r++) {
                                if(r != i && r!= j && r != k) {
                                    for (int l = 0; l < v.size(); l++) {
                                        if(l != i && l != j && l != k && l != r) {
                                            hopsOfRoute = Hop_Matrix.get(0).get(v.get(i)) + Hop_Matrix.get(v.get(i)).get(v.get(j)) + Hop_Matrix.get(v.get(j)).get(v.get(k)) + Hop_Matrix.get(v.get(k)).get(v.get(r)) + Hop_Matrix.get(v.get(r)).get(v.get(l)) + Hop_Matrix.get(v.get(l)).get(0) ;
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
        for(OurMap o : ways){
            if(shortestWay.getKey() > o.getKey()){
                shortestWay = o;
            }
            //shortestWay.printMap();
            //o.printMap();
        }
        distance_sum += shortestWay.key;
        hop_sum += shortestWay.extraKey;
        path_sum = path_sum +  "==>" + shortestWay.value;
      //  shortestWay.printMap();



    }

    public static void main(String[] args) throws FileNotFoundException{

        Bellman_Arraylist bellman_arraylist = new Bellman_Arraylist ();
        System.out.println ("Adjacency Matrix");
        bellman_arraylist.print (  bellman_arraylist.alokuj ()  );
        System.out.println ("Distance Matrix");
        bellman_arraylist.print ( bellman_arraylist.aloc_main_matrix ( bellman_arraylist.infinity ( bellman_arraylist.alokuj () ) ) );
        System.out.println ("Path Matrix");
        bellman_arraylist.print ( bellman_arraylist.aloc_patch_matrix ( bellman_arraylist.infinity ( bellman_arraylist.alokuj () ) ) );
        System.out.println ("Hop Matrix");
        bellman_arraylist.print ( bellman_arraylist.Hop_Matrix );
        System.out.println ("Paths Matrix");
        bellman_arraylist.print_paths ( bellman_arraylist.Path_Matrix );
        System.out.println ();



    }
}