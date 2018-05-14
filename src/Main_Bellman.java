import java.io.FileNotFoundException;
import java.io.IOException;

public class Main_Bellman {

    public static void main(String[] args) throws FileNotFoundException{

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

        Bellman_Arraylist bellman_arraylist = new Bellman_Arraylist ();
        System.out.println ("Adjacency Matrix");
        bellman_arraylist.print (  bellman_arraylist.alokuj ()  );
        System.out.println ("Distance Matrix");
        bellman_arraylist.print ( bellman_arraylist.aloc_main_matrix ( bellman_arraylist.infinity ( adjacentMatrixGenerator.getAdjacent () ) ) );
        System.out.println ("Path Matrix");
        bellman_arraylist.print ( bellman_arraylist.aloc_patch_matrix ( bellman_arraylist.infinity ( adjacentMatrixGenerator.getAdjacent () ) ) );
        System.out.println ("Hop Matrix");
        bellman_arraylist.print ( bellman_arraylist.Hop_Matrix );
        System.out.println ("Paths Matrix");
        bellman_arraylist.print_paths ( bellman_arraylist.Path_Matrix );

        int numberOfElementsInRow = checkInputData.getVertical().get(0).size();
        routeGenerator.generateParcels(5, numberOfElementsInRow);
        routeGenerator.writeParcels();

        System.out.println(routeGenerator.getParcelsNumber());

        System.out.println ();

        bellman_arraylist.choose_the_shortest ( routeGenerator.getParcelsNumber() , bellman_arraylist.aloc_main_matrix ( adjacentMatrixGenerator.getAdjacent () )  );


    }
}
