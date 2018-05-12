import java.io.IOException;
import java.util.ArrayList;

public class Main_Floyd {

    public static void main(String[] args) {

        AdjacentMatrixGenerator adjacentMatrixGenerator = new AdjacentMatrixGenerator ();
        CheckInputData checkInputData = new CheckInputData ();
        RouteGenerator routeGenerator = new RouteGenerator ();


        try {
            checkInputData.read ( "data.txt" );
        } catch (IOException e) {
            System.out.println ( "there is no such a file" );
        }

        checkInputData.separate ();
        checkInputData.print_hor ();
        System.out.println ();
        checkInputData.print_ver ();
        System.out.println ();

        adjacentMatrixGenerator.adjacentGenerator ( checkInputData.getHorizontal (), checkInputData.getVertical () );
        adjacentMatrixGenerator.print(adjacentMatrixGenerator.getAdjacent());
        System.out.println ();
        System.out.println ("Macierz Sasiedztwa");
        Floyd_Arraylist floyd_arraylist = new Floyd_Arraylist ();
        floyd_arraylist.print ( adjacentMatrixGenerator.getAdjacent () );
        System.out.println ("Macierz Odleglosci");

        floyd_arraylist.startPath ( adjacentMatrixGenerator.getAdjacent () );
     //   floyd_arraylist.floyd ( adjacentMatrixGenerator.getAdjacent () );
        ArrayList<ArrayList<Integer>> proper_matrix = floyd_arraylist.infinity ( adjacentMatrixGenerator.getAdjacent () );
        floyd_arraylist.print ( floyd_arraylist.floyd ( proper_matrix) );
        System.out.println ("Macierz Sciezek ");
        floyd_arraylist.print ( floyd_arraylist.P );

        /////////////////////////// Do tego momentu mam macierz Sciezek /////////////////////////////////////////////////////////
        ////////////////////////////////TERAZ DALEJ HOPY I UZYSKANIA Z NICH /////////////////////////////////////////////////


        //////////////////////////////// GENEROWANIE ROUTOW //////////////////////////////////////////////////////
        int numberOfElementsInRow = checkInputData.getVertical().get(0).size();
        routeGenerator.generateParcels(5, numberOfElementsInRow);
        routeGenerator.writeParcels();

        System.out.println(routeGenerator.getParcelsNumber());

        floyd_arraylist.choose_the_shortest ( routeGenerator.getParcelsNumber() , floyd_arraylist.floyd ( proper_matrix ) );

    }
}
