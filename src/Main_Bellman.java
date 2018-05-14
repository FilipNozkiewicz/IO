import java.io.IOException;

public class Main_Bellman {

    public static void main(String[] args){

        AdjacentMatrixGenerator adjacentMatrixGenerator = new AdjacentMatrixGenerator ();
        CheckInputData checkInputData = new CheckInputData ();
        RouteGenerator routeGenerator = new RouteGenerator ();


        try {
            checkInputData.read ( "data.txt" );
        } catch (IOException e) {
            System.out.println ( "there is no such a file" );
        }

        checkInputData.separate ();
     //   checkInputData.print_hor ();
    //    System.out.println ();
     //   checkInputData.print_ver ();
     //   System.out.println ();

        adjacentMatrixGenerator.adjacentGenerator ( checkInputData.getHorizontal (), checkInputData.getVertical () );
        adjacentMatrixGenerator.print(adjacentMatrixGenerator.getAdjacent());

        Bellman_Arraylist bellman_arraylist= new Bellman_Arraylist ();
        ////// Adjacency Matrix
      //  bellman_arraylist.print ( bellman_arraylist.aloc_main_matrix ( adjacentMatrixGenerator.getAdjacent () ) );
        bellman_arraylist.print ( adjacentMatrixGenerator.getAdjacent () );
     //   bellman_arraylist.BellmanFord ( adjacentMatrixGenerator.getAdjacent () , 0 );
        bellman_arraylist.print ( bellman_arraylist.aloc_main_matrix ( bellman_arraylist.infinity ( adjacentMatrixGenerator.getAdjacent () ) ) );
        DijkstraSP_ArrayList dijkstraSP_arrayList = new DijkstraSP_ArrayList ( adjacentMatrixGenerator.getAdjacent().size () );


    }
}
